package keaplus.com.co.sistemaencuesta.Bean;

/**
 * Created by Jhon on 29/11/2015.
 */
public class PreguntaBean {
    private int idPregunta;
    private int idEncuesta;
    private String enunciado;

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
}
