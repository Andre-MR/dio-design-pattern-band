package dev.andremr;

import dev.andremr.patterns.BandaFacade;
import dev.andremr.patterns.BrandSingleton;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(BrandSingleton.INSTANCE.brandName());

        boolean apresentando = true;
        Scanner sc = new Scanner(System.in);
        BandaFacade banda = new BandaFacade();

        while (apresentando) {
            System.out.println("Digite uma opção:");
            System.out.println("1: Preparar banda suave.");
            System.out.println("2: Preparar banda pesada.");
            System.out.println("3: Tocar banda.");
            System.out.println("4: Parar banda.");
            System.out.println("5: Finalizar banda.");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 5 -> {
                    banda.finalizarBanda();
                    apresentando = false;
                    System.out.println("Obrigado pela participação!");
                }
                case 4 -> banda.pararBanda();
                case 3 -> banda.tocarBanda();
                case 2 -> banda.prepararBandaPesada();
                case 1 -> banda.prepararBandaSuave();
            }
            System.out.println();
        }
    }
}