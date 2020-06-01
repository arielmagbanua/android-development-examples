package com.arielmagbanua.datastoragedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String allowNotificationKey = getResources().getString(R.string.allow_notification_key);
        boolean allowNotification = sharedPreferences.getBoolean(allowNotificationKey,false);

        String allowMobileDataKey = getResources().getString(R.string.allow_mobile_data_key);
        boolean allowMobileData = sharedPreferences.getBoolean(allowMobileDataKey, false);

        String allowScreenRotationKey = getResources().getString(R.string.allow_screen_rotation_key);
        boolean allowScreenRotation = sharedPreferences.getBoolean(allowScreenRotationKey, false);

        String numberOfItemsKey = getResources().getString(R.string.number_items_key);
        String numberOfItems = sharedPreferences.getString(numberOfItemsKey, "0");
        int number = Integer.parseInt(numberOfItems);

        String dataRefreshKey = getResources().getString(R.string.data_refresh_key);
        String dataRefresh = sharedPreferences.getString(dataRefreshKey, "0");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(allowNotificationKey, false);
        editor.commit();

        Log.d("test", "test");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_mennu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.settings){
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
        }

        return true;
    }
}
