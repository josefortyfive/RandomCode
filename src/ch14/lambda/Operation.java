package ch14.lambda;

@FunctionalInterface
public interface Operation<T> {
	T operate(T value1, T value2);

}
