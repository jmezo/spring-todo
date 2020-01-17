package hu.flowacademy.todo.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private byte[] media;

    private String mediaContentType;

    @ManyToOne
    @JoinColumn
    private User owner;

    // @TODO checklist

}
