## Logbook — SAÉ S3.5 Resumption Project

### Session 1 — 09/01/2026

Reading the subject and getting started with the project. Initializing NetBeans and the Git repository (`790a795`).
**Exercise 1:** Analysis of floor file formats and creation of the floor 1 plan on paper.

### Session 2 — 09/01/2026

**Exercise 2:** Analysis of the `ISalle`, `IEtage`, `ILabyrinthe`, `IPersonnage`, `IVue`, and `ISprite` interfaces, then creation of the general specification UML diagram (`annexe.pdf`).

*Difficulties:* UML syntax

*Solutions:* Review course materials

### Session 3 — 09/02/2026

**Exercise 2:** Creation of the UML diagram corresponding to the initial code (`codeInitial.pdf`).
**Exercise 3:** Creation of `Salle` with its attributes, constructor, accessors, `equals`, `hashCode`, and `estAdjacente`.

*Difficulties:* UML syntax

*Solutions:* Review course materials

### Session 4 — 09/03/2026

**Exercise 4:** Implementation of `Etage.charger` to read files, create rooms, and convert their types. Updated `pom.xml`.

*Difficulties:* Different switch syntax from the initial code

*Solutions:* Modified the compiler version in `pom.xml`

### Session 5 — 09/03/2026

**Exercise 5:** Implementation of adjacency between rooms on the same floor and beginning of stair management.

*Difficulties:* Adjacency between floors

*Solutions:* Verification of x and y coordinates, difference of 1

### Session 6 — 09/04/2026

Finalization of `Salle.estAdjacente`, particularly for stairs between floors, with correction of a boolean logic issue.
**Exercise 6:** Creation of `Labyrinthe`, loading of floors, and automatic search for the entrance and exit.

*Difficulties:* Implementing automatically for each new .txt

*Solutions:* Re-read the instructions as it was not required

### Session 7 — 09/04/2026

**Exercise 7:** Creation of `Vue` and `Dessin`, loading of images, and implementation of the JavaFX display of the labyrinth.

*Difficulties:* Understanding the implementation of paths

*Solutions:* Asked a classmate about the operation

### Session 8 — 09/07/2026

Optimization of `Dessin.dessinSalles` after noticing a slowdown. Removal of an unnecessary double loop and display of only the rooms present on the floor.

*Difficulties:* Re-reading source code to understand operation

*Solutions:* Re-read source code

### Session 9 — 09/08/2026

**Exercise 8:** Creation of `sallesAccessibles` to determine possible moves for the hero.

*Difficulties:* How to find accessible rooms

*Solutions:* Simply check adjacent rooms and verify the floor

### Session 10 — 09/09/2026

**Exercises 9 & 10:** Creation of the abstract class `APersonnage` and the `Heros` class with position management and the `salleChoisie` attribute returned by `faitSonChoix`.

**Exercise 11:** Creation of the abstract class `ASprite` implementing the `ISprite` interface by composition with an `IPersonnage`. Implementation of graphic coordinate management (`xpix`, `ypix`) and the `dessiner` method for image rendering.

**Exercise 12:** Creation of the `HerosSprite` class inheriting from `ASprite`. Loading the Link sprite (`LinkRunShieldL1.gif`) and implementation of `EventHandler<KeyEvent>` (`handle`) to handle hero movement with directional arrows and floor changes ('M' to go up, 'D' to go down).

**Exercise 13:** Initialization of the hero in `Core.initSprites`, display of sprites on the floor shown in `Vue.dessiner`, and addition of the keyboard listener on the scene during hero sprite registration (`Vue.add`).

*Difficulties:* Conversion of room coordinates to pixels, and capturing the keyboard for movement

*Solutions:* Multiply case coordinates by unit size and implement EventHandler<KeyEvent>

### Session 11 — 09/10/2026

**Exercise 14:** Creation of the `Monstre` class (inheriting from `APersonnage`) with random movement via `faitSonChoix` among accessible rooms, and the graphical class `MonstreSprite` (inheriting from `ASprite`) with the loading of the `monstre1.gif` image.

**Exercise 15:** Instantiation and random placement of about ten monsters in the labyrinth (`Core.initSprites`).

**Exercise 16:** Modification of `AVue` to inherit from `CopyOnWriteArrayList` to avoid `ConcurrentModificationException` during concurrent removal of monsters during collisions with the hero.
Correction of an issue in `Salle.estAdjacente` reversing the logic of upward and downward stairs, restoring correct transition between floors.

*Difficulties:* How to pick a room at random from a Collection

*Solutions:* Convert the collection to an ArrayList to pick a random index with Random.nextInt

### Session 12 — 09/10/2026

**Exercise 17:** Smooth movement of sprites pixel by pixel in `Vue.dessiner` by decoupling logic movement from graphic rendering, with waiting in `ASprite.faitSonChoix` until the animation is finished.

**Exercise 18:** Addition of localized lighting around the hero in `Dessin.dessinSalles` by progressively darkening rooms according to their distance.

*Difficulties:* Synchronizing smooth pixel-by-pixel animation with movement and managing the darkness gradient around the hero

*Solutions:* Progressively increment xpix/ypix towards the target in `Vue.dessiner` and internet research
