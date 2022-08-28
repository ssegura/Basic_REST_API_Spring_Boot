package score.aiss.streamsschedule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import score.aiss.streamsschedule.model.LiveStream;
import score.aiss.streamsschedule.repository.LiveStreamRepository;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    // http://localhost:8080/streams
    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    // http://localhost:8080/streams/0b478404-03d3-4969-8d78-1e89042f5fe8
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String ide) {
        return repository.findById(ide);
    }




}
