package Lesson3.l357;

public abstract class AbstractKeywordAnalyzer implements TextAnalyzer {

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for ( String keyword: getKeywords() ) {
            if ( text.contains(keyword) ) {
                return getLabel();
            }
        }
        return Label.OK;
    }

}
