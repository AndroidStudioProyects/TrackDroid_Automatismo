package com.example.diego.trackdroid_automatismo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Diego on 26/07/2015.
 */
public class Lay_Status extends Activity {

    TextView text_A0,text_A1,text_A2,text_A3,text_A4,text_A5;
    TextView text_unidad_A0,text_unidad_A1,text_unidad_A2,text_unidad_A3,text_unidad_A4,text_unidad_A5;
    Switch Relay_0,Relay_1,Relay_3,Relay_4,Relay_5,Relay_6,Relay_7,Relay_2;
    Switch Rele_1,Rele_2,Rele_3,Rele_4,Rele_5,Rele_6,Rele_7;
    Button btn_status;
    Conexion_IP_Status conIpStatus;
    String Ip;
    int puerto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_status);
        Intent intent = getIntent();
        LevantarXML();
        Botones();
        Ip=intent.getStringExtra("ip");
        puerto=intent.getIntExtra("puerto", 9000);

        conIpStatus=new Conexion_IP_Status(Ip,puerto,"000",getApplicationContext(),Lay_Status.this);
        conIpStatus.execute();

    }

    private void Botones() {

        btn_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 000: mensaje solicitando status del dispositivo
               conIpStatus=new Conexion_IP_Status(Ip,puerto,"000",getApplicationContext(),Lay_Status.this);
               conIpStatus.execute();
            }
        });
    }

    private void LevantarXML() {

        /* boton de consulta que envia "000"
        y responde "P1023 P1023 H417 T1021 T1023 T1020 11001110"
        donde P: Presion
              H: Humedad
              T: Temperatura
              11001110: los estados de izq a der de los Relays 1,2,3...8
              101 201
          */
        btn_status=(Button)findViewById(R.id.btn_status);

        // textViews con los valores de los sensores analogicos del dispositivo
        text_A0=(TextView)findViewById(R.id.text_A0);
        text_A1=(TextView)findViewById(R.id.text_A1);
        text_A2=(TextView)findViewById(R.id.text_A2);
        text_A3=(TextView)findViewById(R.id.text_A3);
        text_A4=(TextView)findViewById(R.id.text_A4);
        text_A5=(TextView)findViewById(R.id.text_A5);

        // unidades
        text_unidad_A0=(TextView)findViewById(R.id.text_unidad_A0);
        text_unidad_A1=(TextView)findViewById(R.id.text_unidad_A1);
        text_unidad_A2=(TextView)findViewById(R.id.text_unidad_A2);
        text_unidad_A3=(TextView)findViewById(R.id.text_unidad_A3);
        text_unidad_A4=(TextView)findViewById(R.id.text_unidad_A4);
        text_unidad_A5=(TextView)findViewById(R.id.text_unidad_A5);


        // entradas digitales del dispositivo
        Relay_0=(Switch)findViewById(R.id.Relay_0);
        Relay_1=(Switch)findViewById(R.id.Relay_1);
        Relay_2=(Switch)findViewById(R.id.Relay_2);
        Relay_3=(Switch)findViewById(R.id.Relay_3);
        Relay_4=(Switch)findViewById(R.id.Relay_4);
        Relay_5=(Switch)findViewById(R.id.Relay_5);
        Relay_6=(Switch)findViewById(R.id.Relay_6);
        Relay_7=(Switch)findViewById(R.id.Relay_7);


        Rele_1=(Switch)findViewById(R.id.Rele_1);
        Rele_2=(Switch)findViewById(R.id.Rele_2);
        Rele_3=(Switch)findViewById(R.id.Rele_3);
        Rele_4=(Switch)findViewById(R.id.Rele_4);
        Rele_5=(Switch)findViewById(R.id.Rele_5);
        Rele_6=(Switch)findViewById(R.id.Rele_6);
        Rele_7=(Switch)findViewById(R.id.Rele_7);



    }


}
