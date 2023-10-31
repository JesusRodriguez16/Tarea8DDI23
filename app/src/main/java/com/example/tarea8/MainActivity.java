package com.example.tarea8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.NotificationManager;

public class MainActivity extends AppCompatActivity {

    static final String CANAL_ID = "mi_canal";
    NotificationManager notificationManager;
    public final static String Notification_Group = "grupo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionState = ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS);
        if(permissionState == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
        }

        notificationManager = (NotificationManager)  getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(
                    CANAL_ID, "Mis Notifiaciones", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Descripcion del canal");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long []{0,100,300,100});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String s = "Texto largo para completar la tarea 8";
                 NotificationCompat.Builder noti =
                         new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                 .setContentTitle("Notificacion 1")
                                 .setStyle(new NotificationCompat.BigTextStyle().bigText(s+s+s+s+s))
                                 .setSmallIcon(R.mipmap.ic_launcher)
                                 .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.cazadornw))
                                 .setGroup(Notification_Group);
                 notificationManager.notify(1, noti.build());

                 NotificationCompat.Builder noti2 =
                         new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                 .setContentTitle("Notificacion 2")
                                 .setStyle(new NotificationCompat.BigTextStyle().bigText(s+s+s+s+s))
                                 .setSmallIcon(R.mipmap.ic_launcher)
                                 .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.cazadornw))
                                 .setGroup(Notification_Group);
                 notificationManager.notify(2, noti2.build());

                 NotificationCompat.Builder noti3 =
                         new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                 .setContentTitle("Notificacion 3")
                                 .setStyle(new NotificationCompat.BigTextStyle().bigText(s+s+s+s+s))
                                 .setSmallIcon(R.mipmap.ic_launcher)
                                 .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.cazadornw))
                                 .setGroup(Notification_Group);
                 notificationManager.notify(3, noti3.build());

                 NotificationCompat.Builder noti4 =
                         new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                 .setContentTitle("Notificacion 4")
                                 .setStyle(new NotificationCompat.BigTextStyle().bigText(s+s+s+s+s))
                                 .setSmallIcon(R.mipmap.ic_launcher)
                                 .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.cazadornw))
                                 .setGroup(Notification_Group)
                                 .setGroupSummary(true);
                 notificationManager.notify(4, noti4.build());

             }
         }
        );


    }
}