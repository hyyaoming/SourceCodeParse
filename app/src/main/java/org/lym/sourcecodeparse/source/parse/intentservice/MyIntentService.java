package org.lym.sourcecodeparse.source.parse.intentservice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * this is intentService Parse
 * <p>
 * Created by asus on 2018/3/3.
 */

public class MyIntentService extends IntentService {

    private LocalBroadcastManager mBroadCastManager;
    public static final String PROGRESS_COUNT = "progress";
    private static final String TAG = MyIntentService.class.getSimpleName();
    public static final String PROGRESS_ACTION = "progress_action";
    private int mCount;

    public MyIntentService() {
        super(TAG);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "IntentService onCreate");
        mBroadCastManager = LocalBroadcastManager.getInstance(getApplicationContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "IntentService OnDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "IntentService onBind");
        return super.onBind(intent);
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "IntentService OnStart");
    }


    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
        Log.d(TAG, "IntentService setIntentRedelivery");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "IntentService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandlerIntent");
        uploadImage();
    }

    private void uploadImage() {
        try {
            while (mCount < 100) {
                mCount++;
                Thread.sleep(50);
                sendCountBroadCast(mCount);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent(context, MyIntentService.class);
        context.startService(intent);
    }

    private void sendCountBroadCast(int mCount) {
        Intent intent = new Intent(PROGRESS_ACTION);
        intent.putExtra(PROGRESS_COUNT, mCount);
        mBroadCastManager.sendBroadcast(intent);
    }
}
