package com.udemy.basic.dp.structural.facade.challenge;

public class NonVegBothRestaurant implements Hotel {
    public Menus getMenus() {
        return new NonVegMenu();
    }
}
