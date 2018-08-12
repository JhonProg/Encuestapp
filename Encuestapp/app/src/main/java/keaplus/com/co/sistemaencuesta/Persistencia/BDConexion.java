package keaplus.com.co.sistemaencuesta.Persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jhon on 29/11/2015.
 */
public class BDConexion extends SQLiteOpenHelper{

    public BDConexion(Context context) {
        super(context, "Base.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        //TODO: El DDL y DML lo cargue por archivo directo al dispositivo.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: Para implementar la losgica en cuento actualizaciones sobre la base de datos.
    }

}
