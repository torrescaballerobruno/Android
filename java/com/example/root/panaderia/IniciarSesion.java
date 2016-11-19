package com.example.root.panaderia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IniciarSesion extends AppCompatActivity{
    EditText usr , pass;
    int i=0;
    Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_sesion);
        usr = (EditText) findViewById(R.id.edit_Usuario);
        pass = (EditText) findViewById(R.id.edit_Pass);
    }

    public void iniciarSesion(View view){

        final String strUsr = usr.getText().toString();
        final String strPass = pass.getText().toString();

        Thread tr = new Thread(){
            public void run(){
                final String resultado = enviarDatosGET(strUsr,strPass);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        int r = obtDatosJSON(resultado);
                        if(r>0){
                            Intent i = new Intent(getApplicationContext(),Muestra.class);



                            i.putExtra("cog",strUsr);
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(),"Usuario o password incorrectos",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        };
        tr.start();

/*        if (strUsr.equals("") || strPass.equals("")){
            Toast.makeText(this,"Falta llenar algun campo",Toast.LENGTH_SHORT).show();
        } else if (obtDatosJSON(registrar(strUsr,strPass))==1){
                /*(strUsr.equals("BRK") && strPass.equals("BRK")){
            Toast.makeText(this,"Que show BRK ",Toast.LENGTH_SHORT).show();
            in = new Intent(this,Muestra.class);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(in);
                    finish();
                }
            },10);
        } else {
            i++;
            Toast.makeText(this,"Usuario no encontrado",Toast.LENGTH_SHORT).show();
            if(i==4){
                Toast.makeText(this,"Demasiados intentos",Toast.LENGTH_SHORT).show();
                i=0;
                finish();
            }
        }*/
    }

    public String enviarDatosGET(String usr, String pass){
        URL url = null;
        String linea="";
        int respuesta;
        StringBuilder resul =new StringBuilder();

        try{

            //url = new URL("http://10.2.8.221/Proyecto_Web/valida.php?usu="+usr+"&pas="+pass); //pasar el URL !!!!
            url = new URL("http://screwco.hol.es/andyEleno/valida.php?usu="+usr+"&pas="+pass);
            HttpURLConnection con =(HttpURLConnection)url.openConnection();
            respuesta = con.getResponseCode();
            Log.d("lo que quieras","  ");

            if(respuesta == HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(con.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while((linea=reader.readLine())!=null){
                    resul.append(linea);
                }
            }

        }catch(Exception e){
            Log.d("Error", e.getCause().toString());
        }
        return resul.toString();
    }

    public int obtDatosJSON(String response){
        int res=0;

            try{
                JSONArray json = new JSONArray(response);
                if(json.length()>0){
                    res=1;
                }
            }catch (Exception e){}


        return res;
    }
}