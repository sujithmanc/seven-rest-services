package tech.suji.seven_prods.projects.bookmark;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookmarkRequest {

    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotBlank(message = "URI must not be blank")
    private String uri;

    // Optional logo path or URL
    private String logo;

    @NotBlank(message = "altText must not be blank")
    @Size(min = 2, max = 2, message = "altText must be exactly 2 characters")
    private String altText;

    // Optional hex color with default blue
    @Pattern(
        regexp = "^#([A-Fa-f0-9]{6})$",
        message = "altTextColor must be a valid hex color like #0000FF"
    )
    private String altTextColor = "#0000FF";
}	