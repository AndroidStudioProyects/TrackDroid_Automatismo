package com.example.diego.trackdroid_automatismo;

/**
 * Created by Diego on 26/07/2015.
 */

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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



public class Conexion_IP_Status extends AsyncTask<Void,Void,String> {

    int Puerto ;
    String msg,Ip,RespServer;
    Context contexto;
    String TAG="ConexionIP";
    String salida;
    PrintWriter out;
    Lay_Status ac;
    Socket socket;
    InputStream is;
    BufferedReader br;


    public Conexion_IP_Status(String Ip, int Puerto, String msg, Context contexto,Lay_Status ac) {

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
            int longitud = dato.length;
            String A0, A1, A2, A3, A4, A5;
            String unit;
            String scale;
            int cantidad;

            A0 = dato[0];
            unit = A0.subSequence(0, 1).toString();
            scale = A0.subSequence(1, 2).toString();
            cantidad = Integer.parseInt(A0.subSequence(2, A0.length()).toString());
            ac.text_A0.setText(Escalas(unit, scale, cantidad));
            Unidad(ac.text_unidad_A0, A0.subSequence(0, 1).toString());

            A1 = dato[1];
            //CargarDato(ac.text_A1, A1);
            unit = A1.subSequence(0, 1).toString();
            scale = A1.subSequence(1, 2).toString();
            cantidad = Integer.parseInt(A1.subSequence(2, A1.length()).toString());
            ac.text_A1.setText(Escalas(unit, scale, cantidad));
            Unidad(ac.text_unidad_A1, A1.subSequence(0, 1).toString());

            A2 = dato[2];
            //CargarDato(ac.text_A2, A2);
            unit = A2.subSequence(0, 1).toString();
            scale = A2.subSequence(1, 2).toString();
            cantidad = Integer.parseInt(A2.subSequence(2, A2.length()).toString());
            ac.text_A2.setText(Escalas(unit, scale, cantidad));
            Unidad(ac.text_unidad_A2, A2.subSequence(0, 1).toString());

            A3 = dato[3];
            // CargarDato(ac.text_A3, A3);
            unit = A3.subSequence(0, 1).toString();
            scale = A3.subSequence(1, 2).toString();
            cantidad = Integer.parseInt(A3.subSequence(2, A3.length()).toString());
            ac.text_A3.setText(Escalas(unit, scale, cantidad));
            Unidad(ac.text_unidad_A3, A3.subSequence(0, 1).toString());

            A4 = dato[4];
            //    CargarDato(ac.text_A4, A4);
            unit = A4.subSequence(0, 1).toString();
            scale = A4.subSequence(1, 2).toString();
            cantidad = Integer.parseInt(A4.subSequence(2, A4.length()).toString());
            ac.text_A4.setText(Escalas(unit, scale, cantidad));
            Unidad(ac.text_unidad_A4, A4.subSequence(0, 1).toString());

            A5 = dato[5];
            //CargarDato(ac.text_A4,A5);
            unit = A5.subSequence(0, 1).toString();
            scale = A5.subSequence(1, 2).toString();
            cantidad = Integer.parseInt(A5.subSequence(2, A5.length()).toString());
            ac.text_A5.setText(Escalas(unit, scale, cantidad));

            Unidad(ac.text_unidad_A5, A5.subSequence(0, 1).toString());


            String EntDig = dato[6];

            if (EntDig.substring(0, 1).equals("1")) {
                ac.Relay_0.setChecked(true);
            } else {
                ac.Relay_0.setChecked(false);
            }

            if (EntDig.substring(1, 2).equals("1")) {
                ac.Relay_1.setChecked(true);
            } else {
                ac.Relay_1.setChecked(false);
            }

            if (EntDig.substring(2, 3).equals("1")) {
                ac.Relay_2.setChecked(true);
            } else {
                ac.Relay_2.setChecked(false);
            }

            if (EntDig.substring(3, 4).equals("1")) {
                ac.Relay_3.setChecked(true);
            } else {
                ac.Relay_3.setChecked(false);
            }

            if (EntDig.substring(4, 5).equals("1")) {
                ac.Relay_4.setChecked(true);
            } else {
                ac.Relay_4.setChecked(false);
            }

            if (EntDig.substring(5, 6).equals("1")) {
                ac.Relay_5.setChecked(true);
            } else {
                ac.Relay_5.setChecked(false);
            }

            if (EntDig.substring(6, 7).equals("1")) {
                ac.Relay_6.setChecked(true);
            } else {
                ac.Relay_6.setChecked(false);
            }

            if (EntDig.substring(7, 8).equals("1")) {
                ac.Relay_7.setChecked(true);
            } else {
                ac.Relay_7.setChecked(false);
            }


            String SalDig = dato[7];

            if (SalDig.substring(0, 1).equals("1")) {
                ac.Rele_1.setChecked(true);
            } else {
                ac.Rele_1.setChecked(false);
            }

            if (SalDig.substring(1, 2).equals("1")) {
                ac.Rele_2.setChecked(true);
            } else {
                ac.Rele_2.setChecked(false);
            }

            if (SalDig.substring(2, 3).equals("1")) {
                ac.Rele_3.setChecked(true);
            } else {
                ac.Rele_3.setChecked(false);
            }

            if (SalDig.substring(3, 4).equals("1")) {
                ac.Rele_4.setChecked(true);
            } else {
                ac.Rele_4.setChecked(false);
            }

            if (SalDig.substring(4, 5).equals("1")) {
                ac.Rele_5.setChecked(true);
            } else {
                ac.Rele_5.setChecked(false);
            }

            if (SalDig.substring(5, 6).equals("1")) {
                ac.Rele_6.setChecked(true);
            } else {
                ac.Relay_6.setChecked(false);
            }


            if (SalDig.substring(6, 7).equals("1")) {
                ac.Rele_7.setChecked(true);
            } else {
                ac.Relay_7.setChecked(false);
            }
        }
    }


    private String Escalas(String Unidad,String esc,int valor){
        String salida="0000";
        float resultado=0;
        switch (Unidad){

            case "P":
              switch (esc){
                  case "1":
                      resultado=-10 +20*(float)(valor/1023.00);

                      break;
                  case "2":
                      resultado=(6/(float)1023)*valor;
                      break;
                  case "3":
                      resultado=(20/(float)1023)*valor;
                      break;
                  default:break ;
              }

                break;
            case "T":
                switch (esc){
                    case "1":
                        resultado=-40 +80*(float)(valor/1023.00);
                        break;
                    case "2":
                        resultado= 100*(float)(valor/1023.00);

                        break;
                    case "3":
                        resultado=20 +780*(float)(valor/1023.00);
                        break;
                    default:break ;
                }

                break;
            case "H":
                switch (esc) {
                    case "1":
                        resultado=100*(float)(valor/1023.00);
                        break;

                   default:break ;
                }
                break;
            case "K":
                switch (esc){
                    case "1":
                        resultado=2*(float)(valor/1023.00);
                        break;
                    case "2":
                        resultado=10*(float)(valor/1023.00);
                        break;
                    case "3":
                        resultado=100*(float)(valor/1023.00);
                        break;
                    default:break ;
                }
                break;

            default:break ;
        }

        salida=Float.toString(resultado);

        return salida;
    }

    private void CargarDato(TextView tv,String valor){

        tv.setText(valor.subSequence(1,valor.length()));

    }

    private void Unidad(TextView tv,String u){

        switch (u){
            case "T":
                tv.setText(" °C");
                break;
            case "P":
                tv.setText(" Bar");
                break;
            case "H":
                tv.setText(" % Hum.");
                break;
            case "K":
                tv.setText(" Kg");
                break;
        }



    }
}


