package com.udemy.basic.dp.structural.facade.challenge;

public class NonVegMenu extends Menus {
    public NonVegMenu() {
        System.out.println("Creating a non-veg menu.");
    }

    @Override
    public void showMenu() {
        System.out.println("Non vegan menu.");
    }
}
