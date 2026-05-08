# Contributing translations

The MITEMC wiki ships in **English, French, German, Spanish, Italian**.

## Source-of-truth rules

- **English is canonical.** Every other locale is a translation of `src/content/docs/en/...`.
- Same file path under `en/` and `fr/`/`de/`/`es/`/`it/`. Same frontmatter `title`, but translated.
- Mod IDs, registry IDs, recipe IDs, item ID strings stay in English (e.g., `mitemc:flint_shard`).
- Display names follow the locale's lang JSON in `mod/src/main/resources/assets/mitemc/lang/<locale>.json`.

## Style guide per locale

### Français (fr)
- Vouvoiement (vous), pas tutoiement.
- Métrique partout (cubes, blocs).
- "Item" reste "objet". "Block" → "bloc". "Mob" → "créature".
- Pas d'apostrophes courbes dans les chemins de code, mais courbes dans la prose (’ pas ').

### Deutsch (de)
- Sie-Form en prose technique.
- Composés en un seul mot ("Feuersteinsplitter", pas "Feuerstein Splitter").

### Español (es)
- Español neutro (latam-friendly), pas castellano-only.
- "Item" → "objeto". "Mob" → "criatura".

### Italiano (it)
- Lei-form en prose technique.
- "Stick" → "bastone". "Block" → "blocco". "Item" → "oggetto".

## Tooling

```bash
pnpm sync-locales
```

Reports for each non-EN locale:
- **Missing:** files present in `en/` but not in this locale.
- **Stale:** files where the EN source's `lastModified` is newer than the translation's last commit (heuristic).

## Tagging untranslated content

If you add a section to an EN article and can't translate it yet, mirror it in the other locales **inside a `:::caution` admonition** so the page renders without missing-content gaps:

```mdx
:::caution[Translation pending]
This section is still in English. Help us translate: [edit on GitHub](...).
:::
```

This keeps every locale shippable while making the gap visible.
