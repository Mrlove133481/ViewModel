package com.mrlove.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    TextView textView;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView2);
        //官方已经弃用
        // myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        //获取实例对象
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        textView.setText(String.valueOf(myViewModel.num));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.num++;
                textView.setText(String.valueOf(myViewModel.num));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.num += 2;
                textView.setText(String.valueOf(myViewModel.num));
            }
        });
    }
}
