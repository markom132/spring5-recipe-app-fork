package guru.springframework.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */

@Entity
public class Recipe {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Integer prepTime;
    @Getter
    @Setter
    private Integer cookTime;
    @Getter
    @Setter
    private Integer servings;
    @Getter
    @Setter
    private String source;
    @Getter
    @Setter
    private String url;

    @Lob
    @Getter
    @Setter
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    @Getter
    @Setter
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    @Getter
    @Setter
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
    @Getter
    @Setter
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @Getter
    @Setter
    private Set<Category> categories = new HashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}