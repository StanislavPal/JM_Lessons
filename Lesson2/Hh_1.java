package Lesson2;

import java.util.ArrayList;
import java.util.Scanner;

public class Hh_1 {
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

        ArrayList<Integer> indexDiff = new ArrayList<>();
        ArrayList<Integer> indexEqal = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                indexDiff.add(i);
            } else {
                indexEqal.add(i);
            }
        }

        //Проверка на вхождение символа сразу в две области совпадающих и несовпадающих
        for (int i:indexDiff) {
            for (int j:indexEqal) {
                if ( str1.charAt(i) == str1.charAt(j) ) {
                    return 0;
                }
            }
        }

        //Проверка символов несовпадающих на парные
        ArrayList<Integer> indexCash = new ArrayList<>();
        boolean moreOneDiff = false;
        for (int i = 0; i < indexDiff.size(); i++) {
            if (indexCash.contains(i)) {
                continue;
            }
            indexCash.add(i);
            for (int j = i + 1; j < indexDiff.size(); j++) {
                if (indexCash.contains(j)) {
                    continue;
                }
                if (str1.charAt( indexDiff.get(i) ) == str1.charAt( indexDiff.get(j) )) {
                    indexCash.add(j);
                    if (str2.charAt( indexDiff.get(i) ) != str2.charAt( indexDiff.get(j) )) {
                        return 0;
                    }
                }else {
                    moreOneDiff = true;
                }
            }
        }

        //Проверка на достаточность свободных символов для замены
        if ((str2.chars().distinct().count() == 33)
        || ((str1.chars().distinct().count() == 33) && moreOneDiff)) {
            return 0;
        }
        return 1;
    }

}
