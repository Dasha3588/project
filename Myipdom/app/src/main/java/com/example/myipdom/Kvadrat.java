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

public class Kvadrat extends AppCompatActivity {

    public double s_kvadrat; //переменная в которую зписывается площадь квадрата
    private double a,d,p; //переменные в которые зписываются сторона, диагональ, периметр квадрата
    private String v; //временная переменная
    public Intent reshenie_kvadrat; //новая активность

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kvadrat);
        //связывание элементов по id
        EditText a_kvadrat = (EditText) findViewById(R.id.a_kvadrat);
        EditText  d_kvadrat = (EditText) findViewById(R.id.d_kvadrat);
        EditText  p_kvadrat = (EditText) findViewById(R.id.p_kvadrat);
        Button button = (Button) findViewById (R.id.button);
        Button back0 = (Button) findViewById(R.id.back0);
        reshenie_kvadrat = new Intent(Kvadrat.this, Reshenie.class); //создание новой активности
        //обрабатывание нажатия на кнопку "вычислитить"
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //если никакие данные не введенны, то появляется всплывающее сообщение
                if(a_kvadrat.getText().toString().isEmpty() && d_kvadrat.getText().toString().isEmpty() && p_kvadrat.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите известные данные", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //иначе поиск данных, по которым можно найти площадь
                else {
                    if (a_kvadrat.getText().toString().isEmpty()) {
                    } else if (d_kvadrat.getText().toString().isEmpty() && p_kvadrat.getText().toString().isEmpty()){
                        v = a_kvadrat.getText().toString();
                        a = Double.parseDouble(v);
                        kvadratA(a);
                    }
                    if (d_kvadrat.getText().toString().isEmpty()) {
                    } else if (a_kvadrat.getText().toString().isEmpty() && p_kvadrat.getText().toString().isEmpty()){
                        v = d_kvadrat.getText().toString();
                        d = Double.parseDouble(v);
                        kvadratD(d);
                    }
                    if (p_kvadrat.getText().toString().isEmpty()) {
                    } else if (d_kvadrat.getText().toString().isEmpty() && a_kvadrat.getText().toString().isEmpty()){
                        v = p_kvadrat.getText().toString();
                        p = Double.parseDouble(v);
                        kvadratP(p);
                    }
                    if (s_kvadrat!=0){
                        //передача данных в другую активность
                        reshenie_kvadrat.putExtra("s_kvadrat", s_kvadrat);
                        //выполнение перехода на новую активность
                        startActivity(reshenie_kvadrat);
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
        back0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Kvadrat.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который высчитывает площадь квадрата, зная сторону
    public double kvadratA (double a){
        s_kvadrat = Math.pow(a, 2);
        reshenie_kvadrat.putExtra("a_kvadrat", a);
        return s_kvadrat;
    }
    //метод, который высчитывает площадь квадрата, зная диагональ
    public double kvadratD (double d){
        s_kvadrat = Math.pow(d, 2)/2;
        reshenie_kvadrat.putExtra("d_kvadrat", d);
        return s_kvadrat;
    }
    //метод, который высчитывает площадь квадрата, зная периметр
    public double kvadratP (double p){
        double a = p/4;
        s_kvadrat = Math.pow(a, 2);
        reshenie_kvadrat.putExtra("p_kvadrat", p);
        reshenie_kvadrat.putExtra("a_kvadrat", a);
        return s_kvadrat;
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Kvadrat.this);
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