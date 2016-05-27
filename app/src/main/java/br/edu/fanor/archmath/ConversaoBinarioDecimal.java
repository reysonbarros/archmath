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
public class ConversaoBinarioDecimal extends Activity {

    EditText edtvalorbinario;
    TextView txtresultado;
    Button btncalcular;
    ProgressBar pbbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_conversao_binario_decimal);

        edtvalorbinario = (EditText) findViewById(R.id.edtvalorbinario);
        txtresultado = (TextView) findViewById(R.id.txtresultado);
        btncalcular = (Button) findViewById(R.id.btncalcular);


        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Conversão Binário para Decimal");
        actionBar.setSubtitle("Tela de Resultados");

        btncalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ConverterBinarioDecimal resultado = new ConverterBinarioDecimal();
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

                Intent i = new Intent(ConversaoBinarioDecimal.this, MainActivity.class);
                startActivity(i);
                finish();

                break;
        }

        return true;
    }


    public class ConverterBinarioDecimal extends AsyncTask<String, String, String> {

        String z = "";
        String valorBinario = edtvalorbinario.getText().toString();
        String mensagem;


        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(ConversaoBinarioDecimal.this, r, Toast.LENGTH_SHORT).show();

            txtresultado.setText(mensagem);

        }


        public String ConversorBinarioDecimal(){

            int num=Integer.parseInt(valorBinario,2);
            String resultado;
            resultado = valorBinario + " base 2 = " + num + " base 10";

            return resultado;

        }


        @Override
        protected String doInBackground(String... params) {

            mensagem = "Resultado:"+ConversorBinarioDecimal();

            z = mensagem;

            return z;

        }
    }

}
