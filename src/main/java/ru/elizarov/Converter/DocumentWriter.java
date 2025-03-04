package ru.elizarov.Converter;


public interface DocumentWriter<R> {
    void write(R content, String filename);
}
