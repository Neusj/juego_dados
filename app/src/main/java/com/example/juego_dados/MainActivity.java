package com.example.juego_dados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {

    private TextView mTextField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView leftDice = findViewById(R.id.imagenDadoIzq);
        final ImageView rightDice = findViewById(R.id.imagenDadoDer);

        mTextField = findViewById(R.id.textView);

        Button myButton = findViewById(R.id.lanzar);

        final int[] diceArray = new int[] {
                R.drawable.dado1,
                R.drawable.dado2,
                R.drawable.dado3,
                R.drawable.dado4,
                R.drawable.dado5,
                R.drawable.dado6
        };

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomNumberGenerator = new Random();


                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int number = randomNumberGenerator.nextInt(6);
                            Log.d("Dados", "El numero de la izquierda es " + number);

                            int imageResourceId = diceArray[number];
                            leftDice.setImageResource(imageResourceId);

                            number = randomNumberGenerator.nextInt(6);
                            Log.d("Dados", "El numero de la derecha es " + number);
                            imageResourceId = diceArray[number];
                            rightDice.setImageResource(imageResourceId);
                        }
                    },500 );

               
                new CountDownTimer(30000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);

                        int number = randomNumberGenerator.nextInt(6);
                        Log.d("Dados", "El numero de la izquierda es " + number);

                        int imageResourceId = diceArray[number];
                        leftDice.setImageResource(imageResourceId);

                        number = randomNumberGenerator.nextInt(6);
                        Log.d("Dados", "El numero de la derecha es " + number);
                        imageResourceId = diceArray[number];
                        rightDice.setImageResource(imageResourceId);
                    }

                    public void onFinish() {
                        mTextField.setText("done!");
                    }
                }.start();






            }
        });
    }
}