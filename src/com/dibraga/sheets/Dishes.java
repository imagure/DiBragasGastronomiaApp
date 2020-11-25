package com.dibraga.sheets;

import java.util.ArrayList;
import java.util.List;

public class Dishes {

    public static List<Dish> dishes = new ArrayList<>();
    public static List<Dish> sideDishes = new ArrayList<>();

    public Dishes() {
        Dish arroz = new Dish("Arroz", "arroz");
        Dish batata_frita = new Dish("Batata Frita", "batata_frita");
        sideDishes.add(arroz);
        sideDishes.add(batata_frita);

        Dish feijoada = new Dish("Feijoada", "feijoada");
        Dish parmegiana = new Dish("Parmegiana", "parmegiana", sideDishes);
        Dish peixe_frito = new Dish("Peixe Frito", "peixe_frito", sideDishes);
        Dish file_de_frango = new Dish("Filé de Frango", "file_de_frango", sideDishes);

        dishes.add(feijoada);
        dishes.add(parmegiana);
        dishes.add(peixe_frito);
        dishes.add(file_de_frango);
    }
}
