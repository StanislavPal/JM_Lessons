package Lesson7;

public interface NumberGenerator<T extends Number> {
    boolean cond(T arg);

    public static NumberGenerator<? super Number> getGenerator() {
        return x -> x.intValue() >= 0;
    }
}
