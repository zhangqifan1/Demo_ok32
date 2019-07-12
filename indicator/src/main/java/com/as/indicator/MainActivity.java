package com.as.indicator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.as.indicator.xiaoguo.Xiaoguo0Activity;
import com.as.indicator.xiaoguo.Xiaoguo1Activity;
import com.as.indicator.xiaoguo.Xiaoguo2Activity;
import com.as.indicator.xiaoguo.Xiaoguo3Activity;
import com.as.indicator.xiaoguo.Xiaoguo4Activity;
import com.as.indicator.xiaoguo.Xiaoguo5Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but0 = findViewById(R.id.but0);
        Button but1 = findViewById(R.id.but1);
        Button but2 = findViewById(R.id.but2);
        Button but3 = findViewById(R.id.but3);
        Button but4 = findViewById(R.id.but4);
        Button but5 = findViewById(R.id.but5);

        but0.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but0:
                Intent intent0 = new Intent(MainActivity.this, Xiaoguo0Activity.class);
                startActivity(intent0);
                break;
            case R.id.but1:
                Intent intent1 = new Intent(MainActivity.this, Xiaoguo1Activity.class);
                startActivity(intent1);
                break;
            case R.id.but2:
                Intent intent2 = new Intent(MainActivity.this, Xiaoguo2Activity.class);
                startActivity(intent2);
                break;
            case R.id.but3:
                Intent intent3 = new Intent(MainActivity.this, Xiaoguo3Activity.class);
                startActivity(intent3);
                break;
            case R.id.but4:
                Intent intent4 = new Intent(MainActivity.this, Xiaoguo4Activity.class);
                startActivity(intent4);
                break;
            case R.id.but5:
                Intent intent5 = new Intent(MainActivity.this, Xiaoguo5Activity.class);
                startActivity(intent5);
                break;
            default:
                break;
        }
    }
}
