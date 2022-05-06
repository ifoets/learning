package com.udemy.basic.dp.structural.facade.challenge;

public class NonVegRestaurant implements Hotel {
    public Menus getMenus() {
        return new NonVegMenu();
    }
}
