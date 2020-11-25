package com.dibraga.sheets;

import java.util.ArrayList;
import java.util.List;

public class Dishes {

    private List<Dish> dishes = new ArrayList<>();
    private List<Dish> sideDishes = new ArrayList<>();

    public Dishes() {
        Dish arroz = new Dish("Arroz", "arroz", (float)5.00);
        Dish batata_frita = new Dish("Batata Frita", "batata_frita", (float)3.00);
        sideDishes.add(arroz);
        sideDishes.add(batata_frita);

        Dish feijoada = new Dish("Feijoada", "feijoada", (float)22.50);
        Dish parmegiana = new Dish("Parmegiana", "parmegiana", (float)18.60 ,sideDishes);
        Dish peixe_frito = new Dish("Peixe Frito", "peixe_frito", (float)20.30, sideDishes);
        Dish file_de_frango = new Dish("Filé de Frango", "file_de_frango", (float)15.00, sideDishes);

        dishes.add(feijoada);
        dishes.add(parmegiana);
        dishes.add(peixe_frito);
        dishes.add(file_de_frango);
    }

    public List<Dish> getDishes() {
        return this.dishes;
    }

    public List<Dish> getSideDishes() {
        return this.sideDishes;
    }
}
