package tech.suji.seven_prods.projects.cats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tech.suji.seven_prods.projects.cats.entity.Cat;

@RepositoryRestResource(collectionResourceRel = "sujith", path = "manchala")
public interface CatRepository extends JpaRepository<Cat, Integer> {

}
