package ru.elizarov.Converter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Converter<T, R> {
    private final DocumentOpener<T> opener;
    private final DocumentTransformer<T, R> transformer;
    private final DocumentWriter<R> writer;

    public void convert(String sourceFile, String targetFile) {
        T content = opener.open(sourceFile);
        R transformedContent = transformer.transform(content);
        writer.write(transformedContent, targetFile);
    }
}