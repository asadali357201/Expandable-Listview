package com.example.expandablelistview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainAdapter extends BaseExpandableListAdapter {
    ArrayList<String> listgroup;
    HashMap<String,ArrayList<String>> listchild;

    public MainAdapter(ArrayList<String> listgroup,HashMap<String,ArrayList<String>> listchild){
        this.listchild=listchild;
        this.listgroup=listgroup;

    }
    @Override
    public int getGroupCount() {
        return listgroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listchild.get(listgroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listgroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listchild.get(listgroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //       view initializatioon
        convertView= LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_expandable_list_item_1,parent,false);
//        assighning values and initializing
        TextView textView=convertView.findViewById(android.R.id.text1);
//        assighning string
        String sGroup=String.valueOf(getGroup(groupPosition));
        textView.setText(sGroup);
//        set text styles
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextColor(Color.BLUE);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item,parent,false);
        TextView textView=convertView.findViewById(android.R.id.text1);
        String childgrp=String.valueOf(getChild(groupPosition,childPosition));
        textView.setText(childgrp);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), childgrp, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
