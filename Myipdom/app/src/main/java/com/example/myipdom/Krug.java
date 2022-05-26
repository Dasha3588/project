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

public class Krug extends AppCompatActivity {

    public double s_krug; //переменная в которую зписывается площадь круга
    private double r, d, l; //переменные в которые зписываются радиус, даметр, длина круга
    private String v; //временная переменная
    public Intent reshenie_krug; //новая активность

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krug);
        //связывание элементов по id
        EditText r_krug = (EditText) findViewById(R.id.r_krug);
        EditText d_krug = (EditText) findViewById(R.id.d_krug);
        EditText l_krug = (EditText) findViewById(R.id.l_krug);
        Button button1 = (Button) findViewById (R.id.button1);
        Button back1 = (Button) findViewById(R.id.back1);
        reshenie_krug = new Intent(Krug.this, Reshenie.class); //создание новой активности
        //обрабатка нажатия на кнопку "вычислитить"
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //если никакие данные не введенны, то появляется всплывающее сообщение
                if(r_krug.getText().toString().isEmpty() && d_krug.getText().toString().isEmpty() && l_krug.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите известные данные", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //иначе поиск данных, по которым можно найти площадь
                else {
                    if (r_krug.getText().toString().isEmpty()) {
                    } else if (d_krug.getText().toString().isEmpty() && l_krug.getText().toString().isEmpty()) {
                        v = r_krug.getText().toString();
                        r = Double.parseDouble(v);
                        krugR(r);
                    }
                    if (d_krug.getText().toString().isEmpty()) {
                    } else if (r_krug.getText().toString().isEmpty() && l_krug.getText().toString().isEmpty()) {
                        v = d_krug.getText().toString();
                        d = Double.parseDouble(v);
                        krugD(d);
                    }
                    if (l_krug.getText().toString().isEmpty()) {
                    } else if (d_krug.getText().toString().isEmpty() && r_krug.getText().toString().isEmpty()) {
                        v = l_krug.getText().toString();
                        l = Double.parseDouble(v);
                        krugL(l);
                    }
                    //если площадь посчитанна
                    if (s_krug>0){
                        //передача данных в другую активность
                        reshenie_krug.putExtra("s_krug", s_krug);
                        //выполнение перехода на новую активность
                        startActivity(reshenie_krug);
                        finish();
                    }
                    //иначе
                    else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Данные введены некорректно", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
        //обработка нажатия на кнопку "назад"
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Krug.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который высчитывает площадь круга, зная радус
    public double krugR (double r){
        s_krug = 3.14*Math.pow(r, 2);
        reshenie_krug.putExtra("r_krug", r);
        return s_krug;
    }
    //метод, который высчитывает площадь круга, зная диаметр
    public double krugD (double d){
        double r=d/2;
        s_krug = 3.14*Math.pow(r, 2);
        reshenie_krug.putExtra("r_krug", r);
        reshenie_krug.putExtra("d_krug", d);
        return s_krug;
    }
    //метод, который высчитывает площадь круга, зная дрину окружности
    public double krugL (double l){
        s_krug = Math.pow(l, 2)/(4*3.14);
        s_krug = s_krug*100;
        s_krug = (int)Math.round(s_krug);
        s_krug = s_krug/100;
        reshenie_krug.putExtra("l_krug", l);
        return s_krug;
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Krug.this);
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