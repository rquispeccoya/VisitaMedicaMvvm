package com.lab04.visitamedicamvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.lab04.visitamedicamvvm.databinding.ActivityFormularioPacienteBinding;
import com.lab04.visitamedicamvvm.databinding.ActivityMainBinding;
import com.lab04.visitamedicamvvm.viewmodels.FormularioPacienteViewModel;

public class FormularioPacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_formulario_paciente);

        ActivityFormularioPacienteBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_formulario_paciente);
        binding.setViewModelFormulario(new FormularioPacienteViewModel(this));

        binding.executePendingBindings();
    }
}