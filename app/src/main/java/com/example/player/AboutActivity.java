package com.example.player;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_back;          //返回

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
//        addPreferencesFromResource(R.xml.preference_setting);
        iv_back=findViewById(R.id.iv_back);

        AboutFragment aboutFragment = new AboutFragment();
        getFragmentManager().beginTransaction().replace(R.id.ll_fragment_container,aboutFragment).commit();
        setupView();
    }

    public static class AboutFragment extends PreferenceFragment {
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference_about);
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
