package com.hollic.bancodedados;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {

    ListView mListView;
    DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        mListView = findViewById(R.id.lista);

        helper = new DataBaseHelper(this);

        SQLiteDatabase db = helper.getReadableDatabase();

        String[] campos = {
                DataBaseHelper.COLUMN_NAME_LOGIN
        };

        Cursor cursor = db.query(DataBaseHelper.TABLE_NAME,campos,null,null,null,null,null);

        ArrayList<String> nomes = new ArrayList<>();
        while (cursor.moveToNext()) {
            nomes.add(cursor.getString(cursor.getColumnIndex("login")));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.addAll(nomes);
        mListView.setAdapter(adapter);
    }
}
