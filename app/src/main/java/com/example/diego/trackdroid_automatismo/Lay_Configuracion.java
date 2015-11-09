package com.example.diego.trackdroid_automatismo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TabHost;

/**
 * Created by diego on 17/08/15.
 */
public class Lay_Configuracion extends Activity {
    EditText edit_A0,edit_A1,edit_A2,edit_A3,edit_A4,edit_A5;
    TabHost th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_configuracion);
        levantarXML();

    }

    private void levantarXML() {
        th= (TabHost) findViewById(R.id.tabHost);
  //      th.setup();
//
        TabHost.TabSpec tab1 = th.newTabSpec("tab1");  //aspectos de cada Tab (pestaña)
        TabHost.TabSpec tab2 = th.newTabSpec("tab2");
        TabHost.TabSpec tab3 = th.newTabSpec("tab3");

        tab1.setIndicator("UNO");    //qué queremos que aparezca en las pestañas
        tab1.setContent(R.id.pesta1); //definimos el id de cada Tab (pestaña)

        tab2.setIndicator("DOS");
        tab2.setContent(R.id.pesta2);

        tab3.setIndicator("TRES");
        tab3.setContent(R.id.pesta3);

        th.addTab(tab1); //añadimos los tabs ya programados
        th.addTab(tab2);
        th.addTab(tab3);

    }


    ///////////////////// PREFERENCIAS DE USUARIO ////////////////
    public void CargarPreferencias(){

        SharedPreferences mispreferencias=getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
      //      edit_A0.setText(mispreferencias.getString("A0", "Sensor 0"));
      //      edit_A1.setText(mispreferencias.getString("A1", "Sensor 1"));
      //      edit_A2.setText(mispreferencias.getString("A2", "Sensor 2"));
      //      edit_A3.setText(mispreferencias.getString("A3", "Sensor 3"));
      //      edit_A4.setText(mispreferencias.getString("A4", "Sensor 4"));
      //      edit_A5.setText(mispreferencias.getString("A5", "Sensor 5"));
    }

    public void GuardarPreferencias() {
        SharedPreferences mispreferencias = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        // editor.putString("A0", edit_A0.getText().toString());
        // editor.putString("A1", edit_A1.getText().toString());
        // editor.putString("A2", edit_A2.getText().toString());
        // editor.putString("A3", edit_A3.getText().toString());
        // editor.putString("A4", edit_A4.getText().toString());
        // editor.putString("A5", edit_A5.getText().toString());
    editor.commit();


    }

}
