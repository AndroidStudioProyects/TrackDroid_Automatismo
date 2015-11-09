package com.example.diego.trackdroid_automatismo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Diego on 09/08/2015.
 */
public class Lay_MainActivity extends AppCompatActivity {
    Button btn_R1,btn_R2,btn_R3,btn_R4,btn_R5,btn_R6,btn_R7;
    Button btn_Status;
    public static TextView txtV_R1,txtV_R2,txtV_R3,txtV_R4,txtV_R5,txtV_R6,txtV_R7;
    TextView text_mensajes;
    EditText edit_IP,edit_Puerto;
    Switch switch1;
    Conexion_IP_layMA Cliente_TCP;
    Conexion_IP Cliente_TCP_stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_mainactivity);
        LevantarXML();
        Botones();
        habilitar(false);
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        CargarPreferencias();
    }

    @Override
    protected void onStop() {
        super.onStop();
        GuardarPreferencias();
    }


    private void Botones() {


        btn_R1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (txtV_R1.getText().toString().equals("Off")) {
                    msg = "101";

                } else {
                    msg = "100";
                }

                Cliente_TCP=new Conexion_IP_layMA(IP,Puerto,msg,getApplicationContext(),Lay_MainActivity.this);
                Cliente_TCP.execute();

            }
        });
        btn_R2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (txtV_R2.getText().toString().equals("Off")) {
                    msg = "201";

                } else {
                    msg = "200";
                }

                Cliente_TCP=new Conexion_IP_layMA(IP,Puerto,msg,getApplicationContext(),Lay_MainActivity.this);
                Cliente_TCP.execute();


            }


        });
        btn_R3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (txtV_R3.getText().toString().equals("Off")) {
                    msg = "301";

                } else {
                    msg = "300";
                }

                Cliente_TCP=new Conexion_IP_layMA(IP,Puerto,msg,getApplicationContext(),Lay_MainActivity.this);
                Cliente_TCP.execute();

            }
        });
        btn_R4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (txtV_R4.getText().toString().equals("Off")) {
                    msg = "401";

                } else {
                    msg = "400";
                }

                Cliente_TCP=new Conexion_IP_layMA(IP,Puerto,msg,getApplicationContext(),Lay_MainActivity.this);
                Cliente_TCP.execute();


            }
        });
        btn_R5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (txtV_R5.getText().toString().equals("Off")) {
                    msg = "501";

                } else {
                    msg = "500";
                }

                Cliente_TCP=new Conexion_IP_layMA(IP,Puerto,msg,getApplicationContext(),Lay_MainActivity.this);
                Cliente_TCP.execute();

            }
        });
        btn_R6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (txtV_R6.getText().toString().equals("Off")) {
                    msg = "601";

                } else {
                    msg = "600";
                }

                Cliente_TCP = new Conexion_IP_layMA(IP, Puerto, msg, getApplicationContext(), Lay_MainActivity.this);
                Cliente_TCP.execute();

            }
        });
        btn_R7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (txtV_R7.getText().toString().equals("Off")) {
                    msg = "701";

                } else {
                    msg = "700";
                }

                Cliente_TCP = new Conexion_IP_layMA(IP, Puerto, msg, getApplicationContext(), Lay_MainActivity.this);
                Cliente_TCP.execute();

            }
        });


        switch1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            { habilitar(isChecked); String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (isChecked) { btn_Status.setEnabled(true);
                    GuardarPreferencias();
                    Cliente_TCP_stat = new Conexion_IP(IP, Puerto, "000", getApplicationContext(), Lay_MainActivity.this);
                    Cliente_TCP_stat.execute(); } else ApagarBotones(); } });


        btn_Status.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                Intent intent = new Intent(Lay_MainActivity.this, Lay_Status.class);
                intent.putExtra("ip", IP); intent.putExtra("puerto", Puerto);
                startActivity(intent); } });
    }

    private void LevantarXML() {

        btn_R1=(Button)findViewById(R.id.layMA_btn_R1);
        btn_R2=(Button)findViewById(R.id.layMA_btn_R2);
        btn_R3=(Button)findViewById(R.id.layMA_btn_R3);
        btn_R4=(Button)findViewById(R.id.layMA_btn_R4);
        btn_R5=(Button)findViewById(R.id.layMA_btn_R5);
        btn_R6=(Button)findViewById(R.id.layMA_btn_R6);
        btn_R7=(Button)findViewById(R.id.layMA_btn_R7);

        btn_Status=(Button)findViewById(R.id.layMA_btn_Status);


        txtV_R1=(TextView)findViewById(R.id.layMA_txtV_R1);
        txtV_R2=(TextView)findViewById(R.id.layMA_txtV_R2);
        txtV_R3=(TextView)findViewById(R.id.layMA_txtV_R3);
        txtV_R4=(TextView)findViewById(R.id.layMA_txtV_R4);
        txtV_R5=(TextView)findViewById(R.id.layMA_txtV_R5);
        txtV_R6=(TextView)findViewById(R.id.layMA_txtV_R6);
        txtV_R7=(TextView)findViewById(R.id.layMA_txtV_R7);

        text_mensajes=(TextView)findViewById(R.id.layMA_text_mensajes);

        switch1= (Switch) findViewById(R.id.layMA_switch1);

        edit_IP= (EditText) findViewById(R.id.layMA_edit_IP);
        edit_Puerto=(EditText) findViewById(R.id.layMA_edit_Puerto);


    }

    ///////////////////// PREFERENCIAS DE USUARIO ////////////////
    public void CargarPreferencias(){

        SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        edit_IP.setText(mispreferencias.getString("edit_IP", "track.dyndns.org"));
        edit_Puerto.setText(mispreferencias.getString("edit_Port", "9000"));
  }

    public void GuardarPreferencias() {
        SharedPreferences mispreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putString("edit_IP", edit_IP.getText().toString());
        editor.putString("edit_Port", edit_Puerto.getText().toString());
        editor.commit();

    }
// //////////////////////////////////////////////////////////

    private void habilitar(boolean bol){
                edit_Puerto.setEnabled(!bol);
                edit_IP.setEnabled(!bol);
                btn_R1.setEnabled(bol);
                btn_R2.setEnabled(bol);
                btn_R3.setEnabled(bol);
                btn_R4.setEnabled(bol);
                btn_R5.setEnabled(bol);
                btn_R6.setEnabled(bol);
                btn_R7.setEnabled(bol);
                btn_Status.setEnabled(bol);


            }

    private void ApagarBotones(){

        txtV_R1.setText("Off");
        txtV_R2.setText("Off");
        txtV_R3.setText("Off");
        txtV_R4.setText("Off");
        txtV_R5.setText("Off");
        txtV_R6.setText("Off");
        txtV_R7.setText("Off");
        btn_R1.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff1a06")));
        btn_R2.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff1a06")));
        btn_R3.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff1a06")));
        btn_R4.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff1a06")));
        btn_R5.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff1a06")));
        btn_R6.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff1a06")));
        btn_R7.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff1a06")));
        btn_Status.setEnabled(false);
    }

    ///////////////////// MENU ////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.configuracion:
                Intent intent = new Intent(Lay_MainActivity.this, Lay_Configuracion.class);
          //      intent.putExtra("ip", IP);
          //      intent.putExtra("puerto", Puerto);

                startActivity(intent);
                break;
            case R.id.about:
                Toast.makeText(getApplicationContext(),"Correo del desarrollador: diegogiovanazzi@gmail.com",Toast.LENGTH_LONG).show();
             break;

        }
                return super.onOptionsItemSelected(item);



    }
///////////////////////////////////////////////////////////////


}
