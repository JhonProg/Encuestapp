package keaplus.com.co.sistemaencuesta.Constante;

/**
 * Created by Jhon on 29/11/2015.
 */
public enum PreguntaTipoEnum {

    ABIERTA(1,"ABIERTA"),
    DICOTOMICA(2,"DICOTOMICA"),
    LIKERT(3,"LIKERT");

    private int index;
    private String tipo;

    private PreguntaTipoEnum(int index, String tipo){
        this.index = index;
        this.tipo = tipo;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
