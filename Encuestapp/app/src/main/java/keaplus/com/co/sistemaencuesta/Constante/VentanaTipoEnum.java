package keaplus.com.co.sistemaencuesta.Constante;

/**
 * Created by Jhon on 30/11/2015.
 */
public enum VentanaTipoEnum {
    INICIOENCUESTADO(1,"Inicio Encuestado"),
    INICIOADMINISTRADOR(2,"Inicio Administrador"),
    REGISTRO(3,"Registrarse");

    private int index;
    private String nombreVentana;

    private VentanaTipoEnum(int index,String nombreVentana){
        this.index=index;
        this.nombreVentana=nombreVentana;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNombreVentana() {
        return nombreVentana;
    }

    public void setNombreVentana(String nombreVentana) {
        this.nombreVentana = nombreVentana;
    }
}
