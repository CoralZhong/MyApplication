package com.example.administrator.myapplication;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/1.
 */
public class QQInnerLayout extends Activity {
    String[] a = {"分组1", "分组2", "分组3", "分组4", "分组5"};
    String[][] b = {{"dsds", "fdfd", "fdfdfd", "fff", "ggg"}, {"ffff", "efe", "fffd", "fdf", "r343"}, {"ffff", "efe", "fffd", "fdf", "r343"}, {"ffff", "efe", "fffd", "fdf", "r343"}, {"ffff", "efe", "fffd", "fdf", "r343"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qqinnerlayout);

        ExpandableListAdapter ela = new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return a.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return a[groupPosition].length();
            }

            @Override
            public Object getGroup(int groupPosition) {
                return a[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return b[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LayoutInflater l=LayoutInflater.from(QQInnerLayout.this);
                View v=l.inflate(android.R.layout.simple_expandable_list_item_1,null);
                TextView tv= (TextView) v.findViewById(android.R.id.text1);
                tv.setPadding(90,0,0,0);
                tv.setText(a[groupPosition]);
                return v;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                LayoutInflater li = LayoutInflater.from(QQInnerLayout.this);
                View v = li.inflate(android.R.layout.simple_list_item_1,null);
                TextView tv = (TextView) v.findViewById(android.R.id.text1);
                tv.setPadding(190,0,0,0);
                tv.setText(b[groupPosition][childPosition]);
                return tv;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return childId;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return groupId;
            }

        };
        ExpandableListView view = (ExpandableListView) findViewById(R.id.expendablelist);
        view.setAdapter(ela);
    }


}
