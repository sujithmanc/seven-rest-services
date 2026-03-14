package tech.suji.seven_prods.projects.games;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GamesRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must not exceed 255 characters")
    private String name;

    @Size(max = 2000, message = "Description must not exceed 2000 characters")
    private String description;

    @NotBlank(message = "Size is required")
    @Size(max = 50, message = "Size must not exceed 50 characters")
    private String size;

    @NotBlank(message = "Dev team is required")
    @Size(max = 255, message = "Dev team must not exceed 255 characters")
    private String devTeam;
}