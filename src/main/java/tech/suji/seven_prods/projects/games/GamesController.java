package tech.suji.seven_prods.projects.games;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/games")
public class GamesController {

    private final GamesRepository gamesRepository;
    private final GamesRequestToEntityConverter converter;

    public GamesController(GamesRepository gamesRepository, GamesRequestToEntityConverter converter) {
        this.gamesRepository = gamesRepository;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<GamesResponse> create(@Valid @RequestBody GamesRequest request) {
        log.info("Creating game: {}", request.getName());
        GamesEntity entity = converter.convert(request);
        GamesEntity saved = gamesRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(GamesResponse.from(saved));
    }

    @GetMapping
    public ResponseEntity<List<GamesResponse>> findAll() {
        log.info("Fetching all games");
        List<GamesResponse> responses = gamesRepository.findAll()
                .stream()
                .map(GamesResponse::from)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GamesResponse> findById(@PathVariable Long id) {
        log.info("Fetching game with id: {}", id);
        return gamesRepository.findById(id)
                .map(GamesResponse::from)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GamesResponse> update(@PathVariable Long id, @Valid @RequestBody GamesRequest request) {
        log.info("Updating game with id: {}", id);
        return gamesRepository.findById(id)
                .map(existing -> {
                    existing.setName(request.getName());
                    existing.setDescription(request.getDescription());
                    existing.setSize(request.getSize());
                    existing.setDevTeam(request.getDevTeam());
                    return ResponseEntity.ok(GamesResponse.from(gamesRepository.save(existing)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Deleting game with id: {}", id);
        if (!gamesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        gamesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}