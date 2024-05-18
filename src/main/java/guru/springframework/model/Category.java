package guru.springframework.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String description;
    @ManyToMany(mappedBy = "categories")
    @Getter
    @Setter
    private Set<Recipe> recipes;

}
