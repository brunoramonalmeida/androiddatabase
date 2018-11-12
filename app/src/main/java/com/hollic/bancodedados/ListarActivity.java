package com.hollic.bancodedados;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
                BaseColumns._ID,
                FeedEntry.COLUMN_NAME_TITLE,
                FeedEntry.COLUMN_NAME_SUBTITLE
        };
    }
}
