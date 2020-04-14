package ru.tpu.android.laboratory_work;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.tpu.android.lab1.Lab1Activity;
import ru.tpu.android.lab2.Lab2Activity;
import ru.tpu.android.lab3.Lab3Activity;
import ru.tpu.android.lab4.Lab4Activity;
import ru.tpu.android.lab5.Lab5Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.lab1).setOnClickListener((v) -> {
            startActivity(Lab1Activity.newIntent(this));
        });
        findViewById(R.id.lab2).setOnClickListener((v) -> startActivity(Lab2Activity.newIntent(this)));
        findViewById(R.id.lab3).setOnClickListener((v) -> startActivity(Lab3Activity.newIntent(this)));
        findViewById(R.id.lab4).setOnClickListener((v) -> startActivity(Lab4Activity.newIntent(this)));
        findViewById(R.id.lab5).setOnClickListener((v) -> startActivity(Lab5Activity.newIntent(this)));
    }
}
