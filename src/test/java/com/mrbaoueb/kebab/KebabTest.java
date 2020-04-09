package com.mrbaoueb.kebab;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class KebabTest {

    private Kebab kebab;

    @Before
    public void setUp() {
        kebab = Kebab.builder().ingredients(new LinkedList<>()).name("Kebab for test").build();
        assertThat(kebab.getIngredients()).isNotNull();
        assertThat(kebab.getIngredients()).isEmpty();
    }

    @Test
    public void create_kebab_with_ingredient_test() {
        kebab.addIngredient(Ingredient.LAITUE)
                .addIngredient(Ingredient.AGNEAU)
                .addIngredient(Ingredient.CHEDDAR);
        assertThat(kebab.getIngredients()).containsExactly(Ingredient.LAITUE, Ingredient.AGNEAU, Ingredient.CHEDDAR);
    }

    @Test
    public void remove_ingredient_from_kebab_test() {
        kebab.addIngredient(Ingredient.LAITUE)
                .addIngredient(Ingredient.AGNEAU)
                .addIngredient(Ingredient.CHEDDAR)
                .addIngredient(Ingredient.AGNEAU)
                .removeIngredient(Ingredient.AGNEAU);

        assertThat(kebab.getIngredients()).containsExactly(Ingredient.LAITUE, Ingredient.CHEDDAR);
    }


    @Test
    public void create_kebab_with_double_cheese_test() {
        kebab.addIngredient(Ingredient.LAITUE)
                .addIngredient(Ingredient.BOEUF)
                .addIngredient(Ingredient.CHEDDAR)
                .addIngredient(Ingredient.ROQUETTE)
                .addIngredient(Ingredient.CHEDDAR)
                .doubleIngredient(KebabType.FROMAGE);

        assertThat(kebab.getIngredients()).containsExactly(Ingredient.LAITUE, Ingredient.BOEUF, Ingredient.CHEDDAR, Ingredient.CHEDDAR, Ingredient.ROQUETTE, Ingredient.CHEDDAR, Ingredient.CHEDDAR);
    }

    @Test
    public void create_empty_kebab_with_double_cheese_test() {
        kebab.doubleIngredient(KebabType.FROMAGE);
        assertThat(kebab.getIngredients()).isEmpty();
    }

    @Test
    public void create_no_cheese_kebab_with_double_cheese_test() {
        kebab.addIngredient(Ingredient.LAITUE)
                .addIngredient(Ingredient.BOEUF)
                .addIngredient(Ingredient.ROQUETTE)
                .doubleIngredient(KebabType.FROMAGE);

        assertThat(kebab.getIngredients()).containsExactly(Ingredient.LAITUE, Ingredient.BOEUF, Ingredient.ROQUETTE);

    }

    @Test
    public void verify_kebeb_vegetarian_test() {
        kebab.addIngredient(Ingredient.LAITUE)
                .addIngredient(Ingredient.MERLU)
                .addIngredient(Ingredient.ROQUETTE)
                .doubleIngredient(KebabType.FROMAGE);
        assertThat(kebab.satisfyRegime(Regime.VEGETARIEN)).isFalse();

        kebab.removeIngredient(Ingredient.MERLU);
        assertThat(kebab.satisfyRegime(Regime.VEGETARIEN)).isTrue();
    }

    @Test
    public void verify_kebeb_pescetarien_test() {
        kebab.addIngredient(Ingredient.TOMATE)
                .addIngredient(Ingredient.OIGNON)
                .addIngredient(Ingredient.MERLU)
                .addIngredient(Ingredient.BOEUF);
        assertThat(kebab.satisfyRegime(Regime.PESCETARIEN)).isFalse();

        kebab.removeIngredient(Ingredient.BOEUF);
        assertThat(kebab.satisfyRegime(Regime.PESCETARIEN)).isTrue();
    }

}
