# CodeKeep backend API

This repository contains the API used in the [codekeep project](https://github.com/GeorgiosDrivas/codekeep).
It is a code-snippet management API in JSON format that allows the user to create an account
and create / update / delete snippets.


# Tech Stack
- Java
- Spring Boot
- Maven
- Docker
- PostgreSQL

# Features
- Create account ( /login )
- Create code snippet ( /addSnippet )
- Edit code snippet ( /snippets/{id} )
- Delete code snippet ( /snippets/{id} )
- Edit account information ( /users/{id} )