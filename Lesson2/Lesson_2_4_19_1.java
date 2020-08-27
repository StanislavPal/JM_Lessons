package Lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Lesson_2_4_19_1 {
    public static void main(String[] args) {
        String text = "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор. (1)\n" +
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
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        /*
        Регулярное выражение для поиска роли в строках текста.
        Роль всегда в начале строки (^), а завершает её всегда ": "
        сама роль в ()
         */
        String roleRegex = "^(.+?):\\s";
        Pattern pattern = Pattern.compile(roleRegex);

        // Буфер для накопления реплик из множества строк, нужна для случая, если роль говорит за раз много строк
        StringBuilder strBuff = new StringBuilder();

        // Динамические массивы для накопления реплик и ролей
        ArrayList<String> replicasList = new ArrayList<>();
        ArrayList<String> rolesList = new ArrayList<>();

        // Основной цикл по всем строчкам текста
        for (String str : textLines) {

            // Поиск куска текста в строке по регулярному выражению, который мог быть ролью
            String role = pattern.matcher(str).results().findFirst().get().group(1);
            String replica;

            /* Проверяем, что в кусок текста, который мог бы быть ролью, найден
               и входит в исходный массив роллей.
               Значит это роль.
             */
            if ((role.length() != 0) && ( Arrays.asList(roles).contains(role) )) {
                //Добавляем её в лист ролей,
                rolesList.add(role);
                //и если был накоплен к этому моменту буфер реплик
                if (strBuff.length() != 0) {
                    //его - в лист реплик
                    replicasList.add(strBuff.toString());
                    //И очищаем, для нового использования
                    strBuff.setLength(0);
                }
                //Затем парсим оставшуюся часть строки,
                replica = str.replaceAll(roleRegex, "");
            } else {
                //Или не парсим, а просто берём всю, если строка не начиналась с роли.
                replica = str;
            }
            //добавляем в буфер
            strBuff.append(replica).append("\n");
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

}
