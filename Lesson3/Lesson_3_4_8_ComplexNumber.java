package Lesson3;

public class Lesson_3_4_8_ComplexNumber {
    public static void main(String[] args) {

    }

    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj) {return true;}
//            if (obj == null) {return false;}
//            if( this.getClass() != obj.getClass() ) {return false;}
//            ComplexNumber other = (ComplexNumber) obj;
//            if (( Double.doubleToLongBits(re) != Double.doubleToLongBits(other.re) )
//                    || (Double.doubleToLongBits(im) != Double.doubleToLongBits(other.im) )) {
//                return false;
//            }
//            return true;
//        }
//
//        @Override
//        public int hashCode() {
//            final int prime = 31;
//            int result = 38;
//            long l;
//
//            l = Double.doubleToLongBits(re);
//            result = prime * result + (int) (l ^ (l>>>32));
//            l = Double.doubleToLongBits(im);
//            result = prime * result + (int) (l ^ (l>>>32));
//            return result;
//        }
    }
}
