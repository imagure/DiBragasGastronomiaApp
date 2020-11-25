package com.dibraga.sheets;

import java.util.ArrayList;
import java.util.List;

public class Dishes {

    public static List<Dish> dishes = new ArrayList<>();

    public Dishes() {
        Dish feijoada = new Dish("Feijoada", "feijoada");
        Dish parmegiana = new Dish("Parmegiana", "parmegiana");
        Dish peixe_frito = new Dish("Peixe Frito", "peixe_frito");
        Dish file_de_frango = new Dish("Filé de Frango", "file_de_frango");

        dishes.add(feijoada);
        dishes.add(parmegiana);
        dishes.add(peixe_frito);
        dishes.add(file_de_frango);
    }
}
