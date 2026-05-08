---
title: Cassaforte
description: Cassa metallica bloccata al giocatore per il multigiocatore.
sidebar:
  order: 9
---

Una **cassaforte** è una cassa che solo il proprietario può aprire. Pensata per server multigiocatore in cui basi condivise hanno bisogno di stoccaggio privato che né tramogge né altri giocatori possano svuotare.

## Cassaforte di ferro — `mitemc:iron_strongbox`

| Proprietà                  | Valore                                       |
|----------------------------|----------------------------------------------|
| Stoccaggio                 | 27 slot (layout cassa singola)               |
| Durezza                    | 5,0                                          |
| Resistenza alle esplosioni | 1200 (classe ossidiana)                      |
| Strumento richiesto        | Piccone                                      |
| Dimensione pila            | 1 (come oggetto)                             |
| Proprietario               | UUID di chi l'ha piazzata                    |

## Funzionamento

1. **Piazzala.** L'UUID del giocatore piazzante è agganciato al BE in `setPlacedBy`.
2. **Clic destro** per aprire. Il `useWithoutItem` legge l'UUID proprietario:
   - Non impostato (legacy): apre per chiunque.
   - Coincide col giocatore: apre.
   - Non coincide e il giocatore **non è OP** (livello permesso ≥ 2): apertura negata con messaggio tradotto.
3. **Rompila** per recuperare. I contenuti cadono al suolo (hook `playerWillDestroy`), il blocco stesso cade via loot table.

L'override OP è intenzionale: gli admin server possono aprire qualunque cassaforte. Per evitarlo, sovrascrivi via il sistema di permessi del server.

## Crafting

```
I I I
I C I    (I = lingotto di ferro, C = cassa)
I I I
```

8 lingotti di ferro attorno a una cassa vanilla.

## Interazione con tramogge

La cassaforte **non implementa** interfacce hopper. Le tramogge non possono né estrarre né inserire — anti-esplosione e anti-tramoggia.

## Note multigiocatore

- L'UUID proprietario sopravvive ai riavvii (NBT chiave `Owner`).
- Se l'UUID del proprietario cambia (raro, ma possibile in offline-mode), la cassaforte resta orfana — apri con strumenti admin.
- Le casseforti **non** sono protette contro la rottura — chiunque può romperle. I contenuti cadono al suolo; anche l'oggetto cassaforte cade. Trattale come casseforti fisiche che possono essere strappate dal muro.

## Varianti future

La roadmap prevede casseforti di tier superiore dopo la Fase 7:

- **Cassaforte di mithril** — immunità all'esplosione + tracciamento dimensione.
- **Cassaforte di adamantio** — resiste anche alla rottura in creativo.

Non nella Fase 6.

## Traguardo Fase 6

`mitemc:phase6/strongbox` scatta non appena hai una cassaforte in inventario.

## Vedi anche

- [Incantesimi](/it/reference/enchantments/) — l'altro sistema della Fase 6.
- [Strumenti e armi](/it/reference/tools-and-weapons/) — piccone richiesto per romperla.
