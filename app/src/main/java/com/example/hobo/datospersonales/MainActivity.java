package com.example.hobo.datospersonales;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etNombre, etTelefono, etEmail, etDesc;
    private DatePicker        dpFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre     = (TextInputEditText) findViewById(R.id.etNombre);
        etTelefono   = (TextInputEditText) findViewById(R.id.etTelefono);
        etEmail      = (TextInputEditText) findViewById(R.id.etEmail);
        etDesc       = (TextInputEditText) findViewById(R.id.etDesc);
        dpFecha      = (DatePicker)        findViewById(R.id.dpFecha);

        Bundle extras = getIntent().getExtras();

        if(extras != null)
            llenar(extras);

        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre   = etNombre.getText().toString();
                String telefono = etTelefono.getText().toString();
                String email    = etEmail.getText().toString();
                String desc     = etDesc.getText().toString();
                int    dia      = dpFecha.getDayOfMonth();
                int    mes      = dpFecha.getMonth();
                int    ano      = dpFecha.getYear();

                Intent conf = new Intent(MainActivity.this, ConfirmacionDatos.class);
                conf.putExtra("Nombre", nombre);
                conf.putExtra("Dia", dia);
                conf.putExtra("Mes", mes);
                conf.putExtra("Ano", ano);
                conf.putExtra("Telefono", telefono);
                conf.putExtra("Email", email);
                conf.putExtra("Desc", desc);
                startActivity(conf);
            }
        });
    }

    public void llenar(Bundle extras) {
        final int dia = extras.getInt("Dia");
        final int mes = extras.getInt("Mes");
        final int ano = extras.getInt("Ano");
        final String nombre   = extras.getString("Nombre");
        final String telefono = extras.getString("Telefono");
        final String email    = extras.getString("Email");
        final String desc     = extras.getString("Desc");

        dpFecha.updateDate(ano, mes, dia);
        etNombre.setText(nombre);
        etTelefono.setText(telefono);
        etEmail.setText(email);
        etDesc.setText(desc);
    }
}
