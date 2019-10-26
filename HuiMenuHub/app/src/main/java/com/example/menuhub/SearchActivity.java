package com.example.menuhub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private GoodAdapter mHomeAdapter;
    private ArrayList<MenuHub> dataList = new ArrayList<>();
    private EditText etName;
    public void setTitle(String title) {
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Search");
        mRecyclerview = findViewById(R.id.recyclerview);
        etName = findViewById(R.id.et_name);
        LinearLayoutManager footManager = new LinearLayoutManager(this);
        footManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(footManager);
        mHomeAdapter = new GoodAdapter(this, dataList);
        mRecyclerview.setAdapter(mHomeAdapter);
        findViewById(R.id.bt_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
        mHomeAdapter.setOnItemClickListener(new GoodAdapter.ItemClickListener() {
            @Override
            public void setOnItemClickListener(int position) {
                Intent intent = new Intent(SearchActivity.this,ImageActivity.class);
                intent.putExtra("data",dataList.get(position));
                startActivity(intent);
            }
        });
    }
    private void getData() {
        String keyword = etName.getText().toString();
        if (TextUtils.isEmpty(keyword)){
            return;
        }
        List<MenuHub> list = DataSupport.findAll(MenuHub.class);
        dataList.clear();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.contains(keyword)||list.get(i).name.equals(keyword)){
                dataList.add(list.get(i));
            }
        }
        mHomeAdapter.notifyDataSetChanged();
    }

}
