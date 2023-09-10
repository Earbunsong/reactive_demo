package co.song.dev.reactive_demo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Flux<Student> findAll() {
        return repository.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<Student> save(StudentRequest request) {
        return repository.save(
                Student.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .age(request.getAge())
                        .build()
        );
    }

    public Flux<Student> findByFirstname(String firstname) {
        return repository.findAllByFirstnameContainingIgnoreCase(firstname);
    }

    public void deleteById(Long id) {
        repository.deleteById(id).subscribe();
    }
}