package com.example.leonardo.blindao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class TreinosActivity extends Activity {

    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treinos);
    }


    public void abrirGif(View v){
        Intent openG = new Intent(this,GifActivity.class);
        startActivity(openG);
    }

    public void abrirA(View v){
        Intent open = new Intent(this, TreinoActivity.class);
        startActivity(open);
        this.finish();
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


}