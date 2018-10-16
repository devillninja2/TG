package com.example.leonardo.blindao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Collections;


public class MainActivity extends Activity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    CheckBox check_cpf;
    EditText cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
         editor = preferences.edit();
         check_cpf = (CheckBox) findViewById(R.id.checkbxCpf);
         cpf = (EditText)findViewById(R.id.editTextCpf);
         cpf.addTextChangedListener(Mask.insert("###.###.###-##", cpf));

        if(preferences.contains("cpf")){
            cpf.setText(preferences.getString("cpf","DEFAULT"));
        }else{
            cpf.setText("");
        }
    }



    public void abrirTreinos(View v) {
        String vetor = cpf.getText().toString();
        if (vetor.length() == 14) {

            if (check_cpf.isChecked()) {
                editor.putString("cpf", vetor);
                editor.commit();

            }else{
                editor.remove("cpf");
                editor.commit();
            }
            Intent abrirTre = new Intent(this, TreinosActivity.class);
            this.finish();
            startActivity(abrirTre);
        }else {
            Toast.makeText(getApplicationContext(), "CPF INVÁLIDO", Toast.LENGTH_SHORT).show();
        }
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
                            }
                        })
                .setNegativeButton("não", null)
                .show();
    }

}
