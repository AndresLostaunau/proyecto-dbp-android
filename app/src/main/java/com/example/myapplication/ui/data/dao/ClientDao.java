package com.example.myapplication.ui.data.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.ui.data.entities.Client;

import java.util.ArrayList;

public class ClientDao {
    SQLiteDatabase cx;
    ArrayList<Client> lista;
    Client client;
    Context ct;
    String nombreBD = "ClientDB";
    String tabla ="CREATE TABLE IF NOT EXISTS client (id int PRIMARY KEY autoincrement, username text, password text, balance real)";

    public ClientDao(Context c){
        this.ct = c;
        cx = c.openOrCreateDatabase(nombreBD, Context.MODE_WORLD_WRITEABLE,null);
        cx.execSQL(tabla);
    }
}
