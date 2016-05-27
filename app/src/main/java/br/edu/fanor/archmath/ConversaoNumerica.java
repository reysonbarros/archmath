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
public class ConversaoNumerica extends Activity {

    Button btnconversaobinariodecimal,btnconversaodecimalbinario;
    ProgressBar pbbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.operacoes_conversao_numerica);

        btnconversaobinariodecimal = (Button) findViewById(R.id.btnconversaobinariodecimal);
        btnconversaodecimalbinario = (Button) findViewById(R.id.btnconversaodecimalbinario);


        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Conversão Numérica");
        actionBar.setSubtitle("Menu de Operações");

        btnconversaobinariodecimal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FormularioConversaoBinarioDecimal form1 = new FormularioConversaoBinarioDecimal();
                form1.execute("");

            }
        });

        btnconversaodecimalbinario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FormularioConversaoDecimalBinario form2 = new FormularioConversaoDecimalBinario();
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

                Intent i = new Intent(ConversaoNumerica.this, MainActivity.class);
                startActivity(i);
                finish();

                break;
        }

        return true;
    }


    public class FormularioConversaoBinarioDecimal extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(ConversaoNumerica.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(ConversaoNumerica.this, ConversaoBinarioDecimal.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


            z = "Conversão Binário Decimal - Formulário";
            isSuccess = true;

            return z;

        }
    }

    public class FormularioConversaoDecimalBinario extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(ConversaoNumerica.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(ConversaoNumerica.this, ConversaoDecimalBinario.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


            z = "Conversão Decimal Binário - Formulário";
            isSuccess = true;

            return z;

        }
    }


}
