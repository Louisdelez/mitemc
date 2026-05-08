# MITEMC Wiki

Astro Starlight site, 5 locales (EN/FR/DE/ES/IT). English is the source of truth.

```bash
cd wiki
pnpm install        # or npm install / yarn
pnpm dev            # dev server
pnpm build          # production build
pnpm sync-locales   # report missing/stale translation keys against EN
```

## Adding a new article

1. Create the file under `src/content/docs/en/<section>/<slug>.md`.
2. Run `pnpm sync-locales` to scaffold stubs in fr/de/es/it.
3. Translate the stubs.
4. PRs that change EN must include the same change in all 4 other locales (or stubs + open issue tracking the translation).

See [`CONTRIBUTING-TRANSLATIONS.md`](./CONTRIBUTING-TRANSLATIONS.md) for the full style guide.
