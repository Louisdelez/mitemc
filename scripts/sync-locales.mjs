#!/usr/bin/env node
// Reports translation gaps between EN and the other locales for the wiki + the mod lang JSON.
// Run from repo root: `node scripts/sync-locales.mjs`

import { readdirSync, readFileSync, statSync, existsSync } from 'node:fs';
import { join, relative } from 'node:path';

const repoRoot = new URL('..', import.meta.url).pathname.replace(/\/$/, '');

const LOCALES = ['fr', 'de', 'es', 'it'];
const WIKI_BASE = join(repoRoot, 'wiki/src/content/docs');
const MOD_LANG_BASE = join(repoRoot, 'mod/src/main/resources/assets/mitemc/lang');
const MOD_LANG_FILES = { en: 'en_us.json', fr: 'fr_fr.json', de: 'de_de.json', es: 'es_es.json', it: 'it_it.json' };

function walk(dir) {
  const out = [];
  for (const entry of readdirSync(dir, { withFileTypes: true })) {
    const full = join(dir, entry.name);
    if (entry.isDirectory()) out.push(...walk(full));
    else out.push(full);
  }
  return out;
}

function reportWiki() {
  const enRoot = join(WIKI_BASE, 'en');
  if (!existsSync(enRoot)) return;
  const enFiles = walk(enRoot)
    .filter(f => /\.(md|mdx)$/.test(f))
    .map(f => relative(enRoot, f));

  console.log('== Wiki coverage ==');
  for (const loc of LOCALES) {
    const locRoot = join(WIKI_BASE, loc);
    const missing = enFiles.filter(f => !existsSync(join(locRoot, f)));
    const stale = [];
    for (const f of enFiles) {
      const enPath = join(enRoot, f);
      const locPath = join(locRoot, f);
      if (!existsSync(locPath)) continue;
      if (statSync(enPath).mtimeMs > statSync(locPath).mtimeMs + 1000) {
        stale.push(f);
      }
    }
    console.log(`  [${loc}] missing: ${missing.length.toString().padStart(3)}   stale: ${stale.length.toString().padStart(3)}`);
    if (process.argv.includes('--verbose')) {
      missing.forEach(f => console.log(`     missing  ${f}`));
      stale.forEach(f   => console.log(`     stale    ${f}`));
    }
  }
}

function reportMod() {
  const enPath = join(MOD_LANG_BASE, MOD_LANG_FILES.en);
  if (!existsSync(enPath)) return;
  const enKeys = Object.keys(JSON.parse(readFileSync(enPath, 'utf8')));
  console.log('\n== Mod lang JSON coverage ==');
  for (const loc of LOCALES) {
    const locPath = join(MOD_LANG_BASE, MOD_LANG_FILES[loc]);
    if (!existsSync(locPath)) {
      console.log(`  [${loc}] FILE MISSING (${MOD_LANG_FILES[loc]})`);
      continue;
    }
    const locKeys = new Set(Object.keys(JSON.parse(readFileSync(locPath, 'utf8'))));
    const missing = enKeys.filter(k => !locKeys.has(k));
    console.log(`  [${loc}] missing keys: ${missing.length.toString().padStart(3)}`);
    if (process.argv.includes('--verbose')) {
      missing.forEach(k => console.log(`     ${k}`));
    }
  }
}

reportWiki();
reportMod();
