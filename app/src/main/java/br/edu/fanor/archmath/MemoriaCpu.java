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
public class MemoriaCpu extends Activity {

    Button btncapacidadememoria,btntamanhocelula;
    ProgressBar pbbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.operacoes_memoria_cpu);

        btncapacidadememoria = (Button) findViewById(R.id.btncapacidadememoria);
        btntamanhocelula = (Button) findViewById(R.id.btntamanhocelula);


        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Memórias e CPU");
        actionBar.setSubtitle("Menu de Operações");

        btncapacidadememoria.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FormularioCapacidadeMemoria form1 = new FormularioCapacidadeMemoria();
                form1.execute("");

            }
        });

        btntamanhocelula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FormularioTamanhoCelula form2 = new FormularioTamanhoCelula();
                form2.execute("");

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

                Intent i = new Intent(MemoriaCpu.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
        }

        return true;
    }


    public class FormularioCapacidadeMemoria extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(MemoriaCpu.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(MemoriaCpu.this, CapacidadeMemoria.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


            z = "Capacidade Memória - Formulário";
            isSuccess = true;

            return z;

        }

    }

    public class FormularioTamanhoCelula extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(MemoriaCpu.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(MemoriaCpu.this, TamanhoCelula.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


            z = "Tamanho Célula - Formulário";
            isSuccess = true;

            return z;

        }
    }



}
