# Spring Boot REST CRUD with Spring Data REST (HATEOAS Demo)

This project demonstrates how to build a fully functional, production-grade RESTful API using Spring Boot and Spring Data REST.

The key focus of this repository is the implementation of HATEOAS (Hypermedia as the Engine of Application State). Instead of manually writing Controllers and Services, this project leverages Spring Data REST to automatically expose JPA Repositories as REST resources, strictly following the HAL (Hypertext Application Language) format.

---

## 🚀 Key Features

  - Zero Boilerplate: No manual RestController or Service classes required for standard CRUD.
  - HATEOAS Driven: APIs are discoverable. The client navigates the API via links, not hardcoded URLs.
  - HAL JSON Format: Responses strictly follow the HAL standard.
  - Full CRUD: Create, Read, Update, and Delete operations out of the box.  

---

## 🧠 What is HATEOAS in this Project?

This project uses Spring Data REST to implement the HATEOAS architectural style. This means the API provides information to the client about what it can do next via Hypermedia links.

Traditional JSON (Not used here):

```json
{
  "id": 1,
  "firstName": "Leslie",
  "lastName": "Ansrews",
  "email" : "leslie@ahaha.com"
}
```

HATEOAS / HAL JSON (Used in this project):

```json
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/magic-api/employees/1"
        },
        "employee": {
            "href": "http://localhost:8080/magic-api/employees/1"
        }
    },
    "firstName": "Leslie",
    "lastName": "Andrews",
    "email": "leslie@ahaha.com"
}
```

Why does this matter?

  - Decoupling: The client does not need to know how to construct URLs (e.g., /api/v1/employees/1/delete). It simply follows the self link provided by the server.
  - Discoverability: You can hit the root URL (/), and the API will tell you all available resources.
  - Evolution: You can change URL structures on the backend without breaking clients, as long as the relationship names (rel) remain the same.


## 🛠 Tech Stack

  - Java (JDK 17+)
  - Spring Boot
  - Spring Data JPA (Hibernate)
  - Spring Data REST (The core engine for HATEOAS)
  - MySQL Database


## 📖 API Usage Examples

### 1. API Discovery (Root)

Perform a GET request to the root. The API introduces itself. 

*GET http://localhost:8080/magic-api/*

```json
{
  "_links" : {
    "employees" : {
      "href" : "http://localhost:8080/magic-api/employees{?page,size,sort*}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/magic-api/profile"
    }
  }
}
```


### 2. Get All Resources (with Pagination)

*GET http://localhost:8080/magic-api/employees*

Notice the _links section containing first, next, last, and self for easy navigation.


### 3. Create a Resource

*POST http://localhost:8080/magic-api/employees*

```json
{
    "firstName": "Daniel",
    "lastName": "Vega",
    "email": "vega@ahaha.com"
}
```


### 4. Update a Resource

*PUT http://localhost:8080/magic-api/employees/1*

```json
{
    "firstName" : "Pappa",
    "lastName" : "Patterson",
    "email" : "pappa@ahaha.com"
}
```

### 5. Delete a Resource

*DELETE http://localhost:8080/magic-api/employees/1*







































