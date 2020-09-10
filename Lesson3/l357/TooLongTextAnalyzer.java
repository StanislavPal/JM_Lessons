package Lesson3.l357;

public class TooLongTextAnalyzer implements TextAnalyzer{
    private int maxLength;

    public Label processText(String text) {
        return Label.TOO_LONG;
    }

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }
}
