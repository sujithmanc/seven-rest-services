package tech.suji.seven_prods.projects.bookmark;

public final class BookmarkRequestToEntityConvertor {

    private BookmarkRequestToEntityConvertor() {
    }

    public static BookmarkEntity convert(BookmarkRequest request) {
        if (request == null) {
            return null;
        }

        return BookmarkEntity.builder()
                .title(request.getTitle())
                .uri(request.getUri())
                .logo(request.getLogo())
                .altText(request.getAltText())
                .altTextColor(request.getAltTextColor())
                .build();
    }
}