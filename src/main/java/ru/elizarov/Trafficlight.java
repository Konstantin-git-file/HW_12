package ru.elizarov;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
class Trafficlight {
    enum Mode { DAY, NIGHT, EMERGENCY }
    private State cur;
    private Mode mode;
    private State defaultState; // по умолчанию для текущего режима

    public Trafficlight() {
        cur = RedState.getInstance();
        mode = Mode.DAY;
        defaultState = cur;
    }

    public void setMode(Mode newMode) {
        this.mode = newMode;
        switch (newMode) {
            case DAY -> defaultState = RedState.getInstance();
            case NIGHT -> defaultState = BlinkingYellowState.getInstance();
            case EMERGENCY -> defaultState = RedState.getInstance();
        }
        System.out.println("переключение на: " + mode);
    }

    public void forceState(State state) {
        this.cur = state;
        System.out.println("в ручную ставим: " + state.getClass().getSimpleName());
    }

    public void off() {
        defaultState = cur;
        cur = OffState.getInstance();
        cur.off(this);
    }

    public void on() {
        cur.on(this);
        cur = defaultState != null ? defaultState : RedState.getInstance();
    }


    public void next() {
        cur.make();
//        ну это так todo
//        try {
//            Thread.sleep(getDelayForState(cur));
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
        if (mode == Mode.DAY) {
            cur.next(this); // cтандарт мод
        } else {
            cur = defaultState; // ручной мод для ночного режима или аварийного
        }
    }

    private long getDelayForState(State state) {
        if (state instanceof RedState || state instanceof GreenState) {
            return 5000;
        } else if (state instanceof YellowState) {
            return 2000;
        }
        return 0;
    }
}
