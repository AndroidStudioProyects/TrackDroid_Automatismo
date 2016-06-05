package com.example.diego.trackdroid_automatismo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Diego on 05/06/2016.
 */
public class Lay_EnviarDatos extends Activity {

    Button btn_Escribir,btn_MostrarEnDisplay,btn_EnviarDatos;
    EditText  Dato0,Dato1,Dato2,Dato3,Dato4,Dato5,Dato6,Dato7;
    Conexion_IP_memoria conexionIp;
    String Ip;
    String Datos="";
    int puerto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_enviardatos);
        LevantarXML();
        Intent intent = getIntent();
        Ip=intent.getStringExtra("ip");
        puerto=intent.getIntExtra("puerto", 9000);

        Botones();

    }

    void Botones(){

        btn_MostrarEnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {

                conexionIp=new Conexion_IP_memoria(Ip,puerto,"777",getApplicationContext(),Lay_EnviarDatos.this);
                conexionIp.execute();


               }
              }
        );

        btn_EnviarDatos.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {

                Datos="I "+Dato0.getText().toString()+","+Dato1.getText().toString()+","+Dato2.getText().toString()+","+Dato3.getText().toString()+","
                        +Dato4.getText().toString()+","
                        +Dato5.getText().toString()+","
                        +Dato6.getText().toString()+","
                        +Dato7.getText().toString();
                conexionIp=new Conexion_IP_memoria(Ip,puerto,Datos,getApplicationContext(),Lay_EnviarDatos.this);
                conexionIp.execute();

                 }
               }
        );

        btn_Escribir.setOnClickListener(new View.OnClickListener() {

             @Override public void onClick(View v) {

                 conexionIp=new Conexion_IP_memoria(Ip,puerto,"999",getApplicationContext(),Lay_EnviarDatos.this);
                 conexionIp.execute();

                  }
                }
        );



    }

    void LevantarXML(){

        btn_Escribir=(Button) findViewById(R.id.btn_999);
        btn_MostrarEnDisplay=(Button) findViewById(R.id.btn_777);
        btn_EnviarDatos=(Button) findViewById(R.id.btn_Enviar);
        Dato0=(EditText)findViewById(R.id.edit_Dato0);
        Dato1=(EditText)findViewById(R.id.edit_Dato1);
        Dato2=(EditText)findViewById(R.id.edit_Dato2);
        Dato3=(EditText)findViewById(R.id.edit_Dato3);
        Dato4=(EditText)findViewById(R.id.edit_Dato4);
        Dato5=(EditText)findViewById(R.id.edit_Dato5);
        Dato6=(EditText)findViewById(R.id.edit_Dato6);
        Dato7=(EditText)findViewById(R.id.edit_Dato7);


    }
}
