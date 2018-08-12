package keaplus.com.co.sistemaencuesta.Static;

import android.util.Log;

import keaplus.com.co.sistemaencuesta.Bean.UsuarioBean;
import keaplus.com.co.sistemaencuesta.Parcelable.UsuarioParcelable;

/**
 * Created by Jhon on 30/11/2015.
 */
public class ObjetoParcelable {

    public static UsuarioParcelable getUsuarioParcelable(UsuarioBean usuario){
        UsuarioParcelable usuarioParcelable = new UsuarioParcelable();
        Log.i("", "Ingreso a getUsuarioParcelable para usuario = "+usuario.getUsername());
        usuarioParcelable.setIdUsuario(usuario.getIdUsuario());
        usuarioParcelable.setIdUsuarioTipo(usuario.getIdUsuarioTipo());
        usuarioParcelable.setNombre(usuario.getNombre());
        usuarioParcelable.setApellido(usuario.getApellido());
        usuarioParcelable.setCorreo(usuario.getCorreo());
        usuarioParcelable.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioParcelable.setTelefono(usuario.getTelefono());
        usuarioParcelable.setUsername(usuario.getUsername());
        usuarioParcelable.setClave(usuario.getClave());

        return usuarioParcelable;
    }

}
