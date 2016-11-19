package com.example.root.panaderia;

import android.provider.BaseColumns;

/**
 * Created by root on 11/11/16.
 */

public final class BDSchema {
    public BDSchema(){}

    public static class Producto implements BaseColumns{
        public static final String NOMBRE="Productos";
        public static final String ID ="Id";
        public static final String PRECIO ="Precio";
        public static final String CANTIDAD ="Cantidad";
    }


    public static class Usuario {
        public static final String USUARIO ="Usuario";
        public static final String ID ="Id";
        public static final String NOMBRE ="Nombre";
        public static final String PASSWD ="Password";
        public static final String EDAD = "Edad";
    }
}
