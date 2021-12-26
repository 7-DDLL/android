package com.example.player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.player.utils.MusicUtils;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {

    protected Handler handler;
    private MusicActivity activity;

    private DrawerLayout drawerLayout;  //抽屉布局
    private ImageView iv_menu;          //侧边栏
    private ImageView iv_search;        //搜索
    private FrameLayout fl_play_bar;    //歌曲栏
    private boolean isPlayFragmentShow; //判断歌曲页面是否出现
    private ViewPager mViewPager;
    private TextView tv_local_music;    //本地音乐
    private TextView tv_music_list;     //我的歌单

    private View vNavigationHeader;
    private NaviMenuExecutor naviMenuExecutor;
    private NavigationView navigation_view;  //抽屉菜单

    private View action_setting;

    //本地扫描授权
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private static int REQUEST_PERMISSION_CODE = 1;

    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        drawerLayout=findViewById(R.id.drawer_layout);
        iv_menu=findViewById(R.id.iv_menu);
        iv_search=findViewById(R.id.iv_search);
        fl_play_bar=findViewById(R.id.fl_play_bar);
        tv_local_music=findViewById(R.id.tv_local_music);
        tv_music_list=findViewById(R.id.tv_music_list);

        navigation_view=findViewById(R.id.navigation_view);

        action_setting=findViewById(R.id.action_setting);
        setupView();

        init();

        //本地扫描
        /*getWindow().setFormat(PixelFormat.TRANSLUCENT);
       *//* if (Build.VERSION.SDK_INT >= 23) {//6.0才用动态权限
            initPermission();
        } else {
            initView();
        }*//*


        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
            initView();
        }*/



    }

    //本地扫描
    /*public void initView() {
        mediaPlayer=new MediaPlayer();

        setContentView(R.layout.activity_main);
        ListView mListView = (ListView) findViewById(R.id.main_listview);
        list = new ArrayList<>();
        //把扫描到的音乐赋值给list
        list = MusicUtils.getMusicData(this);
        adapter = new MyAdapter(this,list);
        mListView.setAdapter((ListAdapter) adapter);
    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_menu:
                drawerLayout.openDrawer(GravityCompat.START);   //显示抽屉布局
                break;
            case R.id.iv_search:
                startActivity(new Intent(this, SearchMusicActivity.class)); //跳转搜索页面
                break;
            case R.id.fl_play_bar:
                startActivity(new Intent(this, InformationActivity.class));  //展示歌曲详情页
                break;
            case R.id.tv_local_music:
                mViewPager.setCurrentItem(0);   //本地音乐页
                break;
            case R.id.tv_music_list:
                mViewPager.setCurrentItem(1);   //歌单列表页
                break;
            case R.id.iv_play_bar_cover:
                startActivity(new Intent(this, InformationActivity.class));   //歌曲详情页
                break;

        }
    }




    private void setupView(){
        vNavigationHeader = LayoutInflater.from(this).inflate(R.layout.navigation_header, navigation_view, false);
        navigation_view.addHeaderView(vNavigationHeader);

        iv_menu.setOnClickListener(this);   //点击列表
        iv_search.setOnClickListener(this); //点击搜索
        fl_play_bar.setOnClickListener(this); //点击歌曲栏
        tv_local_music.setOnClickListener(this);    //点击本地音乐
        tv_music_list.setOnClickListener(this); //点击我的歌单
        navigation_view.setNavigationItemSelectedListener(this);    //显示抽屉菜单

    }

    private void showPlayingFragment() {
        if (isPlayFragmentShow) {
            return;
        }

        isPlayFragmentShow = true;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
//        handler.postDelayed(() -> item.setChecked(false), 500);
        switch (item.getItemId()) {
            case R.id.action_setting:
                startActivity(new Intent(this, SettingActivity.class)); //跳转设置页面
                return true;
            case R.id.action_robot:
                startActivity(new Intent(this, RobotActivity.class));
                break;
            case R.id.action_about:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            case R.id.action_exit:
                activity.finish();
                return true;
        }
        return false;
//        return naviMenuExecutor.onNavigationItemSelected(item);
    }


    ArrayList<Song> list=new ArrayList();
    public void init(){
        list.add(new Song(R.drawable.default_cover,"脆弱少女组","失去尼欧"));
        list.addAll(list);

    }


}