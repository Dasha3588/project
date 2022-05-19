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

public class RezhimStroitelstva extends AppCompatActivity {

    public double s_rezhim_stroitelstva; //переменная в которую зписывается площадь
    private double awall, hwall, swall, awindow, hwindow, swindow, k; //переменные в которые зписываются  ширина стены, высота стены, плоадь станы, ширина окна, высота окна, площадь окна, количество окон
    private String v; //временная переменная
    public Intent reshenie_rezhim_stroitelstva; //новая активность

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezhim_stroitelstva);
        //связывание элементов по id
        EditText a_wall = (EditText) findViewById(R.id.a_wall);
        EditText h_wall = (EditText) findViewById(R.id.h_wall);
        EditText s_wall = (EditText) findViewById(R.id.s_wall);
        EditText a_window = (EditText) findViewById(R.id.a_window);
        EditText h_window = (EditText) findViewById(R.id.h_window);
        EditText s_window = (EditText) findViewById(R.id.s_window);
        EditText k_window = (EditText) findViewById(R.id.k_window);
        Button back8 = (Button) findViewById(R.id.back8);
        Button button8 = (Button) findViewById (R.id.button8);
        reshenie_rezhim_stroitelstva = new Intent(RezhimStroitelstva.this, Reshenie.class); //создание новой активности
        //обрабатка нажатия на кнопку "вычислитить"
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //если никакие данные не введенны, то появляется всплывающее сообщение
                if(a_wall.getText().toString().isEmpty() && h_wall.getText().toString().isEmpty() && s_wall.getText().toString().isEmpty() && a_window.getText().toString().isEmpty() && h_window.getText().toString().isEmpty() && s_window.getText().toString().isEmpty() && k_window.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите известные данные", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //иначе поиск данных, по которым можно найти площадь
                else {
                    if (a_wall.getText().toString().isEmpty() || h_wall.getText().toString().isEmpty() || a_window.getText().toString().isEmpty() || h_window.getText().toString().isEmpty() || k_window.getText().toString().isEmpty()) {
                    } else {
                        v = a_wall.getText().toString();
                        awall = Double.parseDouble(v);
                        v = h_wall.getText().toString();
                        hwall = Double.parseDouble(v);
                        v = a_window.getText().toString();
                        awindow = Double.parseDouble(v);
                        v = h_window.getText().toString();
                        hwindow = Double.parseDouble(v);
                        v = k_window.getText().toString();
                        k = Double.parseDouble(v);
                        rezhimStroitelstvaAHAHK(awall, hwall, awindow, hwindow, k);
                    }
                    if (s_wall.getText().toString().isEmpty() || a_window.getText().toString().isEmpty() || h_window.getText().toString().isEmpty() || k_window.getText().toString().isEmpty()) {
                    } else {
                        v = s_wall.getText().toString();
                        swall = Double.parseDouble(v);
                        v = a_window.getText().toString();
                        awindow = Double.parseDouble(v);
                        v = h_window.getText().toString();
                        hwindow = Double.parseDouble(v);
                        v = k_window.getText().toString();
                        k = Double.parseDouble(v);
                        rezhimStroitelstvaSAHK(awall,awindow,hwindow,k);
                    }
                    if (s_wall.getText().toString().isEmpty() || s_window.getText().toString().isEmpty() || k_window.getText().toString().isEmpty()) {
                    } else {
                        v = s_wall.getText().toString();
                        swall = Double.parseDouble(v);
                        v = s_window.getText().toString();
                        swindow = Double.parseDouble(v);
                        v = k_window.getText().toString();
                        k = Double.parseDouble(v);
                        rezhimStroitelstvaSSK(swall,swindow,k);
                    }
                    if (a_wall.getText().toString().isEmpty() || h_wall.getText().toString().isEmpty() || s_window.getText().toString().isEmpty() || k_window.getText().toString().isEmpty()) {
                    } else {
                        v = a_wall.getText().toString();
                        awall = Double.parseDouble(v);
                        v = h_wall.getText().toString();
                        hwall = Double.parseDouble(v);
                        v = s_window.getText().toString();
                        swindow = Double.parseDouble(v);
                        v = k_window.getText().toString();
                        k = Double.parseDouble(v);
                        rezhimStroitelstvaAHSK(awall,hwall,swindow,k);
                    }
                    if (s_rezhim_stroitelstva!=0){
                        //передача данных в другую активность
                        reshenie_rezhim_stroitelstva.putExtra("s_rezhim_stroitelstva", s_rezhim_stroitelstva);
                        //выполнение перехода на новую активность
                        startActivity(reshenie_rezhim_stroitelstva);
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
        back8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RezhimStroitelstva.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который высчитывает площадь, зная ширину стены, высоту стены, ширину окна, высоту окна, количество окон
    public double rezhimStroitelstvaAHAHK (double awall, double hwall, double awindow, double hwindow, double k){
        if(awall>awindow && hwall>hwindow && awall*hwall-awindow*hwindow*k>0) {
            s_rezhim_stroitelstva = awall*hwall-awindow*hwindow*k;
            reshenie_rezhim_stroitelstva.putExtra("swall_rezhim_stroitelstva", awall*hwall);
            reshenie_rezhim_stroitelstva.putExtra("swindow_rezhim_stroitelstva", awindow*hwindow);
        }
        return s_rezhim_stroitelstva;
    }
    //метод, который высчитывает площадь, зная площадь стены, площадь окна, количество окон
    public double rezhimStroitelstvaSSK (double swall, double swindow, double k){
        if(swall>swindow && swall-swindow*k>0) {
            s_rezhim_stroitelstva = swall-swindow*k;
            reshenie_rezhim_stroitelstva.putExtra("swall_rezhim_stroitelstva", swall);
            reshenie_rezhim_stroitelstva.putExtra("swindow_rezhim_stroitelstva", swindow);
        }
        return s_rezhim_stroitelstva;
    }
    //метод, который высчитывает площадь, зная ширину стены, высоту стены, площадь окна, количество окон
    public double rezhimStroitelstvaAHSK (double awall, double hwall, double swindow, double k){
        if(awall*hwall>swindow && awall*hwall-swindow*k>0) {
            s_rezhim_stroitelstva = awall*hwall-swindow*k;
            reshenie_rezhim_stroitelstva.putExtra("swall_rezhim_stroitelstva", awall*hwall);
            reshenie_rezhim_stroitelstva.putExtra("swindow_rezhim_stroitelstva", swindow);
        }
        return s_rezhim_stroitelstva;
    }
    //метод, который высчитывает площадь, зная площадь стены, ширину окна, высоту окна, количество окон
    public double rezhimStroitelstvaSAHK (double swall, double awindow, double hwindow, double k){
        if(swall>awindow*hwindow && swall-awindow*hwindow*k>0) {
            s_rezhim_stroitelstva = swall-awindow*hwindow*k;
            reshenie_rezhim_stroitelstva.putExtra("swall_rezhim_stroitelstva", swall);
            reshenie_rezhim_stroitelstva.putExtra("swindow_rezhim_stroitelstva", awindow*hwindow);
        }
        return s_rezhim_stroitelstva;
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(RezhimStroitelstva.this);
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