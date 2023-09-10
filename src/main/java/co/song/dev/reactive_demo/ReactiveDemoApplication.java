package co.song.dev.reactive_demo;

import co.song.dev.reactive_demo.student.Student;
import co.song.dev.reactive_demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner
            (StudentRepository studentRepository){

        return args -> {
            for (int i = 0; i < 100; i++) {
                studentRepository.save(
                        Student.builder()
                                .firstname("Ear" + i)
                                .lastname("Bunsong" + i)
                                .age(i)
                                .build()
                ).subscribe();
            }
        };
    }

}