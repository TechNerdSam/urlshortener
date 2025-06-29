# Raccourcisseur d'URL 🚀

Un service de raccourcissement d'URL simple, élégant et efficace, développé avec le framework **Spring Boot**. 💻

## 📜 À propos du projet

Ce projet a été conçu pour transformer de longues URL complexes en liens courts, faciles à partager et à mémoriser. Il offre une interface web intuitive pour la conversion et une API RESTful pour une intégration facile avec d'autres services.

L'application est construite sur une architecture moderne et robuste, utilisant les meilleures pratiques de développement logiciel pour garantir performance et maintenabilité. ✨

### 🌟 Fonctionnalités

  * **Raccourcissement d'URL instantané** : Convertissez n'importe quelle URL longue en un lien court et unique.
  * **Interface utilisateur réactive** : Une page web simple et esthétique pour une expérience utilisateur optimale.
  * **Redirection rapide** : Redirigez les utilisateurs vers l'URL d'origine de manière transparente et rapide.
  * **API RESTful** : Intégrez facilement le service dans vos propres applications.
  * **Aucune base de données externe requise** : Utilise une base de données en mémoire H2 pour une configuration et un démarrage rapides.

### 🛠️ Construit avec

Ce projet a été rendu possible grâce aux technologies et outils suivants :

  * **Backend** :
      * [Spring Boot](https://spring.io/projects/spring-boot) - Framework principal pour l'application.
      * [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Pour l'interaction avec la base de données.
      * [Maven](https://maven.apache.org/) - Outil de gestion de projet et de build.
      * [H2 Database](https://www.h2database.com) - Base de données relationnelle en mémoire.
  * **Frontend** :
      * HTML5 & CSS3
      * [Bootstrap](https://getbootstrap.com/) - Pour un design responsive.
      * [jQuery](https://jquery.com/) - Pour la manipulation du DOM et les appels AJAX.
      * [GSAP](https://www.google.com/search?q=https://greensock.com/gsap/) - Pour des animations fluides et professionnelles.
  * **Utilitaires** :
      * [Lombok](https://projectlombok.org/) - Pour réduire le code boilerplate.
      * [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/) - Pour la génération de chaînes aléatoires.

## 🚀 Démarrage

Suivez ces étapes pour obtenir une copie locale du projet et la faire fonctionner.

### ✅ Prérequis

Assurez-vous d'avoir les outils suivants installés sur votre machine :

  * **JDK 17** ou une version plus récente.
  * **Maven** 3.x ou une version plus récente.
  * **Git** pour cloner le dépôt.

### ⚙️ Installation

1.  **Clonez le dépôt**
    ```sh
    git clone https://github.com/TechNerdSam/urlshortener.git
    ```
2.  **Naviguez vers le répertoire du projet**
    ```sh
    cd urlshortener/url-shortener
    ```
3.  **Lancez l'application avec Maven**
    ```sh
    mvn spring-boot:run
    ```

L'application sera alors accessible à l'adresse `http://localhost:8080`. ☕

## 💡 Utilisation

### Interface Web

1.  Ouvrez votre navigateur et allez sur `http://localhost:8080`.
2.  Entrez l'URL longue que vous souhaitez raccourcir dans le champ de saisie.
3.  Cliquez sur le bouton "Raccourcir".
4.  L'URL raccourcie apparaîtra en dessous, prête à être copiée et partagée \! 🔗

### API REST

Vous pouvez également interagir avec l'application via son API REST.

#### Raccourcir une URL

  * **Endpoint** : `POST /api/shorten`
  * **Corps de la requête** (`JSON`) :
    ```json
    {
      "longUrl": "https://votre-longue-url.com/a-propos/de/quelque-chose"
    }
    ```
  * **Réponse** (`JSON`) :
    ```json
    {
      "shortUrl": "http://localhost:8080/XyZ123a",
      "longUrl": "https://votre-longue-url.com/a-propos/de/quelque-chose"
    }
    ```

#### Redirection

  * **Endpoint** : `GET /{shortCode}`
  * **Exemple** : Accéder à `http://localhost:8080/XyZ123a` dans votre navigateur vous redirigera vers l'URL longue d'origine.

## 🔧 Configuration

Les principales configurations de l'application se trouvent dans le fichier `src/main/resources/application.properties`.

  * `server.port`: Le port sur lequel l'application s'exécute (par défaut : `8080`).
  * `spring.datasource.*`: Configuration de la base de données H2.
  * `spring.jpa.*`: Configuration de l'ORM Hibernate.
  * `spring.h2.console.*`: Activation de la console web H2 (accessible à `http://localhost:8080/h2-console`).
  * `app.baseUrl`: L'URL de base utilisée pour construire les liens courts (par défaut : `http://localhost:8080`).

## 🤝 Contribution

Les contributions sont ce qui fait de la communauté open source un endroit incroyable pour apprendre, inspirer et créer. Toutes les contributions que vous faites sont **grandement appréciées**.

Si vous avez une suggestion pour améliorer ce projet, n'hésitez pas à forker le dépôt et à créer une pull request. Vous pouvez aussi simplement ouvrir une issue avec le tag "enhancement".

1.  Forkez le Projet
2.  Créez votre branche de fonctionnalité (`git checkout -b feature/AmazingFeature`)
3.  Commitez vos changements (`git commit -m 'Add some AmazingFeature'`)
4.  Poussez vers la branche (`git push origin feature/AmazingFeature`)
5.  Ouvrez une Pull Request

N'oubliez pas de donner une étoile au projet \! ⭐ Merci encore \!

## 📜 Licence

Distribué sous la licence MIT. Voir `LICENSE` pour plus d'informations.

## 📧 Contact

**TechNerdSam (Samyn-Antoy ABASSE)**

  * **GitHub**: [TechNerdSam](https://www.google.com/search?q=https://github.com/TechNerdSam)
  * **Email**: [samynantoy@gmail.com](mailto:samynantoy@gmail.com)

Un grand merci d'avoir consulté ce projet \! 🎉
