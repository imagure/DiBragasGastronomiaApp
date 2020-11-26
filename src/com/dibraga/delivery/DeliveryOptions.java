package com.dibraga.delivery;

import com.dibraga.utils.ComboBoxOption;

import java.util.ArrayList;
import java.util.List;

public class DeliveryOptions {

    private List<ComboBoxOption> deliveryOptions = new ArrayList<>();

    public DeliveryOptions() {
        ComboBoxOption pickup = new ComboBoxOption("Retirada no local", "pickup");
        ComboBoxOption delivery = new ComboBoxOption("Entrega", "delivery");
        ComboBoxOption app = new ComboBoxOption("Aplicativo", "app");

        deliveryOptions.add(pickup);
        deliveryOptions.add(delivery);
        deliveryOptions.add(app);
    }

    public List<ComboBoxOption> getDeliveryOptions() {
        return this.deliveryOptions;
    }
}
