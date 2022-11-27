package com.example.formulari;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Formulari extends AppCompatActivity {
    private EditText nom, cognoms, telefon, mail, adreça;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulari);
        nom=(EditText) findViewById(R.id.enom);
        cognoms=(EditText) findViewById(R.id.cognoms);
        telefon=(EditText) findViewById(R.id.telefon);
        mail=(EditText) findViewById(R.id.mail);
        adreça=(EditText) findViewById(R.id.adreça);
    }

    public void validar(View v){
        Intent i = new Intent(Formulari.this, Personal.class);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Protecció de dades..!!!");
        alertDialogBuilder.setIcon(R.drawable.xsdsdafas);
        alertDialogBuilder.setMessage(Html.fromHtml("La" + "<b>" +" protecció de dades"+"</b>" +" personals és el conjunt de tècniques jurídiques i informàtiques encaminades a garantir els drets de les persones sobre el control de la seva " + "<b>" +"informació personal"+"</b>" +" i sobre la confidencialitat, integritat i disponibilitat d'aquesta."));
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Accepto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("cognoms",cognoms.getText().toString());
                i.putExtra("telefon",telefon.getText().toString());
                i.putExtra("mail",mail.getText().toString());
                i.putExtra("adreça",adreça.getText().toString());
                startActivity(i);
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Formulari.this,"No has acceptat la protecció de dades",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Has cancelat",Toast.LENGTH_SHORT).show();
            }
        });
        if(nom.getText().toString().isEmpty()){
            Toast.makeText(this,"nom buit", Toast.LENGTH_LONG).show();
        }else{
            if(cognoms.getText().toString().isEmpty()){
                Toast.makeText(this,"cognoms buit", Toast.LENGTH_LONG).show();
            }else{
                if(telefon.getText().toString().isEmpty()){
                    Toast.makeText(this,"telefon buit", Toast.LENGTH_LONG).show();
                }else{
                    if(mail.getText().toString().isEmpty()){
                        Toast.makeText(this,"mail buit", Toast.LENGTH_LONG).show();
                    }else{
                        if(adreça.getText().toString().isEmpty()){
                            Toast.makeText(this,"adreça buit", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(this,"Formulari complet!", Toast.LENGTH_LONG).show();
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();
                        }
                    }
                }
            }
        }
    }
}