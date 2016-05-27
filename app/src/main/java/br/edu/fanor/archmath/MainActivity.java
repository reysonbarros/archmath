package br.edu.fanor.archmath;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btnbarramento,btnconversaonumerica,btnmemoriacpu;
    ProgressBar pbbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbarramento = (Button) findViewById(R.id.btnbarramento);
        btnconversaonumerica = (Button) findViewById(R.id.btnconversaonumerica);
        btnmemoriacpu = (Button) findViewById(R.id.btnmemoriacpu);

        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("ArchMath 1.0");
        actionBar.setSubtitle("Menu Principal");

        btnbarramento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                OperacoesBarramento operacoesBarramento = new OperacoesBarramento();
                operacoesBarramento.execute("");

            }
        });

        btnconversaonumerica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OperacoesConversaoNumerica operacoesConversaoNumerica = new OperacoesConversaoNumerica();
                operacoesConversaoNumerica.execute("");

            }
        });

        btnmemoriacpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OperacoesMemoriaCpu operacoesMemoriaCpu = new OperacoesMemoriaCpu();
                operacoesMemoriaCpu.execute("");

            }
        });


    }

    public class OperacoesBarramento extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(MainActivity.this, Barramento.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


           z = "Barramentos - Menu de Operações";
           isSuccess = true;

           return z;

        }
    }

    public class OperacoesConversaoNumerica extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(MainActivity.this, ConversaoNumerica.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


            z = "Conversão Numérica - Menu de Operações";
            isSuccess = true;

            return z;

        }
    }


    public class OperacoesMemoriaCpu extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, r, Toast.LENGTH_SHORT).show();

            if(isSuccess==true) {
                Intent i = new Intent(MainActivity.this, MemoriaCpu.class);
                startActivity(i);
                finish();

            }

        }

        @Override
        protected String doInBackground(String... params) {


            z = "Memórias e CPU - Menu de Operações";
            isSuccess = true;

            return z;

        }
    }





}
