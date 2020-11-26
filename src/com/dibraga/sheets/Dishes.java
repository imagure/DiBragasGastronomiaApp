package com.dibraga.sheets;

import com.dibraga.utils.ComboBoxOption;

import java.util.ArrayList;
import java.util.List;

public class Dishes {

    private List<ComboBoxOption> dishes = new ArrayList<>();
    private List<ComboBoxOption> sideDishes = new ArrayList<>();

    public Dishes() {
        ComboBoxOption arroz = new ComboBoxOption("Arroz", "arroz", (float)5.00);
        ComboBoxOption batata_frita = new ComboBoxOption("Batata Frita", "batata_frita", (float)3.00);
        sideDishes.add(arroz);
        sideDishes.add(batata_frita);

        ComboBoxOption feijoada = new ComboBoxOption("Feijoada", "feijoada", (float)22.50);
        ComboBoxOption parmegiana = new ComboBoxOption("Parmegiana", "parmegiana", (float)18.60 ,sideDishes);
        ComboBoxOption peixe_frito = new ComboBoxOption("Peixe Frito", "peixe_frito", (float)20.30, sideDishes);
        ComboBoxOption file_de_frango = new ComboBoxOption("Filé de Frango", "file_de_frango", (float)15.00, sideDishes);

        dishes.add(feijoada);
        dishes.add(parmegiana);
        dishes.add(peixe_frito);
        dishes.add(file_de_frango);
    }

    public List<ComboBoxOption> getDishes() {
        return this.dishes;
    }

    public List<ComboBoxOption> getSideDishes() {
        return this.sideDishes;
    }
}
