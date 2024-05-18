package guru.springframework.model;

import lombok.*;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @OneToOne
    @Getter
    @Setter
    private Recipe recipe;
    @Lob
    @Getter
    @Setter
    private String recipeNotes;

}
