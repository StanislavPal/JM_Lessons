package Lesson2;

public class Lesson_2_4_19_4 {
    public static void main(String[] args) {
        String text = "Городничий:        Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор. (1)\n" +
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
        StringBuilder str = new StringBuilder();
        for (String role: roles) {
            str.append(role).append(":\n");
            for (int i = 0; i < textLines.length; i++) {
                if ( textLines[i].trim().startsWith(role + ":") ) {
                    str.append(i + 1).append(") ").append( textLines[i].replaceFirst(role + ":", "").trim() ).append("\n");
                }
            }
            str.append("\n");
        }
        return str.toString();
    }
}
