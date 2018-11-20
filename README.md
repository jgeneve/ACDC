# ACDC-project

## Static / dynamic website

Ce projet a été réalisé dans le cadre de la formation d'ingénieur spécialité ingénierie logicielle lors de la première année.

***

## A propos du projet
### Présentation
Le but du projet est de pouvoir facilement ajouter de nouveaux articles sur un site web utilisant jekyll (plus d'informations sur https://jekyllrb.com).

J'ai choisi d'implémenter cette solution en mettant en place les classes suivantes :
![Diagramme_de_classe](./ClassDiagram.png)

- Une classe `Post` qui permet de stocker les différentes informations relatives au nouveau post.
- Une classe `Categories` qui permet de gérer les catégories d'un post via différentes méthodes (Ajout, suppression, récupération).
- Une classe `Markdown` qui permet d'utiliser les différentes méthodes relatives au markdown.
- Une classe `Tools` qui permet de stocker et de mettre à disposition diverses méthodes.
- Une classe `Main` contenant la méthode `main` qui permet au programme de se lancer correctement.

> Plus de détails sur les méthodes et les classes [ici](https://jgeneve.github.io//ACDC/Main.html).

***

## Prérequis
Afin que le programme fonctionne correctement il faut vérifier plusieurs choses :

- Avoir une connexion internet valide.
- Dans le `Main` avoir changé `localRepo` et `gitRepo` correspondant respectivement au dossier local contenant le site web et au lien vers le répertoire Git du dossier web.
- Etre connecté en SSH à Git sur votre terminal. (Plus de détails [ici](https://help.github.com/articles/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent/)).
- Avoir installé jekyll (Plus de détails [ici](https://jekyllrb.com/docs/installation/)).

***

## Lancement du programme

1. Cloner le [projet ACDC](https://github.com/jgeneve/ACDC) depuis Git ainsi que l'[archive web](https://github.com/jgeneve/web_inria).
2. Changer les chemins `localRepo` et `gitRepo` dans la classe `Main`
3. Ouvrir votre CMD, se déplacer dans le dossier ACDC et executer la commande `java -cp bin Main`.  

***

*LOG 21/11/2018*
- Build jekyll et lancement du serveur local de démonstration.
- Refactoring du code existant afin rendre la transition pour la partie graphique la plus facile possible.
- Commit et push Git après la validation par l'utilisateur.
- Actualisation du README

*LOG 31/10/2018*
- Refactorisation du code du projet et ajout d'une nouvelle classe `Tools`
- Test de génération du site web en local en utilisant Jekyll.

*Log 24/10/2018*
- Demande d'ajout d'images et de liens
- Gestion des catégories et création de la classe `Categories`
- Création du fichier markdown .md dans le dossier du site web et création de la classe `Markdown`

*LOG 17/10/2018*
- Analyse du projet et création de celui-ci
- Récupération des informations du post via la CMD
- Génération des classes de base (`Main` & `Post`)