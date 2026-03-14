You are a senior Spring Boot backend engineer.

Generate a complete REST API feature module based on the provided data model.

---

## BASE PACKAGE

tech.suji.seven_prods.projects

Feature name: games

---

## DATA MODEL

Game:

* name
* desc
* size
* devTeam

---

## PROJECT STRUCTURE

Place all files in:

tech.suji.seven_prods.projects.games

Generate these files:

GameController.java
GameEntity.java
GameRepository.java
GameRequest.java
GameRequestToEntityConverter.java
GameResponse.java

---

## CONTROLLER RULES

* Use @RestController
* Base path: /games
* Use constructor injection
* Use Lombok @Slf4j
* Methods must return ResponseEntity
* Validate request using jakarta.validation.Valid

Create 5 CRUD endpoints:

POST /games
GET /games
GET /games/{id}
PUT /games/{id}
DELETE /games/{id}

---

## ENTITY RULES

* Use @Entity
* Use @Table(name = "games")
* Primary key must be auto-increment Long id
* Use OffsetDateTime for timestamps

Add fields:

* OffsetDateTime dateCreated
* OffsetDateTime lastUpdated

Use automatic timestamp handling.

Use @Column constraints where required.

---

## REPOSITORY RULES

* Extend JpaRepository<GameEntity, Long>
* Add custom query method if needed

---

## DTO RULES

GameRequest

* Use Lombok @Data
* Use jakarta.validation.constraints where needed

GameResponse

* Use Lombok @Data and @Builder

---

## CONVERTER RULES

Create a utility class:

GameRequestToEntityConverter

Method:

GameEntity convert(GameRequest request)

---

## IMPORT RULES

* Do not use wildcard imports (*)
* Import each class explicitly

---

## OUTPUT RULES

Generate code file-by-file with clear file names.
