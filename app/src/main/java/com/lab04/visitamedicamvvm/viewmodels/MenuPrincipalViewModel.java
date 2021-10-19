package com.lab04.visitamedicamvvm.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.lab04.visitamedicamvvm.ConexionSQLite;
import com.lab04.visitamedicamvvm.FormularioPacienteActivity;
import com.lab04.visitamedicamvvm.MenuPrincipalActivity;
import com.lab04.visitamedicamvvm.VisitaPacienteActivity;
import com.lab04.visitamedicamvvm.model.Paciente;

public class MenuPrincipalViewModel extends BaseObservable {

    //private Paciente paciente;
    private Context context;

    public MenuPrincipalViewModel(Context context) {
        //paciente = new Paciente();
        this.context = context;

    }

    public void onFormularioPaciente() {

        Intent intent = new Intent(context, FormularioPacienteActivity.class);
        context.startActivity(intent);
    }

    public void onFormularioVisita() {

        Intent intent = new Intent(context, VisitaPacienteActivity.class);
        context.startActivity(intent);
    }

    public String informacionPaciente() {
        String a = "";
        ConexionSQLite conn = new ConexionSQLite(context.getApplicationContext(), "bd_Consultorio", null, 1, null);
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT*FROM pacientes ", null);


        if (!cursor.moveToLast())
            return a;
        else {
            cursor.moveToLast();
            //cursor2.moveToLast();
            a += "DNI: " + cursor.getString(0) + "\n";
            a += "NOMBRE: " + cursor.getString(1) + "\n";
            a += "EMAIL: " + cursor.getString(2) + "\n";
           // return a;
            //Cursor cursor2 = db.rawQuery(" SELECT*FROM visitaMedica WHERE PacDni = ?", new String[]{cursor.getString(0)});
            //Cursor cursor2 = db.rawQuery(" SELECT*FROM visitaMedica ", null);
            //cursor2.moveToLast();
            //a += "PESO: " + cursor2.getInt(2) + "\n";
            //a += "TEMPERATURA: " + cursor2.getInt(3) + "\n";
            //a += "SATURACION: " + cursor2.getInt(4) + "\n";
            //a += "PRESION: " + cursor2.getInt(5) + "\n";

            //return a;
        }

        Cursor cursor2 = db.rawQuery(" SELECT*FROM visitaMedica WHERE PacDni = ?", new String[]{cursor.getString(0)});

        if(!cursor2.moveToLast())
            return a;
        else {
            cursor2.moveToLast();
            a += "PESO: " + cursor2.getInt(2) + "\n";
            a += "TEMPERATURA: " + cursor2.getInt(3) + "\n";
            a += "SATURACION: " + cursor2.getInt(4) + "\n";
            a += "PRESION: " + cursor2.getInt(5) + "\n";
            return a;
        }

    }
}
