package ru.elizarov;

public class Main {
    public static void main(String[] args) {
        Trafficlight tl = new Trafficlight();

        // по дефолту дневной режим
        tl.next(); // красный
        tl.next(); // желтый
        tl.next(); // зеленый
        tl.next(); // желтый
        tl.next(); // красный

        // ночной режим
        tl.setMode(Trafficlight.Mode.NIGHT);
        tl.next(); // мигающий желтый
        tl.next(); // желтый (остается)

        // выключаем светофор
        tl.off();
        tl.next();
        tl.next();

        // включаем обратно
        tl.on();
        tl.next();
        tl.next();

        // форсим включение зеленого
        tl.forceState(GreenState.getInstance());
        tl.next();

        // возвращаемся в дефолт режим
        tl.setMode(Trafficlight.Mode.DAY);
        tl.next(); // желтый
        tl.next(); // зеленый;
    }
}