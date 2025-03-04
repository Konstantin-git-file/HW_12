package ru.elizarov.Converter;

public interface DocumentTransformer<T, R> {
    R transform(T content);
}
