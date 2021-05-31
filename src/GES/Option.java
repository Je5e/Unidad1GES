package GES;

import java.io.IOException;
// Representa una opcion en el sistema.
public abstract class Option {
    private int code;
    private String description;

    protected int getCode() {
        return code;
    }

    protected void setCode(int code) {
        this.code = code;
    }

    protected String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public abstract void executeAction() throws IOException;
}
