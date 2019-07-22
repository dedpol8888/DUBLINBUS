package com.example.myapplication;
//new code//
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
//new code//

public class MainActivity extends AppCompatActivity {
    //newcode//
    private static final String  CHANNEL_ID ="SIMPLIFIED_CODING";
    private static final String  CHANNEL_name ="SIMPLG";
    private static final String  CHANNEL_desc ="SIMPLIF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel(CHANNEL_ID,CHANNEL_name, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_desc);
            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        findViewById(R.id.buttonNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNotification();
            }


        });
    }

    private void displayNotification(){
        NotificationCompat.Builder mBuilder=
                new NotificationCompat.Builder(this,CHANNEL_ID )
        .setSmallIcon(R.drawable.ic_transfer)
        .setContentTitle("working")
        .setContentText("notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat mNotificationMgr= NotificationManagerCompat.from(this);
        mNotificationMgr.notify(1, mBuilder.build());

    }
    //newcode//
}
