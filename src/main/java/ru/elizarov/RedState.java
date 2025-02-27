package ru.elizarov;

import lombok.Getter;

@Getter
class RedState implements State {
    @Getter
    private static final RedState instance = new RedState(); // синглетон
    private RedState() {}

    @Override
    public void make() {
        System.out.println("красный");
    }

    @Override
    public void next(Trafficlight trafficlight) {
        trafficlight.setCur(YellowState.getInstance()); // Переход на желтый
    }
}