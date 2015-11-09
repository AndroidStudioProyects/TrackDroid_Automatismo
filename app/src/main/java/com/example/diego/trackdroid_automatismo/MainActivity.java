package com.example.diego.trackdroid_automatismo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

static String TAG="TrackDroid";


    Conexion_IP  Cliente_TCP;
    EditText edit_IP,edit_Puerto;
    Button btn_Status,btn_Reset;
    CheckBox CkB_Echo;
    Boolean EchoBool=false,EnterBool=false;
    public static TextView text_Temp,textTitServ,txtV_R1,txtV_R2,txtV_R3,txtV_R4,txtV_R5,txtV_R6,txtV_R7;
    public static ToggleButton TB_1,TB_2,TB_3,TB_4,TB_5,TB_6,TB_7;
    Switch switch1;
    static String R100="100",R101="101",R200="200",R201="201",R300="300",R301="301",R400="400",R401="401",
            R500="500",R501="501",R600="600",R601="601",R700="700",R701="701";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LevantarXML();
        Botones();
        CargarPreferencias();
        habilitar(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        GuardarPreferencias();
    }



    private void Botones() {
        CkB_Echo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EchoBool = isChecked;
                EnterBool=isChecked;

                Log.d(TAG,"enter habilitado:"+EnterBool);
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Enter Habilitado", Toast.LENGTH_SHORT).show();
                    textTitServ.setEnabled(true);
                    text_Temp.setEnabled(true);
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Deshabilido",Toast.LENGTH_SHORT).show();
                    textTitServ.setEnabled(false);
                    text_Temp.setEnabled(false);

                }

            }
        });

        btn_Status.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                Intent intent= new Intent(MainActivity.this,Lay_Status.class);
                intent.putExtra("ip",IP);
                intent.putExtra("puerto",Puerto);

                startActivity(intent);

                }
                });


        TB_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (isChecked) {
                    msg = R101;

                } else {
                    msg = R100;
               }
                buttonView.setChecked(false);
           //Cliente_TCP=new Conexion_IP_layMA(IP,Puerto,msg,getApplicationContext(),MainActivity.this);
             //   Cliente_TCP.execute();
            }
        });
        TB_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (isChecked) {
                    msg = R201;
                } else {
                    msg = R200;
                }

          //      Cliente_TCP=new Conexion_IP(IP,Puerto,msg,getApplicationContext(),MainActivity.this);
           //     Cliente_TCP.execute();

            }
        });
        TB_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (isChecked) {
                    msg = R301;
                } else {
                    msg = R300;
                }

              //  Cliente_TCP=new Conexion_IP(IP,Puerto,msg,getApplicationContext(),MainActivity.this);
              //  Cliente_TCP.execute();

            }
        });
        TB_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (isChecked) {
                    msg = R401;
                } else {
                    msg = R400;
                }

           //     Cliente_TCP=new Conexion_IP(IP,Puerto,msg,getApplicationContext(),MainActivity.this);
            //    Cliente_TCP.execute();

            }
        });
        TB_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (isChecked) {
                    msg = R501;
                } else {
                    msg = R500;
                }

             //   Cliente_TCP=new Conexion_IP(IP,Puerto,msg,getApplicationContext(),MainActivity.this);
              //  Cliente_TCP.execute();

            }
        });
        TB_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (isChecked) {
                    msg = R601;
                } else {
                    msg = R600;
                }

