# Challenge Capitole Consulting 

#### **Se construyo el proyecto basándonos en una Arquitectura Hexagonal, en donde se definieron 3 módulos:**

### web:
Este módulo define el acceso a nuestra aplicación.<br/>
Definimos el Controller, Dto y RestControllerAdvice para manejo de excepciones.<br/>
Se realizaron Pruebas de Aceptación

Tecnologías aplicadas:
- Open API - Swagger: para la documentación del endpoint


### core:
Este módulo define nuestra capa de dominio y reglas de negocio, sin dependencia hacia un framework.<br/>
Definimos Modelos de Dominio, Excepciones de Dominio, Interfaces de Servicios e Implementaciones y además las Interfaces de Puertos.<br/>
Se realizaron Pruebas Unitarias


### infra:
Este módulo define la implementación de adaptadores con servicios externos.<br/>
Definimos el Adapter, Entidades, Mapper, Repository


Tecnologías aplicadas:
- H2: base de datos
- SpringDataJpa: facilitador para realizar consultas a la BD
- Liquibase: para el control y gestión de cambios en la BD
- MapStruct: facilitador de mapeo 

___

# Prueba del Servicio

#### Documentación OPEN API - SWAGGER Link: http://localhost:8080/swagger-ui/index.html
#### Acceso a BD H2 Link: http://localhost:8080/h2-console

### Ejecutar con Docker (Ubicarse dentro del proyecto)
```
mvn clean package
docker build -t service-price:1.0 .
docker run -d -p 8080:8080 -t service-price:1.0
```

### Endpoint de prueba:
```
curl --location --request GET 'localhost:8080/v1/prices?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1'

Response:
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "startDate": "2020-06-14T00:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": 35.50
}
```
```
curl --location --request GET 'localhost:8080/v1/prices?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1'

Response:
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 2,
    "startDate": "2020-06-14T15:00:00",
    "endDate": "2020-06-14T18:30:00",
    "price": 25.45
}
```

```
curl --location --request GET 'localhost:8080/v1/prices?applicationDate=2020-06-14T21:00:00&productId=35455&brandId=1'

Response:
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "startDate": "2020-06-14T00:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": 35.50
}
```

```
curl --location --request GET 'localhost:8080/v1/prices?applicationDate=2020-06-15T10:00:00&productId=35455&brandId=1'

Response:
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 3,
    "startDate": "2020-06-15T00:00:00",
    "endDate": "2020-06-15T11:00:00",
    "price": 30.50
}
```

```
curl --location --request GET 'localhost:8080/v1/prices?applicationDate=2020-06-16T21:00:00&productId=35455&brandId=1'

Response:
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 4,
    "startDate": "2020-06-15T16:00:00",
    "endDate": "2020-12-31T23:59:59",
    "price": 38.95
}
```