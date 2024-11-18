# WalletGraphQL

## Description
WalletGraphQL est une application de gestion de portefeuilles utilisant GraphQL pour les opérations de crédit et de débit. Ce projet permet de gérer des portefeuilles, des transactions et des devises.

## Prérequis
- Java 17
- Maven 3.9.9
- Spring Boot 3.3.5

## Installation
1. Clonez le dépôt :
    ```sh
    git clone https://github.com/RicoGac/WalletGraphQL.git

    cd WalletGraphQL
    ```

2. Construisez le projet avec Maven :
    ```sh
    mvn clean install
    ```

## Configuration
Le fichier de configuration principal est `src/main/resources/application.properties` :
``` properties
spring.application.name=tp_GraphQl
spring.datasource.url=jdbc:h2:mem:wallet-db
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
server.port=8082
spring.graphql.graphiql.enabled=true
spring.jpa.hibernate.ddl-auto=update

``` 

## Démarrage

Pour démarrer l'application, exécutez la commande suivante :
``` 
mvn spring-boot:run
``` 
L'application sera accessible à l'adresse http://localhost:8082.

## Endpoints GraphQL
- Query
  - ```userWallets```: Liste des portefeuilles d'un utilisateur
  - ```findWalletById(id: ID!)```: Trouver un portefeuille par ID
  - ```listCurrencies```: Liste des devises

- Mutation
  - ```addWallet(userId: String!, balance: Float!, currencyCode: String!)```: Ajouter un portefeuille
  - ```transfer(walletFromId: ID!, walletToId: ID!, amount: Float!)```: Transférer des fonds entre portefeuilles

## Tests

Pour exécuter les tests, utilisez la commande suivante :
mvn test

## Auteur
Américo GAPO
