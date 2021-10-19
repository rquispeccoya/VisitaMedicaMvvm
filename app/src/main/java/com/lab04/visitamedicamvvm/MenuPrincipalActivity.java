package com.lab04.visitamedicamvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import com.lab04.visitamedicamvvm.databinding.ActivityMainBinding;
import com.lab04.visitamedicamvvm.viewmodels.MenuPrincipalViewModel;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModelMenuPrincipal(new MenuPrincipalViewModel(this));
        activityMainBinding.executePendingBindings();
    }
}