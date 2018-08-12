package keaplus.com.co.sistemaencuesta.Preguntas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import keaplus.com.co.sistemaencuesta.R;

public class PreguntaDosActivity extends AppCompatActivity implements View.OnClickListener{

    private int idUser;
    private RadioButton si;
    private RadioButton no;
    private Button boton;
    private String respuestaUno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_dos);
    }

    @Override
    protected void onResume() {

        idUser = getIntent().getExtras().getInt("idusuario");
        respuestaUno = getIntent().getExtras().getString("respuestaUno");

        si = (RadioButton) findViewById(R.id.radioButtonp2o1);
        no = (RadioButton) findViewById(R.id.radioButtonp2o2);
        boton = (Button) findViewById(R.id.buttonSiguienteP2);

        boton.setOnClickListener(this);

        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==boton.getId()) {
            String respuestaDos = "";
            if (si.isChecked()) {
                respuestaDos = idUser + "," + "2" + "," + "1";
            } else if (no.isChecked()) {
                respuestaDos = idUser + "," + "2" + "," + "2";
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }

            if (respuestaDos.length() > 0) {
                Intent intento = new Intent(this, PreguntaTresActivity.class );
                intento.putExtra("idusuario",idUser);
                intento.putExtra("respuestaUno",respuestaUno);
                intento.putExtra("respuestaDos",respuestaDos);
                startActivity(intento);
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }
        }
    }
}
