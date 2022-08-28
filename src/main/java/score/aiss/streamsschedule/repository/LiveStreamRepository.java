package score.aiss.streamsschedule.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import score.aiss.streamsschedule.model.LiveStream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {

    List<LiveStream> streams = new ArrayList();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Building REST APIs with Spring Boot",
                "This is a sample description",
                "https://www.youtube.com/watch?v=q_RLfOB7axQ&t=535s",
                LocalDateTime.of(2022, 8, 26, 15, 30,00),
                LocalDateTime.of(2022, 8, 26, 17, 30,00)));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) {
        return streams.stream().filter(stream -> stream.id().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Stream not found"));
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update (LiveStream stream, String id) {
        LiveStream existing = findById(id);
        int i = streams.indexOf(existing);
        streams.set(i, stream);
    }

    public void delete (String id) {
        streams.removeIf(stream -> stream.id().equals(id));
    }

}
