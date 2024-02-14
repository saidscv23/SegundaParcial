package com.example.datospersonales;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLConnection extends SQLiteOpenHelper {
    public MySQLConnection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE tbldatos"+"(" +
                "datos_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre text NOT NULL,"+
                "edad text NOT NULL," +
                "telefono text NOT NULL,"+
                "carrera text NOT NULL,"+
                "deporte text NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //CAMBIE LA VERSIÓN DE LA TABLA DE LA BDD
        db.execSQL("DROP TABLE tbldatos");
        onCreate(db);
    }
}
