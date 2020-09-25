package sandbox;

public class SurrogatePair {
    public static void main(String[] args) {
        char ch1 = 0xd83d;
        char ch2 = 0xde80;

        System.out.println("Привет!");
        if (Character.isSurrogatePair(ch1, ch2)) {
            System.out.println("ch1 и ch2 являются корректной суррогатной парой");

            int codePoint = Character.toCodePoint(ch1, ch2);
            System.out.println("Кодовая точка ch1 и ch2 равна " + codePoint);

            char[] ch;
            ch = Character.toChars(codePoint);
            System.out.println("ch 2 string" + String.copyValueOf(ch));
            for (char c : ch) {
                System.out.println(c);
            }
        } else {
            System.out.println("ch1 и ch2 не являются корректной суррогатной парой");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ch1).append(ch2);
        System.out.println("ch1 ch2 2 StringBuilder" + sb.toString());
    }

}
