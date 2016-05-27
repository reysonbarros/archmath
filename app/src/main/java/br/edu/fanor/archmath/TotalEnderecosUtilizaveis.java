package br.edu.fanor.archmath;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
public class TotalEnderecosUtilizaveis extends Activity {

    EditText edtlargurabarramentoendereco;
    TextView txtresultado;
    Button btncalcular;
    ProgressBar pbbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_total_enderecos_utilizaveis);

        edtlargurabarramentoendereco = (EditText) findViewById(R.id.edtlargurabarramentoendereco);
        txtresultado = (TextView) findViewById(R.id.txtresultado);
        btncalcular = (Button) findViewById(R.id.btncalcular);


        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Total de Endereços Utilizáveis");
        actionBar.setSubtitle("Tela de Resultados");

        btncalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                CalcularTotalEnderecosUtilizaveis resultado = new CalcularTotalEnderecosUtilizaveis();
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

                Intent i = new Intent(TotalEnderecosUtilizaveis.this, MainActivity.class);
                startActivity(i);
                finish();

                break;
        }

        return true;
    }


    public class CalcularTotalEnderecosUtilizaveis extends AsyncTask<String, String, String> {

        String z = "";
        Integer larguraBE = Integer.parseInt(edtlargurabarramentoendereco.getText().toString());
        String mensagem;


        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(TotalEnderecosUtilizaveis.this, r, Toast.LENGTH_SHORT).show();

            txtresultado.setText(mensagem);

        }


        public Long ProcessarTotalEnderecosUtilizaveis(){

            double resposta = Math.pow(2, larguraBE);

            long resposta_final = (long) resposta;

            return resposta_final;

        }


        @Override
        protected String doInBackground(String... params) {

            mensagem = "Resultado:"+ProcessarTotalEnderecosUtilizaveis()+" endereços";

            z = mensagem;

            return z;

        }
    }


}
