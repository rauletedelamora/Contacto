package com.raulmora.contactos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    private Contacto contacto;
    private TextInputLayout nombre;
    private TextInputLayout telefono;
    private TextInputLayout email;
    private TextInputLayout descripcion;
    private int dia;
    private int mes;
    private int año;
    DatePicker datePicker;
    Button botonSig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle datos = getIntent().getExtras();
        if(datos!=null){
            cargaDatos();
        }

        datePicker = (DatePicker)findViewById(R.id.datePicker);
        dia = datePicker.getDayOfMonth();
        mes = datePicker.getMonth();
        año = datePicker.getYear();

        nombre = (TextInputLayout)findViewById(R.id.view);
        telefono = (TextInputLayout)findViewById(R.id.telefono);
        email = (TextInputLayout)findViewById(R.id.email);
        descripcion = (TextInputLayout)findViewById(R.id.descripContacto);

        botonSig = (Button)findViewById(R.id.boton_siguiente);

        botonSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ConfirmarDatos.class);
                intent.putExtra("Nombre",nombre.getEditText().getText().toString());
                intent.putExtra("telefono",telefono.getEditText().getText().toString());
                intent.putExtra("email",email.getEditText().getText().toString());
                intent.putExtra("descripcion",descripcion.getEditText().getText().toString());
                intent.putExtra("dia",datePicker.getDayOfMonth());
                intent.putExtra("mes",datePicker.getMonth());
                intent.putExtra("año",datePicker.getYear());
                startActivity(intent);
                finish();
            }
        });
    }

    public void cargaDatos(){
        Bundle parametros = getIntent().getExtras();

            String nombre = parametros.getString("nombre");
            String telefono = parametros.getString("telefono");
            String email = parametros.getString("email");
            String descripcion = parametros.getString("descripcion");
            final int dia = parametros.getInt("dia");
            final int mes = parametros.getInt("mes");
            final int año = parametros.getInt("año");

            final TextInputEditText name = (TextInputEditText)findViewById(R.id.nombreContacto);
            final TextInputEditText tel = (TextInputEditText)findViewById(R.id.num_tel);
            final TextInputEditText mail = (TextInputEditText)findViewById(R.id.email_contacto);
            final TextInputEditText desc = (TextInputEditText)findViewById(R.id.descrip);
            final DatePicker dp = (DatePicker)findViewById(R.id.datePicker);

            name.setText(nombre);
            tel.setText(telefono);
            mail.setText(email);
            desc.setText(descripcion);

            dp.updateDate(año,mes,dia);

        botonSig = (Button)findViewById(R.id.boton_siguiente);

        botonSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra("Nombre", name.getText().toString());
                intent.putExtra("telefono", tel.getText().toString());
                intent.putExtra("email", mail.getText().toString());
                intent.putExtra("descripcion", desc.getText().toString());
                intent.putExtra("dia", dia);
                intent.putExtra("mes", mes);
                intent.putExtra("año", año);
                startActivity(intent);
                finish();
            }
        });

        return;
    }
}
