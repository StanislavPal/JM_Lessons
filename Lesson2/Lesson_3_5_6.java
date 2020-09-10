package Lesson2;

import java.util.Arrays;

public class Lesson_3_5_6 {
    public static class AsciiCharSequence implements CharSequence {
        private final byte[] value;

        public AsciiCharSequence(byte[] value) {
//            this.value = Arrays.copyOf(value, value.length);
            this.value = value;
        }

        @Override
        public String toString() {
            char[] chValue = new char[value.length];
            for (int i = 0; i < value.length; i++) {
                chValue[i] = (char) value[i];
            }
            return String.valueOf(chValue);
//            return new String(value).intern();
        }

        @Override
        public int length() {
            return value.length;
        }

        @Override
        public char charAt(int index) {
            return (char) value[index];
        }

        @Override
        public CharSequence subSequence(int beginIndex, int endIndex) {
            if (beginIndex == 0 && endIndex == length()) {
                return this;
            }
            return new AsciiCharSequence( Arrays.copyOfRange(value, beginIndex, endIndex) );
        }
    }
    public static void main(String[] args) {
        byte[] b = {67, 72, 45, 88};
        AsciiCharSequence acs = new AsciiCharSequence(b);
        System.out.println( acs );
        b[1] = 89;
        System.out.println( acs );
        System.out.println(Arrays.toString(b));
    }
}
