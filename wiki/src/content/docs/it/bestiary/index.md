---
title: Bestiario
description: Nuove creature introdotte da MITEMC.
sidebar:
  order: 1
---

La Fase 4 porta **10 nuove specie ostili**. Ognuna è una sottoclasse di un mob vanilla con statistiche distinte e un comportamento caratteristico; i modelli geo e le texture custom arriveranno in una passata di rifinitura.

## A colpo d'occhio

| Specie                | PV | ATK | Spawn                  | Caratteristica                                       |
|-----------------------|---:|----:|------------------------|------------------------------------------------------|
| Lupo terribile        | 20 |  6  | Superficie overworld   | Sempre ostile al giocatore; branchi di 2-4           |
| Ragno dei boschi      | 14 |  3  | Biomi forestali        | Scala muri; molto veloce                             |
| Ghoul                 | 24 |  4  | Strati di caverne      | Morso: Lentezza IV + Affaticamento minatore II 4 s   |
| Spettro               | 18 |  4  | Sottoterra             | I colpi tolgono 4 di esaurimento fame                |
| Ombra                 | 16 |  5  | Luce livello 0         | Appare *solo* in oscurità assoluta                   |
| Predatore invisibile  | 18 |  5,5| Strati di caverne      | Auto-invisibilità permanente                         |
| Mastino infernale     | 24 |  7  | Nether                 | Immune al fuoco; incendia il bersaglio 5 s           |
| Ragno demoniaco       | 20 |  5  | Caverne profonde       | Balza sul bersaglio ogni 3 s                         |
| Creeper infernale     | 24 |  —  | Nether                 | Esplosione più ampia; immune al fuoco                |
| Elementale del fuoco  | 24 |  6  | Caverne nether-like    | Fuoco a distanza; più resistente di un blaze         |

## Schede dettagliate

### Lupo terribile — `mitemc:dire_wolf`

Cugino più grande e cattivo del lupo vanilla. **Sempre ostile** al giocatore (sovrascrive il comportamento addomesticabile di `Wolf`). Compare al crepuscolo nei biomi overworld, di solito in branco.

- **Bottino:** 1–2 ossa.
- **Tattica:** Asciotta+ in mano, combatti in alto; i branchi colpiscono i PV più bassi.

### Ragno dei boschi — `mitemc:wood_spider`

Variante di superficie del ragno delle caverne, nei biomi forestali. Leggermente più grande della vanilla, niente morso avvelenato — ma molto rapido nella chioma.

- **Bottino:** 0–2 corda, 0–1 occhio di ragno.
- **Tattica:** Un pugnale di selce regge la cadenza; spezza la linea di vista nel sottobosco.

### Ghoul — `mitemc:ghoul`

Variante zombie da caverna. Il morso applica **Lentezza IV + Affaticamento minatore II** per 4 s — un effetto paralizzante che impedisce di scavare per fuggire.

- **Bottino:** 0–3 carne marcia, 0–1 osso.
- **Tattica:** Niente mischia in tunnel. Martello da guerra + via di fuga obbligatori.

### Spettro — `mitemc:wight`

Variante scheletrica non-morta. **I colpi tolgono 4 di esaurimento fame** al giocatore — porta cibo o cadrai in Debolezza da fame nel mezzo della lotta.

- **Bottino:** 0–3 ossa, 0–2 frecce.
- **Tattica:** Porta stufato o bistecca; finisci in fretta.

### Ombra — `mitemc:shadow`

Compare **solo a luce livello 0**. Non brucia mai al sole (vive comunque sottoterra).

- **Bottino:** 0–2 carne marcia, 0–1 carbone.
- **Tattica:** Una sola torcia uccide l'intero raggio di spawn. La luce è la risposta.

### Predatore invisibile — `mitemc:invisible_stalker`

Auto-invisibilità permanente (rinnovata ogni 200 tick). Lo senti prima di vederlo.

- **Bottino:** 0–2 carne marcia, 0–1 boccetta di vetro.
- **Tattica:** Ascolta i passi; una pozione lanciabile di Bagliore lo smaschera.

### Mastino infernale — `mitemc:hellhound`

Lupo terribile del Nether. Immune al fuoco; **i colpi incendiano il bersaglio 5 s**. Branchi di 1–3.

- **Bottino:** 1–2 ossa, 0–1 polvere di blaze.
- **Tattica:** Pozione di Resistenza al fuoco prima delle fortezze del Nether.

### Ragno demoniaco — `mitemc:demon_spider`

Variante delle caverne profonde. **Balza periodicamente sul bersaglio** con alta velocità verticale. Ti raggiunge su cornicioni che credevi sicuri.

- **Bottino:** 0–2 corda, 0–2 occhi di ragno.
- **Tattica:** Solo arene aperte; mai combattere su un cornicione di un blocco.

### Creeper infernale — `mitemc:infernal_creeper`

Variante creeper del Nether. **Raggio di esplosione più grande** (~5 contro 3 vanilla), immune al fuoco, resistenza modesta alle cadute.

- **Bottino:** 1–3 polvere da sparo, 0–1 verruca del Nether.
- **Tattica:** Come un creeper, ma distanza di sicurezza 1,6× maggiore.

### Elementale del fuoco — `mitemc:fire_elemental`

Cugino profondo del blaze. Compare sotto Y=0 invece che nel Nether, con un po' più di PV e raggio di inseguimento di 32 blocchi.

- **Bottino:** 1–2 verghe di blaze.
- **Tattica:** Arco + armatura Protezione dal fuoco. Niente mischia senza equipaggiamento adeguato.

## Pesi di spawn

| Classe di bioma           | Spawner                                                                  |
|---------------------------|--------------------------------------------------------------------------|
| `#minecraft:is_overworld` | Lupo terribile 8, Ragno dei boschi 6, Ghoul 12, Spettro 10, Ombra 4, Predatore invisibile 2, Ragno demoniaco 5, Elementale del fuoco 3 |
| `#minecraft:is_nether`    | Mastino infernale 12, Creeper infernale 8                                |

I pesi sono voci NeoForge BiomeModifier `add_spawns` — sovrascrivibili via datapack.

## Fame degli animali amici

La Fase 4 introduce anche una meccanica di **fame per gli animali amici** (mucche, pecore, maiali, polli):

- Ogni animale tracciato accumula un contatore di fame quando non è adiacente a erba / grano / acqua.
- Dopo una giornata in-game completa senza cibo, l'animale subisce 1 danno da fame.
- Il contatore si resetta al contatto col cibo e recupera 4× più in fretta mentre mangia.
- Tracciato in NBT persistente — sopravvive al chunk-unload.

Pianifica le fattorie: animali in recinti di sola terra moriranno. La Fase 5 aggiungerà alimentazione esplicita, letame e sete.

## Catena di traguardi della Fase 4

```
phase4/root  →  first_kill  →  all_ten  (sfida)
```

`first_kill` scatta al primo kill di una specie MITEMC. `all_ten` chiede uno di ogni specie — il trofeo da completista del bestiario.
