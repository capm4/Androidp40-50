package ru.startandroid.develop.p0431simplelistchoice;

import android.content.DialogInterface;
import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_multiple_choice);
        lvMain.setAdapter(adapter);
        Button btnChecet = (Button) findViewById(R.id.btnChecked);
        btnChecet.setOnClickListener(this);
        names = getResources().getStringArray(R.array.names);
    }

    @Override
    public void onClick(View view) {
        Log.d(LOG_TAG, "checked: " );
        SparseBooleanArray array = lvMain.getCheckedItemPositions();
        for (int i = 0; i < array.size(); i++){
            int key = array.keyAt(i);
            if(array.get(key))
                Log.d(LOG_TAG, names[key]);
        }
    }
}
