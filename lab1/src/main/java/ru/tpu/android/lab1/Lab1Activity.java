package ru.tpu.android.lab1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Lab1Activity extends AppCompatActivity {

    public static Intent newIntent(@NonNull Context context) {
        try {
            return new Intent(context, Lab1Activity.class);
        }
        catch (Exception e)
        {
            String a = e.getMessage();
        }
        return new Intent(context, Lab1Activity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(getString(R.string.lab1_title, getClass().getSimpleName()));
    }
}