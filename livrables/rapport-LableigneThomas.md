## Journal de bord — Projet de Reprise SAÉ S3.5

### Séance 1 — 01/09/2026

Lecture du sujet et prise en main du projet. Initialisation de NetBeans et du dépôt Git (`790a795`).
**Exercice 1 :** analyse du format des fichiers d'étages et réalisation du plan de l'étage 1 sur papier.

### Séance 2 — 01/09/2026

**Exercice 2 :** analyse des interfaces `ISalle`, `IEtage`, `ILabyrinthe`, `IPersonnage`, `IVue` et `ISprite`, puis réalisation du diagramme UML de spécification générale (`annexe.pdf`).

### Séance 3 — 02/09/2026

**Exercice 2 :** réalisation du diagramme UML correspondant au code initial (`codeInitial.pdf`).
**Exercice 3 :** création de `Salle` avec ses attributs, constructeur, accesseurs, `equals`, `hashCode` et `estAdjacente`.

### Séance 4 — 03/09/2026

**Exercice 4 :** implémentation de `Etage.charger` pour lire les fichiers, créer les salles et convertir leurs types. Mise à jour du `pom.xml`.

### Séance 5 — 03/09/2026

**Exercice 5 :** implémentation de l'adjacence entre salles sur un même étage et début de la gestion des escaliers.

### Séance 6 — 04/09/2026

Finalisation de `Salle.estAdjacente`, notamment pour les escaliers entre étages, avec correction d'un problème de logique booléenne.
**Exercice 6 :** création de `Labyrinthe`, chargement des étages et recherche automatique de l'entrée et de la sortie.

### Séance 7 — 04/09/2026

**Exercice 7 :** création de `Vue` et `Dessin`, chargement des images et mise en place de l'affichage JavaFX du labyrinthe.

### Séance 8 — 07/09/2026

Optimisation de `Dessin.dessinSalles` après constat d'un ralentissement. Suppression d'une double boucle inutile et affichage uniquement des salles présentes dans l'étage.

### Séance 9 — 08/09/2026

**Exercice 8 :** création de `sallesAccessibles` pour déterminer les déplacements possibles du héros.

### Séance 10 — 09/09/2026

**Exercices 9 & 10 :** création de la classe abstraite `APersonnage` et de la classe `Heros` avec la gestion de la position et de l'attribut `salleChoisie` retourné par `faitSonChoix`.
**Exercice 11 :** création de la classe abstraite `ASprite` implémentant l'interface `ISprite` par composition avec un `IPersonnage`. Mise en place de la gestion des coordonnées graphiques (`xpix`, `ypix`) et de la méthode `dessiner` pour le rendu de l'image.
**Exercice 12 :** création de la classe `HerosSprite` héritant de `ASprite`. Chargement du sprite de Link (`LinkRunShieldL1.gif`) et implémentation de `EventHandler<KeyEvent>` (`handle`) pour gérer les déplacements du héros avec les flèches directionnelles et les changements d'étage ('M' pour monter, 'D' pour descendre).
**Exercice 13 :** initialisation du héros dans `Core.initSprites`, affichage des sprites sur l'étage affiché dans `Vue.dessiner`, et ajout de l'écouteur clavier sur la scène lors de l'enregistrement du sprite du héros (`Vue.add`).

### Séance 11 — 10/09/2026

**Exercice 14 :** création de la classe `Monstre` (héritant de `APersonnage`) avec déplacement aléatoire via `faitSonChoix` parmi les salles accessibles, et de la classe graphique `MonstreSprite` (héritant de `ASprite`) avec le chargement de l'image `monstre1.gif`.
**Exercice 15 :** instanciation et placement aléatoire d'une dizaine de monstres dans le labyrinthe (`Core.initSprites`).
**Exercice 16 :** modification de `AVue` pour hériter de `CopyOnWriteArrayList` afin d'éviter les exceptions `ConcurrentModificationException` lors de la suppression concurrente de monstres lors des collisions avec le héros.
Correction d'un problème dans `Salle.estAdjacente` inversant la logique des escaliers montants et descendants, rétablissant la transition correcte entre les étages. 

### Séance 12 — 10/09/2026

**Exercice 17 :** déplacement fluide des sprites pixel par pixel dans `Vue.dessiner` en découplant le déplacement logique du rendu graphique, avec attente dans `ASprite.faitSonChoix` que l'animation soit terminée.
**Exercice 18 :** ajout d'un éclairage localisé autour du héros dans `Dessin.dessinSalles` en assombrissant progressivement les salles selon leur distance de Manhattan.

