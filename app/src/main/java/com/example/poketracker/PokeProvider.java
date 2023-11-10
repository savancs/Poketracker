package com.example.poketracker;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class PokeProvider extends ContentProvider {

    public final static String DBNAME = "PokeDatabase";
    public PokeProvider() {
    }
    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);
        }
        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        }
    };


    public final static String TABLE_POKETABLE = "Pokemon";
    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_GENDER = "gender";
    public final static String COLUMN_SPECIES = "species";
    public final static String COLUMN_HP = "hp";
    public final static String COLUMN_ATTACK = "attack";
    public final static String COLUMN_DEFENSE = "defense";
    public final static String COLUMN_HEIGHT = "height";
    public final static String COLUMN_WEIGHT = "weight";
    public final static String COLUMN_NUM = "natnumber";

    public static final String AUTHORITY = "com.example.pokedata";
    public static final Uri CONTENT_URI = Uri.parse(
            "content://" + AUTHORITY +"/" + TABLE_POKETABLE);

    private static UriMatcher sUriMatcher;

    private MainDatabaseHelper mOpenHelper;

    private static final String SQL_CREATE_MAIN = "CREATE TABLE " +
            TABLE_POKETABLE +  // Table's name
            "(" +               // The columns in the table
            " _ID INTEGER PRIMARY KEY, " +
            COLUMN_NUM + " INTEGER ," +
            COLUMN_NAME + " TEXT ," +
            COLUMN_SPECIES + " TEXT," +
            COLUMN_GENDER + " TEXT," +
            COLUMN_HEIGHT + " FLOAT," +
            COLUMN_WEIGHT + " FLOAT," +
            COLUMN_HP + " INTEGER," +
            COLUMN_ATTACK + " INTEGER," +
            COLUMN_DEFENSE + " INTEGER)";


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().delete(TABLE_POKETABLE, selection, selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String name = values.getAsString(COLUMN_NAME).trim();
        String species = values.getAsString(COLUMN_SPECIES).trim();
        String gender = values.getAsString(COLUMN_GENDER).trim();
        Integer natnum = values.getAsInteger(COLUMN_NUM);
        Float height = values.getAsFloat(COLUMN_HEIGHT);
        Float weight = values.getAsFloat(COLUMN_WEIGHT);
        Integer hp = values.getAsInteger(COLUMN_HP);
        Integer attack = values.getAsInteger(COLUMN_ATTACK);
        Integer defense = values.getAsInteger(COLUMN_DEFENSE);

        if (name.equals(""))
            return null;
        if (species.equals(""))
            return null;
        if (gender.equals(""))
            return null;
        if (natnum.equals(""))
            return null;
        if (height.equals(""))
            return null;
        if (weight.equals(""))
            return null;
        if (hp.equals(""))
            return null;
        if (attack.equals(""))
            return null;
        if (defense.equals(""))
            return null;



        long id = mOpenHelper.getWritableDatabase().insert(TABLE_POKETABLE, null, values);

        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return mOpenHelper.getReadableDatabase().query(TABLE_POKETABLE, projection, selection, selectionArgs,
                null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().update(TABLE_POKETABLE, values, selection, selectionArgs);
    }
}
