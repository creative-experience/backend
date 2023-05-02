## Actors

| Actor | Description           |
|:------|:----------------------|
| ALL   | All users             |
| ADMIN | System Administrator  |
| ADMIN | Company Administrator |
| USER  | Company Employee      |

## Acesso às páginas

| base path       | permitAll | authenticated | role         |
|:----------------|:----------|:--------------|:-------------|
| /register       | yes       | no            | ALL          |
| /swagger-ui*/** | no        | yes           | ADMIN        |
| /swagger-ui/**  | no        | yes           | ADMIN        |
| /api-docs.yaml  | no        | yes           | ADMIN        |
| /actuator/**    | no        | yes           | ADMIN        |
| /product        | no        | yes           | USER / ADMIN |
| /finance        | no        | yes           | USER / ADMIN |

## Endpoints

| Method | Base path         | Description          | Role         | Authenticated |
|:-------|:------------------|:---------------------|:-------------|:--------------|
| POST   | /register         | Register Customer    | ALL          | NO            |
| GET    | /user             | Enter                | ALL          | NO            |
| GET    | /swagger-ui*/**   | Documentation        | ADMIN        | YES           |
| GET    | /swagger-ui.html  | Documentation        | ADMIN        | YES           |
| GET    | /v3/api-docs/**   | Documentation        | ADMIN        | YES           |
| GET    | /v3/api-docs.yaml | Documentation        | ADMIN        | YES           |
| GET    | /actuator/**      |                      | ADMIN        | YES           |
| GET    | /product          | List products        | ADMIN / USER | YES           |
| POST   | /product          | Register product     | ADMIN        | YES           |
| GET    | /product/{id}     | Search product by ID | ADMIN / USER | YES           |
| PUT    | /product/{id}     | Update product by ID | ADMIN        | YES           |
| DELETE | /product/{id}     | Delete product by ID | ADMIN        | YES           |
| GET    | /finance          | List finance         | ADMIN / USER | YES           |
| POST   | /finance          | Register finance     | ADMIN        | YES           |
| GET    | /finance/{id}     | Search finance by ID | ADMIN / USER | YES           |
| PUT    | /finance/{id}     | Update finance by ID | ADMIN        | YES           |
| DELETE | /finance/{id}     | Delete finance by ID | ADMIN        | YES           |

---

get User Details After Login = obter detalhes do usuário após o login