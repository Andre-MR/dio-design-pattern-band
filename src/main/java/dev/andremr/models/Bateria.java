package dev.andremr.models;

import dev.andremr.patterns.BrandSingleton;
import dev.andremr.patterns.InstrumentoStrategy;

public class Bateria implements InstrumentoStrategy {
    private boolean tocando, montagem, afinacao, plugue;

    @Override
    public String marca() {
        return BrandSingleton.INSTANCE.brandInitials();
    }

    @Override
    public boolean configurado() {
        return (!montagem || !afinacao || !plugue);
    }

    @Override
    public boolean configurar() {
        if (tocando) {
            System.out.println("Bateria " + marca() + " impossível de configurar, está tocando.");
            return false;
        }
        montagem = afinacao = plugue = true;
        System.out.println("Bateria " + marca() + " configurada.");
        return true;
    }


    @Override
    public void guardar() {
        if (tocando) {
            System.out.println("Bateria " + marca() + " impossível de guardar, está tocando.");
            return;
        } else {
            montagem = afinacao = plugue = false;
        }
        System.out.println("Bateria " + marca() + " guardada.");
    }

    @Override
    public void tocar() {
        if (tocando) {
            System.out.println("Bateria " + marca() + " já está tocando.");
            return;
        } else if (!plugue) {
            System.out.println("Bateria " + marca() + " precisa de configuração.");
            return;
        }
        System.out.println("Bateria " + marca() + " tocando...");
        tocando = true;
    }

    @Override
    public void parar() {
        if (!tocando) {
            System.out.println("Bateria " + marca() + " já está parada.");
            return;
        }
        tocando = false;
        System.out.println("Bateria " + marca() + " parada.");
    }
}
