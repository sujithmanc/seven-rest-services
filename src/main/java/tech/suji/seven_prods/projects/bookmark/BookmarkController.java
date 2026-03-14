package tech.suji.seven_prods.projects.bookmark;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {

	private final BookmarkRepository bookmarkRepository;

	public BookmarkController(BookmarkRepository bookmarkRepository) {
		this.bookmarkRepository = bookmarkRepository;
	}

	@PostMapping
	public ResponseEntity<BookmarkResponse> createBookmark(@Valid @RequestBody BookmarkRequest request) {
		BookmarkEntity entity = BookmarkRequestToEntityConvertor.convert(request);
		BookmarkEntity saved = bookmarkRepository.save(entity);
		log.info("Created bookmark: {}", saved);
		return ResponseEntity.ok(toResponse(saved));
	}

	@GetMapping
	public ResponseEntity<List<BookmarkResponse>> getAllBookmarks() {
		List<BookmarkResponse> response = bookmarkRepository.findAll().stream().map(this::toResponse)
				.collect(Collectors.toList());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookmarkResponse> getBookmarkById(@PathVariable Long id) {
		Optional<BookmarkEntity> entity = bookmarkRepository.findById(id);
		if (entity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(toResponse(entity.get()));
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookmarkResponse> updateBookmark(@PathVariable Long id,
			@Valid @RequestBody BookmarkRequest request) {

		Optional<BookmarkEntity> existing = bookmarkRepository.findById(id);
		if (existing.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		BookmarkEntity entity = existing.get();
		entity.setTitle(request.getTitle());
		entity.setUri(request.getUri());
		entity.setLogo(request.getLogo());
		entity.setAltText(request.getAltText());
		entity.setAltTextColor(request.getAltTextColor());

		BookmarkEntity updated = bookmarkRepository.save(entity);
		log.info("Updated bookmark: {}", updated);

		return ResponseEntity.ok(toResponse(updated));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBookmark(@PathVariable Long id) {
		Optional<BookmarkEntity> entity = bookmarkRepository.findById(id);
		if (entity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		bookmarkRepository.deleteById(id);
		log.info("Deleted bookmark with id {}", id);

		return ResponseEntity.noContent().build();
	}

	private BookmarkResponse toResponse(BookmarkEntity entity) {
		return BookmarkResponse.builder().id(entity.getId()).title(entity.getTitle()).uri(entity.getUri())
				.logo(entity.getLogo()).altText(entity.getAltText()).altTextColor(entity.getAltTextColor())
				.dateCreated(entity.getDateCreated()).lastUpdated(entity.getLastUpdated()).build();
	}
}