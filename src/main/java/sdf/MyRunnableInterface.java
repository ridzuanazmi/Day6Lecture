package sdf;
/*
 * Only have the function signature but no implementation
 */
@FunctionalInterface
public interface MyRunnableInterface<T> {
    // T denotes an object
    T process(T a, T b);
}
