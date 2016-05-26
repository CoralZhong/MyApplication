package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-24.
 */
public class Dictionary extends Activity {
    String[] str = {"access", "apple", "ambulance", "successful", "generation", "accent", "adopt", "boot"};


    List<String> result;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary);
        ListView lv = (ListView) findViewById(R.id.showlist);
        result = new ArrayList<String>();
        ad = new ArrayAdapter(Dictionary.this, android.R.layout.simple_list_item_1, result);
        lv.setAdapter(ad);
        SearchView sv = (SearchView) findViewById(R.id.search);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                int len = newText.length();
                result.clear();
                for (int i = 0; i < str.length; i++) {
                    if(str[i].length()>=newText.length()){
                        if (str[i].substring(0, len).equals(newText)) {
                            result.add(str[i]);
                        }
                    }else{
                        result.clear();
                    }

                }

                ad.notifyDataSetChanged();
                return true;
            }
        });


    }
}
