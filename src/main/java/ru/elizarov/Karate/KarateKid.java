package ru.elizarov.Karate;

import lombok.Getter;

import java.util.List;
import java.util.function.Consumer;

@Getter
public class KarateKid {
    private final String name;

    public KarateKid(String name) {
        this.name = name;
    }

    public void kick() {
        System.out.println(name + ": бац!");
    }

    public void punch() {
        System.out.println(name + ": кия!");
    }

    public void jumpKick() {
        System.out.println(name + ": вжух!");
    }

    // комбо
    public void performCombo(List<Consumer<KarateKid>> combo) {
        combo.forEach(move -> move.accept(this));
    }
}
