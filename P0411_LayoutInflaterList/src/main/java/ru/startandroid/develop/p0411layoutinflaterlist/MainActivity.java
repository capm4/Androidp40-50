package ru.startandroid.develop.p0411layoutinflaterlist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] name = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь" };
    String[] position = { "Программер", "Бухгалтер", "Программер",
            "Программер", "Бухгалтер", "Директор", "Программер", "Охранник" };
    int salary[] = { 13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000 };


    int[] colors = new int[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");

        LinearLayout layout = (LinearLayout) findViewById(R.id.linLayout);
        LayoutInflater lflater = getLayoutInflater();

        for (int i = 0; i < name.length; i++){
            Log.d("myLog", " i = " + i);
                View item = lflater.inflate(R.layout.item, layout, false);
                TextView tvName = (TextView) item.findViewById(R.id.tvName);
                tvName.setText(name[i]);
                TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
                tvPosition.setText("Посада = " + position[i]);
                TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
                tvSalary.setText("Заплата = " + salary[i]);
                item.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
                item.setBackgroundColor(colors[i % 2]);
                layout.addView(item);
        }
    }
}
