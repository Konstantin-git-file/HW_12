package ru.elizarov;

import lombok.Getter;


@Getter
class BlinkingYellowState implements State {
    @Getter
    private static final BlinkingYellowState instance = new BlinkingYellowState();

    private BlinkingYellowState() {}

    @Override
    public void make() {
        System.out.println("мигающий желтый");
    }

    @Override
    public void next(Trafficlight trafficlight) {
        if (trafficlight.getMode() == Trafficlight.Mode.NIGHT) {
            trafficlight.setCur(this);
        } else {
            trafficlight.setCur(YellowState.getInstance());
        }
    }
}