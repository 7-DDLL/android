package com.example.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener {
    private InformationActivity activity;
    private ImageView iv_back_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_play);
        iv_back_list=findViewById(R.id.iv_back_list);

        setupView();

    }

    private void setupView(){

        iv_back_list.setOnClickListener(this); //点击我的歌单

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_list:
                this.finish();
                break;
        }
    }
}
