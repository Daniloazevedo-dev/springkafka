package br.com.springkafka.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    @ManyToOne
    private People people;
}
