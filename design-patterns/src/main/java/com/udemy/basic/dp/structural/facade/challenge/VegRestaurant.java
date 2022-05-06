package com.udemy.basic.dp.structural.facade.challenge;

public class VegRestaurant implements Hotel {
    public Menus getMenus() {
        return new VegMenu();
    }
}
