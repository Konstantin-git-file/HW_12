package ru.elizarov;

import lombok.Getter;

@Getter
class GreenState implements State {
    @Getter
    private static final GreenState instance = new GreenState();
    private GreenState() {}

    @Override
    public void make() {
        System.out.println("зеленый");
    }

    @Override
    public void next(Trafficlight trafficlight) {
        trafficlight.setCur(YellowState.getInstance()); // переходим на желтый
    }
}