package dev.andremr.patterns;

public interface InstrumentoStrategy {
    String marca();

    boolean configurar();

    void guardar();

    void tocar();

    void parar();

    boolean configurado();
}
