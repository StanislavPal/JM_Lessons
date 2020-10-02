package Lesson3.l357;

public class NegativeTextAnalyzer extends AbstractKeywordAnalyzer{
    private final String[] keywords = {":(", "=(", ":|"};
    public NegativeTextAnalyzer() {
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
