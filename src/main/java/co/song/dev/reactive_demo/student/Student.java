package co.song.dev.reactive_demo.student;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Setter
@AllArgsConstructor
@Builder
@Table(name = "students")
public class Student {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private int age;

}
