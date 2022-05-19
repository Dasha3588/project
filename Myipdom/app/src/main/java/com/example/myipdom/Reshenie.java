package com.example.myipdom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Reshenie extends AppCompatActivity {

    public double s;
    public Intent intent;
    public TextView reshenie;
    public ImageView formula;
    public double s_kvadrat, s_krug, s_pryamougolnik, s_romb, s_parallelogramm, s_trapetsiya, s_pryamougolnyy_treugolnik, s_treugolnik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reshenie);
        //связывание элементов по id
        TextView otvet = (TextView) findViewById(R.id.otvet);
        Button figura = (Button) findViewById (R.id.figura);
        Button back = (Button) findViewById (R.id.back);
        reshenie = (TextView)findViewById(R.id.reshenie);
        formula = (ImageView)findViewById(R.id.formula);
        //получение данных из другой активности
        Bundle s = getIntent().getExtras();
        s_kvadrat = s.getDouble("s_kvadrat");
        s_krug = s.getDouble("s_krug");
        s_pryamougolnik = s.getDouble("s_pryamougolnik");
        s_romb = s.getDouble("s_romb");
        s_parallelogramm = s.getDouble("s_parallelogramm");
        s_trapetsiya = s.getDouble("s_trapetsiya");
        s_pryamougolnyy_treugolnik = s.getDouble("s_pryamougolnyy_treugolnik");
        s_treugolnik = s.getDouble("s_treugolnik");
        double s_rezhim_stroitelstva = s.getDouble("s_rezhim_stroitelstva");
        double swindow_rezhim_stroitelstva = s.getDouble("swindow_rezhim_stroitelstva");
        double swall_rezhim_stroitelstva = s.getDouble("swall_rezhim_stroitelstva");
        //вывод ответа
        String s2 = Double.toString(kto(s_kvadrat, s_pryamougolnik, s_krug, s_romb, s_parallelogramm, s_trapetsiya, s_pryamougolnyy_treugolnik, s_treugolnik));
        if (s_rezhim_stroitelstva!=0) {
            otvet.setText("Площадь стены без учёта окон: \n" + swall_rezhim_stroitelstva+"\nПлощадь окна: \n"+swindow_rezhim_stroitelstva+"\nПлощадь стены с учётом окон: \n"+s_rezhim_stroitelstva);
            //создание новой активности (режим строительства)
            intent=new Intent(Reshenie.this, RezhimStroitelstva.class);
        } else {
            otvet.setText("Ответ: " + s2);
        }
        //обрабатка нажатия на кнопку
        figura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //создание и переход на новую активность (главный экран)
                Intent MainActivity = new Intent(Reshenie.this, MainActivity.class);
                startActivity(MainActivity);
                finish();
            }
        });
        //обрабатка нажатия на кнопку
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //преход на новую активность
                startActivity(intent);
                finish();
            }
        });
    }
    //метод, который определяет площадь какой фигуры была найдена
    public double kto(double s_kvadrat, double s_pryamougolnik, double s_krug, double s_romb, double s_parallelogramm, double s_trapetsiya, double s_pryamougolnyy_treugolnik, double s_treugolnik){
        if (s_kvadrat!=0 && s_pryamougolnik==0 && s_krug==0 && s_trapetsiya==0 && s_romb==0 && s_parallelogramm==0 && s_pryamougolnyy_treugolnik==0 && s_treugolnik==0){
            s = s_kvadrat;
            ktoKvadrat();
            //создание новой активности (квадрат)
            intent = new Intent(Reshenie.this, Kvadrat.class);
        }
        if (s_pryamougolnik!=0 && s_krug==0 && s_romb==0 && s_parallelogramm==0 && s_kvadrat==0 && s_pryamougolnyy_treugolnik==0 && s_trapetsiya==0 && s_treugolnik==0) {
            s = s_pryamougolnik;
            ktoPryamougolnik();
            //создание новой активности (прямоугольник)
            intent = new Intent(Reshenie.this, Pryamougolnik.class);
        }
        if (s_krug!=0 && s_pryamougolnik==0 && s_romb==0 && s_parallelogramm==0 && s_kvadrat==0 && s_pryamougolnyy_treugolnik==0 && s_trapetsiya==0 && s_treugolnik==0) {
            s = s_krug;
            ktoKrug();
            //создание новой активности (круг)
            intent= new Intent(Reshenie.this, Krug.class);
        }
        if (s_romb!=0 && s_parallelogramm==0 && s_pryamougolnik==0 && s_krug==0 && s_kvadrat==0 && s_pryamougolnyy_treugolnik==0 && s_trapetsiya==0 && s_treugolnik==0) {
            s = s_romb;
            ktoRomb();
            //создание новой активности (ромб)
            intent = new Intent(Reshenie.this, Romb.class);
        }
        if (s_parallelogramm!=0 && s_kvadrat==0 && s_pryamougolnik==0 && s_krug==0 && s_romb==0 && s_pryamougolnyy_treugolnik==0 && s_trapetsiya==0 && s_treugolnik==0) {
            s = s_parallelogramm;
            ktoParallelogramm();
            //создание новой активности (параллелограмм)
            intent = new Intent(Reshenie.this, Parallelogramm.class);
        }
        if (s_trapetsiya!=0 && s_kvadrat==0 && s_pryamougolnik==0 && s_krug==0 && s_romb==0 && s_parallelogramm==0 && s_pryamougolnyy_treugolnik==0 && s_treugolnik==0) {
            s = s_trapetsiya;
            ktoTrapetsiya();
            //создание новой активности (трапеция)
            intent = new Intent(Reshenie.this, Trapetsiya.class);
        }
        if (s_pryamougolnyy_treugolnik!=0 && s_kvadrat==0 && s_pryamougolnik==0 && s_krug==0 && s_romb==0 && s_parallelogramm==0 && s_trapetsiya==0 && s_treugolnik==0) {
            s = s_pryamougolnyy_treugolnik;
            ktoPryamougolnyyTreugolnik();
            //создание новой активности (прямоугольный треугольник)
            intent = new Intent(Reshenie.this, PryamougolnyyTreugolnik.class);
        }
        if (s_treugolnik!=0 && s_kvadrat==0 && s_pryamougolnik==0 && s_krug==0 && s_romb==0 && s_parallelogramm==0 && s_trapetsiya==0 && s_pryamougolnyy_treugolnik==0) {
            s = s_treugolnik;
            ktoTreugolnik();
            //создание новой активности (треугольник)
            intent = new Intent(Reshenie.this, Treugolnik.class);
        }
        //округление до десятых
        s = s*100;
        s = (int)Math.round(s);
        s = s/100;
        return s;
    }
    //метод, который определяет по каким данным была найдена площадь прямоуголльника
    public void ktoPryamougolnik(){
        Bundle s = getIntent().getExtras();
        double a_pryamougolnik = s.getDouble("a_pryamougolnik");
        double b_pryamougolnik = s.getDouble("b_pryamougolnik");
        double d_pryamougolnik = s.getDouble("d_pryamougolnik");
        double e_pryamougolnik = s.getDouble("e_pryamougolnik");
        double p_pryamougolnik = s.getDouble("p_pryamougolnik");
        if (a_pryamougolnik!=0 && b_pryamougolnik!=0 && p_pryamougolnik==0){
            //вывод решения
            reshenie.setText("a="+a_pryamougolnik+ "\nb="+b_pryamougolnik+"\n\nS="+a_pryamougolnik+"*"+b_pryamougolnik+"="+s_pryamougolnik);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/ab.png?alt=media&token=2619003a-e503-4e39-a3e8-a967e88cc453";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (p_pryamougolnik!=0){
            //вывод решения
            reshenie.setText("a="+a_pryamougolnik+ "\nP="+p_pryamougolnik+"\nb=(P-2*a)/2=("+p_pryamougolnik+"-2*"+a_pryamougolnik+")/2="+b_pryamougolnik+"\n\nS="+a_pryamougolnik+"*"+b_pryamougolnik+"="+s_pryamougolnik);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/ab.png?alt=media&token=2619003a-e503-4e39-a3e8-a967e88cc453";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (d_pryamougolnik!=0 && e_pryamougolnik!=0){
            //вывод решения
            reshenie.setText("d="+d_pryamougolnik+ "\nsin e="+e_pryamougolnik+"\n\nS="+d_pryamougolnik+"^2*"+e_pryamougolnik+"/2="+s_pryamougolnik);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.5d%5E2sine.png?alt=media&token=938677c5-a73a-4610-bf27-4f3d93a403ad";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
    }
    //метод, который определяет по каким данным была найдена площадь квадрата
    public void ktoKvadrat(){
        Bundle s = getIntent().getExtras();
        double a_kvadrat = s.getDouble("a_kvadrat");
        double d_kvadrat = s.getDouble("d_kvadrat");
        double p_kvadrat = s.getDouble("p_kvadrat");
        if (a_kvadrat!=0 && p_kvadrat==0){
            //вывод решения
            reshenie.setText("a="+a_kvadrat+"\n\nS="+a_kvadrat+"^2="+s_kvadrat);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/a%5E2.png?alt=media&token=767f9504-b46b-4c75-a3bf-e045a69bd144";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (p_kvadrat!=0){
            //вывод решения
            reshenie.setText("P="+p_kvadrat+"\na=P/4="+p_kvadrat+"/4="+a_kvadrat+"\n\nS="+a_kvadrat+"^2="+s_kvadrat);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/a%5E2.png?alt=media&token=767f9504-b46b-4c75-a3bf-e045a69bd144";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (d_kvadrat!=0){
            //вывод решения
            reshenie.setText("d="+d_kvadrat+"\n\nS="+d_kvadrat+"^2/2="+s_kvadrat);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.5d%5E2.png?alt=media&token=5a6230ef-869b-4ec1-914c-699a17712f1a";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
    }
    //метод, который определяет по каким данным была найдена площадь круга
    public void ktoKrug(){
        Bundle s = getIntent().getExtras();
        double r_krug = s.getDouble("r_krug");
        double d_krug = s.getDouble("d_krug");
        double l_krug = s.getDouble("l_krug");
        if (r_krug!=0 && d_krug==0){
            //вывод решения
            reshenie.setText("R="+r_krug+"\n\nS=pi*"+r_krug+"^2="+s_krug);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/piR%5E2.png?alt=media&token=d3636ef2-c9e3-4e84-858d-b06ddc5c96c7";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (d_krug!=0){
            //вывод решения
            reshenie.setText("D="+d_krug+"\nR=D/2="+d_krug+"/2="+r_krug+"\n\nS=pi*"+r_krug+"^2="+s_krug);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/piR%5E2.png?alt=media&token=d3636ef2-c9e3-4e84-858d-b06ddc5c96c7";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (l_krug!=0){
            //вывод решения
            reshenie.setText("l="+l_krug+"\n\nS="+l_krug+"^2/(4*pi)="+s_krug);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.25l%5E2.png?alt=media&token=7c863f06-d3a0-4a04-ac57-ba6806a358b4";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
    }
    //метод, который определяет по каким данным была найдена площадь параллелограмма
    public void ktoParallelogramm(){
        Bundle s = getIntent().getExtras();
        double a_parallelogramm = s.getDouble("a_parallelogramm");
        double b_parallelogramm = s.getDouble("b_parallelogramm");
        double h_parallelogramm = s.getDouble("h_parallelogramm");
        double d1_parallelogramm = s.getDouble("d1_parallelogramm");
        double d2_parallelogramm = s.getDouble("d2_parallelogramm");
        double y_parallelogramm = s.getDouble("y_parallelogramm");
        double e_parallelogramm = s.getDouble("e_parallelogramm");
        if (a_parallelogramm!=0 && h_parallelogramm!=0){
            //вывод решения
            reshenie.setText("a="+a_parallelogramm+"\nh="+h_parallelogramm+"\n\nS="+a_parallelogramm+"*"+h_parallelogramm+"="+s_parallelogramm);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/ah.png?alt=media&token=6e890107-851e-4c27-b5b7-b44b2972e20a";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (a_parallelogramm!=0 && b_parallelogramm!=0 && y_parallelogramm!=0){
            //вывод решения
            reshenie.setText("a="+a_parallelogramm+"\nb="+b_parallelogramm+"\nsin y="+y_parallelogramm+"\n\nS="+a_parallelogramm+"*"+b_parallelogramm+"*"+y_parallelogramm+"="+s_parallelogramm);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/abcsiny.png?alt=media&token=b16f8cfe-f4d0-4811-92a1-9d6f3830cf12";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (d1_parallelogramm!=0 && d2_parallelogramm!=0 && e_parallelogramm!=0){
            //вывод решения
            reshenie.setText("d1="+d1_parallelogramm+"\nd2="+d2_parallelogramm+"\nsin e="+e_parallelogramm+"\n\nS="+d1_parallelogramm+"*"+d2_parallelogramm+"*"+e_parallelogramm+"/2="+s_parallelogramm);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.5d1d1sine.png?alt=media&token=85f6f3b1-29bc-4f98-808e-c4fe1a115263";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
    }
    //метод, который определяет по каким данным была найдена площадь прямоугольного треугольника
    public void ktoPryamougolnyyTreugolnik(){
        Bundle s = getIntent().getExtras();
        double a_pryamougolnyy_treugolnik = s.getDouble("a_pryamougolnyy_treugolnik");
        double b_pryamougolnyy_treugolnik = s.getDouble("b_pryamougolnyy_treugolnik");
        //вывод решения
        reshenie.setText("a="+a_pryamougolnyy_treugolnik+"\nb="+b_pryamougolnyy_treugolnik+"\n\nS="+a_pryamougolnyy_treugolnik+"*"+b_pryamougolnyy_treugolnik+"/2="+s_pryamougolnyy_treugolnik);
        //вывод формулы из базы данных
        String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.5ab.png?alt=media&token=89996f94-5723-44c8-927c-8bb7a51fafba";
        Glide.with(getApplicationContext()).load(url).into(formula);
    }
    //метод, который определяет по каким данным была найдена площадь трапеции
    public void ktoTrapetsiya(){
        Bundle s = getIntent().getExtras();
        double a_trapetsiya = s.getDouble("a_trapetsiya");
        double b_trapetsiya = s.getDouble("b_trapetsiya");
        double h_trapetsiya = s.getDouble("h_trapetsiya");
        double d1_trapetsiya = s.getDouble("d1_trapetsiya");
        double d2_trapetsiya = s.getDouble("d2_trapetsiya");
        double m_trapetsiya = s.getDouble("m_trapetsiya");
        double e_trapetsiya = s.getDouble("e_trapetsiya");
        if (a_trapetsiya!=0 && b_trapetsiya!=0 && h_trapetsiya!=0){
            //вывод решения
            reshenie.setText("a="+a_trapetsiya+"\nb="+b_trapetsiya+"\nh="+h_trapetsiya+"\n\nS=("+a_trapetsiya+"+"+b_trapetsiya+")*"+h_trapetsiya+"/2="+s_trapetsiya);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.5(a%2Bb)h.png?alt=media&token=c9cc5a3a-7a5b-4d07-aab9-25b26918148c";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (m_trapetsiya!=0 && h_trapetsiya!=0){
            //вывод решения
            reshenie.setText("h="+h_trapetsiya+"\nm="+m_trapetsiya+"\n\nS="+h_trapetsiya+"*"+m_trapetsiya+"="+s_trapetsiya);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/hm.png?alt=media&token=75f042f9-c7c7-4c08-9879-3f07a89b8368";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (d1_trapetsiya!=0 && d2_trapetsiya!=0 && e_trapetsiya!=0){
            //вывод решения
            reshenie.setText("d1="+d1_trapetsiya+"\nd2="+d2_trapetsiya+"\nsin e="+e_trapetsiya+"\n\nS="+d1_trapetsiya+"*"+d2_trapetsiya+"*"+e_trapetsiya+"/2="+s_trapetsiya);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.5d1d1sine.png?alt=media&token=85f6f3b1-29bc-4f98-808e-c4fe1a115263";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
    }
    //метод, который определяет по каким данным была найдена площадь треугольника
    public void ktoTreugolnik(){
        Bundle s = getIntent().getExtras();
        double a_treugolnik = s.getDouble("a_treugolnik");
        double b_treugolnik = s.getDouble("b_treugolnik");
        double c_treugolnik = s.getDouble("c_treugolnik");
        double h_treugolnik = s.getDouble("h_treugolnik");
        double pP_treugolnik = s.getDouble("pP_treugolnik");
        double p_treugolnik = s.getDouble("p_treugolnik");
        double r_treugolnik = s.getDouble("r_treugolnik");
        double rR_treugolnik = s.getDouble("rR_treugolnik");
        double y_treugolnik = s.getDouble("y_treugolnik");
        if (a_treugolnik!=0 && h_treugolnik!=0){
            //вывод решения
            reshenie.setText("a="+a_treugolnik+"\nh="+h_treugolnik+"\n\nS=("+a_treugolnik+"*"+h_treugolnik+"/2="+s_treugolnik);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.5ah.png?alt=media&token=d5a6d4a1-de3a-465f-94e7-efaf952314b5";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (r_treugolnik!=0 && p_treugolnik!=0){
            //вывод решения
            reshenie.setText("r="+r_treugolnik+"\nP="+pP_treugolnik+"p=P/2="+pP_treugolnik+"/2="+p_treugolnik+"\n\nS="+r_treugolnik+"*"+p_treugolnik+"="+s_treugolnik);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/rp.png?alt=media&token=511939b2-55d8-419d-9760-ba5ba4009e06";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if ((a_treugolnik!=0 || b_treugolnik!=0) && (a_treugolnik!=0 || c_treugolnik!=0) && (c_treugolnik!=0 || b_treugolnik!=0) && y_treugolnik!=0){
            //вывод решения
            reshenie.setText("a="+a_treugolnik+"\nb="+b_treugolnik+"\nsin y="+y_treugolnik+"\n\nS="+a_treugolnik+"*"+b_treugolnik+"*"+y_treugolnik+"/2="+s_treugolnik);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.5absiny.png?alt=media&token=73bad147-c5e3-4660-a72d-118856f2b34b";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (a_treugolnik!=0 && b_treugolnik!=0 && c_treugolnik!=0 && rR_treugolnik!=0){
            //вывод решения
            reshenie.setText("a="+a_treugolnik+"\nb="+b_treugolnik+"\nc="+c_treugolnik+"\nR="+rR_treugolnik+"\n\nS="+a_treugolnik+"*"+b_treugolnik+"*"+c_treugolnik+"/4"+rR_treugolnik+"="+s_treugolnik);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/abc4R.png?alt=media&token=27119b21-c745-4f2f-86c6-7beab3b035f9";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (a_treugolnik!=0 && b_treugolnik!=0 && c_treugolnik!=0 && p_treugolnik!=0){
            //вывод решения
            reshenie.setText("a="+a_treugolnik+"\nb="+b_treugolnik+"\nc="+c_treugolnik+"\nP="+pP_treugolnik+"p=P/2="+pP_treugolnik+"/2="+p_treugolnik+"\n\nS=sqrt("+p_treugolnik+"*("+p_treugolnik+"-"+a_treugolnik+")*("+p_treugolnik+"-"+b_treugolnik+")*("+p_treugolnik+"-"+c_treugolnik+"))="+s_treugolnik);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/abcp.png?alt=media&token=cc272a5c-6b33-441f-80d0-d4dac88d8f95";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
    }
    //метод, который определяет по каким данным была найдена площадь ромба
    public void ktoRomb(){
        Bundle s = getIntent().getExtras();
        double a_romb= s.getDouble("a_romb");
        double h_romb = s.getDouble("h_romb");
        double d1_romb = s.getDouble("d1_romb");
        double d2_romb = s.getDouble("d2_romb");
        double y_romb = s.getDouble("y_romb");
        double p_romb = s.getDouble("p_romb");
        if (a_romb!=0 && h_romb!=0 && p_romb==0){
            //вывод решения
            reshenie.setText("a="+a_romb+"\nh="+h_romb+"\n\nS="+a_romb+"*"+h_romb+"="+s_romb);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/ah.png?alt=media&token=6e890107-851e-4c27-b5b7-b44b2972e20a";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (a_romb!=0 && y_romb!=0 && p_romb==0){
            //вывод решения
            reshenie.setText("a="+a_romb+"\nsin y="+y_romb+"\n\nS="+a_romb+"^2*"+y_romb+"="+s_romb);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/a%5E2siny.png?alt=media&token=37938bf5-2b83-4dd9-bee0-0d5954e669a3";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (d1_romb!=0 && d2_romb!=0){
            //вывод решения
            reshenie.setText("d1="+d1_romb+"\nd2="+d2_romb+"\n\nS="+d1_romb+"*"+d2_romb+"/2="+s_romb);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/0.5d1d2.png?alt=media&token=bab730b0-4613-4f16-8683-0a61e1990853";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (a_romb!=0 && h_romb!=0 && p_romb!=0){
            //вывод решения
            reshenie.setText("h="+h_romb+"\nP="+p_romb+"\na=P/4="+p_romb+"/4="+a_romb+"\n\nS="+a_romb+"*"+h_romb+"="+s_romb);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/ah.png?alt=media&token=6e890107-851e-4c27-b5b7-b44b2972e20a";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
        if (a_romb!=0 && y_romb!=0 && p_romb!=0){
            //вывод решения
            reshenie.setText("P="+p_romb+"\nsin y="+y_romb+"\na=P/4="+p_romb+"/4="+a_romb+"\n\nS="+a_romb+"^2*"+y_romb+"="+s_romb);
            //вывод формулы из базы данных
            String url ="https://firebasestorage.googleapis.com/v0/b/myipdom-b7c1b.appspot.com/o/a%5E2siny.png?alt=media&token=37938bf5-2b83-4dd9-bee0-0d5954e669a3";
            Glide.with(getApplicationContext()).load(url).into(formula);
        }
    }
    //обработка нажатия на системную кнопку "назад"
    @Override
    public void onBackPressed() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(Reshenie.this);
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