package com.example.player;

import android.content.Intent;
import android.view.MenuItem;


public class NaviMenuExecutor {
    private MusicActivity activity;

    public NaviMenuExecutor(MusicActivity activity) {
        this.activity = activity;
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                startActivity(SettingActivity.class);
                return true;
            case R.id.action_robot:
                startActivity(RobotActivity.class);
                break;
            case R.id.action_about:
                startActivity(AboutActivity.class);
                return true;
            case R.id.action_exit:
                activity.finish();
                return true;

        }
        return false;
    }

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }


}
