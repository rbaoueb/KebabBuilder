package com.mrbaoueb.kebab;

import java.util.Arrays;
import java.util.List;

public enum Ingredient {
    LAITUE(KebabType.VEGETARIEN, new Regime[]{Regime.VEGETARIEN, Regime.PESCETARIEN, Regime.CARNIVORE}),
    ROQUETTE(KebabType.VEGETARIEN, new Regime[]{Regime.VEGETARIEN, Regime.PESCETARIEN, Regime.CARNIVORE}),
    TOMATE(KebabType.VEGETARIEN, new Regime[]{Regime.VEGETARIEN, Regime.PESCETARIEN, Regime.CARNIVORE}),
    OIGNON(KebabType.VEGETARIEN, new Regime[]{Regime.VEGETARIEN, Regime.PESCETARIEN, Regime.CARNIVORE}),
    CHEDDAR(KebabType.FROMAGE, new Regime[]{Regime.VEGETARIEN, Regime.PESCETARIEN, Regime.CARNIVORE}),
    AGNEAU(KebabType.VIANDE, new Regime[]{Regime.CARNIVORE}),
    BOEUF(KebabType.VIANDE, new Regime[]{Regime.CARNIVORE}),
    MERLU(KebabType.POISSON, new Regime[]{Regime.PESCETARIEN, Regime.CARNIVORE});

    private final KebabType kebabType;
    private final Regime[] regimes;

    Ingredient(KebabType kebabType, Regime[] regimes) {
        this.kebabType = kebabType;
        this.regimes = regimes;
    }

    public KebabType category() {
        return kebabType;
    }

    public List<Regime> regimes() {
        return Arrays.asList(regimes);
    }
}
