package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.testapp.models.MidModel;
import com.example.testapp.models.MidModelList;
import com.example.testapp.models.Sort;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class DashboardActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initView();
        getData();
    }

    private void initView() {
        textView = findViewById(R.id.textview);
    }

    private void getData() {
        Resources resources = getResources();
        InputStream inputStream = resources.openRawResource(R.raw.json);
        Scanner scanner = new Scanner(inputStream);
        StringBuffer stringBuffer = new StringBuffer();
        while (scanner.hasNext()) {
            stringBuffer.append(scanner.nextLine());
        }
        pasingJson(stringBuffer.toString());
    }

    @SuppressLint("NotifyDataSetChanged")
    private void pasingJson(String s) {
        Gson gson = new Gson();
        MidModelList p = gson.fromJson(s, MidModelList.class);
        Log.e("p value", "" + p.getSort().size());
        /**
         * sort the array based on the mid
         */
        HashMap<String, ArrayList<Sort>> myProgram = new HashMap<>();
        for (int i = 0; i < p.getSort().size(); i++) {
            String date = p.getSort().get(i).getMid().toString();
            ArrayList<Sort> programList = myProgram.get(date);
            if (programList == null) {
                programList = new ArrayList<Sort>();
                myProgram.put(date, programList);
            }
            programList.add(p.getSort().get(i));
        }
        /**
         * group the items based on the mid values
         */
        ArrayList<MidModel> models = new ArrayList<>();
        Set<String> values = myProgram.keySet();
        for (String sss : values) {
            if (myProgram.containsKey(sss)) {
                ArrayList<Sort> sorts = myProgram.get(sss);
                MidModel midModel = new MidModel();
                midModel.id = sss;
                midModel.list = sorts;
                models.add(midModel);
            }
        }

        Log.e("here data", "" + models.size());
        MyListAdapter adapter = new MyListAdapter(models);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}