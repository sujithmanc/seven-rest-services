
# Typical Spring Boot Project

```
project/
 ├─ .mvn/
 │   └─ wrapper/
 │       ├─ maven-wrapper.jar
 │       └─ maven-wrapper.properties
 ├─ mvnw
 ├─ mvnw.cmd
 ├─ src/
 ├─ pom.xml
 └─ .gitignore
 ```
 These wrapper files should be committed to Git. This guarantees the build works the same everywhere.
 
- The .mvn/wrapper folder is part of the Maven Wrapper.
- It allows to run Maven without installing Maven manually.
- Provides consistent Maven Version. This can cause build inconsistencies.


The wrapper will:
1. Check if Maven is installed
2. Download the correct Maven version automatically
3. Run the build
 