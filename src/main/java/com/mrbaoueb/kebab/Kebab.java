package com.mrbaoueb.kebab;

import lombok.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Kebab {

    private String name;
    private KebabType type;
    private List<Ingredient> ingredients;

    public Kebab addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public Kebab removeIngredient(Ingredient ingredient) {
        ingredients.removeIf(ing -> ing.equals(ingredient));
        return this;
    }

    public Kebab doubleIngredient(KebabType kebabType) {
        this.ingredients = ingredients.stream()
                .flatMap(ingredient -> Objects.equals(ingredient.category(), kebabType) ? Stream.of(ingredient, ingredient) : Stream.of(ingredient))
                .collect(Collectors.toCollection(LinkedList::new));
        return this;
    }

    public boolean satisfyRegime(Regime regime) {
        return ingredients.stream()
                .allMatch(ingredient -> ingredient.regimes().contains(regime));
    }


}
