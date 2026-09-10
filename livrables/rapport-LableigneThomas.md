## Journal de bord — Projet de Reprise SAÉ S3.5

### Séance 1 — 01/09/2026

Lecture du sujet et prise en main du projet. Initialisation de NetBeans et du dépôt Git (`790a795`).
**Exercice 1 :** analyse du format des fichiers d'étages et réalisation du plan de l'étage 1 sur papier.

### Séance 2 — 01/09/2026

**Exercice 2 :** analyse des interfaces `ISalle`, `IEtage`, `ILabyrinthe`, `IPersonnage`, `IVue` et `ISprite`, puis réalisation du diagramme UML de spécification générale (`annexe.pdf`).

*Difficultés :* syntaxe UML

*Solutions :* relire le cours

### Séance 3 — 02/09/2026

**Exercice 2 :** réalisation du diagramme UML correspondant au code initial (`codeInitial.pdf`).
**Exercice 3 :** création de `Salle` avec ses attributs, constructeur, accesseurs, `equals`, `hashCode` et `estAdjacente`.

*Difficultés :* syntaxe UML

*Solutions :* relire le cours

### Séance 4 — 03/09/2026

**Exercice 4 :** implémentation de `Etage.charger` pour lire les fichiers, créer les salles et convertir leurs types. Mise à jour du `pom.xml`.

*Difficultés :* syntaxe différente du swicth venant du code initial

*Solutions :* modification de la version du compilateur dans le `pom.xml`

### Séance 5 — 03/09/2026

**Exercice 5 :** implémentation de l'adjacence entre salles sur un même étage et début de la gestion des escaliers.

*Difficultés :* adjacence entre étages

*Solutions :* vérification des coordonnées x et y, différence de 1

### Séance 6 — 04/09/2026

Finalisation de `Salle.estAdjacente`, notamment pour les escaliers entre étages, avec correction d'un problème de logique booléenne.
**Exercice 6 :** création de `Labyrinthe`, chargement des étages et recherche automatique de l'entrée et de la sortie.

*Difficultés :* implémenter de facon automatique pour chaque nouveau .txt

*Solutions :* relecture de l'énoncé car il n'y en avait pas besoin

### Séance 7 — 04/09/2026

**Exercice 7 :** création de `Vue` et `Dessin`, chargement des images et mise en place de l'affichage JavaFX du labyrinthe.

*Difficultés :* comprendre l'implémentation des chemins

*Solutions :* demander à un camarade le fonctionnement 

### Séance 8 — 07/09/2026

Optimisation de `Dessin.dessinSalles` après constat d'un ralentissement. Suppression d'une double boucle inutile et affichage uniquement des salles présentes dans l'étage.

*Difficultés :* relecture du code source pour comprendre le fonctionnement

*Solutions :* relecture du code source 

### Séance 9 — 08/09/2026

**Exercice 8 :** création de `sallesAccessibles` pour déterminer les déplacements possibles du héros.

*Difficultés :* comment trouver les salles accessibles

*Solutions :* il suffit de regarder les salles adjacentes et de vérifier l'étage

### Séance 10 — 09/09/2026

**Exercices 9 & 10 :** création de la classe abstraite `APersonnage` et de la classe `Heros` avec la gestion de la position et de l'attribut `salleChoisie` retourné par `faitSonChoix`.

**Exercice 11 :** création de la classe abstraite `ASprite` implémentant l'interface `ISprite` par composition avec un `IPersonnage`. Mise en place de la gestion des coordonnées graphiques (`xpix`, `ypix`) et de la méthode `dessiner` pour le rendu de l'image.



**Exercice 12 :** création de la classe `HerosSprite` héritant de `ASprite`. Chargement du sprite de Link (`LinkRunShieldL1.gif`) et implémentation de `EventHandler<KeyEvent>` (`handle`) pour gérer les déplacements du héros avec les flèches directionnelles et les changements d'étage ('M' pour monter, 'D' pour descendre).

**Exercice 13 :** initialisation du héros dans `Core.initSprites`, affichage des sprites sur l'étage affiché dans `Vue.dessiner`, et ajout de l'écouteur clavier sur la scène lors de l'enregistrement du sprite du héros (`Vue.add`).

*Difficultés :* conversion des coordonnées de la salle en pixels, et capture du clavier pour les déplacements

*Solutions :* multiplier les coordonnées de la case par la taille unitaire et implémenter EventHandler<KeyEvent>

### Séance 11 — 10/09/2026

**Exercice 14 :** création de la classe `Monstre` (héritant de `APersonnage`) avec déplacement aléatoire via `faitSonChoix` parmi les salles accessibles, et de la classe graphique `MonstreSprite` (héritant de `ASprite`) avec le chargement de l'image `monstre1.gif`.

**Exercice 15 :** instanciation et placement aléatoire d'une dizaine de monstres dans le labyrinthe (`Core.initSprites`).

**Exercice 16 :** modification de `AVue` pour hériter de `CopyOnWriteArrayList` afin d'éviter les exceptions `ConcurrentModificationException` lors de la suppression concurrente de monstres lors des collisions avec le héros.
Correction d'un problème dans `Salle.estAdjacente` inversant la logique des escaliers montants et descendants, rétablissant la transition correcte entre les étages. 

*Difficultés :* comment tirer une salle au hasard parmi une Collection

*Solutions :* convertir la collection en ArrayList pour tirer un index aléatoire avec Random.nextInt

### Séance 12 — 10/09/2026

**Exercice 17 :** déplacement fluide des sprites pixel par pixel dans `Vue.dessiner` en découplant le déplacement logique du rendu graphique, avec attente dans `ASprite.faitSonChoix` que l'animation soit terminée.

**Exercice 18 :** ajout d'un éclairage localisé autour du héros dans `Dessin.dessinSalles` en assombrissant progressivement les salles selon leur distance.

*Difficultés :* synchroniser l'animation fluide pixel par pixel avec le déplacement et gérer le dégradé d'obscurité autour du héros

*Solutions :* incrémenter progressivement xpix/ypix vers la cible dans Vue.dessiner et recherches sur internet 
