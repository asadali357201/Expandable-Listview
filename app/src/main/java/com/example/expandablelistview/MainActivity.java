package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ExpandableListView elv;
    ArrayList<String> listGroup=new ArrayList<>();
    HashMap<String,ArrayList<String>> listChild=new HashMap<>();
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elv=findViewById(R.id.elv);

        for(int g=0;g<=10;g++){
//            add variable in group list
            listGroup.add("Group"+g);
            ArrayList<String> arrayList=new ArrayList<>();
            for (int c=0;c<=5;c++)
            {
                arrayList.add("Item"+c);
            }
//            put values in hashmap child list
            listChild.put(listGroup.get(g),arrayList);
        }
        adapter=new MainAdapter(listGroup,listChild);
        elv.setAdapter(adapter);
    }
}