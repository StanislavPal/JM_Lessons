public class Program {

    public static void main(String[] args) throws Exception {

        System.out.print(charExpression(0));
        System.out.println();
        System.out.println('\u221e');
        int x = 'f';
        System.out.println("fffffffff = " + x);
        Integer.bitCount(123);
        byte b = 1;
        byte bb = 2;
        byte bbb = b;
        double d = 10d/3d;
        System.out.println(d);
        /*
        for (int i = 1; i < 65_535 ; i++  ) {
            System.out.print(charExpression(i));
            if (i % 130 == 0) {
                System.out.println();
            }
        }
         */
        System.out.println((char)('\\' + 6));

        /*
        int[] arr = {0, 1, 2, 3, 10, 100, 1000, 10_000, 100_000, 1_000_000};
        for (int i : arr) {
            countStep(0.0f, 0.1f, i);
        }
        */
    }

    public static char charExpression(int a) {
        return (char)('\\' + a);
    }


    public static void countStep(float begin, float end, int offset) {
        float x = offset + begin;
        float y = offset + end;
        int numFloats = 0;
        while (x <= y) {
            numFloats++;
            x = Math.nextUp(x);
        }
        System.out.printf("В диапазоне [%f; %f] существует \t %d промежуточных чисел.\n", offset + begin, y, numFloats);
    }
}
