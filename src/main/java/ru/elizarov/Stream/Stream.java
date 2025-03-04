package ru.elizarov.Stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Stream<T> {

    private final List<T> data;

    public Stream(List<T> data) {
        this.data = new ArrayList<>(data);
    }

    // для каждого
    public <R> Stream<R> applyFunction(Function<T, R> function) {
        List<R> result = data.stream()
                .map(function)
                .collect(Collectors.toList());
        return new Stream<>(result);
    }

    // для фильтрации
    public Stream<T> filter(Predicate<T> predicate) {
        List<T> result = data.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        return new Stream<>(result);
    }

    // reduce
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return data.stream()
                .reduce(identity, accumulator);
    }

    //  collect
    public <P> P collect(Supplier<P> collectionFactory, Function<List<T>, P> collector) {
        return collector.apply(data);
    }
}
