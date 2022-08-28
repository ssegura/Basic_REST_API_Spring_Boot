package score.aiss.streamsschedule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import score.aiss.streamsschedule.exception.LiveStreamNotFoundException;
import score.aiss.streamsschedule.model.LiveStream;
import score.aiss.streamsschedule.repository.LiveStreamRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    // GET http://localhost:8080/streams
    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    // GET http://localhost:8080/streams/0b478404-03d3-4969-8d78-1e89042f5fe8
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id) throws LiveStreamNotFoundException {
        return repository.findById(id);
    }

    // POST http://localhost:8080/streams
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@Valid @RequestBody LiveStream stream) {
        return repository.create(stream);
    }

    // PUT http://localhost:8080/streams/0b478404-03d3-4969-8d78-1e89042f5fe8
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping ("/{id}")
    public void update(@RequestBody LiveStream stream, @PathVariable String id) throws LiveStreamNotFoundException {
        repository.update(stream,id);
    }

    // DELETE http://localhost:8080/streams/0b478404-03d3-4969-8d78-1e89042f5fe8
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

    /* To manipulate the response (ex. adding headers):
    public ResponseEntity<LiveStream> (...)
    */

}
