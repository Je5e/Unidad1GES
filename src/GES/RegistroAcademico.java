package GES;

import java.util.List;
import java.util.Scanner;

public class RegistroAcademico {

    static boolean salir = false;

    public static void main(String[] args) {

        RegistroAcademico r = new RegistroAcademico();
        r.iniciar();
    }

    public static void Salir() {
        salir = true;
    }

    void iniciar() {
        while (!RegistroAcademico.salir) {
            int opcionSeleccionada = mostrarMenu();
            try {
                Option o = ListaOpciones.getOption(opcionSeleccionada);
                o.executeAction();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            iniciar();
        }
    }

    private int mostrarMenu() {
        int result;
        System.out.println("Opciones:");
        System.out.println("----------------------");

        List<Option> options = ListaOpciones.getOptions();

        for (Option op : options) {
            System.out.println(op.getCode() + " - " + op.getDescription());
        }
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite: ");
        result = sc.nextInt();

        return result;
    }
}
