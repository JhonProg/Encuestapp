package keaplus.com.co.sistemaencuesta.Preguntas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import keaplus.com.co.sistemaencuesta.R;

public class PreguntaTresActivity extends AppCompatActivity implements View.OnClickListener{


    private int idUser;
    private RadioButton si;
    private RadioButton no;
    private Button boton;
    private String respuestaUno;
    private String respuestaDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_tres);

    }

    @Override
    protected void onResume() {

        idUser =getIntent().getExtras().getInt("idusuario");
        respuestaUno = getIntent().getExtras().getString("respuestaUno");
        respuestaDos = getIntent().getExtras().getString("respuestaDos");

        si = (RadioButton) findViewById(R.id.radioButtonp3o1);
        no = (RadioButton) findViewById(R.id.radioButtonp3o2);
        boton = (Button) findViewById(R.id.buttonSiguienteP3);

        boton.setOnClickListener(this);

        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==boton.getId()) {
            String respuestaTres = "";
            if (si.isChecked()) {
                respuestaTres = idUser + "," + "3" + "," + "1";
            } else if (no.isChecked()) {
                respuestaTres = idUser + "," + "3" + "," + "2";
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }

            if (respuestaTres.length() > 0) {
                Intent intento = new Intent(this, PreguntaCuatroActivity.class );
                intento.putExtra("idusuario",idUser);
                intento.putExtra("respuestaUno",respuestaUno);
                intento.putExtra("respuestaDos",respuestaDos);
                intento.putExtra("respuestaTres",respuestaTres);
                startActivity(intento);
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }
        }
    }
}
