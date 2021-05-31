package GES;

import java.util.ArrayList;
import java.util.List;

public class ListaOpciones {
    static List<Option> options;

    static {
        options = new ArrayList<>();
        options.add(new RegistrarNotasOption(1));
        options.add(new GenerarEstadisticasOption(2));
        options.add(new OpcionSalir(0));
    }

    public static Option getOption(int codigo) {
        Option result = null;
        for (Option op : options) {
            if (op.getCode() == codigo) {
                result = op;
                break;
            }
        }
        return result;
    }

    public static List<Option> getOptions() {
        return options;
    }
}
