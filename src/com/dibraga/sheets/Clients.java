package com.dibraga.sheets;

import com.dibraga.utils.ComboBoxOption;

import java.util.ArrayList;
import java.util.List;

public class Clients {

    private List<ComboBoxOption> clients = new ArrayList<>();

    public Clients() {
        ComboBoxOption joao = new ComboBoxOption("João", "joao", new Object[]{"55119876-5432", "R. da Fantasia nº23"});
        ComboBoxOption maria = new ComboBoxOption("Maria", "maria", new Object[]{"55119123-4567", "R. Artacho nº60"});

        clients.add(joao);
        clients.add(maria);
    }

    public List<ComboBoxOption> getClients() {
        return this.clients;
    }
}
