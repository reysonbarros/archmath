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
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by reyson on 29/11/15.
 */
public class Barramento extends Activity {

    Button btntotalenderecos,btntaxatransfbd,btnlargurabc;
    ProgressBar pbbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.operacoes_barramento);

        btntotalenderecos = (Button) findViewById(R.id.btntotalenderecos);
        btntaxatransfbd = (Button) findViewById(R.id.btntaxatransfbd);
        btnlargurabc = (Button) findViewById(R.id.btnlargurabc);

        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Barramentos");
        actionBar.setSubtitle("Menu de Opções");

        btntotalenderecos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FormularioTotalEnderecosUtilizaveis form1 = new FormularioTotalEnderecosUtilizaveis();
                form1.execute("");

            }
        });

        btntaxatransfbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FormularioTaxaTransferenciaBarramentoDados form2 = new FormularioTaxaTransferenciaBarramentoDados();
                form2.execute("");

            }
        });

        btnlargurabc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FormularioLarguraBarramentoControle form3 = new FormularioLarguraBarramentoControle();
                form3.execute("");

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

                Intent i = new Intent(Barramento.this, MainActivity.class);
                startActivity(i);
                finish();

                break;
        }

        return true;
    }


    public class FormularioTotalEnderecosUtilizaveis extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(Barramento.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(Barramento.this, TotalEnderecosUtilizaveis.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


            z = "Total de Endereços Utilizáveis - Formulário";
            isSuccess = true;

            return z;

        }
    }

    public class FormularioTaxaTransferenciaBarramentoDados extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(Barramento.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(Barramento.this, TaxaTransferenciaBarramentoDados.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


            z = "Taxa de Transferência do Barramento de Dados - Formulário";
            isSuccess = true;

            return z;

        }
    }


    public class FormularioLarguraBarramentoControle extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(Barramento.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(Barramento.this, LarguraBarramentoControle.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


            z = "Largura do Barramento de Controle - Formulário";
            isSuccess = true;

            return z;

        }
    }


}
