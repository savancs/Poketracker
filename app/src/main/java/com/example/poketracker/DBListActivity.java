package com.example.poketracker;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.LinkedList;

public class DBListActivity extends AppCompatActivity {
    Cursor mCursor;
    LinkedList<Pokemon> pokemans;
    ListView listView;
    Pokemon pikachu = new Pokemon(25, "Pikachu", "Electric", "male", 2.2F, 3.4F, 123, 456, 145);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dblist2);
        updatelistUI();
        listView = findViewById(R.id.listView);

    }


    public void updatelistUI(){
        mCursor = getContentResolver().query(
                PokeProvider.CONTENT_URI, null, null,
                null, null);
        pokemans = new LinkedList<>();
        pokemans.add(pikachu);
        if (mCursor != null) {
            mCursor.moveToFirst();
            if (mCursor.getCount() > 0) {
                while(mCursor.isAfterLast() == false) {
                    String name = mCursor.getString(1);
                    int num = mCursor.getInt(2);
                    String species = mCursor.getString(3);
                    String gender = mCursor.getString(4);
                    Float height = mCursor.getFloat(5);
                    Float weight = mCursor.getFloat(6);
                    int attack = mCursor.getInt(7);
                    int defense = mCursor.getInt(8);
                    int hp = mCursor.getInt(9);
                    pokemans.add(new Pokemon(num, name, species, gender, height, weight, hp, attack, defense));
                    mCursor.moveToNext();
                }
            }
        }
        ArrayAdapter<Pokemon> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pokemans);
        listView.setAdapter(adapter);
    }
}
