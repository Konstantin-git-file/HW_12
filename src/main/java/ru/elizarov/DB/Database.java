package ru.elizarov.DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Database {
    private final List<String> data = new ArrayList<>();
    private final Map<Class<?>, Function<String, ?>> extractors = new HashMap<>();
    private final Map<Class<?>, Function<Object, String>> representators = new HashMap<>();

    // для добавления преобразователей (экстракторов)
    public <T> void addExtractor(Class<T> type, Function<String, T> extractor) {
        extractors.put(type, extractor);
    }

    // для добавления репрезентаторов (в строку)
    public <T> void addRepresentator(Class<T> type, Function<T, String> representator) {
        representators.put(type, obj -> representator.apply(type.cast(obj)));
    }

    // для добавления объекта в базу
    public <T> void push(T obj) {
        Function<Object, String> representator = representators.get(obj.getClass());
        if (representator == null) {
            throw new IllegalArgumentException("Не найден репрезентатор для класса: " + obj.getClass().getSimpleName());
        }
        data.add(representator.apply(obj));
    }

    // для получения объекта из базы по индексу и типу
    public <T> T get(int index, Class<T> type) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("Запись с таким индексом отсутствует");
        }
        String storedData = data.get(index);
        Function<String, ?> extractor = extractors.get(type);
        if (extractor == null) {
            throw new IllegalArgumentException("Не найден экстрактор для класса: " + type.getSimpleName());
        }
        return type.cast(extractor.apply(storedData));
    }

    @Override
    public String toString() {
        return "Database: " + data;
    }
}