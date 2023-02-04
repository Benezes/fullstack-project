# fullstack-project

## Stack

- Java (v17)
- Maven (v17.0.5)
- Spring Boot (v2.7.8)
- Postgresql
- Swagger
- Angular

## Run the app

Run the backend
```sh
./mvnw spring-boot:run
```

Run the frontend
```sh
ng serve
```

# Paths

## Paths - Product

| HTTP | Path |
| ------ | ------ |
| GET | /api/products/ |
| POST | /api/products |
| DELETE | /api/products/id |

### List products
GET 
```sh
/api/products
```

### Create a product
POST /api/products
```
{
    "name": "string",
    "value": number,
    "description": "string"
}
```

### Delete a product by id
DELETE
```sh
/api/products/id:int
```
