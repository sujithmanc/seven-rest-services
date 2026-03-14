package tech.suji.seven_prods.projects.bookmark;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkResponse {

    private Long id;
    private String title;
    private String uri;
    private String logo;
    private String altText;
    private String altTextColor;
    private OffsetDateTime dateCreated;
    private OffsetDateTime lastUpdated;
}