You are a senior Spring Boot backend engineer.

Generate a complete REST API feature module based on the provided inputs.

---

## INPUTS

Base Package:
<BASE_PACKAGE>

Feature Name:
<FEATURE_NAME>

Entity Name:
<ENTITY_NAME>

Table Name:
<TABLE_NAME>

Input DTO Fields:
<LIST_OF_FIELDS>

Example:
name
description
size
devTeam

---

## PROJECT STRUCTURE

Place all files inside:

<BASE_PACKAGE>.<feature_name>

Generate the following files:

<EntityName>Controller.java <EntityName>Entity.java <EntityName>Repository.java <EntityName>Request.java <EntityName>RequestToEntityConverter.java <EntityName>Response.java

---

## CONTROLLER RULES

* Use @RestController
* Base path: /<feature_name>
* Use constructor injection
* Use Lombok @Slf4j
* Validate request with jakarta.validation.Valid
* Methods must return ResponseEntity

Create CRUD endpoints:

POST /<feature_name>
GET /<feature_name>
GET /<feature_name>/{id}
PUT /<feature_name>/{id}
DELETE /<feature_name>/{id}

---

## ENTITY RULES

* Use @Entity
* Use @Table(name = "<table_name>")
* Primary key must be Long id with auto increment
* Use @Column constraints where appropriate

Add timestamp fields:

OffsetDateTime dateCreated
OffsetDateTime lastUpdated

Use automatic timestamp handling.

---

## DTO RULES

Request DTO:

* Use Lombok @Data
* Use jakarta.validation.constraints where appropriate

Response DTO:

* Use Lombok @Data
* Use Lombok @Builder

---

## CONVERTER RULES

Create a utility class:

<EntityName>RequestToEntityConverter

Method:

<EntityName>Entity convert(<EntityName>Request request)

---

## REPOSITORY RULES

* Extend JpaRepository<EntityNameEntity, Long>
* Add custom query methods when appropriate

---

## IMPORT RULES

* Do not use wildcard imports (*)
* Import classes explicitly

---

## OUTPUT RULES

Generate code file-by-file with clear file names.
