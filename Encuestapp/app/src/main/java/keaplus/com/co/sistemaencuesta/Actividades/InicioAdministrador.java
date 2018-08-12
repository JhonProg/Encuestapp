package keaplus.com.co.sistemaencuesta.Actividades;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import keaplus.com.co.sistemaencuesta.Bean.UsuarioPreguntaRespuestaBean;
import keaplus.com.co.sistemaencuesta.Dao.EncuestaDAO;
import keaplus.com.co.sistemaencuesta.Parcelable.UsuarioParcelable;
import keaplus.com.co.sistemaencuesta.R;

public class InicioAdministrador extends AppCompatActivity implements View.OnClickListener {

    private TextView tvNombreUserLogueado;
    private TextView tvRUno;
    private TextView tvRDos;
    private TextView tvRTres;
    private TextView tvRCuatro;
    private TextView tvRCinco;
    private TextView tvRSeis;
    private TextView tvRSiete;
    private Button btnGenerarReporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_administrador);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {

        tvNombreUserLogueado = (TextView)findViewById(R.id.textViewNombreUsuarioLogueado);
        btnGenerarReporte = (Button) findViewById(R.id.buttonGenerarReporte);
        tvRUno = (TextView)findViewById(R.id.textViewUno);
        tvRDos = (TextView)findViewById(R.id.textViewDos);
        tvRTres = (TextView)findViewById(R.id.textViewTres);
        tvRCuatro = (TextView)findViewById(R.id.textViewCuatro);
        tvRCinco = (TextView)findViewById(R.id.textViewCinco);
        tvRSeis = (TextView)findViewById(R.id.textViewSeis);
        tvRSiete = (TextView)findViewById(R.id.textViewSiete);

        UsuarioParcelable obj = (UsuarioParcelable)getIntent().getExtras().getParcelable("usuario");
        String name = obj.getNombre();
        String apellido = obj.getApellido();
        printMensaje("Bienvenido "+name);
        tvNombreUserLogueado.setText("Bienvenido, " + name + " " + apellido);

        btnGenerarReporte.setOnClickListener(this);
        super.onResume();
    }

    private void printMensaje(String msn){
        Toast.makeText(getApplicationContext(),msn,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== btnGenerarReporte.getId()){
            EncuestaDAO encuestaDAO =  new EncuestaDAO(getApplicationContext());
            List<UsuarioPreguntaRespuestaBean> listaInsumoReporte = encuestaDAO.getRespuestas();

            int preguntaUnoSi = 0;
            int preguntaUnoNo = 0;

            int preguntaDosSi = 0;
            int preguntaDosNo = 0;

            int preguntaTresSi = 0;
            int preguntaTresNo = 0;

            int preguntaCuatroa = 0;
            int preguntaCuatrob = 0;
            int preguntaCuatroc = 0;
            int preguntaCuatrod = 0;
            int preguntaCuatroe = 0;
            int preguntaCuatrof = 0;

            int preguntaCincoa = 0;
            int preguntaCincob = 0;
            int preguntaCincoc = 0;

            int preguntaSeisa = 0;
            int preguntaSeisb = 0;
            int preguntaSeisc = 0;
            int preguntaSeisd = 0;

            int preguntaSieteSi = 0;
            int preguntaSieteNo = 0;

            for(UsuarioPreguntaRespuestaBean upr : listaInsumoReporte){
                if(upr.getIdPregunta()==1){
                    if(upr.getIdOpcion()==1){
                        preguntaUnoSi++;
                    }else if(upr.getIdOpcion()==2){
                        preguntaUnoNo++;
                    }
                }else if(upr.getIdPregunta()==2){
                    if(upr.getIdOpcion()==1){
                        preguntaDosSi++;
                    }else if(upr.getIdOpcion()==2){
                        preguntaDosNo++;
                    }
                }else if(upr.getIdPregunta()==3) {
                    if (upr.getIdOpcion() == 1) {
                        preguntaTresSi++;
                    } else if (upr.getIdOpcion() == 2) {
                        preguntaTresNo++;
                    }
                } else if(upr.getIdPregunta()==4) {
                    if (upr.getIdOpcion() == 1) {
                        preguntaCuatroa++;
                    } else if (upr.getIdOpcion() == 2) {
                        preguntaCuatrob++;
                    } else if (upr.getIdOpcion() == 3) {
                        preguntaCuatroc++;
                    }else if (upr.getIdOpcion() == 4) {
                        preguntaCuatrod++;
                    }else if (upr.getIdOpcion() == 5) {
                        preguntaCuatroe++;
                    }else if (upr.getIdOpcion() == 6) {
                        preguntaCuatrof++;
                    }
                }else if(upr.getIdPregunta()==5) {
                    if (upr.getIdOpcion() == 1) {
                        preguntaCincoa++;
                    } else if (upr.getIdOpcion() == 2) {
                        preguntaCincob++;
                    } else if (upr.getIdOpcion() == 3) {
                        preguntaCincoc++;
                    }
                } else if(upr.getIdPregunta()==6) {
                    if (upr.getIdOpcion() == 1) {
                        preguntaSeisa++;
                    } else if (upr.getIdOpcion() == 2) {
                        preguntaSeisb++;
                    } else if (upr.getIdOpcion() == 3) {
                        preguntaSeisc++;
                    }else if (upr.getIdOpcion() == 4) {
                        preguntaSeisd++;
                    }
                }else if(upr.getIdPregunta()==7) {
                    if (upr.getIdOpcion() == 1) {
                        preguntaSieteSi++;
                    } else if (upr.getIdOpcion() == 2) {
                        preguntaSieteNo++;
                    }
                }
            }

            tvRUno.setText("(1) SI="+preguntaUnoSi+", NO="+preguntaUnoNo);
            tvRDos.setText("(2) SI="+preguntaDosSi+", NO="+preguntaDosNo);
            tvRTres.setText("(3) SI="+preguntaTresSi+", NO="+preguntaTresNo);
            tvRCuatro.setText("(4) a:"+preguntaCuatroa+",b:"+preguntaCuatrob+",c:"+preguntaCuatroc+",d:"+preguntaCuatrod+",e:"+preguntaCuatroe+",f:"+preguntaCuatrof);
            tvRCinco.setText("(5) a:"+preguntaCincoa+",b:"+preguntaCincob+",c:"+preguntaCincoc);
            tvRSeis.setText("(6) a:"+preguntaSeisa+",b:"+preguntaSeisb+",c:"+preguntaSeisc+",d:"+preguntaSeisc);
            tvRSiete.setText("(7) SI="+preguntaSieteSi+", NO="+preguntaSieteNo);
        }
    }
}