//                Cliente_TCP=new Conexion_IP(IP,Puerto,msg,getApplicationContext(),MainActivity.this);
  //              Cliente_TCP.execute();
            }
        });
        TB_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg=null;
                String IP = edit_IP.getText().toString();
                int Puerto = Integer.parseInt(edit_Puerto.getText().toString());
                if (isChecked) {
                    msg = R701;
                } else {
                    msg = R700;
                }

      //          Cliente_TCP=new Conexion_IP(IP,Puerto,msg,getApplicationContext(),MainActivity.this);
        //        Cliente_TCP.execute();
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            habilitar(isChecked);
                if(isChecked){
                    GuardarPreferencias();
                }else{
                    CargarPreferencias();
                }

 }
        });



    }

    private void LevantarXML() {

        text_Temp=(TextView)findViewById(R.id.text_Temp);
        textTitServ=(TextView)findViewById(R.id.textTitServ);
        txtV_R1=(TextView)findViewById(R.id.txtV_R1);
        txtV_R2=(TextView)findViewById(R.id.txtV_R2);
        txtV_R3=(TextView)findViewById(R.id.txtV_R3);
        txtV_R4=(TextView)findViewById(R.id.txtV_R4);
        txtV_R5=(TextView)findViewById(R.id.txtV_R5);
        txtV_R6=(TextView)findViewById(R.id.txtV_R6);
        txtV_R7=(TextView)findViewById(R.id.txtV_R7);

        CkB_Echo=(CheckBox)findViewById(R.id.ckBox_Echo);
        edit_IP= (EditText) findViewById(R.id.edit_IP);
        edit_Puerto=(EditText) findViewById(R.id.edit_Puerto);
        btn_Status=(Button)findViewById(R.id.btn_Status);
        btn_Reset=(Button)findViewById(R.id.btn_Reset);

        TB_1=(ToggleButton)findViewById(R.id.TB_1);
        TB_2=(ToggleButton)findViewById(R.id.TB_2);
        TB_3=(ToggleButton)findViewById(R.id.TB_3);
        TB_4=(ToggleButton)findViewById(R.id.TB_4);
        TB_5=(ToggleButton)findViewById(R.id.TB_5);
        TB_6=(ToggleButton)findViewById(R.id.TB_6);
        TB_7=(ToggleButton)findViewById(R.id.TB_7);

        switch1= (Switch) findViewById(R.id.switch1);

    }

    ///////////////////// PREFERENCIAS DE USUARIO ////////////////
    public void CargarPreferencias(){

        SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
    edit_IP.setText(mispreferencias.getString("edit_IP", "idirect.dlinkddns.com"));
        edit_Puerto.setText(mispreferencias.getString("edit_Port", "9000"));

        Log.d(TAG, "Preferencias Cargadas");


    }

    public void GuardarPreferencias() {
        SharedPreferences mispreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putString("edit_IP", edit_IP.getText().toString());
        editor.putString("edit_Port", edit_Puerto.getText().toString());
        editor.commit();
        Log.d(TAG, "Preferencias Almacenadas");

    }
// //////////////////////////////////////////////////////////

    private void habilitar(boolean bol){
        edit_Puerto.setEnabled(!bol);
        edit_IP.setEnabled(!bol);
        TB_1.setEnabled(bol);
        TB_2.setEnabled(bol);
        TB_3.setEnabled(bol);
        TB_4.setEnabled(bol);
        TB_5.setEnabled(bol);
        TB_6.setEnabled(bol);
        TB_7.setEnabled(bol);
        btn_Status.setEnabled(bol);


    }

/*
    private class Conexion extends AsyncTask <Void,Void,String>{

        int Puerto ;
        String msg,Ip,RespServer;
        Context contexto;
        String TAG="ConexionIP";
        String salida;
        PrintWriter out;

        public  Conexion(String Ip,int Puerto,String msg,Context contexto) {

            this.Ip = Ip;
            this.msg = msg;
            this.Puerto = Puerto;
            this.contexto=contexto;

        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {


            try {
                Socket socket;
                //Create a client socket and define internet address and the port of the server
                socket = new Socket(Ip,Puerto);
                //Get the input stream of the client socket
                InputStream is = socket.getInputStream();
                //Get the output stream of the client socket
                out = new PrintWriter(socket.getOutputStream(),true);
                //Write data to the output stream of the client socket
                out.println(msg+"\n");// Id REadiobase + Id alarma
                final BufferedReader br = new BufferedReader(
                        new InputStreamReader(is));
                if(EchoBool){
                //Buffer the data coming from the input stream

                String msg=br.readLine();
                    Log.d(TAG, "REcibido mensjae ");
                    salida=msg;}else{msg="Hecho Deshabiliado";}
                salida=msg;
                Log.d(TAG, " " + msg);
                publishProgress();
                socket.close();

            } catch (NumberFormatException e) {
                e.printStackTrace();
                Log.d(TAG, "NumberFormatException " + e);


            } catch (UnknownHostException e) {

                e.printStackTrace();
                Log.d(TAG, "UnknownHostException " + e);
            } catch (IOException e) {

                e.printStackTrace();
                Log.d(TAG, " IOException " + e);
            }



            return RespServer=salida;
        }

        @Override
        protected void onProgressUpdate(Void... values) {

            super.onProgressUpdate(values);
      //      Toast.makeText(getApplicationContext(), salida, Toast.LENGTH_SHORT).show();
      //      text_Temp.setText(values);

        }


        @Override
        protected void onPostExecute(String aVoid) {
        //   Toast.makeText(getApplicationContext(),aVoid,Toast.LENGTH_SHORT).show();
            text_Temp.setText(aVoid);
        }
    }

*/




}
