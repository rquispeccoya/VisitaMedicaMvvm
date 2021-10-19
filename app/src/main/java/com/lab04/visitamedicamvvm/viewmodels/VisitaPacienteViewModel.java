package com.lab04.visitamedicamvvm.viewmodels;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.lab04.visitamedicamvvm.ConexionSQLite;
import com.lab04.visitamedicamvvm.MenuPrincipalActivity;
import com.lab04.visitamedicamvvm.model.Paciente;
import com.lab04.visitamedicamvvm.model.Visita;

public class VisitaPacienteViewModel extends BaseObservable {

    private Visita visita;
    private Context context;

    /*
    * private String codigo;
    private String dni;
    private String peso;
    private String saturacion;
    private String temperatura;
    private String presion;
    *
    * */

    public  VisitaPacienteViewModel (Context context){
        visita = new Visita();
        this.context= context;
    }

    public void setVisitaCodigo(String codigo){
        visita.setCodigo(codigo);
    }

    public void setVisitaDni(String dni){
        visita.setDni(dni);
    }

    public void setVisitaPeso(String peso){
        visita.setPeso(peso);
    }

    public void setVisitaSaturacion(String saturacion) {
        visita.setSaturacion(saturacion);
    }

    public void setVisitaTemperatura(String temperatura) {
        visita.setTemperatura(temperatura);
    }

    public void setVisitaPresion(String presion){
        visita.setPresion(presion);
    }

    @Bindable
    public String getVisitaCodigo() { return visita.getCodigo(); }
    @Bindable
    public String getVisitaDni() { return visita.getDni(); }
    @Bindable
    public String getVisitaPeso() { return visita.getPeso(); }
    @Bindable
    public String getVisitaSaturacion(){
        return visita.getSaturacion();
    }
    @Bindable
    public String getVisitaTemperatura(){
        return visita.getTemperatura();
    }
    @Bindable
    public String getVisitaPresion() { return visita.getPresion(); }

    public void onClickRegistrar(){

        ConexionSQLite conn = new ConexionSQLite(context.getApplicationContext(), "bd_Consultorio", null, 1, null);
        SQLiteDatabase db = conn.getWritableDatabase();
        Intent intent= new Intent(context, MenuPrincipalActivity.class);
        ContentValues values = new ContentValues();
        values.put("VisMedCod",Integer.parseInt(visita.getCodigo()));
        values.put("PacDni", Integer.parseInt(visita.getDni()));
        values.put("VisMedPes", Integer.parseInt(visita.getPeso()));
        values.put("VisMedTem", Integer.parseInt(visita.getTemperatura()));
        values.put("VisMedSat", Integer.parseInt(visita.getSaturacion()));
        values.put("VisMedPre", Integer.parseInt(visita.getPresion()));

        Long idResultante = db.insert("visitaMedica", "VisMedCod", values);
        Toast.makeText(context.getApplicationContext(), "!!!  REGISTRADO  !!! " , Toast.LENGTH_SHORT).show();
        db.close();

        context.startActivity(intent);

    }


}
