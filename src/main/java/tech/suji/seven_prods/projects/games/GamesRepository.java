package tech.suji.seven_prods.projects.games;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<GamesEntity, Long> {

    List<GamesEntity> findByDevTeam(String devTeam);

    List<GamesEntity> findByNameContainingIgnoreCase(String name);
}