package Lesson2;

import java.util.ArrayList;

public class Lesson_2_4_19_2 {
    public static void main(String[] args) {
        String text = "Городничий:        Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор. (1)\n" +
                      "Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор. (2)\n" +
                      "Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор. (3)\n" +
                      "Аммос Федорович: Как ревизор?\n" +
                      "Артемий Филиппович: Как ревизор?\n" +
                      "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\n" +
                      "Аммос Федорович: Вот те на!\n" +
                      "Артемий Филиппович: Вот не было заботы, так подай!\n" +
                      "Лука Лукич: Господи боже! еще и с секретным предписаньем!";
        String roles = "Городничий\n" +
                       "Аммос Федорович\n" +
                       "Артемий Филиппович\n" +
                       "Лука Лукич";

        String[] textLines = text.split("\n");
        String[] roleLines = roles.split("\n");

        System.out.println( printTextPerRole(roleLines, textLines) );

        roleLines = new String[]{
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич",
                "Демис Карибидис",
                "Лука"
        };
        textLines = new String[]{
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович:        Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                "Лука Лукич: сэмпл текс Лука Лукич:",
                "Лука Лукич: Лука: Господи боже!  еще и с секретным предписаньем",
                "  "
        };

        System.out.println( printTextPerRole(roleLines, textLines) );

    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        // Буфер для накопления реплик из множества строк, нужна для случая, если роль говорит за раз много строк
        StringBuilder strBuff = new StringBuilder();

        // Динамические массивы для накопления реплик и ролей
        ArrayList<String> replicasList = new ArrayList<>();
        ArrayList<String> rolesList = new ArrayList<>();

        // Основной цикл по всем строчкам текста
        for (String str : textLines) {

            String role = "";
            StringBuilder replica = new StringBuilder();

            //Парсим строку на куски по ":" в массив
            String[] piecesStr = str.trim().split(":");
            if (piecesStr.length != 0) {
                role = piecesStr[0];
            }

            /* Проверяем, что в кусок текста, который мог бы быть ролью, найден
               и входит в исходный массив роллей.
               Значит это роль.
             */
            if ((role.length() != 0) && ( isInArray(roles, role) )) {
                //Добавляем её в лист ролей,
                rolesList.add(role);
                //и если был накоплен к этому моменту буфер реплик
                if (strBuff.length() != 0) {
                    //его - в лист реплик
                    replicasList.add(strBuff.toString());
                    //И очищаем, для нового использования
                    strBuff.setLength(0);
                }
                //
                replica.append( str.replaceFirst(role + ":", "").trim() );
            } else {
                //Или не парсим, а просто берём всю, если строка не начиналась с роли.
                replica.append(str.trim());
            }
            //добавляем в буфер
            strBuff.append(replica).append("\n");
        }
        //Если в буфере что-то осталось, то выгружаем
        if (strBuff.length() != 0) {
            //его - в лист реплик
            replicasList.add(strBuff.toString());
        }

        //Строка<StringBuilder>, в которую всё собираем и строку из которой вернёт метод
        StringBuilder result = new StringBuilder();

        //Перебираем роли из исходного массива
        for (String role : roles) {
            //Добавляем роль с переносом строки
            result.append(role).append(":\n");

            //Ищем в цикле вхождения ролей в нашем массиве ролей
            for (int j = 0; j < replicasList.size(); j++) {
                //Если нашли
                if ( rolesList.get(j).equals(role) ) {
                    //Пишем в результирующую строку индекс реплики и саму реплику
                    result.append(j + 1).append(") ").append( replicasList.get(j) );
                }
            }

            //Дабавляем пустую строку между ролями
            result.append("\n");

        }

        return result.toString();

    }

    //Функция поиска в массиве вместо более удобного Arrays.asList().contains()...
    public static boolean isInArray(String[] arr, String s) {

        for (String a : arr) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;

    }

}
