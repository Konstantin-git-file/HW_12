package ru.elizarov;

import lombok.Getter;

@Getter
class YellowAfterGreenState implements State {
    @Getter
    private static final YellowAfterGreenState instance = new YellowAfterGreenState();

    private YellowAfterGreenState() {
    }

    @Override
    public void make() {
        System.out.println("yellow");
    }

    @Override
    public void next(Trafficlight trafficlight) {
        trafficlight.setCur(RedState.getInstance());
    }
}
