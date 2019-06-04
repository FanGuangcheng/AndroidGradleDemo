package com.wenman.androidgradledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click tv name!!!", Toast.LENGTH_LONG).show();
                testMakeException();
            }
        });

    }

    private void testMakeException() {
        String str = "";
        if (str.length() != 0) {
            Log.d("MainActivity", "str length is :" + str.length());
        } else {
            Log.d("MainActivity", "str length is empty~!");
        }
    }
}
