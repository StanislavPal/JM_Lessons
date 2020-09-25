package sandbox;

public class MaxArrayIndex {
    public static void main(String[] args) {
        byte[] string = new byte[2_047_483_000];
        long l = Long.MAX_VALUE;
        float f = l;
        long lAfterFloat = (long) f;
        System.out.println(l == lAfterFloat);
    }
}
