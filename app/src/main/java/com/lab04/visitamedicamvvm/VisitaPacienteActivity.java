package com.lab04.visitamedicamvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.lab04.visitamedicamvvm.databinding.ActivityVisitaPacienteBinding;
import com.lab04.visitamedicamvvm.viewmodels.VisitaPacienteViewModel;

public class VisitaPacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //     setContentView(R.layout.activity_visita_paciente);

        ActivityVisitaPacienteBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_visita_paciente);
        binding.setViewModelVisita(new VisitaPacienteViewModel(this));

        binding.executePendingBindings();

    }
}