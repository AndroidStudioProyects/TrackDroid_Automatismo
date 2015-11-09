package com.example.diego.trackdroid_automatismo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.annotation.ColorRes;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by diego on 10/08/15.
 */
public class Conexion_IP_layMA extends AsyncTask<Void,Void,String> {


    int Puerto ;
    String msg,Ip,RespServer;
    Context contexto;
    String TAG="TrackDroid";
    String salida;
    PrintWriter out;
    Lay_MainActivity ac;
    Socket socket;
    InputStream is;
    BufferedReader br;



    public Conexion_IP_layMA(String Ip, int Puerto, String msg, Context contexto,Lay_MainActivity ac) {

        this.Ip = Ip;
        this.msg = msg;
        this.Puerto = Puerto;
        this.contexto=contexto;
        this.ac=ac;


    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
Log.d(TAG,"");
    }

    @Override
    protected String doInBackground(Void... params) {


        try {
            socket = new Socket(Ip,Puerto);

            out = new PrintWriter(socket.getOutputStream(),true);
            out.println(msg);// Id REadiobase + Id alarma
            is = socket.getInputStream();
            br = new BufferedReader( new InputStreamReader(is));
            msg=br.readLine();
            salida=msg;
            Log.d(TAG, " " + msg);

            br.close();
            is.close();
            out.close();
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

        Log.d(TAG,"salida: "+salida);

        return RespServer=salida;
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);

    }


    @Override
    protected void onPostExecute(String aVoid) {
        String boton = null;
        String datoTB=null;
        Log.d(TAG,"onPost");
        if((aVoid == null) || (aVoid.equals(""))){
             Toast.makeText(contexto,"El equipo no responde o esta ocupado", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "null");
        } else {
            Log.d(TAG,"no null");


  try {
                boton = aVoid.subSequence(0, 1).toString();
                datoTB = aVoid.subSequence(2, 3).toString();

            } catch (Exception e) {


            }

            // Toast.makeText(contexto,"dato: '"+ datoTB+"'", Toast.LENGTH_SHORT).show();
            switch (boton) {

                case "1":
                    cambiarTexto(ac.txtV_R1, ac.btn_R1, datoTB);
                    break;
                case "2":
                    cambiarTexto(ac.txtV_R2, ac.btn_R2, datoTB);
                    break;
                case "3":
                    cambiarTexto(ac.txtV_R3, ac.btn_R3, datoTB);
                    break;
                case "4":
                    cambiarTexto(ac.txtV_R4, ac.btn_R4, datoTB);
                    break;
                case "5":
                    cambiarTexto(ac.txtV_R5, ac.btn_R5, datoTB);
                    break;
                case "6":
                    cambiarTexto(ac.txtV_R6, ac.btn_R6, datoTB);
                    break;
                case "7":
                    cambiarTexto(ac.txtV_R7, ac.btn_R7, datoTB);
                    break;
                default:
                    break;


            }





        }
    }


    private void cambiarTexto(TextView TV,Button btn,String dato) {

        switch (dato) {
            case "1":
                TV.setText("On");
                btn.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF49FF11")));

                Log.d(TAG, " Rele Encendido");
                break;
            case "0":
                TV.setText("Off");
                btn.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff1a06")));
             //   Toast.makeText(contexto, "Apagado", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Rele Apagado");
                break;
            default:
                break;
        }


    }
}
