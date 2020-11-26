package com.dibraga.sheets;

import com.dibraga.utils.ComboBoxOption;

import java.util.ArrayList;
import java.util.List;

public class Drinks {

    private List<ComboBoxOption> drinks = new ArrayList<>();
    private List<ComboBoxOption> sideDishes = new ArrayList<>();

    public Drinks() {
        ComboBoxOption coca_cola = new ComboBoxOption("Coca Cola", "coca_cola", (float)5.50);
        ComboBoxOption guarana = new ComboBoxOption("Guaraná", "guarana", (float)5.50);
        ComboBoxOption suco_de_uva = new ComboBoxOption("Suco de Uva", "suco_de_uva", (float)4.00);

        drinks.add(coca_cola);
        drinks.add(guarana);
        drinks.add(suco_de_uva);
    }

    public List<ComboBoxOption> getDrinks() {
        return this.drinks;
    }
}
