package ru.startandroid.develop.p0501simpleadaptercustom2.blinder;

import android.graphics.Color;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import ru.startandroid.develop.p0501simpleadaptercustom2.R;

/**
 * Created by Alex on 14.11.2017.
 */

public class MyViewBinder implements SimpleAdapter.ViewBinder {

    int red = Color.parseColor("#B71C1C");
    int orange = Color.parseColor("#FF9800");
    int green = Color.parseColor("#689F38");

    @Override
    public boolean setViewValue(View view, Object data, String textRepresentation) {
        int i = 0;
        switch (view.getId()){
            case R.id.llLoad:
                i = ((Integer) data).intValue();
                if(i < 40){
                    view.setBackgroundColor(green);
                }else if (i < 70){
                    view.setBackgroundColor(orange);
                }else view.setBackgroundColor(red);
                return true;
            case R.id.pbLoad:
                i = ((Integer) data).intValue();
                ((ProgressBar) view).setProgress(i);
                return true;
        }
        return false;
    }
}
