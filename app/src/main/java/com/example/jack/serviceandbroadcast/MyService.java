package com.example.jack.serviceandbroadcast;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.NotificationCompat;

/**
 * 位置：
 * 作用：
 * 时间：2017/6/20
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
    public class MyBinder extends Binder
    {
        public void connService()
        {
        }
        public void NotifiStart()
        {
            Intent intent=new Intent(MyService.this,MainActivity.class);
            PendingIntent pi=PendingIntent.getActivity(MyService.this,0,intent,0);
            Notification notifi=new NotificationCompat.Builder(MyService.this)
                    .setContentTitle("我他妈看今天谁敢念诗")
                    .setContentText("苟利国家生死以，岂因福祸避趋之！")
                    .setSmallIcon(R.mipmap.rt)
                    .setContentIntent(pi)
                    .build();
            startForeground(1,notifi);


            Intent intent1=new Intent("notifi");
            LocalBroadcastManager.getInstance(MyService.this).sendBroadcast(intent1);
        }
        public void NotifiStop()
        {

            Intent intent2=new Intent("stopN");
            LocalBroadcastManager.getInstance(MyService.this).sendBroadcast(intent2);
            stopForeground(true);

        }
    }
}
