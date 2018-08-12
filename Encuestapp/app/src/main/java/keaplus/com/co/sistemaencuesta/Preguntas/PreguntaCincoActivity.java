package keaplus.com.co.sistemaencuesta.Preguntas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import keaplus.com.co.sistemaencuesta.R;

public class PreguntaCincoActivity extends AppCompatActivity implements View.OnClickListener{

    private int idUser;

    private RadioButton uno;
    private RadioButton dos;
    private RadioButton tres;


    private Button boton;

    private String respuestaUno;
    private String respuestaDos;
    private String respuestaTres;
    private String respuestaCuatro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_cinco);
    }

    @Override
    protected void onResume() {

        idUser =getIntent().getExtras().getInt("idusuario");

        respuestaUno = getIntent().getExtras().getString("respuestaUno");
        respuestaDos = getIntent().getExtras().getString("respuestaDos");
        respuestaTres = getIntent().getExtras().getString("respuestaTres");
        respuestaCuatro = getIntent().getExtras().getString("respuestaCuatro");

        uno = (RadioButton) findViewById(R.id.radioButtonp5o1);
        dos = (RadioButton) findViewById(R.id.radioButtonp5o2);
        tres = (RadioButton) findViewById(R.id.radioButtonp5o3);

        boton = (Button) findViewById(R.id.buttonSiguienteP5);

        boton.setOnClickListener(this);

        super.onResume();
    }




    @Override
    public void onClick(View v) {

        if(v.getId()==boton.getId()) {
            String respuestaCinco = "";
            if (uno.isChecked()) {
                respuestaCinco = idUser + "," + "5" + "," + "1";
            } else if (dos.isChecked()) {
                respuestaCinco = idUser + "," + "5" + "," + "2";
            } else if (tres.isChecked()) {
                respuestaCinco = idUser + "," + "5" + "," + "3";
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }

            if (respuestaCinco.length() > 0) {
                Intent intento = new Intent(this, PreguntaSeisActivity.class );
                intento.putExtra("idusuario",idUser);
                intento.putExtra("respuestaUno",respuestaUno);
                intento.putExtra("respuestaDos",respuestaDos);
                intento.putExtra("respuestaTres",respuestaTres);
                intento.putExtra("respuestaCuatro",respuestaCuatro);
                intento.putExtra("respuestaCinco",respuestaCinco);
                startActivity(intento);
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }
        }

    }

}
