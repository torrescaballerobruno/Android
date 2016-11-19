package com.example.root.panaderia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by root on 16/11/16.
 */

public class Registrarse extends AppCompatActivity {
    EditText nombre, user, pass, pass2;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse);
        nombre = (EditText) findViewById(R.id.edit_Nombre);
        user = (EditText) findViewById(R.id.edit_Usurio);
        pass = (EditText) findViewById(R.id.edit_Pass);
        pass2 = (EditText) findViewById(R.id.edit_Pass2);
    }

    public void registro (View view){
        String strNombre = nombre.getText().toString();
        String strUser = user.getText().toString();
        String strPass = pass.getText().toString();
        String strPass2 = pass2.getText().toString();

        if(strNombre.equals("") || strUser.equals("") || strPass.equals("") || strPass2.equals("")){
            Toast.makeText(this,"Por favor llena todos los campos",Toast.LENGTH_SHORT).show();

        }else if(!strPass2.equals(strPass)){
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();

        }else {
            int respuesta = registrar(strUser,strPass);
            if(respuesta == HttpURLConnection.HTTP_OK || respuesta == HttpURLConnection.HTTP_ACCEPTED) {
                Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                i = new Intent(this, Muestra.class);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(i);
                        finish();
                    }
                }, 10);
            }else{
                Toast.makeText(this,"Error al registrar",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public int registrar(String usr, String pass){
        URL url = null;
        String linea="";
        int respuesta=0;
        StringBuilder resul =null;
        HttpURLConnection conection = null;

        try{

            url = new URL(""); //pasar el URL !!!!
             conection =(HttpURLConnection)url.openConnection();
            respuesta = conection.getResponseCode();
            resul = new StringBuilder();

            if(respuesta == HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(conection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while((linea=reader.readLine())!=null){
                    resul.append(linea);
                }
            }

        }catch(Exception e){

        }finally {
            conection.disconnect();
        }
        return respuesta;
    }
}