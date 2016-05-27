package br.edu.fanor.archmath;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by reyson on 29/11/15.
 */
public class CapacidadeMemoria extends Activity {

    EditText edttamanhocelula,edtcelulasmemoria;
    TextView txtresultado;
    Button btncalcular;
    ProgressBar pbbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_capacidade_memoria);

        edttamanhocelula = (EditText) findViewById(R.id.edttamanhocelula);
        edtcelulasmemoria = (EditText) findViewById(R.id.edtcelulasmemoria);
        txtresultado = (TextView) findViewById(R.id.txtresultado);
        btncalcular = (Button) findViewById(R.id.btncalcular);


        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Capacidade da Memória");
        actionBar.setSubtitle("Tela de Resultados");

        btncalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                CalcularCapacidadeMemoria resultado = new CalcularCapacidadeMemoria();
                resultado.execute("");

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_padrao, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_home:
                Toast.makeText(this, "Menu Principal", Toast.LENGTH_SHORT)
                        .show();

                Intent i = new Intent(CapacidadeMemoria.this, MainActivity.class);
                startActivity(i);
                finish();

                break;
        }

        return true;
    }


    public class CalcularCapacidadeMemoria extends AsyncTask<String, String, String> {

        String z = "";
        Long tamanhoCelula = Long.parseLong(edttamanhocelula.getText().toString());
        Long celulasMemoria = Long.parseLong(edtcelulasmemoria.getText().toString());
        String mensagem;


        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(CapacidadeMemoria.this, r, Toast.LENGTH_SHORT).show();

            txtresultado.setText(mensagem);

        }


        public Long ProcessarCapacidadeMemoria(){

            Long resposta = tamanhoCelula * celulasMemoria;

            return resposta;

        }


        @Override
        protected String doInBackground(String... params) {

            mensagem = "Resultado:"+ProcessarCapacidadeMemoria()+" Kbits";

            z = mensagem;

            return z;

        }
    }


}
