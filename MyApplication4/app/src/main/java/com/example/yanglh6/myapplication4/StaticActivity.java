package com.example.yanglh6.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2016/10/21.
 */

public class StaticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.static_layout);

        final int[] stu_pic = {
                R.mipmap.apple,
                R.mipmap.banana,
                R.mipmap.cherry,
                R.mipmap.coco,
                R.mipmap.kiwi,
                R.mipmap.orange,
                R.mipmap.pear,
                R.mipmap.strawberry,
                R.mipmap.watermelon};

        final List<Map<String, Object>> data = new ArrayList<>();
        /*生成动态数组，加入数据*/
        final List<Fruit> ItemName = new ArrayList<Fruit>();
        ItemName.add(new Fruit("Apple"));
        ItemName.add(new Fruit("Banana"));
        ItemName.add(new Fruit("Cherry"));
        ItemName.add(new Fruit("Coco"));
        ItemName.add(new Fruit("Kiwi"));
        ItemName.add(new Fruit("Orange"));
        ItemName.add(new Fruit("Pear"));
        ItemName.add(new Fruit("Strawberry"));
        ItemName.add(new Fruit("Watermelon"));

        final String[] name = new String[ItemName.size()];
        for (int i = 0; i < ItemName.size(); i++) {
            String x = ItemName.get(i).getItemName();
            name[i] = x;
        }
        for (int i = 0; i < ItemName.size(); i++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put("ItemImage", stu_pic[i]);
            temp.put("name", name[i]);
            data.add(temp);
        }

        ListView listView = (ListView) findViewById(R.id.staticStart);
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.item,
                new String[]{"ItemImage", "name"}, new int[]{R.id.ItemImage, R.id.ItemName});
        listView.setAdapter(simpleAdapter);

        /*  ListView单击事件  */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent("com.example.yanglh6.myapplication4.staticreceiver");
                Fruit temp = ItemName.get(i);
                intent.putExtra("ItemImage", stu_pic[i]);
                intent.putExtra("name", name[i]);
                sendBroadcast(intent);
            }
        });

    }
}