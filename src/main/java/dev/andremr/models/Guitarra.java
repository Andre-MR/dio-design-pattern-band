package dev.andremr.models;

import dev.andremr.patterns.BrandSingleton;
import dev.andremr.patterns.InstrumentoStrategy;

public class Guitarra implements InstrumentoStrategy {
    private boolean tocando, afinacao, plugue, pedaleira, distorcao;

    @Override
    public String marca() {
        return BrandSingleton.INSTANCE.brandInitials();
    }

    @Override
    public boolean configurado() {
        return (!afinacao || !plugue || !pedaleira);
    }

    @Override
    public boolean configurar() {
        if (tocando) {
            System.out.println("Guitarra " + marca() + " impossível de configurar, está tocando.");
            return false;
        }
        pedaleira = afinacao = plugue = true;
        System.out.println("Guitarra " + marca() + " configurada.");
        return true;
    }

    @Override
    public void guardar() {
        if (tocando) {
            System.out.println("Guitarra " + marca() + " impossível de guardar, está tocando.");
            return;
        } else {
            afinacao = pedaleira = distorcao = plugue = false;
        }
        System.out.println("Guitarra " + marca() + " guardada.");
    }

    @Override
    public void tocar() {
        if (tocando) {
            System.out.println("Guitarra " + marca() + " já está tocando.");
            return;
        } else if (!plugue) {
            System.out.println("Guitarra " + marca() + " precisa de configuração.");
            return;
        }
        if (distorcao) {
            System.out.println("Guitarra " + marca() + " tocando pesado...");
        } else {
            System.out.println("Guitarra " + marca() + " tocando suave...");
        }
        tocando = true;
    }

    @Override
    public void parar() {
        if (!tocando) {
            System.out.println("Guitarra " + marca() + " já está parada.");
            return;
        }
        tocando = false;
        System.out.println("Guitarra " + marca() + " parada.");
    }

    public void definirDistorcao(boolean ligada) {
        if (!tocando) {
            distorcao = ligada;
            if (distorcao) {
                System.out.println("Distorção ligada.");
            } else {
                System.out.println("Distorção desligada.");
            }
        }
    }
}
