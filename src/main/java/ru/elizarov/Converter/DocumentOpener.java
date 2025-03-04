package ru.elizarov.Converter;

public interface DocumentOpener<T> {
    T open(String filename);
}

