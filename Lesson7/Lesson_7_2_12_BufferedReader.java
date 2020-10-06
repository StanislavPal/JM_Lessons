package Lesson7;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lesson_7_2_12_BufferedReader {
    public static void main(String[] args) {
//        String strTest1 = "Мама мыла-мыла-мыла раму!";
//
//        String strTest2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
//
//        BufferedReader bf = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(strTest2.getBytes()),
        Charset charset = Charset.forName("UTF-8");
        String text = "Lorem ipsum dolor sit amet, "
                + "consectetur 32 adipiscing elit. "
                + "Sed sodales consectetur purus at faucibus."
                + " Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. "
                + "Morbi lacinia velit blandit 32 tincidunt 32 efficitur. "
                + "Vestibulum eget metus imperdiet sapien laoreet faucibus. "
                + "Nunc eget vehicula mauris, ac auctor lorem. 32 Lorem ipsum dolor sit amet,"
                + " consectetur adipiscing elit. Integer vel odio 32 nec mi tempor dignissim.";
        ByteArrayInputStream textInput = new ByteArrayInputStream(text.getBytes());
        System.setIn(textInput);
//        countOfWords(System.in, charset);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> map = bf.lines()
                .map(s -> s.toLowerCase())
                .flatMap(str -> Arrays.stream(str.split("[^a-zA-Zа-яА-Я0-9]+")))
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );

        map.entrySet()
                .stream()
                .sorted( Map.Entry.<String, Long>comparingByValue().reversed().thenComparing( Map.Entry.comparingByKey()) )
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()) );
    }
}
