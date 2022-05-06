package com.udemy.basic.dp.structural.flyweight.challenge;

public class Terrorist implements Player {
    private final String TASK;
    private WeaponType weapon;

    public Terrorist() {
        this.TASK = "Plant a bomb.";
    }

    public WeaponType getWeapon() {
        return weapon;
    }

    public void assignWeapon(WeaponType type) {
        this.weapon = type;
    }

    @Override
    public void mission() {
        System.out.println("Player: Terrorist, Weapon: " + weapon + ", Mission: " + TASK);
    }
}
