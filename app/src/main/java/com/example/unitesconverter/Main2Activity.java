package com.example.unitesconverter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText unidad;
    TextView resul;
    Button Calcular;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int c;

    @Override
    protected void onDestroy() {


        String g = unidad.getText().toString();
        editor.putString("unidad",g);
        editor.commit();
        super.onDestroy();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedPreferences = getSharedPreferences("dato", Context.MODE_PRIVATE);
        String huin=sharedPreferences.getString("unidad","NoSeLogroEncontrar");

        if(!huin.equals("NoSeLogroEncontrar"))
        {
            unidad.setText("");
        }
        else
        {
            unidad.setText(huin);
        }

        c=0;
        String valor = getIntent().getStringExtra("Titulo");
        this.setTitle(valor);
        final String ope = getIntent().getStringExtra("Operacion");


        unidad=findViewById(R.id.Un);
        Calcular = findViewById(R.id.btn9);
        resul=findViewById(R.id.txtVer);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    double dato = Double.valueOf(unidad.getText().toString());
                    double res;
                    String yolo;
                    switch (ope) {
                        case "1":
                            res = (dato * 9 / 5) + 32;
                            yolo = String.valueOf(res);
                            resul.setText(yolo + "°F");
                            break;
                        case "2":
                            res = (dato - 32) * 5 / 9;
                            yolo = String.valueOf(res);
                            resul.setText(yolo + "°C");
                            break;
                        case "3":
                            res = dato + 273.15;
                            yolo = String.valueOf(res);
                            resul.setText(yolo + "°K");
                            break;
                        case "4":
                            res = dato - 273.15;
                            yolo = String.valueOf(res);
                            resul.setText(yolo + "°C");
                            break;
                        case "5":
                            res = dato *100;
                            yolo = String.valueOf(res);
                            resul.setText(yolo + "cm");
                            break;
                        case "6":
                            res = dato/100;
                            yolo = String.valueOf(res);
                            resul.setText(yolo + "m");
                            break;
                        case "7":
                            res = dato/2.54;
                            yolo = String.valueOf(res);
                            resul.setText(yolo + "plg");
                            break;
                        case "8":
                            res = dato*2.54;
                            yolo = String.valueOf(res);
                            resul.setText(yolo + "cm");
                            break;

                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Ingrese un dato correcto"+e.getMessage(),Toast.LENGTH_LONG).show();
                }




            }
        });
    }
}
