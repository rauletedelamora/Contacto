package com.raulmora.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Button botonEditar;

        Bundle parametros = getIntent().getExtras();
        final String nombre = parametros.getString("Nombre");
        final String telefono = parametros.getString("telefono");
        final String email = parametros.getString("email");
        final String descripcion = parametros.getString("descripcion");
        final int dia = parametros.getInt("dia");
        final int mes = parametros.getInt("mes");
        final int año = parametros.getInt("año");

        TextView tvnombre = (TextView)findViewById(R.id.tvNombre);
        TextView tvtelefono = (TextView)findViewById(R.id.telefono);
        TextView tvemail = (TextView)findViewById(R.id.email);
        TextView tvdescripcion = (TextView)findViewById(R.id.descripcion);
        TextView tvfecha = (TextView)findViewById(R.id.fecha);

        tvnombre.setText(nombre);
        tvtelefono.setText(telefono);
        tvemail.setText(email);
        tvdescripcion.setText(descripcion);
        tvfecha.setText(dia + "/" + mes + "/" + año);

        botonEditar = (Button)findViewById(R.id.btnEditarContacto);

        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("telefono", telefono);
                intent.putExtra("email", email);
                intent.putExtra("descripcion", descripcion);
                intent.putExtra("dia", dia);
                intent.putExtra("mes", mes);
                intent.putExtra("año", año);
                startActivity(intent);
                finish();
            }
        });

    }
}
