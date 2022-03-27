package main.java.bibliographyManager;

import java.util.HashMap;

public class ConcreteBibItemFactory {
    private static ConcreteBibItemFactory self;
    HashMap<String, ItemInputStrategy> inputStrategies;

    protected ConcreteBibItemFactory(HashMap<String, ItemInputStrategy> inputStrategies) {
        this.inputStrategies = inputStrategies;
    }

    public static ConcreteBibItemFactory getInstance(HashMap<String, ItemInputStrategy> inputStrategies) {
        if (self == null) self = new ConcreteBibItemFactory(inputStrategies);
        return self;
    }

    public BibItem createBibItem(String typeOfItem) {
        BibItem item = null;
        if (typeOfItem.equals("book")) {
            item = createBibItemUsingStrategy(inputStrategies.get("bookStrategy"));
        }
        if (typeOfItem.equals("article")) {
            item = createBibItemUsingStrategy(inputStrategies.get("articleStrategy"));
        }
        if (typeOfItem.equals("techReport")) {
            item = createBibItemUsingStrategy(inputStrategies.get("techReportStrategy"));
        }
        return item;
    }

    private BibItem createBibItemUsingStrategy(ItemInputStrategy strategy) {
        return strategy.createBibItemFromInput();
    }
}
