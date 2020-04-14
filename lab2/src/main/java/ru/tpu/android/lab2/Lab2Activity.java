package ru.tpu.android.lab2;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Lab2Activity extends AppCompatActivity {

    List<String> namesOfItems = new ArrayList<String>();
    List<Double> ratings = new ArrayList<Double>();

    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, Lab2Activity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab2_activity);

        setTitle(getString(R.string.lab2_title, getClass().getSimpleName()));

        //получение кнопки добавления записи
        Button addButton = findViewById(R.id.btn_add_view);

        //задание добавления записи при нажатии на кнопку
        addButton.setOnClickListener(view -> AddNewItem());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //массивы, в которые будут сохранены введенные данные
        String[] namesArray = new String[namesOfItems.size()];
        double[] ratingsArray = new double[ratings.size()];
        //передача данных из списков в массивы
        for (int i = 0; i < namesArray.length; i++)
        {
            namesArray[i] = namesOfItems.get(i);
            ratingsArray[i] = ratings.get(i);
        }
        //сохранение
        outState.putStringArray("namesOfItems", namesArray);
        outState.putDoubleArray("ratings", ratingsArray);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //получение сохраненных значений
        String[] nameArray = savedInstanceState.getStringArray("namesOfItems");
        double[] ratingsArray = savedInstanceState.getDoubleArray("ratings");

        //заполнение списков данными из массивов
        for (int i = 0; i<nameArray.length; i++)
        {
            namesOfItems.add(nameArray[i]);
            ratings.add(ratingsArray[i]);

            AddNewItem(i);
        }
    }

    /*добавление новых элементов в список*/
    //без аргументов - с сохранением значения из EditText'ов
    public void AddNewItem()
    {
        LayoutInflater inflater = getLayoutInflater();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.list_of_items);

        //получение родительской активити
        View view = findViewById(R.id.activity_main);

        //очистка hint, если в него была выведена ошибка
        ((TextView)view.findViewById(R.id.edit_rating)).setHint("Рейтинг");

        //получение введенных значений
        String nameOfItem = ((TextView)view.findViewById(R.id.edit_name)).getText().toString();
        String ratingStr = ((TextView)view.findViewById(R.id.edit_rating)).getText().toString();
        double rating = 0;
        try {
            rating = Double.parseDouble(ratingStr);
        } catch (NumberFormatException e)
        {
            //запись ошибки
            ((TextView)view.findViewById(R.id.edit_rating)).setHint("Неправильно введено число!");
            //очистка поля
            ((TextView)view.findViewById(R.id.edit_rating)).setText("");
            return;
        }
        if ((rating < 0)||(rating>10))
        {
            //запись ошибки
            ((TextView)view.findViewById(R.id.edit_rating)).setHint("Неправильно введено число!");
            //очистка поля
            ((TextView)view.findViewById(R.id.edit_rating)).setText("");
            return;
        }

        //сохранение значений
        namesOfItems.add(nameOfItem);
        ratings.add(rating);

        //добавление новой записи на экран
        View newView = inflater.inflate(R.layout.rating_item, linearLayout, false);
        TextView nameOfItemView = newView.findViewById(R.id.name_of_item);
        nameOfItemView.setText(nameOfItem);
        ProgressBar progressBar = newView.findViewById(R.id.progress_item);
        progressBar.setProgress((int)rating*10);
        TextView progressNum = newView.findViewById(R.id.number_progress);
        progressNum.setText(Double.toString(rating));

        linearLayout.addView(newView);

        //очистка полей
        ((TextView)view.findViewById(R.id.edit_name)).setText("");
        ((TextView)view.findViewById(R.id.edit_rating)).setText("");
    }

    //конкретный айтем - только вывод на экран
    public void AddNewItem(int number)
    {
        LayoutInflater inflater = getLayoutInflater();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.list_of_items);

        //заполнение значений
        View view = inflater.inflate(R.layout.rating_item, linearLayout, false);
        TextView nameOfItemView = view.findViewById(R.id.name_of_item);
        nameOfItemView.setText(namesOfItems.get(number));
        ProgressBar progressBar = view.findViewById(R.id.progress_item);
        progressBar.setProgress((int)(ratings.get(number)*10));
        TextView progressNum = view.findViewById(R.id.number_progress);
        progressNum.setText(Double.toString(ratings.get(number)));

        //добавление нового айтема в список
        linearLayout.addView(view);
    }

}
