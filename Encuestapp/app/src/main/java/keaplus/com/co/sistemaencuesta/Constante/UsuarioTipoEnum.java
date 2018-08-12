package keaplus.com.co.sistemaencuesta.Constante;

/**
 * Created by Jhon on 29/11/2015.
 */
public enum UsuarioTipoEnum {

    ADMINISTRADOR(1,"ADMINISTRADOR"),
    ENCUESTADO(2,"ENCUESTADO");

    private int index;
    private String usuarioTipo;

    private UsuarioTipoEnum(int index, String usuarioTipo){
        this.index = index;
        this.usuarioTipo = usuarioTipo;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(String usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }
}
