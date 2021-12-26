package com.example.player;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

public class SearchMusicActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_search_back;   //返回

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_music);
        iv_search_back=findViewById(R.id.iv_search_back);
        setupView();
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_search_back:
                this.finish();   //返回到主界面
                break;
        }
    }

    private void setupView(){
        iv_search_back.setOnClickListener(this);
    }
}
