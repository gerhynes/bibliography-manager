package main.java.bibliographyManager;

/**
 * Creates specific BibItems based off the strategy provided
 */
public class ConcreteBibItemFactory {
    private ItemInputStrategy bookStrategy;
    private ItemInputStrategy articleStrategy;
    private ItemInputStrategy techReportStrategy;

    /**
     * Generate ConcreteBibItemFactory and instantiate strategies
     */
    public ConcreteBibItemFactory() {
        bookStrategy = new BookGUIInputStrategy();
        articleStrategy = new ArticleGUIInputStrategy();
        techReportStrategy = new TechReportGUIInputStrategy();
    }

    /**
     * Selects appropriate strategy based off option provided
     * Delegates creation of BibItem to createBibItemUsingStrategy()
     * @param typeOfItem
     * @return
     */
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

    /**
     * Creates specific BibItem based off strategy provided
     * @param strategy
     * @return
     */
    private BibItem createBibItemUsingStrategy(ItemInputStrategy strategy) {
        return strategy.createBibItemFromInput();
    }
}
