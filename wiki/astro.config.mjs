// @ts-check
import { defineConfig } from 'astro/config';
import starlight from '@astrojs/starlight';

export default defineConfig({
  site: 'https://mitemc.dev',
  integrations: [
    starlight({
      title: 'MITEMC Wiki',
      description: 'Complete reference for the MITEMC (Minecraft Is Too Easy) mod.',
      logo: { src: './src/assets/logo.svg', replacesTitle: false },
      social: [
        { icon: 'github', label: 'GitHub', href: 'https://github.com/MITEMC/mitemc' },
        { icon: 'discord', label: 'Discord', href: 'https://discord.gg/mitemc' },
      ],
      defaultLocale: 'en',
      locales: {
        en: { label: 'English',  lang: 'en' },
        fr: { label: 'Français', lang: 'fr' },
        de: { label: 'Deutsch',  lang: 'de' },
        es: { label: 'Español',  lang: 'es' },
        it: { label: 'Italiano', lang: 'it' },
      },
      sidebar: [
        {
          label: 'Start',
          translations: { fr: 'Démarrer', de: 'Start', es: 'Empezar', it: 'Inizio' },
          autogenerate: { directory: 'guides' },
        },
        {
          label: 'Reference',
          translations: { fr: 'Référence', de: 'Referenz', es: 'Referencia', it: 'Riferimento' },
          autogenerate: { directory: 'reference' },
        },
        {
          label: 'Bestiary',
          translations: { fr: 'Bestiaire', de: 'Bestiarium', es: 'Bestiario', it: 'Bestiario' },
          autogenerate: { directory: 'bestiary' },
        },
        {
          label: 'Recipes',
          translations: { fr: 'Recettes', de: 'Rezepte', es: 'Recetas', it: 'Ricette' },
          autogenerate: { directory: 'recipes' },
        },
      ],
      customCss: ['./src/assets/custom.css'],
      lastUpdated: true,
      pagination: true,
      tableOfContents: { minHeadingLevel: 2, maxHeadingLevel: 4 },
      editLink: {
        baseUrl: 'https://github.com/MITEMC/mitemc/edit/main/wiki/',
      },
    }),
  ],
});
