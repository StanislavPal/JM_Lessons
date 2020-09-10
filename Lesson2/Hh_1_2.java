package Lesson2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hh_1_2 {
    public static void main(String[] args) {

        System.out.print("Введите строку из двух слов: ");
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        in.close();

        System.out.println( test(str1, str2) );
    }

    public static int test(String str1, String str2) {

        if ( str1.length() != str2.length() ) {
            return 0;
        }

        if ( str1.equals(str2) ) {
            return 1;
        }

        Map<Character, Character> cash = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if ( cash.containsKey( str1.charAt(i) ) ) {
                if ( cash.get( str1.charAt(i) ) != str2.charAt(i) ) {
                    return 0;
                }
            } else {
                cash.put( str1.charAt(i), str2.charAt(i) );
            }
        }

        //Проверка на достаточность свободных символов для замены
        if (str2.chars().distinct().count() == 33) {
            return 0;
        }
        return 1;
    }

}
