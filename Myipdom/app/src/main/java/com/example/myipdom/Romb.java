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

public class Romb extends AppCompatActivity {

    public double s_romb; //переменная в которую зписывается площадь ромба
    private double a, h, d1, d2, p, y; //переменные в которые зписываются сторона, высота, диагонали, периметр, угол между диагоналями ромба
    private String v; //временная переменная
    Intent reshenie_romb; //новая активность

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romb);
        //связывание элементов по id
        EditText a_romb = (EditText) findViewById(R.id.a_romb);
        EditText  h_romb = (EditText) findViewById(R.id.h_romb);
        EditText  d1_romb = (EditText) findViewById(R.id.d1_romb);
        EditText  d2_romb = (EditText) findViewById(R.id.d2_romb);
        EditText  p_romb = (EditText) findViewById(R.id.p_romb);
        EditText  y_romb = (EditText) findViewById(R.id.y_romb);
        Button button4 = (Button) findViewById (R.id.button4);
        Button back4 = (Button) findViewById(R.id.back4);
        reshenie_romb = new Intent(Romb.this, Reshenie.class); //создание новой активности
        //обрабатка нажатия на кнопку "вычислитить"
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //если никакие данные не введенны, то появляется всплывающее сообщение
                if(a_romb.getText().toString().isEmpty() && h_romb.getText().toString().isEmpty() && d1_romb.getText().toString().isEmpty() && d2_romb.getText().toString().isEmpty() && p_romb.getText().toString().isEmpty() && y_romb.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите известные данные", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //иначе поиск данных, по которым можно найти площадь
                else {
                    if (a_romb.getText().toString().isEmpty() || h_romb.getText().toString().isEmpty()){
                    } else if (d1_romb.getText().toString().isEmpty() && d2_romb.getText().toString().isEmpty() && p_romb.getText().toString().isEmpty() && y_romb.getText().toString().isEmpty()){
                        v = a_romb.getText().toString();
                        a = Double.parseDouble(v);
                        v = h_romb.getText().toString();
                        h = Double.parseDouble(v);
                        rombAH(a,h);
                    }
                    if (a_romb.getText().toString().isEmpty() || y_romb.getText().toString().isEmpty()){
                    } else if (d1_romb.getText().toString().isEmpty() && d2_romb.getText().toString().isEmpty() && p_romb.getText().toString().isEmpty() && h_romb.getText().toString().isEmpty()){
                        v = a_romb.getText().toString();
                        a = Double.parseDouble(v);
                        v = y_romb.getText().toString();
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
                        rombAY(a,y);
                    }
                    if (d1_romb.getText().toString().isEmpty() || d1_romb.getText().toString().isEmpty()){
                    } else if (a_romb.getText().toString().isEmpty() && h_romb.getText().toString().isEmpty() && p_romb.getText().toString().isEmpty() && y_romb.getText().toString().isEmpty()){
                        v = d1_romb.getText().toString();
                        d1 = Double.parseDouble(v);
                        v = d2_romb.getText().toString();
                        d2 = Double.parseDouble(v);
                        rombD1D2(d1,d2);
                    }
                    if (p_romb.getText().toString().isEmpty() || h_romb.getText().toString().isEmpty()){
                    } else if (d1_romb.getText().toString().isEmpty() && d2_romb.getText().toString().isEmpty() && a_romb.getText().toString().isEmpty() && y_romb.getText().toString().isEmpty()){
                        v = p_romb.getText().toString();
                        p = Double.parseDouble(v);
                        v = h_romb.getText().toString();
                        h = Double.parseDouble(v);
                        rombPH(p,h);
                    }
                    if (p_romb.getText().toString().isEmpty() || y_romb.getText().toString().isEmpty()){
                    } else if (d1_romb.getText().toString().isEmpty() && d2_romb.getText().toString().isEmpty() && a_romb.getText().toString().isEmpty() && h_romb.getText().toString().isEmpty()){
                        v = p_romb.getText().toString();
                        p = Double.parseDouble(v);
                        v = y_romb.getText().toString();
                        y = Double.parseDouble(v);
                        if (y==30){
                            y=0.5;
                        }else if(y==45){
                            y=(Math.sqrt(2))/2;

                        } else if(y==60){
                            y=(Math.sqrt(3))/2;

                        } else {
                            y=0;
                        }
                        rombPY(p,y);
                    }
                    if (s_romb!=0){
                        //передача данных в другую активность
                        reshenie_romb.putExtra("s_romb", s_romb);
                        //выполнение перехода на новую активность
                        startActivity(reshenie_romb);
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
        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Romb.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который высчитывает площадь ромба, зная сторону и высоту
    public double rombAH (double a, double h){
        s_romb = a*h;
        reshenie_romb.putExtra("a_romb", a);
        reshenie_romb.putExtra("h_romb", h);
        return s_romb;
    }
    //метод, который высчитывает площадь ромба, зная диагонали
    public double rombD1D2 (double d1, double d2){
        s_romb = d1*d2/2;
        reshenie_romb.putExtra("d1_romb", d1);
        reshenie_romb.putExtra("d2_romb", d2);
        return s_romb;
    }
    //метод, который высчитывает площадь ромба, зная периметр и высоту
    public double rombPH (double p, double h){
        double a = p/4;
        s_romb = a*h;
        reshenie_romb.putExtra("p_romb", p);
        reshenie_romb.putExtra("a_romb", a);
        reshenie_romb.putExtra("h_romb", h);
        return s_romb;
    }
    //метод, который высчитывает площадь ромба, зная сторону и угол между сторонами
    public double rombAY (double a, double y){
        s_romb = Math.pow(a, 2)*y;
        reshenie_romb.putExtra("a_romb", a);
        reshenie_romb.putExtra("y_romb", y);
        return s_romb;
    }
    //метод, который высчитывает площадь ромба, зная периметр и угол между сторонами
    public double rombPY (double p, double y){
        double a = p/4;
        s_romb = Math.pow(a, 2)*y;
        reshenie_romb.putExtra("p_romb", p);
        reshenie_romb.putExtra("a_romb", a);
        reshenie_romb.putExtra("y_romb", y);
        return s_romb;
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Romb.this);
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