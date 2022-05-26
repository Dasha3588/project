package com.example.myipdom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Parallelogramm extends AppCompatActivity {

    public double s_parallelogramm; //переменная в которую зписывается площадь параллелограмма
    private double a, b, h, d1, d2, e, y; //переменные в которые зписываются стороны, высота, диагонали, угол между диагоналями, угол между сторонами параллелограмма
    private String v; //временная переменная
    public Intent reshenie_parallelogramm; //новая активность
    EditText a_parallelogramm, b_parallelogramm, h_parallelogramm, d1_parallelogramm, d2_parallelogramm, e_parallelogramm, y_parallelogramm; //EditText для эллементов фигуры

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallelogramm);
        //связывание элементов по id
        a_parallelogramm = (EditText) findViewById(R.id.a_parallelogramm);
        b_parallelogramm = (EditText) findViewById(R.id.b_parallelogramm);
        h_parallelogramm = (EditText) findViewById(R.id.h_parallelogramm);
        d1_parallelogramm = (EditText) findViewById(R.id.d1_parallelogramm);
        d2_parallelogramm = (EditText) findViewById(R.id.d2_parallelogramm);
        e_parallelogramm = (EditText) findViewById(R.id.e_parallelogramm);
        y_parallelogramm = (EditText) findViewById(R.id.y_parallelogramm);
        Button button3 = (Button) findViewById (R.id.button3);
        Button back3 = (Button) findViewById(R.id.back3);
        reshenie_parallelogramm = new Intent(Parallelogramm.this, Reshenie.class); //создание новой активности
        //обрабатка нажатия на кнопку "вычислитить"
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //если никакие данные не введенны, то появляется всплывающее сообщение
                if(a_parallelogramm.getText().toString().isEmpty() && b_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите известные данные", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //иначе поиск данных, по которым можно найти площадь
                else {
                    if ((a_parallelogramm.getText().toString().isEmpty() && b_parallelogramm.getText().toString().isEmpty()) || h_parallelogramm.getText().toString().isEmpty()) {
                    } else if ((a_parallelogramm.getText().toString().isEmpty() || b_parallelogramm.getText().toString().isEmpty()) && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()) {
                        v = h_parallelogramm.getText().toString();
                        h = Double.parseDouble(v);
                        if (a_parallelogramm.getText().toString().isEmpty()) {
                            v = b_parallelogramm.getText().toString();
                            b = Double.parseDouble(v);
                            parallelogrammAH(b,h);
                        } else{
                            v = a_parallelogramm.getText().toString();
                            a = Double.parseDouble(v);
                            parallelogrammAH(a,h);
                        }
                    }
                    if (a_parallelogramm.getText().toString().isEmpty() || b_parallelogramm.getText().toString().isEmpty() || y_parallelogramm.getText().toString().isEmpty()) {
                    } else if (h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty()) {
                        v = b_parallelogramm.getText().toString();
                        b = Double.parseDouble(v);
                        v = a_parallelogramm.getText().toString();
                        a = Double.parseDouble(v);
                        v = y_parallelogramm.getText().toString();
                        y = Double.parseDouble(v);
                        if (y==30){
                            y=0.5;
                        }else if(y==45){
                            y=(Math.sqrt(2))/2;
                            y = y*100;
                            y = (int)Math.round(y);
                            y = y/100;
                        } else if(y==60){
                            y=(Math.sqrt(3))/2;
                            y = y*100;
                            y = (int)Math.round(y);
                            y = y/100;
                        } else {
                            y=0;
                        }
                        parallelogrammABY(a,b,y);
                    }
                    if (d1_parallelogramm.getText().toString().isEmpty() || d2_parallelogramm.getText().toString().isEmpty() || e_parallelogramm.getText().toString().isEmpty()) {
                    } else if (h_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty() && b_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()) {
                        v = d1_parallelogramm.getText().toString();
                        d1 = Double.parseDouble(v);
                        v = d2_parallelogramm.getText().toString();
                        d2 = Double.parseDouble(v);
                        v = e_parallelogramm.getText().toString();
                        e = Double.parseDouble(v);
                        if (e==30){
                            e=0.5;
                        }else if(e==45){
                            e=(Math.sqrt(2))/2;
                            e = e*100;
                            e = (int)Math.round(e);
                            e = e/100;
                        } else if(e==60){
                            e=(Math.sqrt(3))/2;
                            e = e*100;
                            e = (int)Math.round(e);
                            e = e/100;
                        } else {
                            e=0;
                        }
                        parallelogrammD1D2E(d1,d2,e);
                    }
                    //если площадь посчитанна
                    if (s_parallelogramm>0){
                        //передача данных в другую активность
                        reshenie_parallelogramm.putExtra("s_parallelogramm", s_parallelogramm);
                        //выполнение перехода на новую активность
                        startActivity(reshenie_parallelogramm);
                        finish();
                    }
                    //иначе
                    else {
                        if (b_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите высоту или сторону и угол между сторонами", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor();
                        } else if (a_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите высоту или сторону и угол между сторонами", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor();
                        } else if (b_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor();
                        } else if (b_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагонали", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагоняль и угол между диагонялями", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагоняль и угол между диагонялями", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите угол между сторонами", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        }  else if (h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && b_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагональ", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагональ", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_parallelogramm.getText().toString().isEmpty() && h_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите угол между диагонялями", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else{
                            Toast toast = Toast.makeText(getApplicationContext(), "Данные введены некорректно", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                }
            }
        });
        //обработка нажатия на кнопку "назад"
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parallelogramm.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который высчитывает площадь параллелограмма, зная сторону и высоту
    public double parallelogrammAH (double a, double h){
        s_parallelogramm = a*h;
        reshenie_parallelogramm.putExtra("a_parallelogramm", a);
        reshenie_parallelogramm.putExtra("h_parallelogramm", h);
        return s_parallelogramm;
    }
    //метод, который высчитывает площадь параллелограмма, зная две стороны и угол между ними
    public double parallelogrammABY  (double a, double b, double y){
        s_parallelogramm = a*b*y;
        reshenie_parallelogramm.putExtra("a_parallelogramm", a);
        reshenie_parallelogramm.putExtra("b_parallelogramm", b);
        reshenie_parallelogramm.putExtra("y_parallelogramm", y);
        return s_parallelogramm;
    }
    //метод, который высчитывает площадь параллелограмма, зная две диагонали и угол между ними
    public double parallelogrammD1D2E (double d1, double d2, double e){
        s_parallelogramm = d1*d2/2*e;
        reshenie_parallelogramm.putExtra("d1_parallelogramm", d1);
        reshenie_parallelogramm.putExtra("d2_parallelogramm", d2);
        reshenie_parallelogramm.putExtra("e_parallelogramm", e);
        return s_parallelogramm;
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Parallelogramm.this);
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
    //метод, который окрашевает недастоющие данные в красный
    private void setCollor(){
        if ((a_parallelogramm.getText().toString().isEmpty() || b_parallelogramm.getText().toString().isEmpty()) && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()){
            a_parallelogramm.setHintTextColor(Color.RED);
            h_parallelogramm.setHintTextColor(Color.RED);
        }
        if (h_parallelogramm.getText().toString().isEmpty() && d1_parallelogramm.getText().toString().isEmpty() && d2_parallelogramm.getText().toString().isEmpty() && e_parallelogramm.getText().toString().isEmpty()) {
            a_parallelogramm.setHintTextColor(Color.RED);
            b_parallelogramm.setHintTextColor(Color.RED);
            y_parallelogramm.setHintTextColor(Color.RED);
        }
        if (h_parallelogramm.getText().toString().isEmpty() && a_parallelogramm.getText().toString().isEmpty() && b_parallelogramm.getText().toString().isEmpty() && y_parallelogramm.getText().toString().isEmpty()) {
            d1_parallelogramm.setHintTextColor(Color.RED);
            d2_parallelogramm.setHintTextColor(Color.RED);
            e_parallelogramm.setHintTextColor(Color.RED);
        }
    }
}