package ru.startandroid.develop.p0491simpleadaptercustom1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_VALUE = "value";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    final int positiv = R.mipmap.like;
    final int negativ = R.mipmap.dislike;

    MySimpleAdapter mySimpleAdapter;

    ListView lvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMain = (ListView) findViewById(R.id.lvSimple);
        int[] values = { 8, 4, -3, 2, -5, 0, 3, -6, 1, -1 };

        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(values.length);
        Map<String, Object> m;
        int img = 0;
        for (int i = 0; i < values.length; i++){
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_TEXT, "Day " + (i+1));
            m.put(ATTRIBUTE_NAME_VALUE, values[i]);
            if(values[i] == 0) img = 0; else
                img = (values[i] > 0) ? positiv : negativ;
            m.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(m);
        }
        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_VALUE, ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.tvText, R.id.tvValue, R.id.ivImg};

        mySimpleAdapter = new MySimpleAdapter(this, data, R.layout.item, from, to);
        lvMain.setAdapter(mySimpleAdapter);

    }
}
