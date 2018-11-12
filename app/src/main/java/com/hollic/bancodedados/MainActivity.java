package com.hollic.bancodedados;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper helper;
    EditText usuario,senha;
    Button cadastrar, listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DataBaseHelper(this);
        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);
        cadastrar = findViewById(R.id.cadastrar);
        listar = findViewById(R.id.listar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDados();
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listarDados();
            }
        });
    }

    private void listarDados() {
        startActivity(new Intent(MainActivity.this,ListarActivity.class));
    }

    private void salvarDados() {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("login",usuario.getText().toString());
        values.put("senha",senha.getText().toString());

        long newId = db.insert(DataBaseHelper.TABLE_NAME,null,values);

        if (newId != -1)
            Toast.makeText(this,"Dados inseridos", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Erro ao inserir dados", Toast.LENGTH_LONG).show();
    }
}
