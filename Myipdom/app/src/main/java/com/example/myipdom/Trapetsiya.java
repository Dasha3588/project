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

public class Trapetsiya extends AppCompatActivity {

    public double s_trapetsiya; //переменная в которую зписывается площадь трапеции
    private double a, b, h, d1, d2, e, m; //переменные в которые зписываются основания, высота, диагонали, угол между диагоналями, средняя линия трапеции
    private String v; //временная переменная
    public Intent reshenie_trapetsiya; //новая активность
    EditText a_trapetsiya, b_trapetsiya, h_trapetsiya, d1_trapetsiya, d2_trapetsiya, e_trapetsiya, m_trapetsiya; //EditText для эллементов фигуры


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapetsiya);
        //связывание элементов по id
        a_trapetsiya = (EditText) findViewById(R.id.a_trapetsiya);
        b_trapetsiya = (EditText) findViewById(R.id.b_trapetsiya);
        h_trapetsiya = (EditText) findViewById(R.id.h_trapetsiya);
        d1_trapetsiya = (EditText) findViewById(R.id.d1_trapetsiya);
        d2_trapetsiya = (EditText) findViewById(R.id.d2_trapetsiya);
        e_trapetsiya = (EditText) findViewById(R.id.e_trapetsiya);
        m_trapetsiya = (EditText) findViewById(R.id.m_trapetsiya);
        Button button6 = (Button) findViewById (R.id.button6);
        Button back6 = (Button) findViewById(R.id.back6);
        reshenie_trapetsiya = new Intent(Trapetsiya.this, Reshenie.class); //создание новой активности
        //обрабатка нажатия на кнопку "вычислитить"
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //если никакие данные не введенны, то появляется всплывающее сообщение
                if(a_trapetsiya.getText().toString().isEmpty() && b_trapetsiya.getText().toString().isEmpty() && h_trapetsiya.getText().toString().isEmpty() && d1_trapetsiya.getText().toString().isEmpty() && d2_trapetsiya.getText().toString().isEmpty() && e_trapetsiya.getText().toString().isEmpty() && m_trapetsiya.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите известные данные", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //иначе поиск данных, по которым можно найти площадь
                else {
                    if (a_trapetsiya.getText().toString().isEmpty() || b_trapetsiya.getText().toString().isEmpty() || h_trapetsiya.getText().toString().isEmpty()) {
                    } else if (d1_trapetsiya.getText().toString().isEmpty() && d2_trapetsiya.getText().toString().isEmpty() && e_trapetsiya.getText().toString().isEmpty() && m_trapetsiya.getText().toString().isEmpty()) {
                        v = h_trapetsiya.getText().toString();
                        h = Double.parseDouble(v);
                        v = b_trapetsiya.getText().toString();
                        b = Double.parseDouble(v);
                        v = a_trapetsiya.getText().toString();
                        a = Double.parseDouble(v);
                        trapetsiyaABH(a,b,h);
                    }
                    if (h_trapetsiya.getText().toString().isEmpty() || m_trapetsiya.getText().toString().isEmpty()) {
                    } else if (b_trapetsiya.getText().toString().isEmpty() && d1_trapetsiya.getText().toString().isEmpty() && d2_trapetsiya.getText().toString().isEmpty() && a_trapetsiya.getText().toString().isEmpty() && e_trapetsiya.getText().toString().isEmpty()) {
                        v = h_trapetsiya.getText().toString();
                        h = Double.parseDouble(v);
                        v = m_trapetsiya.getText().toString();
                        m = Double.parseDouble(v);
                        trapetsiyaMH(m,h);
                    }
                    if (d1_trapetsiya.getText().toString().isEmpty() || d2_trapetsiya.getText().toString().isEmpty() || e_trapetsiya.getText().toString().isEmpty()) {
                    } else if (h_trapetsiya.getText().toString().isEmpty() && a_trapetsiya.getText().toString().isEmpty() && b_trapetsiya.getText().toString().isEmpty() && m_trapetsiya.getText().toString().isEmpty()) {
                        v = d1_trapetsiya.getText().toString();
                        d1 = Double.parseDouble(v);
                        v = d2_trapetsiya.getText().toString();
                        d2 = Double.parseDouble(v);
                        v = e_trapetsiya.getText().toString();
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
                        trapetsiyaD1D2E(d1,d2,e);
                    }
                    //если площадь посчитанна
                    if (s_trapetsiya>0){
                        //передача данных в другую активность
                        reshenie_trapetsiya.putExtra("s_trapetsiya", s_trapetsiya);
                        //выполнение перехода на новую активность
                        startActivity(reshenie_trapetsiya);
                        finish();
                    }
                    //иначе
                    else {
                        if (b_trapetsiya.getText().toString().isEmpty() &&  h_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону и высоту", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() && h_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону и высоту", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() &&  b_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны или средюю линию", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() &&  b_trapetsiya.getText().toString().isEmpty() &&  h_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите высоту", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() &&  b_trapetsiya.getText().toString().isEmpty() &&  h_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагональ и угол между диагоналями", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() &&  b_trapetsiya.getText().toString().isEmpty() &&  h_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагональ и угол между диагоналями", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() &&  b_trapetsiya.getText().toString().isEmpty() &&  h_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите угол между диагоналями", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() &&  b_trapetsiya.getText().toString().isEmpty() &&  h_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагонали", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() &&  b_trapetsiya.getText().toString().isEmpty() &&  h_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагональ", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_trapetsiya.getText().toString().isEmpty() &&  b_trapetsiya.getText().toString().isEmpty() &&  h_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() && m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите диагональ", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (h_trapetsiya.getText().toString().isEmpty() &&  d1_trapetsiya.getText().toString().isEmpty() &&  d2_trapetsiya.getText().toString().isEmpty() &&  e_trapetsiya.getText().toString().isEmpty() &&  m_trapetsiya.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите высоту", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "Данные введены некорректно", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                }
            }
        });
        //обработка нажатия на кнопку "назад"
        back6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Trapetsiya.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который высчитывает площадь трапеции, зная две стороны и высоту
    public double trapetsiyaABH (double a, double b, double h){
        s_trapetsiya = (a+b)/2*h;
        reshenie_trapetsiya.putExtra("a_trapetsiya", a);
        reshenie_trapetsiya.putExtra("b_trapetsiya", b);
        reshenie_trapetsiya.putExtra("h_trapetsiya", h);
        return s_trapetsiya;
    }
    //метод, который высчитывает площадь трапеции, зная среднюю линию и высоту
    public double trapetsiyaMH (double m, double h){
        s_trapetsiya = h*m;
        reshenie_trapetsiya.putExtra("m_trapetsiya", m);
        reshenie_trapetsiya.putExtra("h_trapetsiya", h);
        return s_trapetsiya;
    }
    //метод, который высчитывает площадь трапеции, зная две диагонали и угол между ними
    public double trapetsiyaD1D2E (double d1, double d2, double e){
        s_trapetsiya = d1*d2/2*e;
        reshenie_trapetsiya.putExtra("d1_trapetsiya", d1);
        reshenie_trapetsiya.putExtra("d2_trapetsiya", d2);
        reshenie_trapetsiya.putExtra("e_trapetsiya", e);
        return s_trapetsiya;
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Trapetsiya.this);
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
        if (d1_trapetsiya.getText().toString().isEmpty() && d2_trapetsiya.getText().toString().isEmpty() && e_trapetsiya.getText().toString().isEmpty() && m_trapetsiya.getText().toString().isEmpty()) {
            a_trapetsiya.setHintTextColor(Color.RED);
            b_trapetsiya.setHintTextColor(Color.RED);
            h_trapetsiya.setHintTextColor(Color.RED);
        }
        if (b_trapetsiya.getText().toString().isEmpty() && d1_trapetsiya.getText().toString().isEmpty() && d2_trapetsiya.getText().toString().isEmpty() && a_trapetsiya.getText().toString().isEmpty() && e_trapetsiya.getText().toString().isEmpty()) {
            h_trapetsiya.setHintTextColor(Color.RED);
            m_trapetsiya.setHintTextColor(Color.RED);
        }
        if (h_trapetsiya.getText().toString().isEmpty() && a_trapetsiya.getText().toString().isEmpty() && b_trapetsiya.getText().toString().isEmpty() && m_trapetsiya.getText().toString().isEmpty()) {
            d1_trapetsiya.setHintTextColor(Color.RED);
            d2_trapetsiya.setHintTextColor(Color.RED);
            e_trapetsiya.setHintTextColor(Color.RED);
        }
    }
}