package tech.suji.seven_prods.projects.games;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class GamesResponse {

    private Long id;
    private String name;
    private String description;
    private String size;
    private String devTeam;
    private OffsetDateTime dateCreated;
    private OffsetDateTime lastUpdated;

    public static GamesResponse from(GamesEntity entity) {
        return GamesResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .size(entity.getSize())
                .devTeam(entity.getDevTeam())
                .dateCreated(entity.getDateCreated())
                .lastUpdated(entity.getLastUpdated())
                .build();
    }
}