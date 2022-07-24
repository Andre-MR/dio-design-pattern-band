package dev.andremr.models;

import dev.andremr.patterns.BrandSingleton;
import dev.andremr.patterns.InstrumentoStrategy;

public class Baixo implements InstrumentoStrategy {

    private boolean tocando, afinacao, plugue;

    @Override
    public String marca() {
        return BrandSingleton.INSTANCE.brandInitials();
    }

    @Override
    public boolean configurado() {
        return (!afinacao || !plugue);
    }

    @Override
    public boolean configurar() {
        if (tocando) {
            System.out.println("Baixo " + marca() + " impossível de configurar, está tocando.");
            return false;
        }
        plugue = afinacao = true;
        System.out.println("Baixo " + marca() + " configurado.");
        return true;
    }

    @Override
    public void guardar() {
        if (tocando) {
            System.out.println("Baixo " + marca() + " impossível de guardar, está tocando.");
            return;
        } else {
            afinacao = plugue = false;
        }
        System.out.println("Baixo " + marca() + " guardado.");
    }

    @Override
    public void tocar() {
        if (tocando) {
            System.out.println("Baixo " + marca() + " já está tocando.");
            return;
        } else if (!plugue) {
            System.out.println("Baixo " + marca() + " precisa de configuração.");
            return;
        }
        System.out.println("Baixo " + marca() + " tocando...");
        tocando = true;
    }

    @Override
    public void parar() {
        if (!tocando) {
            System.out.println("Baixo " + marca() + " já está parado.");
            return;
        }
        tocando = false;
        System.out.println("Baixo " + marca() + " parado.");
    }
}
