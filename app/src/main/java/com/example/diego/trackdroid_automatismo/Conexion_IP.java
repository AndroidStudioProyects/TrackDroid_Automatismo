package com.example.diego.trackdroid_automatismo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
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
 * Created by Diego on 04/06/2015.
 */


public class Conexion_IP extends AsyncTask<Void,Void,String> {

    int Puerto ;
    String msg,Ip,RespServer;
    Context contexto;
    String TAG="ConexionIP";
    String salida;
    PrintWriter out;
    Lay_MainActivity ac;
    Socket socket;
    InputStream is;
    BufferedReader br;


    public Conexion_IP(String Ip, int Puerto, String msg, Context contexto,Lay_MainActivity ac) {

        this.Ip = Ip;
        this.msg = msg;
        this.Puerto = Puerto;
        this.contexto=contexto;
        this.ac=ac;

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

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
            publishProgress();


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



        return RespServer=salida;
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);

    }


    @Override
    protected void onPostExecute(String aVoid) {
        if((aVoid == null) || (aVoid.equals(""))){
            System.out.print("erroreasooooooooooooooooo");
            Log.d(TAG, "null");
        }
        else {
            Log.d(TAG, "no null");


            String delimitadores = " ";
            String[] dato = aVoid.split(delimitadores);







            String SalDig = dato[7];
            cambiarTexto(ac.txtV_R1, ac.btn_R1, SalDig.substring(0, 1));
            cambiarTexto(ac.txtV_R2, ac.btn_R2, SalDig.substring(1, 2));
            cambiarTexto(ac.txtV_R3, ac.btn_R3, SalDig.substring(2, 3));
            cambiarTexto(ac.txtV_R4, ac.btn_R4, SalDig.substring(3, 4));
            cambiarTexto(ac.txtV_R5, ac.btn_R5, SalDig.substring(4, 5));
            cambiarTexto(ac.txtV_R6, ac.btn_R6, SalDig.substring(5, 6));
            cambiarTexto(ac.txtV_R7, ac.btn_R7, SalDig.substring(6, 7));

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
                Log.d(TAG, "Rele Apagado");
                break;
            default:
                break;
        }


    }

}