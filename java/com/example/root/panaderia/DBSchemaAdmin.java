package com.example.root.panaderia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 11/11/16.
 */

public class DBSchemaAdmin extends SQLiteOpenHelper{
    public static final int VERSION = 1;
    public static final String NOMBRE_DB = "BaseDeDatos.db";

    public static final String CREAR_TABLA_PRODUCTO =
            "CREATE TABLE " + BDSchema.Producto.NOMBRE +
                    " (" + BDSchema.Producto.ID+" INTEGER PRIMARY KEY, "+
                    BDSchema.Producto.NOMBRE+" TEXT, "+
                    BDSchema.Producto.CANTIDAD+" REAL, " +
                    BDSchema.Producto.PRECIO + " REAL )";

    public static final String CREAR_TABLA_USUARIO =
            "CREATE TABLE " + BDSchema.Usuario.USUARIO +
                    " (" + BDSchema.Usuario.ID + " INTEGER PRIMARY KEY, "+
                    BDSchema.Usuario.NOMBRE + " TEXT, " +
                    BDSchema.Usuario.PASSWD + " TEXT, " +
                    BDSchema.Usuario.EDAD + " )";

    public static final String BORRATABLE_PRODUCTO = " DROP TABLE IF EXISTS " + BDSchema.Producto.NOMBRE;
    public static final String BORRATABLE_USUARIO = " DROP TABLE IF EXISTS " + BDSchema.Usuario.USUARIO;

    public DBSchemaAdmin(Context context) {
        super(context, NOMBRE_DB,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAR_TABLA_PRODUCTO);
        sqLiteDatabase.execSQL(CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(BORRATABLE_PRODUCTO);
        sqLiteDatabase.execSQL(BORRATABLE_USUARIO);
        onCreate(sqLiteDatabase);
    }
}
