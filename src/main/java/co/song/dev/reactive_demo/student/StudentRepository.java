package co.song.dev.reactive_demo.student;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student,Long> {
//    Flux<Student> findAllByFirstnameIgnoreCase(String firstname);

    Flux<Student> findAllByFirstnameContainingIgnoreCase(String firstname);
}
