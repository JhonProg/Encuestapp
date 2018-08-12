package keaplus.com.co.sistemaencuesta.Preguntas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import keaplus.com.co.sistemaencuesta.R;

public class PreguntaCuatroActivity extends AppCompatActivity implements View.OnClickListener{

    private int idUser;

    private RadioButton uno;
    private RadioButton dos;
    private RadioButton tres;
    private RadioButton cuatro;
    private RadioButton cinco;
    private RadioButton seis;

    private Button boton;
    private String respuestaUno;
    private String respuestaDos;
    private String respuestaTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_cuatro);
    }

    @Override
    protected void onResume() {

        idUser =getIntent().getExtras().getInt("idusuario");
        respuestaUno = getIntent().getExtras().getString("respuestaUno");
        respuestaDos = getIntent().getExtras().getString("respuestaDos");
        respuestaTres = getIntent().getExtras().getString("respuestaTres");

        uno = (RadioButton) findViewById(R.id.radioButtonp4o1);
        dos = (RadioButton) findViewById(R.id.radioButtonp4o2);
        tres = (RadioButton) findViewById(R.id.radioButtonp4o3);
        cuatro = (RadioButton) findViewById(R.id.radioButtonp4o4);
        cinco = (RadioButton) findViewById(R.id.radioButtonp4o5);
        seis = (RadioButton) findViewById(R.id.radioButtonp4o6);

        boton = (Button) findViewById(R.id.buttonSiguienteP4);

        boton.setOnClickListener(this);

        super.onResume();
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==boton.getId()) {
            String respuestaCuatro = "";
            if (uno.isChecked()) {
                respuestaCuatro = idUser + "," + "4" + "," + "1";
            } else if (dos.isChecked()) {
                respuestaCuatro = idUser + "," + "4" + "," + "2";
            } else if (tres.isChecked()) {
                respuestaCuatro = idUser + "," + "4" + "," + "3";
            } else if (cuatro.isChecked()) {
                respuestaCuatro = idUser + "," + "4" + "," + "4";
            }else if (cinco.isChecked()) {
                respuestaCuatro = idUser + "," + "4" + "," + "5";
            }else if (seis.isChecked()) {
                respuestaCuatro = idUser + "," + "4" + "," + "6";
            }else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }

            if (respuestaCuatro.length() > 0) {
                Intent intento = new Intent(this, PreguntaCincoActivity.class );
                intento.putExtra("idusuario",idUser);
                intento.putExtra("respuestaUno",respuestaUno);
                intento.putExtra("respuestaDos",respuestaDos);
                intento.putExtra("respuestaTres",respuestaTres);
                intento.putExtra("respuestaCuatro",respuestaCuatro);
                startActivity(intento);
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }
        }

    }


}
