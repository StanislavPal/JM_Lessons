package Lesson3.l357;

public class SpamAnalyzer extends AbstractKeywordAnalyzer {
    private String[] keywords;

    public SpamAnalyzer (String[] keywords) {
        this.keywords = keywords.clone();
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }

}
