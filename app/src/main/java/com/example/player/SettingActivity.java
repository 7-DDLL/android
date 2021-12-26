package com.example.player;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class SettingActivity extends  AppCompatActivity implements View.OnClickListener{
    private DrawerLayout drawerLayout;  //抽屉布局
    private ImageView iv_back;          //返回
    private View vNavigationHeader;
    private NavigationView navigation_view;  //抽屉菜单
    private SettingActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        drawerLayout=findViewById(R.id.drawer_layout);
        iv_back=findViewById(R.id.iv_back);
        navigation_view=findViewById(R.id.navigation_view);

        SettingFragment settingFragment = new SettingFragment();
        getFragmentManager().beginTransaction().replace(R.id.ll_fragment_container, settingFragment).commit();
        setupView();
    }

    public static class SettingFragment extends PreferenceFragment{
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference_setting);
        }

    }

    private void setupView(){
//        vNavigationHeader = LayoutInflater.from(this).inflate(R.layout.navigation_header, navigation_view, false);
//        navigation_view.addHeaderView(vNavigationHeader);

        iv_back.setOnClickListener(this);   //点击返回
//        navigation_view.setNavigationItemSelectedListener(this);    //显示抽屉菜单

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_back:
//                drawerLayout.openDrawer(GravityCompat.START);   //显示抽屉布局
//                startActivity(new Intent(this, MusicActivity.class)); //跳转设置页面
                this.finish();
                break;


        }
    }


}
