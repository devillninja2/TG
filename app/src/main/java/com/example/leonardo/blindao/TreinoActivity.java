package com.example.leonardo.blindao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TreinoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);
    }


    public void abrirCronometro(View v){
        Intent openCronometro = new Intent(this,CronometroActivity.class);
        startActivity(openCronometro);
    }

    public void sair(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Tem certeza que deseja encerrar a sessao?")
                .setPositiveButton("sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                Intent openMain = new Intent(getBaseContext(), MainActivity.class);
                                startActivity(openMain);
                            }
                        })
                .setNegativeButton("não", null)
                .show();
    }

    public void onBackPressed(){ //Botão BACK padrão do android

        Intent openTreinos = new Intent(getBaseContext(), TreinosActivity.class);
        startActivity(openTreinos);
        this.finish();

    }
}
