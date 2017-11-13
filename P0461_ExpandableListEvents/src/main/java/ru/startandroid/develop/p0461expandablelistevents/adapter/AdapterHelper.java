package ru.startandroid.develop.p0461expandablelistevents.adapter;

import android.content.Context;
import android.widget.SimpleExpandableListAdapter;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 13.11.2017.
 */

public class AdapterHelper {
    final String ATTR_GROUP_NAME= "groupName";
    final String ATTR_PHONE_NAME= "phoneName";

    // названия компаний (групп)
    String[] groups = new String[] {"HTC", "Samsung", "LG"};

    // названия телефонов (элементов)
    String[] phonesHTC = new String[] {"Sensation", "Desire", "Wildfire", "Hero"};
    String[] phonesSams = new String[] {"Galaxy S II", "Galaxy Nexus", "Wave"};
    String[] phonesLG = new String[] {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};

    // коллекция для групп
    ArrayList<Map<String, String>> groupData;

    //коллекция для элементов одной группы
    ArrayList<Map<String, String>> childDataItem;

    //общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String >>> chiltdData;

    // список аттрибутов группы или элемента
    Map<String, String> m;
    Context ctx;

    public AdapterHelper(Context _ctx){
        ctx = _ctx;
    }

    SimpleExpandableListAdapter adapter;
    public SimpleExpandableListAdapter getAdapter (){
        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<Map<String, String>>();
        for (String name : groups){
            m = new HashMap<String, String>();
            m.put(ATTR_GROUP_NAME, name);
            groupData.add(m);
        }
        // заполняем коллекцию групп из массива с названиями групп
        String groupFrom[] = new String[]{ATTR_GROUP_NAME};
        // список ID view-элементов, в которые будет помещены аттрибуты групп
        int groupTo [] = new int[]{android.R.id.text1};
        chiltdData = new ArrayList<ArrayList<Map<String, String>>>();
        // создаем коллекцию элементов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String name : phonesHTC){
            m = new HashMap<String, String>();
            m.put(ATTR_PHONE_NAME, name);
            childDataItem.add(m);
        }
        chiltdData.add(childDataItem);

        // создаем коллекцию элементов для второго группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String name : phonesSams){
            m = new HashMap<String, String>();
            m.put(ATTR_PHONE_NAME, name);
            childDataItem.add(m);
        }
        chiltdData.add(childDataItem);

        // создаем коллекцию элементов для третього группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String name : phonesLG){
            m = new HashMap<String, String>();
            m.put(ATTR_PHONE_NAME, name);
            childDataItem.add(m);
        }
        chiltdData.add(childDataItem);

        String childFrom[] = new String[]{ATTR_PHONE_NAME};
        // список ID view-элементов, в которые будет помещены аттрибуты элементов
        int childTo[] = new int[] {android.R.id.text1};
        adapter = new SimpleExpandableListAdapter(
                ctx,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                chiltdData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo
        );
        return adapter;
    }

    public String getGroupText(int groupPos){
        return ((Map<String,String>)(adapter.getGroup(groupPos))).get(ATTR_GROUP_NAME);
    }
    public String getChildText(int groupPos, int childPos) {
        return ((Map<String, String>)(adapter.getChild(groupPos, childPos))).get(ATTR_PHONE_NAME);
    }

    public String getGroupChildText (int groupPos, int childPos){
        return getGroupText(groupPos) + " " + getChildText(groupPos, childPos);
    }
}
