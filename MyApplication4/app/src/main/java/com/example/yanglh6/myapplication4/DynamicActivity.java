package com.example.yanglh6.myapplication4;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lenovo on 2016/10/21.
 */

public class DynamicActivity extends AppCompatActivity {
    private boolean tag = false;
    private DynamicReceiver dynamicReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_layout);

        final Button buttonRegister = (Button) findViewById(R.id.register);
        Button buttonSend = (Button) findViewById(R.id.send);

        buttonRegister.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tag) {
                    buttonRegister.setText("Unregister Broadcast");
                    tag = true;
                    dynamicReceiver = new DynamicReceiver();
                    IntentFilter dynamic_filter = new IntentFilter();
                    dynamic_filter.addAction("com.example.yanglh6.myapplication4.dynamicreceiver");
                    registerReceiver(dynamicReceiver, dynamic_filter);
                } else {
                    buttonRegister.setText("Register Broadcast");
                    tag = false;
                    unregisterReceiver(dynamicReceiver);
                }
            }
        });

        buttonSend.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tag) {

                } else {
                    Intent intent = new Intent("com.example.yanglh6.myapplication4.dynamicreceiver");
                    String str1 = "";
                    EditText editText = (EditText) findViewById(R.id.editText);
                    str1 = editText.getText().toString();
                    intent.putExtra("ItemImage", R.mipmap.dynamic);
                    intent.putExtra("name", str1);
                    sendBroadcast(intent);
                }
            }
        });
    }
}
