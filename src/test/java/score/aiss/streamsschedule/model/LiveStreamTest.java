package score.aiss.streamsschedule.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class LiveStreamTest {

    @Test
    void createNewMutableLiveStream() {
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Building REST APIs with Spring Boot");
        stream.setDescription("This is a sample description");
        stream.setUrl("https://www.youtube.com/watch?v=q_RLfOB7axQ&t=535s");
        stream.setStartDate(LocalDateTime.of(2022, 8, 26, 15, 30,00));
        stream.setEndDate(LocalDateTime.of(2022, 8, 26, 17, 30,00));

        assertNotNull(stream, "Null object");
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle(),"Wrong title");
    }

    @Test
    void createNewInmutableLiveStream() {
        InmutableLiveStream stream = new InmutableLiveStream(UUID.randomUUID().toString(),
        "Building REST APIs with Spring Boot",
        "This is a sample description",
        "https://www.youtube.com/watch?v=q_RLfOB7axQ&t=535s",
        LocalDateTime.of(2022, 8, 26, 15, 30,00),
        LocalDateTime.of(2022, 8, 26, 17, 30,00));

        assertNotNull(stream, "Null object");
        assertEquals("Building REST APIs with Spring Boot", stream.getTitle(),"Wrong title");
    }

    @Test
    void createNewLiveStream() {
        LiveStream stream = new LiveStream(UUID.randomUUID().toString(),
                "Building REST APIs with Spring Boot",
                "This is a sample description",
                "https://www.youtube.com/watch?v=q_RLfOB7axQ&t=535s",
                LocalDateTime.of(2022, 8, 26, 15, 30,00),
                LocalDateTime.of(2022, 8, 26, 17, 30,00));

        assertNotNull(stream, "Null object");
        assertEquals("Building REST APIs with Spring Boot", stream.title(),"Wrong title");
        assertTrue(stream.getClass().isRecord());
        assertEquals(6, stream.getClass().getRecordComponents().length);
    }

}
