package com.mobiloitte.friendsierunnerapp.firebase;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FireBaseMessageService extends FirebaseMessagingService {

    private static final String TAG = "MyFireBaseMsgService";
   /* private NotificationParseModel model = new NotificationParseModel();*/


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

       /* Log.e(TAG,getString(R.string.remote_message)+remoteMessage);
        Log.e(TAG, getString(R.string.from) + remoteMessage.getFrom());
        Log.e(TAG,getString(R.string.remote_message_data)+remoteMessage.getData());*/
        sendNotification();
    }

    private void sendNotification() {

   /*     Intent intent=new Intent(getApplicationContext(), ActivitySplash.class);
        int notificationId = 0;
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), notificationId *//* Request code *//*, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
*/
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
      /*  NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext())
                .setSmallIcon(getNotificationIcon())
                .setContentTitle(getString(R.string.rennam))
                .setContentText(model.message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);*/

       /* NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId , notificationBuilder.build());*/
    }

    /*private int getNotificationIcon() {

        boolean useWhiteIcon = (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP);
        {
            return useWhiteIcon ? R.mipmap.icon_notification : R.mipmap.icon_notification;
        }

    }*/

}
