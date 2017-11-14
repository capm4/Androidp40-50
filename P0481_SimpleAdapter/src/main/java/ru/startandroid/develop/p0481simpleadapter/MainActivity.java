package ru.startandroid.develop.p0481simpleadapter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    // имена атрибутов для Map
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    final String ATTRIBUTR_NAME_COLOR_PARAM = "param";


    TextView tvText;
    ListView lvSimple;
    LinearLayout.LayoutParams params;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSimple = (ListView) findViewById(R.id.lvSimple);
        tvText = (TextView) findViewById(R.id.tvText);
        String[] texts = { "sometext 1", "sometext 2", "sometext 3",
                "sometext 4", "sometext 5" };
        boolean[] checked = { true, false, false, true, false };

        int img = R.mipmap.ic_launcher_round;

        ArrayList <Map<String, Object>> data = new ArrayList<Map<String, Object>>(texts.length);

        Map<String, Object> m;

        for (int i = 0; i < texts.length; i++){
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
            m.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
            m.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.cbChecked, R.id.ivImg};
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item, from, to);
        lvSimple.setAdapter(adapter);

    }
}
