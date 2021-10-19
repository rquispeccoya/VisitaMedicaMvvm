package com.lab04.visitamedicamvvm;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLite extends  SQLiteOpenHelper{
    public ConexionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pacientes(pacDni INTEGER NOT NULL ,PacNom TEXT NOT NULL ,PacEma TEXT NOT NULL,CONSTRAINT PK_pacientes PRIMARY KEY(pacDni))");
        db.execSQL("create table visitaMedica(VisMedCod INTEGER  NOT NULL ,PacDni INTEGER,VisMedPes INTEGER,VisMedTem INTEGER, VisMedSat INTEGER, VisMedPre INTEGER," +
                "CONSTRAINT PK_visitaMedica PRIMARY KEY(VisMedCod) ,CONSTRAINT Relationship1 FOREIGN KEY (PacDni) REFERENCES pacientes (PacDni))");
       db.execSQL("CREATE INDEX IX_Relationship1 ON visitaMedica (PacDni);");
      //  db.execSQL("CREATE INDEX IX_Relationship3 ON fichaInscripcion (DepCod);");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS pacientes");
        db.execSQL("DROP TABLE IF EXISTS visitaMedica");
        //db.execSQL("DROP TABLE IF EXISTS fichaInscripcion");
        onCreate(db);

    }
}
