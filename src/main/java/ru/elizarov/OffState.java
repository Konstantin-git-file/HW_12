package ru.elizarov;

import lombok.Getter;

// выкл.
class OffState implements State {
    @Getter
    private static final OffState instance = new OffState();
    private OffState() {}

    @Override
    public void make() {
        System.out.println("Выкл!");
    }

    @Override
    public void next(Trafficlight trafficlight) {
        trafficlight.setCur(this); // остается выкл
    }
}