package Lesson3.l357;

public class NegativeTextAnalyzer implements TextAnalyzer{
    public NegativeTextAnalyzer() {
    }

    public Label processText(String text) {
        return Label.NEGATIVE_TEXT;
    }

}
