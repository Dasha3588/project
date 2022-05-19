package com.example.myipdom;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //связывание элементов по id
        CardView kvadrat = (CardView)findViewById(R.id.kvadrat);
        CardView krug = (CardView)findViewById(R.id.krug);
        CardView pryamoygolnik = (CardView)findViewById(R.id.pryamougolnik);
        CardView parallelogramm = (CardView)findViewById(R.id.parallelogramm);
        CardView pryamougolnyytreugolnik = (CardView)findViewById(R.id.pryamougolnyytreugolnik);
        CardView romb = (CardView)findViewById(R.id.romb);
        CardView trapetsiya = (CardView)findViewById(R.id.trapetsiya);
        CardView treugolnik = (CardView)findViewById(R.id.treugolnik);
        Button rezhim_stroitelstva = (Button)findViewById(R.id.rezhim);
        ImageView imkvadrat = (ImageView)findViewById(R.id.imkvadrat);
        ImageView imkrug = (ImageView)findViewById(R.id.imkrug);
        ImageView impryamoygolnik = (ImageView)findViewById(R.id.impryamougolnik);
        ImageView imparallelogramm = (ImageView)findViewById(R.id.imparallelogramm);
        ImageView impryamougolnyytreugolnik = (ImageView)findViewById(R.id.impryamougolnyytreugolnik);
        ImageView imromb = (ImageView)findViewById(R.id.imromb);
        ImageView imtrapetsiya = (ImageView)findViewById(R.id.imtrapetsiya);
        ImageView imtreugolnik = (ImageView)findViewById(R.id.imtreugolnik);
        //передача в ImageView изображения из базы данных
        String urlkrug ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/krug.png?alt=media&token=ac6c303e-bc2f-49b2-acff-c9aaf8ec91a2";
        Glide.with(getApplicationContext()).load(urlkrug).into(imkrug);
        String urlkvadrat ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/kvadrat.png?alt=media&token=0d5c8534-4ea5-4316-b91a-6194a9be3daf";
        Glide.with(getApplicationContext()).load(urlkvadrat).into(imkvadrat);
        String urlpryamoygolnik ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/pryamougolnik.jpeg?alt=media&token=deb9273c-27df-4c94-8e90-559b7a3db814";
        Glide.with(getApplicationContext()).load(urlpryamoygolnik).into(impryamoygolnik);
        String urlparallelogramm ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/parallelogramm.png?alt=media&token=7d2f842b-2b9f-48d0-868c-9370f66c82b1";
        Glide.with(getApplicationContext()).load(urlparallelogramm).into(imparallelogramm);
        String urlpryamougolnyytreugolnik ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/pryamougolnyytreugolnik.png?alt=media&token=ce2a7bd5-97ed-49c2-9238-cfc52212c96f";
        Glide.with(getApplicationContext()).load(urlpryamougolnyytreugolnik).into(impryamougolnyytreugolnik);
        String urlromb ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/romb.png?alt=media&token=f75a2a3a-918c-434a-b75f-0db732a14002";
        Glide.with(getApplicationContext()).load(urlromb).into(imromb);
        String urltrapetsiya ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/trapesiya.png?alt=media&token=2e9184e8-37fc-4917-967e-d73387f7d460";
        Glide.with(getApplicationContext()).load(urltrapetsiya).into(imtrapetsiya);
        String urltreugolnik ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/treugolnik.png?alt=media&token=754756d3-cbc3-4c9c-b162-402e68ba56e9";
        Glide.with(getApplicationContext()).load(urltreugolnik).into(imtreugolnik);
        //создание и переход на активность, которая расчитывает площадь квадрата, по нажатию на CardView
        kvadrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kvadrat = new Intent(MainActivity.this, Kvadrat.class);
                startActivity(kvadrat);
                finish();
            }
        });
        //создание и переход на активность, которая расчитывает площадь круга, по нажатию на CardView
        krug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent krug = new Intent(MainActivity.this, Krug.class);
                startActivity(krug);
                finish();
            }
        });
        //создание и переход на активность, которая расчитывает площадь прямоугольника, по нажатию на CardView
        pryamoygolnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pryamougolnik =  new Intent(MainActivity.this, Pryamougolnik.class);
                startActivity(pryamougolnik);
                finish();
            }
        });
        //создание и переход на активность, которая расчитывает площадь параллелограмма, по нажатию на CardView
        parallelogramm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent parallelogramm = new Intent(MainActivity.this, Parallelogramm.class);
                startActivity(parallelogramm);
                finish();
            }
        });
        //создание и переход на активность, которая расчитывает площадь прямоуголього треугольника, по нажатию на CardView
        pryamougolnyytreugolnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pryamougolnyytreugolnik = new Intent(MainActivity.this, PryamougolnyyTreugolnik.class);
                startActivity(pryamougolnyytreugolnik);
                finish();
            }
        });
        //создание и переход на активность, которая расчитывает площадь ромба, по нажатию на CardView
        romb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent romb = new Intent(MainActivity.this, Romb.class);
                startActivity(romb);
                finish();
            }
        });
        //создание и переход на активность, которая расчитывает площадь трапеции, по нажатию на CardView
        trapetsiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trapetsiya = new Intent(MainActivity.this, Trapetsiya.class);
                startActivity(trapetsiya);
                finish();
            }
        });
        //создание и переход на активность, которая расчитывает площадь треугольника, по нажатию на CardView
        treugolnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent treugolnik = new Intent(MainActivity.this, Treugolnik.class);
                startActivity(treugolnik);
                finish();
            }
        });
        //создание и переход на активность, которая расчитывает площадь производно фигуры, по нажатию на CardView
        rezhim_stroitelstva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rezhim_stroitelstva = new Intent(MainActivity.this, RezhimStroitelstva.class);
                startActivity(rezhim_stroitelstva);
                finish();
            }
        });
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(MainActivity.this);
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