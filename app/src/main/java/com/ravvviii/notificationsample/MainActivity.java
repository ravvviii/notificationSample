package com.ravvviii.notificationsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String CHANNEL_ID = "my_Channnel";
    public static final int NOTIFICATION_ID = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.dbms, null);

        BitmapDrawable bitmapdrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapdrawable.getBitmap();

        Notification notification;
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this).setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.notifi).setContentText("Run out of storage")
                    .setSubText(" New Message")
                    .setChannelId(CHANNEL_ID).build();

            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "NEW cHANNEL", NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification = new Notification.Builder(this).setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.dbms).setContentText("Neww Message")
                    .setSubText("Run out of storage")
                    .build();

        }

        nm.notify(NOTIFICATION_ID, notification);
    }
}