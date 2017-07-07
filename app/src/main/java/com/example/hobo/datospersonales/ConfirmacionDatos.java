package com.example.hobo.datospersonales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDesc;

        tvNombre   = (TextView) findViewById(R.id.tvNombre);
        tvFecha    = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail    = (TextView) findViewById(R.id.tvEmail);
        tvDesc     = (TextView) findViewById(R.id.tvDesc);

        Button btnEditar = (Button) findViewById(R.id.btnEditar);

        final Bundle extras = getIntent().getExtras();

        final int dia = extras.getInt("Dia");
        final int mes = extras.getInt("Mes");
        final int ano = extras.getInt("Ano");
        final String nombre   = extras.getString("Nombre");
        final String fecha    = String.valueOf(dia) + " - " + String.valueOf(mes) + " - " + String.valueOf(ano);
        final String telefono = extras.getString("Telefono");
        final String email    = extras.getString("Email");
        final String desc     = extras.getString("Desc");

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(desc);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editar = new Intent(ConfirmacionDatos.this, MainActivity.class);
                editar.putExtra("Nombre", nombre);
                editar.putExtra("Dia", dia);
                editar.putExtra("Mes", mes);
                editar.putExtra("Ano", ano);
                editar.putExtra("Telefono", telefono);
                editar.putExtra("Email", email);
                editar.putExtra("Desc", desc);
                startActivity(editar);
            }
        });
    }

}
