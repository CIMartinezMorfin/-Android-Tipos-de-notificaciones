package com.example.lap_lenovo.app5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //lista de  cosas globales
    NotificationManager manager;
    NotificationCompat.Builder notificacion1;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        lista=(ListView)findViewById(R.id.listView);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mostrarNotificacion(i);
            }
        });
    }
    public void mostrarNotificacion(int i){
        Notification miNotificacion= new Notification(R.mipmap.ic_launcher,"hola mundo",Notification.PRIORITY_HIGH);
        switch(i){
            case 0: {
                notificacion1 = new NotificationCompat.Builder(getApplicationContext());
                notificacion1.setContentTitle("Titulo de notificacion1");
                notificacion1.setContentText("hola munda notificacion 1");
                notificacion1.setSmallIcon(R.mipmap.ic_launcher);
                notificacion1.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                notificacion1.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                notificacion1.setTicker("texto 1");
                Intent mismaActivity = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent intent =
                        PendingIntent.getActivity(getApplicationContext(),
                                1,
                                mismaActivity,
                                PendingIntent.FLAG_ONE_SHOT);
                notificacion1.setContentIntent(intent);
                manager.notify(10, notificacion1.build());

            } break;

            case 1: {
                notificacion1 = new NotificationCompat.Builder(getApplicationContext());
                notificacion1.setContentTitle("Titulo de notificacion2");
                notificacion1.setContentText("hola munda notificacion 2");
                notificacion1.setSmallIcon(R.mipmap.ic_launcher);
                notificacion1.setSound(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ringtone));
                notificacion1.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                notificacion1.setTicker("texto 2");
                Intent mismaActivity = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent intent =
                        PendingIntent.getActivity(getApplicationContext(),
                                1,
                                mismaActivity,
                                PendingIntent.FLAG_ONE_SHOT);
                notificacion1.setContentIntent(intent);

                NotificationCompat.BigTextStyle estilo=new NotificationCompat.BigTextStyle(notificacion1);
                estilo.setSummaryText("ESto es un resumen");
                estilo.setBigContentTitle("ESte es un Titulo");
                estilo.bigText("ESte es un texto largo que se puede repetir" +
                        "ESte es un texto largo que se puede repetir" +
                        "ESte es un texto largo que se puede repetir" +
                        "ESte es un texto largo que se puede repetir");

                manager.notify(20, estilo.build());

            }break;

            case 2: {
                notificacion1 = new NotificationCompat.Builder(getApplicationContext());
                notificacion1.setContentTitle("Titulo de notificacion2");
                notificacion1.setContentText("hola munda notificacion 2");
                notificacion1.setSmallIcon(R.mipmap.ic_launcher);
                notificacion1.setSound(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ringtone));
                notificacion1.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                notificacion1.setTicker("texto 2");
                Intent mismaActivity = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent intent =
                        PendingIntent.getActivity(getApplicationContext(),
                                1,
                                mismaActivity,
                                PendingIntent.FLAG_ONE_SHOT);
                notificacion1.setContentIntent(intent);
                notificacion1.setAutoCancel(true);
                NotificationCompat.BigPictureStyle estilo=new NotificationCompat.BigPictureStyle(notificacion1);
                Bitmap imagen= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round);
                estilo.bigPicture(imagen);
                estilo.setBigContentTitle("titulo de la notificacion 3");
                estilo.setSummaryText("resumen");
                estilo.bigLargeIcon(imagen);

                manager.notify(30, estilo.build());

            }break;

            case 3: {
                notificacion1 = new NotificationCompat.Builder(getApplicationContext());
                notificacion1.setContentTitle("Titulo de notificacion1");
                notificacion1.setContentText("hola munda notificacion 1");
                notificacion1.setSmallIcon(R.mipmap.ic_launcher);
                notificacion1.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
                notificacion1.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                notificacion1.setTicker("texto 1");
                Intent mismaActivity = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent intent =
                        PendingIntent.getActivity(getApplicationContext(),
                                1,
                                mismaActivity,
                                PendingIntent.FLAG_ONE_SHOT);
                notificacion1.addAction(android.R.drawable.ic_input_delete,"misma activity",intent);
                Intent nuevaActivity=new Intent(MainActivity.this,MainActivity2.class);
                PendingIntent intent2 =
                        PendingIntent.getActivity(getApplicationContext(),
                                1,
                                nuevaActivity,
                                PendingIntent.FLAG_ONE_SHOT);
                notificacion1.addAction(android.R.drawable.ic_menu_add,
                        "nueva activity",
                        intent2);
                notificacion1.setContentIntent(intent);
                manager.notify(40, notificacion1.build());

            } break;

        }
    }
    class Prueba{
        private Prueba (){} //constructor
        Prueba creaUnUnicoObjeto(){
            return new Prueba();
        }

    }
}
