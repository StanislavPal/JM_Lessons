package Lesson3.l357;

public class TooLongTextAnalyzer implements TextAnalyzer{
    private final int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public Label processText(String text) {
        if ( text.length() > getMaxLength() ) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}
