package GES;

public class OpcionSalir extends Option{

    public OpcionSalir(int code){
        this.setCode(code);
        this.setDescription("Salir del sistema.");
    }
    @Override
    public void executeAction() {
        RegistroAcademico.Salir();
    }
}
