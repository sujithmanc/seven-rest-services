package tech.suji.seven_prods.projects.games;

import org.springframework.stereotype.Component;

@Component
public class GamesRequestToEntityConverter {

    public GamesEntity convert(GamesRequest request) {
        GamesEntity entity = new GamesEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setSize(request.getSize());
        entity.setDevTeam(request.getDevTeam());
        return entity;
    }
}