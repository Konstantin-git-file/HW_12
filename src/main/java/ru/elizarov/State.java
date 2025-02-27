package ru.elizarov;

// состояния
interface State {
    void make(); // вывести цвет
    void next(Trafficlight trafficlight); // переключение состояния

    default void on(Trafficlight trafficlight) {}
    default void off(Trafficlight trafficlight) {}
}
