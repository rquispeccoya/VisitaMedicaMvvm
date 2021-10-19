package com.lab04.visitamedicamvvm.viewmodels;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
//import androidx.databinding.library.baseAdapters.BR;
import androidx.databinding.Bindable;
import com.lab04.visitamedicamvvm.ConexionSQLite;
import com.lab04.visitamedicamvvm.FormularioPacienteActivity;
import com.lab04.visitamedicamvvm.MenuPrincipalActivity;
import com.lab04.visitamedicamvvm.model.Paciente;

public class FormularioPacienteViewModel extends BaseObservable {

    private Paciente paciente;
    private Context context;

    public  FormularioPacienteViewModel (Context context){
        paciente = new Paciente();
        this.context= context;
    }

    public void setPacienteNombres(String nombres){
        paciente.setNombre(nombres);
    }

    public void setPacienteEmail(String email){
        paciente.setEmail(email);
    }

    public void setPacienteDni(String dni){
        paciente.setDni(dni);
    }


    @Bindable
    public String getPacienteNombres(){
        return  paciente.getNombre();
    }
    @Bindable
    public  String getPacienteEmail(){
        return paciente.getEmail();
    }
    @Bindable
    public  String getPacienteDni(){
        return paciente.getDni();
    }

    public void onClickRegistrar(){

        ConexionSQLite conn = new ConexionSQLite(context.getApplicationContext(), "bd_Consultorio", null, 1, null);
        SQLiteDatabase db = conn.getWritableDatabase();
        Intent intent= new Intent(context, MenuPrincipalActivity.class);
        ContentValues values = new ContentValues();
        values.put("PacDni",Integer.parseInt(paciente.getDni()));
        values.put("PacNom", paciente.getNombre());
        values.put("PacEma", paciente.getEmail());

        Long idResultante = db.insert("pacientes", "PacDni", values);
        Toast.makeText(context.getApplicationContext(), "!!!  REGISTRADO  !!! " , Toast.LENGTH_SHORT).show();
        db.close();

        context.startActivity(intent);

    }

}
