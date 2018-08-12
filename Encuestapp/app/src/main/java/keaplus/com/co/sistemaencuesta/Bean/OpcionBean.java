package keaplus.com.co.sistemaencuesta.Bean;

/**
 * Created by Jhon on 29/11/2015.
 */
public class OpcionBean {

    private int idOpcion;
    private int idDetallePregunta;
    private String opcion;

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    public int getIdDetallePregunta() {
        return idDetallePregunta;
    }

    public void setIdDetallePregunta(int idDetallePregunta) {
        this.idDetallePregunta = idDetallePregunta;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}
