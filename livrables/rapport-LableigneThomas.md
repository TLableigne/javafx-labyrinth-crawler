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

**Exercice 5 :** implémentation de l'adjacence entre salles sur un même étage et début de la gestion des escaliers. Ajout de tests unitaires dans `SalleTest`.

### Séance 6 — 04/09/2026

Finalisation de `Salle.estAdjacente`, notamment pour les escaliers entre étages, avec correction d'un problème de logique booléenne.
**Exercice 6 :** création de `Labyrinthe`, chargement des étages et recherche automatique de l'entrée et de la sortie.

### Séance 7 — 04/09/2026

**Exercice 7 :** création de `Vue` et `Dessin`, chargement des images et mise en place de l'affichage JavaFX du labyrinthe.

### Séance 8 — 07/09/2026

Optimisation de `Dessin.dessinSalles` après constat d'un ralentissement. Suppression d'une double boucle inutile et affichage uniquement des salles présentes dans l'étage.

### Séance 9 — 08/09/2026

Finalisation et validation de l'**Objectif 1** : affichage fluide de l'étage et intégration sur `main`.
**Exercice 8 :** création de `sallesAccessibles` pour déterminer les déplacements possibles du héros.

### Séance 10 — 09/09/2026

**Exercices 9 à 13 :** création de `APersonnage`, `Heros`, `ASprite` et `HerosSprite`. Gestion des déplacements au clavier et affichage du héros. Validation de l'**Objectif 2**.

### Séance 11 — 11/09/2026

**Exercices 14 à 16 :** création de `Monstre` et `MonstreSprite`, ajout des monstres et gestion des collisions. Utilisation de `CopyOnWriteArrayList` pour éviter les modifications concurrentes. Validation de l'**Objectif 3** et finalisation des livrables.
