package dev.andremr.patterns;

import dev.andremr.models.Baixo;
import dev.andremr.models.Bateria;
import dev.andremr.models.Guitarra;

public class BandaFacade {
    private final Bateria bateria;
    private final Baixo baixo;
    private final Guitarra guitarra;
    private final String brandName;

    public BandaFacade() {
        this.bateria = new Bateria();
        this.baixo = new Baixo();
        this.guitarra = new Guitarra();
        this.brandName = BrandSingleton.INSTANCE.brandName();
    }

    public void prepararBandaSuave() {
        if (bateria.configurar() && baixo.configurar() && guitarra.configurar()) {
            guitarra.definirDistorcao(false);
            System.out.println(brandName + " preparada em modo suave.");
        }
    }

    public void prepararBandaPesada() {
        if (bateria.configurar() && baixo.configurar() && guitarra.configurar()) {
            guitarra.definirDistorcao(true);
            System.out.println(brandName + " preparada em modo pesado.");
        }
    }

    public void tocarBanda() {
        if (bateria.configurado() || baixo.configurado() || guitarra.configurado()) {
            System.out.println("Configure os instrumentos antes de tocar.");
        } else {
            bateria.tocar();
            baixo.tocar();
            guitarra.tocar();
        }
    }

    public void pararBanda() {
        bateria.parar();
        baixo.parar();
        guitarra.parar();
    }

    public void finalizarBanda() {
        pararBanda();
        bateria.guardar();
        baixo.guardar();
        guitarra.guardar();
        System.out.println(brandName + " finalizada.");
    }
}
