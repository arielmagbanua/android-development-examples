package com.arielmagbanua.userinterface;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";
    public static final String MAIN_NOTIFICATION_CHANNEL_ID = "MainActivity.channelID";
    public static final int MAIN_NOTIFICATION_ID = 1;
    public static final String MAIN_NOTIFICATION_CHANNEL_NAME = "MainActivity_notification";
    public static final String MAIN_NOTIFICATION_DESCRIPTION = "MainActivity notification channel.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get all the buttons
        Button showNotificationButton = findViewById(R.id.show_notification);
        Button showToastButton = findViewById(R.id.show_toast);
        Button showDialogButton = findViewById(R.id.show_dialog);
        Button showLayoutsDemoButton = findViewById(R.id.show_layouts_demo);

        // Implement listeners here
        showNotificationButton.setOnClickListener(this);
        showDialogButton.setOnClickListener(this);
        showLayoutsDemoButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_send:
                Log.d(TAG, "menu_send is clicked!");
                return true;
            case R.id.menu_settings:
                Log.d(TAG, "menu_settings is clicked!");
                return true;
            case R.id.menu_delete:
                Log.d(TAG, "menu_delete is clicked!");
                return true;
        }

        return false;
    }

    public void showToast(View view){
        Toast.makeText(this, "Advance Thinker!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.show_dialog:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("Sample Dialog");
                builder.setMessage("Are you an advance thinker?");
                /*
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Positive button clicked!", Toast.LENGTH_SHORT).show();

                        // Your logic here...
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Negative button clicked!", Toast.LENGTH_SHORT).show();

                        // Your logic here...
                    }
                });
                builder.setNeutralButton("Meh...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Neutral button clicked!", Toast.LENGTH_SHORT).show();

                        // Your logic here...
                    }
                });
                */

                builder.setPositiveButton("Ok", dialogListener);
                builder.setNegativeButton("Cancel", dialogListener);
                builder.setNeutralButton("Neutral", dialogListener);

                builder.show();
                break;

            case R.id.show_layouts_demo:

                Intent intent = new Intent(this, LayoutsDemoActivity.class);
                startActivity(intent);

                break;

            case R.id.show_notification:

                showNotification("Notification Title", "Notification Message");

                break;
        }
    }

    private DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    Toast.makeText(MainActivity.this, "Positive button clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    Toast.makeText(MainActivity.this, "Negative button clicked!", Toast.LENGTH_SHORT).show();
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    Toast.makeText(MainActivity.this, "Neutral button clicked!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private void showNotification(String title, String message) {
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this, MAIN_NOTIFICATION_CHANNEL_ID);
        notifBuilder.setSmallIcon(R.mipmap.ic_launcher_round); // set the small icon of the notification
        notifBuilder.setContentTitle(title); // set the title
        notifBuilder.setContentText(message); // set the content text
        notifBuilder.setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

        // This is to make the notification a heads-up notification
        notifBuilder.setDefaults(Notification.DEFAULT_ALL);
        notifBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);

        // For Oreo and above
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(MAIN_NOTIFICATION_CHANNEL_ID, MAIN_NOTIFICATION_CHANNEL_NAME, importance);
            channel.setDescription(MAIN_NOTIFICATION_DESCRIPTION);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            channel.setShowBadge(false);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(MAIN_NOTIFICATION_ID, notifBuilder.build());
        } else {
            // show the notification
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(MAIN_NOTIFICATION_ID, notifBuilder.build());
        }
    }
}
