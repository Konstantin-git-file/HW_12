package ru.elizarov;

import lombok.Getter;

@Getter
class YellowAfterRedState implements State {
    @Getter
    private static final YellowAfterRedState instance = new YellowAfterRedState();
    private YellowAfterRedState() {}

    @Override
    public void make() {
        System.out.println("yellow");
    }

    @Override
    public void next(Trafficlight trafficlight) {
        trafficlight.setCur(GreenState.getInstance());
    }
}
