package Lesson3.l357;

import java.util.Arrays;

public class SpamAnalyzer implements TextAnalyzer{
    private String[] keywords;

    public SpamAnalyzer (String[] keywords) {
        this.keywords = keywords.clone();
    }

    public Label processText(String text) {
        return Label.SPAM;
    }

}
