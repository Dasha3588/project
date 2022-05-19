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

public class PryamougolnyyTreugolnik extends AppCompatActivity {

    public double s_pryamougolnyy_treugolnik; //переменная в которую зписывается площадь прямоугольного треугольника
    private double a,b; //переменные в которые зписываются катеты прямоугольного треугольника
    private String v; //временная переменная
    Intent reshenie_pryamougolnyy_treugolnik; //новая активность

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pryamougolnyy_treugolnik);
        //связывание элементов по id
        EditText a_pryamougolnyy_treugolnik = (EditText) findViewById(R.id.a_pryamougolnyy_treugolnik);
        EditText b_pryamougolnyy_treugolnik = (EditText) findViewById(R.id.b_pryamougolnyy_treugolnik);
        Button button7 = (Button) findViewById (R.id.button7);
        Button back7 = (Button) findViewById(R.id.back7);
        reshenie_pryamougolnyy_treugolnik = new Intent(PryamougolnyyTreugolnik.this, Reshenie.class); //создание новой активности
        //обрабатка нажатия на кнопку "вычислитить"
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //если никакие данные не введенны, то появляется всплывающее сообщение
                if(a_pryamougolnyy_treugolnik.getText().toString().isEmpty() && b_pryamougolnyy_treugolnik.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Введите известные данные", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //иначе поиск данных, по которым можно найти площадь
                else {
                    if (a_pryamougolnyy_treugolnik.getText().toString().isEmpty() || b_pryamougolnyy_treugolnik.getText().toString().isEmpty()) {
                    } else {
                        v = a_pryamougolnyy_treugolnik.getText().toString();
                        a = Double.parseDouble(v);
                        v = b_pryamougolnyy_treugolnik.getText().toString();
                        b = Double.parseDouble(v);
                        pryamougolnyyTreugolnikAB(a, b);
                    }
                    if (s_pryamougolnyy_treugolnik!=0){
                        //передача данных в другую активность
                        reshenie_pryamougolnyy_treugolnik.putExtra("s_pryamougolnyy_treugolnik", s_pryamougolnyy_treugolnik);
                        //выполнение перехода на новую активность
                        startActivity(reshenie_pryamougolnyy_treugolnik);
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
        back7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PryamougolnyyTreugolnik.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который высчитывает площадь прямоугольного треугольника, зная два катета
    public double pryamougolnyyTreugolnikAB (double a, double b){
        s_pryamougolnyy_treugolnik = a*b/2;
        reshenie_pryamougolnyy_treugolnik.putExtra("a_pryamougolnyy_treugolnik", a);
        reshenie_pryamougolnyy_treugolnik.putExtra("b_pryamougolnyy_treugolnik", b);
        return s_pryamougolnyy_treugolnik;
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(PryamougolnyyTreugolnik.this);
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