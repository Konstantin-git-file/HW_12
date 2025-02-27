package ru.elizarov;

import lombok.Getter;

@Getter
class YellowState implements State {
    @Getter
    private static final YellowState instance = new YellowState(); // Singleton
    private YellowState() {}

    @Override
    public void make() {
        System.out.println("желтый");
    }

    @Override
    public void next(Trafficlight trafficlight) {
        //хотя  получается inst redState всегда false
        trafficlight.setCur(trafficlight.getCur() instanceof RedState
                ? GreenState.getInstance() : RedState.getInstance());
    }
}

