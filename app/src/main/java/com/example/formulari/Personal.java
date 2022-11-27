package com.example.formulari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Personal extends AppCompatActivity {
    String nom, cognoms, telefon, mail, adreça;
    private TextView tnom, tcognoms, ttelefon, tmail, tadreça;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        tnom=(TextView) findViewById(R.id.nom);
        tcognoms=(TextView) findViewById(R.id.cognoms);
        ttelefon=(TextView) findViewById(R.id.telefon);
        tmail=(TextView) findViewById(R.id.mail);
        tadreça=(TextView) findViewById(R.id.adreça);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nom = extras.getString("nom");
            cognoms = extras.getString("cognoms");
            telefon = extras.getString("telefon");
            mail = extras.getString("mail");
            adreça = extras.getString("adreça");
        }
        tnom.setText(nom);
        tcognoms.setText(cognoms);
        ttelefon.setText(telefon);
        tmail.setText(mail);
        tadreça.setText(adreça);
    }
}