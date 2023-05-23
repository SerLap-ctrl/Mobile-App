package com.example.practice_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.MapKitFactory;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int progress = 0;
    private ProgressBar pbHorizontal;
    private TextView tvProgressHorizontal;
    private Handler handler = new Handler();

    private Button button;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapKitFactory.setApiKey("50ffdf0d-360d-4d5c-8a67-a86e15bd7b70");
        pbHorizontal = (ProgressBar) findViewById(R.id.progressBar);
        pbHorizontal.setProgressDrawable(getDrawable(R.drawable.customprogressbar));
        tvProgressHorizontal = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
//        tvProgressCircle     = (TextView)findViewById(R.id.tv_progress_circle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pbHorizontal.setProgressDrawable(getDrawable(R.drawable.customprogressbar));
                doStartProgressBar2();
            }
        });

    }


    private void doStartProgressBar2()  {
        this.pbHorizontal.setIndeterminate(true);

        Thread thread = new Thread(new Runnable()  {

            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void run() {
                // Update interface
                String[] texts = {"— Доктор, от меня ушла собака!\n" +
                        "— А что вы ей сказали?\n" +
                        "— Сказал «служить», а она взяла каску и пошла в армию.\n" +
                        "\n", "Плывут две акулы вдоль побережья и вдруг видят виндсерфингиста. " +
                        "Одна другой восхищенно: \n" +
                        "— Вот это сервис — на подносе, да еще и с салфеткой!\n" +
                        "\n", "Бесит, когда монстры под кроватью не стелят тебе постель\n" +
                        "\n", "Преподаватель в возрасте \"бес в ребро\" объясняется студентке:\n" +
                        "— За всю жизнь я любил только трех женщин: \n" +
                        "— Маму, жену и, простите, как вас зовут?\n" +
                        "\n","Дети, у которых были только печеньки и конфеты, из сладостей выложили " +
                        "слово «пить».\n" +
                        "\n","До скелета динозавра опять докопались какие — то археологи.\n" +
                        "\n","Вот сидит баба, сидит... С виду — ничего не делает.\n" +
                        "А на самом деле бесится, хочет тортик и ненавидит своих бывших и бывших " +
                        "нынешнего.\n" +
                        "Многозадачность...\n" +
                        "\n"};
                handler.post(new Runnable() {
                    @SuppressLint("UseCompatLoadingForDrawables")
                    public void run() {
                        pbHorizontal.setProgressDrawable(getDrawable(R.drawable.customprogressbar));
                        tvProgressHorizontal.setText(texts[new Random().nextInt(texts.length)]);
                        button.setEnabled(false);
                        button.setVisibility(View.INVISIBLE);
                    }
                });
                // Do something ... (Update database,..)
                SystemClock.sleep(5000); // Sleep 5 seconds.

                pbHorizontal.setIndeterminate(true);
                pbHorizontal.setMax(1);
                pbHorizontal.setProgress(1);

                // Update interface
                handler.post(new Runnable() {
                    public void run() {
                        tvProgressHorizontal.setText("Completed!");
                        pbHorizontal.setIndeterminate(false);
                        pbHorizontal.setProgress(100);
                        button.setVisibility(View.VISIBLE);
                        button.setEnabled(true);
                        Intent myIntent = new Intent(MainActivity.this, Page2.class);
                        myIntent.putExtra("key", 1); //Optional parameters
                        MainActivity.this.startActivity(myIntent);
                        MainActivity.this.onStop();
                    }
                });
            }
        });
        thread.start();
    }


}