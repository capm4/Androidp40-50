package ru.startandroid.develop.p0501simpleadaptercustom2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ru.startandroid.develop.p0501simpleadaptercustom2.blinder.MyViewBinder;

public class MainActivity extends AppCompatActivity {
    // имена атрибутов для Map
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_PB = "pb";
    final String ATTRIBUTE_NAME_LL = "ll";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // массив данных
        int load[] = { 41, 48, 22, 35, 30, 67, 51, 88 };
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(load.length);

        Map<String, Object>m;
        for(int i = 0; i < load.length; i++){
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, "Day " + (i+1) + ". Load: " + load[i] + "%");
            m.put(ATTRIBUTE_NAME_PB, load[i]);
            m.put(ATTRIBUTE_NAME_LL, load[i]);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_PB, ATTRIBUTE_NAME_LL};
        int[] to = {R.id.tvLoad, R.id.pbLoad, R.id.llLoad};

        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);
        sAdapter.setViewBinder(new MyViewBinder());
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);
    }
}
