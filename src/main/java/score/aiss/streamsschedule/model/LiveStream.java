package score.aiss.streamsschedule.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public record LiveStream (
        String id,
        @NotEmpty(message = "Stream title is required")
        String title,
        String description,
        String url,
        LocalDateTime startDate,
        LocalDateTime endDate) {}

/*

EQUIVALENT TO:

public class LiveStream {

    private final String id;
    private final String title;
    private final String description;
    private final String url;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public LiveStream(String id, String title, String description, String url, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiveStream that = (LiveStream) o;
        return id.equals(that.id) && title.equals(that.title) && description.equals(that.description) && url.equals(that.url) && startDate.equals(that.startDate) && endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, url, startDate, endDate);
    }

    @Override
    public String toString() {
        return "LiveStream{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
 */