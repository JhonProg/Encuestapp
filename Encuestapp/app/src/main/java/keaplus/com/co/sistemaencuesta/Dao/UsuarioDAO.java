package keaplus.com.co.sistemaencuesta.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import keaplus.com.co.sistemaencuesta.Bean.UsuarioBean;
import keaplus.com.co.sistemaencuesta.Persistencia.BDConexion;

/**
 * Created by Jhon on 02/12/2015.
 */
public class UsuarioDAO extends BDConexion {

    public UsuarioDAO(Context context) {
        super(context);
    }

    public boolean insertarUsuario(UsuarioBean usuario){
        boolean inserto = true;
        long idGenerado = 0;
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues valores = new ContentValues();

            valores.put("idusuariotipo", usuario.getIdUsuarioTipo());
            valores.put("nombre", usuario.getNombre());
            valores.put("apellido", usuario.getApellido());
            valores.put("correo", usuario.getCorreo());
            valores.put("fechanacimiento", usuario.getFechaNacimiento());
            valores.put("telefono", usuario.getTelefono());
            valores.put("username", usuario.getUsername());
            valores.put("clave", usuario.getClave());

            idGenerado = db.insert("usuario", null, valores);

            if(idGenerado>0){
                inserto = true;
            }
        }catch (Exception e){
            Log.i("ERROR AL INSERTAR", "Error." + e.toString());
            e.printStackTrace();
        }finally {
            db.close();
        }
        return  inserto;
    }

}
