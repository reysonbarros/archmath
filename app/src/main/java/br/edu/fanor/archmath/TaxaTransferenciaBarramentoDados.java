package br.edu.fanor.archmath;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
public class TaxaTransferenciaBarramentoDados extends Activity {

    EditText edtlargurabarramentodados,edtvelocidadecpu;
    TextView txtresultado;
    Button btncalcular;
    ProgressBar pbbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_taxa_transf_barram_dados);

        edtlargurabarramentodados = (EditText) findViewById(R.id.edtlargurabarramentodados);
        edtvelocidadecpu = (EditText) findViewById(R.id.edtvelocidadecpu);
        txtresultado = (TextView) findViewById(R.id.txtresultado);
        btncalcular = (Button) findViewById(R.id.btncalcular);


        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Taxa de Transferência do Barramento de Dados");
        actionBar.setSubtitle("Tela de Resultados");

        btncalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                CalcularTaxaTransferenciaBarramentoDados resultado = new CalcularTaxaTransferenciaBarramentoDados();
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

                Intent i = new Intent(TaxaTransferenciaBarramentoDados.this, MainActivity.class);
                startActivity(i);
                finish();

                break;
        }

        return true;
    }


    public class CalcularTaxaTransferenciaBarramentoDados extends AsyncTask<String, String, String> {

        String z = "";
        Long larguraBD = Long.parseLong(edtlargurabarramentodados.getText().toString());
        Long velocidadeCPU = Long.parseLong(edtvelocidadecpu.getText().toString());
        String mensagem;


        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(TaxaTransferenciaBarramentoDados.this, r, Toast.LENGTH_SHORT).show();

            txtresultado.setText(mensagem);

        }


        public Long ProcessarTaxaTransferenciaBarramentoDados(){

            Long resposta = larguraBD * velocidadeCPU;


            return resposta;

        }


        @Override
        protected String doInBackground(String... params) {

            mensagem = "Resultado:"+ProcessarTaxaTransferenciaBarramentoDados()+" bps";

            z = mensagem;

            return z;

        }
    }

}
