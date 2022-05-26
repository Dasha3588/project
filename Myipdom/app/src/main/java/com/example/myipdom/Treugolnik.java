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

public class Treugolnik extends AppCompatActivity {

    public double s_treugolnik; //переменная в которую зписывается площадь треугольника
    private double a, b, c, h, rR, r, pP, p, y; //переменные в которые зписываются стороны, высота, радиус описанной окружности, радиус вписанной окружности, полупериметр, периметр, угол между сторонами треугольника
    private String v; //временная переменная
    public Intent reshenie_treugolnik; //новая активность
    EditText a_treugolnik, b_treugolnik, c_treugolnik, h_treugolnik, pP_treugolnik, r_treugolnik, rR_treugolnik, y_treugolnik; //EditText для эллементов фигуры

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treugolnik);
        //связывание элементов по id
        a_treugolnik = (EditText) findViewById(R.id.a_treugolnik);
        b_treugolnik = (EditText) findViewById(R.id.b_treugolnik);
        c_treugolnik = (EditText) findViewById(R.id.c_treugolnik);
        h_treugolnik = (EditText) findViewById(R.id.h_treugolnik);
        pP_treugolnik = (EditText) findViewById(R.id.p_treugolnik);
        r_treugolnik = (EditText) findViewById(R.id.r_treugolnik);
        rR_treugolnik = (EditText) findViewById(R.id.R_treugolnik);
        y_treugolnik = (EditText) findViewById(R.id.y_treugolnik);
        Button button5 = (Button) findViewById (R.id.button5);
        Button back5 = (Button) findViewById(R.id.back5);
        reshenie_treugolnik = new Intent(Treugolnik.this, Reshenie.class); //создание новой активности
        //обрабатка нажатия на кнопку "вычислитить" "вычислитить"
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //если никакие данные не введенны, то появляется всплывающее сообщение
                if(a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите известные данные", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //иначе поиск данных, по которым можно найти площадь
                else {
                    if ((a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty()) || h_treugolnik.getText().toString().isEmpty()) {
                    } else if (pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty() && (a_treugolnik.getText().toString().isEmpty() || b_treugolnik.getText().toString().isEmpty() || c_treugolnik.getText().toString().isEmpty())){
                        v = h_treugolnik.getText().toString();
                        h = Double.parseDouble(v);
                        if (a_treugolnik.getText().toString().isEmpty()) {
                            if (b_treugolnik.getText().toString().isEmpty()) {
                                v = c_treugolnik.getText().toString();
                                c = Double.parseDouble(v);
                                treugolnikAH(c,h);
                            } else{
                                v = b_treugolnik.getText().toString();
                                b = Double.parseDouble(v);
                                treugolnikAH(b,h);
                            }
                        } else{
                            v = a_treugolnik.getText().toString();
                            a = Double.parseDouble(v);
                            treugolnikAH(a,h);
                        }
                    }
                    if (r_treugolnik.getText().toString().isEmpty() || pP_treugolnik.getText().toString().isEmpty()) {
                    } else if (h_treugolnik.getText().toString().isEmpty() && a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty()) {
                        v = r_treugolnik.getText().toString();
                        r = Double.parseDouble(v);
                        v = pP_treugolnik.getText().toString();
                        pP = Double.parseDouble(v);
                        treugolnikRP(r,pP);
                    }
                    if (a_treugolnik.getText().toString().isEmpty() || b_treugolnik.getText().toString().isEmpty() || c_treugolnik.getText().toString().isEmpty() || pP_treugolnik.getText().toString().isEmpty()) {
                    } else if (h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                        v = a_treugolnik.getText().toString();
                        a = Double.parseDouble(v);
                        v = b_treugolnik.getText().toString();
                        b = Double.parseDouble(v);
                        v = c_treugolnik.getText().toString();
                        c = Double.parseDouble(v);
                        v = pP_treugolnik.getText().toString();
                        pP = Double.parseDouble(v);
                        treugolnikABCP(a,b,c,pP);
                    }
                    if (a_treugolnik.getText().toString().isEmpty() || b_treugolnik.getText().toString().isEmpty() || c_treugolnik.getText().toString().isEmpty() || rR_treugolnik.getText().toString().isEmpty()) {
                    } else if (h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()) {
                        v = a_treugolnik.getText().toString();
                        a = Double.parseDouble(v);
                        v = b_treugolnik.getText().toString();
                        b = Double.parseDouble(v);
                        v = c_treugolnik.getText().toString();
                        c = Double.parseDouble(v);
                        v = rR_treugolnik.getText().toString();
                        rR = Double.parseDouble(v);
                        treugolnikABCR(a,b,c,rR);
                    }
                    if ((a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty()) || (a_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty()) || (b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty()) || y_treugolnik.getText().toString().isEmpty()) {
                    } else if (h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && ((a_treugolnik.getText().toString().isEmpty() || b_treugolnik.getText().toString().isEmpty()) && (a_treugolnik.getText().toString().isEmpty() || c_treugolnik.getText().toString().isEmpty()) && (b_treugolnik.getText().toString().isEmpty() || c_treugolnik.getText().toString().isEmpty()))) {
                        v = y_treugolnik.getText().toString();
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
                        if (a_treugolnik.getText().toString().isEmpty()) {
                            v = c_treugolnik.getText().toString();
                            c = Double.parseDouble(v);
                            v = b_treugolnik.getText().toString();
                            b = Double.parseDouble(v);
                            treugolnikABY(b,c,y);
                        } else if (c_treugolnik.getText().toString().isEmpty()){
                            v = a_treugolnik.getText().toString();
                            a = Double.parseDouble(v);
                            v = b_treugolnik.getText().toString();
                            b = Double.parseDouble(v);
                            treugolnikABY(a,b,y);
                        } else{
                            v = b_treugolnik.getText().toString();
                            b = Double.parseDouble(v);
                            v = c_treugolnik.getText().toString();
                            c = Double.parseDouble(v);
                            treugolnikABY(a,c,y);
                        }
                    }
                    //если площадь посчитанна
                    if (s_treugolnik>0){
                        //передача данных в другую активность
                        reshenie_treugolnik.putExtra("s_treugolnik", s_treugolnik);
                        //выполнение перехода на новую активность
                        startActivity(reshenie_treugolnik);
                        finish();
                    }
                    //иначе
                    else {
                        if (b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите высоту или сторону и угол между сторонами или стороны и периметр или стороны и радиус описанной окружности", Toast.LENGTH_LONG);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите высоту или сторону и угол между сторонами или стороны и периметр или стороны и радиус описанной окружности", Toast.LENGTH_LONG);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите высоту или сторону и угол между сторонами или стороны и периметр или стороны и радиус описанной окружности", Toast.LENGTH_LONG);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty()  && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите две стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите периметр", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны или радиус вписанной окружности", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите угол между сторонами или стороны и периметр или стороны и радиус описанной окружности", Toast.LENGTH_LONG);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите угол между сторонами или стороны и периметр или стороны и радиус описанной окружности", Toast.LENGTH_LONG);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите угол между сторонами или стороны и периметр или стороны и радиус описанной окружности", Toast.LENGTH_LONG);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите радиус описанной окружности или периметр", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите стороны", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (b_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (a_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
                            toast.show(); //всплывающие сообщение о том, каких данных не хватает
                            setCollor(); //установка цвета недостающим данным
                        } else if (c_treugolnik.getText().toString().isEmpty() && h_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
                            Toast toast = Toast.makeText(getApplicationContext(), "Введите сторону", Toast.LENGTH_SHORT);
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
        back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Treugolnik.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который высчитывает площадь треугольника, зная сторону и ввысоту
    public double treugolnikAH (double a, double h){
        reshenie_treugolnik.putExtra("a_treugolnik", a);
        reshenie_treugolnik.putExtra("h_treugolnik", h);
        s_treugolnik = a*h/2;
        return s_treugolnik;
    }
    //метод, который высчитывает площадь треугольника, зная две стороны и угол между ними
    public double treugolnikABY (double a, double b, double y){
        s_treugolnik = a*b*y/2;
        reshenie_treugolnik.putExtra("a_treugolnik", a);
        reshenie_treugolnik.putExtra("b_treugolnik", b);
        reshenie_treugolnik.putExtra("y_treugolnik", y);
        return s_treugolnik;
    }
    //метод, который высчитывает площадь треугольника, зная три стороны и полупериметр
    public double treugolnikABCP (double a, double b, double c, double pP){
        if (pP==a+b+c) {
            p = pP / 2;
            s_treugolnik = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            s_treugolnik = s_treugolnik*100;
            s_treugolnik = (int)Math.round(s_treugolnik);
            s_treugolnik = s_treugolnik/100;
            reshenie_treugolnik.putExtra("a_treugolnik", a);
            reshenie_treugolnik.putExtra("b_treugolnik", b);
            reshenie_treugolnik.putExtra("c_treugolnik", c);
            reshenie_treugolnik.putExtra("p_treugolnik", p);
            reshenie_treugolnik.putExtra("pP_treugolnik", pP);
        }
        return s_treugolnik;
    }
    //метод, который высчитывает площадь треугольника, зная радиус вписанной окружности и полупериметр
    public double treugolnikRP (double r, double pP){
        p = pP/2;
        s_treugolnik = r*p;
        reshenie_treugolnik.putExtra("r_treugolnik", r);
        reshenie_treugolnik.putExtra("p_treugolnik", p);
        reshenie_treugolnik.putExtra("pP_treugolnik", pP);
        return s_treugolnik;
    }
    //метод, который высчитывает площадь треугольника, зная три стороны и радиус описанной окружности
    public double treugolnikABCR (double a, double b, double c, double rR){
        s_treugolnik = a*b*c/(4*rR);
        reshenie_treugolnik.putExtra("a_treugolnik", a);
        reshenie_treugolnik.putExtra("b_treugolnik", b);
        reshenie_treugolnik.putExtra("c_treugolnik", c);
        reshenie_treugolnik.putExtra("rR_treugolnik", rR);
        return s_treugolnik;
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Treugolnik.this);
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
        if (pP_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty() && (a_treugolnik.getText().toString().isEmpty() || b_treugolnik.getText().toString().isEmpty() || c_treugolnik.getText().toString().isEmpty())){
            a_treugolnik.setHintTextColor(Color.RED);
            h_treugolnik.setHintTextColor(Color.RED);
        }
        if (h_treugolnik.getText().toString().isEmpty() && a_treugolnik.getText().toString().isEmpty() && b_treugolnik.getText().toString().isEmpty() && c_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty()) {
            r_treugolnik.setHintTextColor(Color.RED);
            pP_treugolnik.setHintTextColor(Color.RED);
        }
        if (h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()){
            a_treugolnik.setHintTextColor(Color.RED);
            b_treugolnik.setHintTextColor(Color.RED);
            c_treugolnik.setHintTextColor(Color.RED);
            pP_treugolnik.setHintTextColor(Color.RED);
        }
        if (h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && y_treugolnik.getText().toString().isEmpty()) {
            a_treugolnik.setHintTextColor(Color.RED);
            b_treugolnik.setHintTextColor(Color.RED);
            c_treugolnik.setHintTextColor(Color.RED);
            rR_treugolnik.setHintTextColor(Color.RED);
        }
        if (h_treugolnik.getText().toString().isEmpty() && r_treugolnik.getText().toString().isEmpty() && pP_treugolnik.getText().toString().isEmpty() && rR_treugolnik.getText().toString().isEmpty() && ((a_treugolnik.getText().toString().isEmpty() || b_treugolnik.getText().toString().isEmpty()) && (a_treugolnik.getText().toString().isEmpty() || c_treugolnik.getText().toString().isEmpty()) && (b_treugolnik.getText().toString().isEmpty() || c_treugolnik.getText().toString().isEmpty()))) {
            a_treugolnik.setHintTextColor(Color.RED);
            b_treugolnik.setHintTextColor(Color.RED);
            y_treugolnik.setHintTextColor(Color.RED);
        }
    }
}