package com.example.myipdom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pryamougolnik extends AppCompatActivity {

    public double s_pryamougolnik; //переменная в которую зписывается площадь прямоугольника
    private double a, b, d, p, e; //переменные в которые зписываются стороны, диагональ, периметр, угол между диагоналями прямоугольника
    private String v; //временная переменная
    public Intent reshenie_pryamougolnik; //новая активность

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pryamougolnik);
        //связывание элементов по id
        EditText a_pryamougolnik = (EditText) findViewById(R.id.a_pryamougolnik);
        EditText b_pryamougolnik = (EditText) findViewById(R.id.b_pryamougolnik);
        EditText d_pryamougolnik = (EditText) findViewById(R.id.d_pryamougolnik);
        EditText p_pryamougolnik = (EditText) findViewById(R.id.p_pryamougolnik);
        EditText e_pryamougolnik = (EditText) findViewById(R.id.e_pryamougolnik);
        Button button2 = (Button) findViewById (R.id.button2);
        Button back2 = (Button) findViewById(R.id.back2);
        reshenie_pryamougolnik = new Intent(Pryamougolnik.this, Reshenie.class); //создание новой активности
        //обрабатка нажатия на кнопку "вычислитить"
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //если никакие данные не введенны, то появляется всплывающее сообщение
                if(a_pryamougolnik.getText().toString().isEmpty() && b_pryamougolnik.getText().toString().isEmpty() && d_pryamougolnik.getText().toString().isEmpty() && p_pryamougolnik.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите известные данные", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //иначе поиск данных, по которым можно найти площадь
                else {
                    if (a_pryamougolnik.getText().toString().isEmpty() || b_pryamougolnik.getText().toString().isEmpty()) {
                    } else if (d_pryamougolnik.getText().toString().isEmpty() && p_pryamougolnik.getText().toString().isEmpty() && e_pryamougolnik.getText().toString().isEmpty()) {
                        v = a_pryamougolnik.getText().toString();
                        a = Double.parseDouble(v);
                        v = b_pryamougolnik.getText().toString();
                        b = Double.parseDouble(v);
                        pryamougolnilAB(a, b);
                    }
                    if (d_pryamougolnik.getText().toString().isEmpty() || e_pryamougolnik.getText().toString().isEmpty()) {
                    } else if (a_pryamougolnik.getText().toString().isEmpty() && p_pryamougolnik.getText().toString().isEmpty() && b_pryamougolnik.getText().toString().isEmpty()) {
                        v = d_pryamougolnik.getText().toString();
                        d = Double.parseDouble(v);
                        v = e_pryamougolnik.getText().toString();
                        e = Double.parseDouble(v);
                        if (e == 30) {
                            e = 0.5;
                        } else if (e == 45) {
                            e = (Math.sqrt(2))/2;
                            e = e*100;
                            e = (int)Math.round(e);
                            e = e/100;
                        } else if (e == 60) {
                            e = (Math.sqrt(3))/2;
                            e = e*100;
                            e = (int)Math.round(e);
                            e = e/100;
                        } else {
                            e = 0;
                        }
                        pryamougolnilDE(d, e);
                    }
                    if (p_pryamougolnik.getText().toString().isEmpty() || (a_pryamougolnik.getText().toString().isEmpty() && b_pryamougolnik.getText().toString().isEmpty())) {
                    } else if (e_pryamougolnik.getText().toString().isEmpty() && d_pryamougolnik.getText().toString().isEmpty() && (a_pryamougolnik.getText().toString().isEmpty() || b_pryamougolnik.getText().toString().isEmpty())) {
                        v = p_pryamougolnik.getText().toString();
                        p = Double.parseDouble(v);
                        if (a_pryamougolnik.getText().toString().isEmpty()) {
                            v = b_pryamougolnik.getText().toString();
                            b = Double.parseDouble(v);
                            pryamougolnilPA(p, b);
                        } else {
                            v = a_pryamougolnik.getText().toString();
                            a = Double.parseDouble(v);
                            pryamougolnilPA(p, a);
                        }
                    }
                    if (s_pryamougolnik!=0){
                        //передача данных в другую активность
                        reshenie_pryamougolnik.putExtra("s_pryamougolnik", s_pryamougolnik);
                        //выполнение перехода на новую активность
                        startActivity(reshenie_pryamougolnik);
                        finish();
                    }
                    else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Данные введены некорректно", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
        //обработка нажатия на кнопку "назад"
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pryamougolnik.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который высчитывает площадь прямоугольника, зная две стороны
    public double pryamougolnilAB (double a, double b){
        s_pryamougolnik = a*b;
        reshenie_pryamougolnik.putExtra("a_pryamougolnik", a);
        reshenie_pryamougolnik.putExtra("b_pryamougolnik", b);
        return s_pryamougolnik;
    }
    //метод, который высчитывает площадь прямоугольника, зная диагональ и угол между диагоналями
    public double pryamougolnilDE (double d, double e){
        s_pryamougolnik = Math.pow(d, 2)/2*e;
        reshenie_pryamougolnik.putExtra("d_pryamougolnik", d);
        reshenie_pryamougolnik.putExtra("e_pryamougolnik", e);
        return s_pryamougolnik;
    }
    //метод, который высчитывает площадь прямоугольника, зная периметр и сторону
    public double pryamougolnilPA (double p, double a){
        double b=(p-2*a)/2;
        if (b>0) {
            s_pryamougolnik = a * b;
            reshenie_pryamougolnik.putExtra("p_pryamougolnik", p);
            reshenie_pryamougolnik.putExtra("a_pryamougolnik", a);
            reshenie_pryamougolnik.putExtra("b_pryamougolnik", b);
        }
        return s_pryamougolnik;
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Pryamougolnik.this);
        quitDialog.setTitle("Вы уверены, что хотите выйти?");
        quitDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        quitDialog.show();
    }
}
