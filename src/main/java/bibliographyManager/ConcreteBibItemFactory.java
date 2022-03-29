package main.java.bibliographyManager;

public class ConcreteBibItemFactory {
    private static ConcreteBibItemFactory self;
    ItemInputStrategy bookStrategy;
    ItemInputStrategy articleStrategy;
    ItemInputStrategy techReportStrategy;

    public ConcreteBibItemFactory() {
        bookStrategy = new BookGUIInputStrategy();
        articleStrategy = new ArticleGUIInputStrategy();
        techReportStrategy = new TechReportGUIInputStrategy();
    }

    public static ConcreteBibItemFactory getInstance() {
        if (self == null) self = new ConcreteBibItemFactory();
        return self;
    }

    public BibItem createBibItem(String typeOfItem) {
        BibItem item = null;
        if (typeOfItem.equals("book")) {
            item = createBibItemUsingStrategy(bookStrategy);
        }
        if (typeOfItem.equals("article")) {
            item = createBibItemUsingStrategy(articleStrategy);
        }
        if (typeOfItem.equals("techReport")) {
            item = createBibItemUsingStrategy(techReportStrategy);
        }
        return item;
    }

    private BibItem createBibItemUsingStrategy(ItemInputStrategy strategy) {
        return strategy.createBibItemFromInput();
    }
}
