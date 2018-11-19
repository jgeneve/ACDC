# ACDC-project

## Static / dynamic website

Ce projet a été réalisé dans le cadre de la formation d'ingénieur spécialité ingénierie logicielle lors de la première année.

***
## A propos du projet
### Présentation
Le but du projet est de pouvoir facilement ajouter de nouveaux articles sur un site web utilisant jekyll (plus d'informations sur https://jekyllrb.com).

J'ai choisi d'implémenter cette solution en mettant en place les classes suivantes :
![Diagramme_de_classe](./ClassDiagram.png)
Voir plus [ici](./doc/index.html).
***
## Mise en place
Afin que tout fonctionne correctement il faudra lier votre dépôt github correspondant à votre pc à l'aide d'une clé ssh. Pour se faire, suivre les étapes énnoncées dans la partie Set up 'git push' with an ssh key.
***
## Run the program
1. Clone the project with github
2. Open a new CMD and go to the project
3. Execute the command `java -cp bin add_news`

***
## Class description
### Add_news
Main class of the program that helps the user to create the news
- `void main(String[] args)`
- `boolean askParameters()`

### Categories
Class to manage the categories
- `String chooseExistingCategory()`
- `String createCategory()`
- `List<String> getCategories()`

### Markdown
Class to transform the user's input into a .markdown file
- `String generateMarkdown(News news)`
- `File createMarkdownFile(String markdownString, News news)`

### News
Class that contains the data entered by the user

*Constructor*
- `public News(String layout, String title, String date, String categories, String author, String content, List<String> linkList, List<String> imageList)`

*Getters*
- `String getLayout()`
- `String getTitle()`
- `String getDate()`
- `String getCategories()`
- `String getAuthor()`
- `String getContent()`
- `List<String> getLinkList()`
- `List<String> getImageList()`

*Setters*
- `String setLayout()`
- `String setTitle()`
- `String setDate()`
- `String setCategories()`
- `String setAuthor()`
- `String setContent()`
- `List<String> setLinkList()`
- `List<String> setImageList()`

### Tools
Class that contains some tools methods
- `void executeCommand(String command)`
- ` void pushGit()`

***
*LOG 2018-10-31*
- Cleaning of the project by adding new classes
- Test generating the website using Jekyll

*Log 2018-10-23*
- Adding images and link
- Category management
- Creation of a .markdown file with the user's parameters

*LOG 2018-10-16*
- Start of the project
- Gathering needed user's information using the CMD
- Generation of the basic classes



    
    


