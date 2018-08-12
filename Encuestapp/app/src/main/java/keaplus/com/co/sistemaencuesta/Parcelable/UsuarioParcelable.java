package keaplus.com.co.sistemaencuesta.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jhon on 30/11/2015.
 */
public class UsuarioParcelable implements Parcelable{

    private int idUsuario;
    private int idUsuarioTipo;
    private String nombre;
    private String apellido;
    private String correo;
    private String fechaNacimiento;
    private String telefono;
    private String username;
    private String clave;

    public UsuarioParcelable(){
    }

    private UsuarioParcelable(Parcel in){
        this.idUsuario = in.readInt();
        this.idUsuarioTipo = in.readInt();
        this.nombre = in.readString();
        this.apellido= in.readString();
        this.correo= in.readString();
        this.fechaNacimiento= in.readString();
        this.telefono = in.readString();
        this. username= in.readString();
        this.clave= in.readString();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuarioTipo() {
        return idUsuarioTipo;
    }

    public void setIdUsuarioTipo(int idUsuarioTipo) {
        this.idUsuarioTipo = idUsuarioTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idUsuario);
        dest.writeInt(this.idUsuarioTipo);
        dest.writeString(this.nombre);
        dest.writeString(this.apellido);
        dest.writeString(this.correo);
        dest.writeString(this.fechaNacimiento);
        dest.writeString(this.telefono);
        dest.writeString(this. username);
        dest.writeString(this.clave);
    }

    public static final UsuarioParcelable.Creator<UsuarioParcelable> CREATOR = new UsuarioParcelable.Creator<UsuarioParcelable>() {
        public UsuarioParcelable createFromParcel(Parcel in) {
            return new UsuarioParcelable(in);
        }
        public UsuarioParcelable[] newArray(int size) {
            return new UsuarioParcelable[size];
        }
    };

}
