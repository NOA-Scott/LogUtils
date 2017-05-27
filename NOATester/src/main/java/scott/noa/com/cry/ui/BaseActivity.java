package scott.noa.com.cry.ui;

import android.bluetooth.BluetoothGatt;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.Collections;

import scott.noa.com.cry.R;
import scott.noa.com.cry.bean.SensorEntity;
import scott.noa.com.cry.bluetooth.ServiceCallback;
import scott.noa.com.cry.service.BluetoothBleService;

/**
 * Created by scottwang on 17/5/5.
 */

public abstract class BaseActivity extends Base implements ServiceCallback {

    protected final String TAG = BaseActivity.class.getName();
    protected SharedPreferences prefs;
    protected SensorEntity entity = new SensorEntity();
    protected Handler handler = new Handler();
    protected String type;


    protected BluetoothBleService mService;

    @Override
    protected void onStart() {
        super.onStart();
        entity.setEnabled(false);
        String name = prefs.getString("name",type);
        int rssi = prefs.getInt("rssi",100);
        entity.setFilter("Filter Name:"+name+"   Rssi:-"+rssi);
        Intent service = new Intent(this, BluetoothBleService.class);
        bindService(service, connection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mService.setCallback(null);
        handler.removeCallbacks(runnable);
        unbindService(connection);
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ((BluetoothBleService.LocalBinder) service).getService();
            mService.setCallback(BaseActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }


    public class Handlers {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.start: {
                    Log.e(TAG,"--->  start "+type);
                    entity.setEnabled(true);
                    if (mService!=null){
                        mService.scan(prefs.getString("name",type),null,-prefs.getInt("rssi",100));
                    }
                    break;
                }
                case R.id.stop: {
                    Log.e(TAG,"--->  stop"+type);
                    if(entity.getId()!=0){
                        stop();
                    }
                    break;
                }
            }
        }
    }


    public void stop(){
        handler.removeCallbacks(runnable);
        if(savaSD(type)){
            Log.e(TAG,"保存成功...");
        }else{
            Log.e(TAG,"保存失败...");
        }
        entity.setId(0);
        entity.setRssi(0);
        entity.setBattery(0);
        entity.setLeft(0);
        entity.setRight(0);
        entity.setV(0);
        entity.setMac(null);
        entity.setData(null);
        entity.setState(true);
        entity.setDesc(null);
        entity.setName(null);
        handler.removeCallbacks(runnable);
        entity.setEnabled(true);
    }

    public boolean savaSD(String type){
        boolean b = false;
        switch (type){
            case "Cashew":{
                StringBuffer sb=new StringBuffer();
                sb.append(entity.getId());
                sb.append(",");
                sb.append(entity.getName());
                sb.append(",");
                sb.append(entity.getMac());
                sb.append(",");
                sb.append(entity.getRssi());
                sb.append(",");
                sb.append(entity.getBattery());
                sb.append(",");
                sb.append(entity.isState()?"fingerprint testing ok":"...");
                b = folder(type,sb);
            }
        }
        return b;
    }


    Runnable runnable= new Runnable() {
        @Override
        public void run() {
            mService.readRssi();
            handler.postDelayed(this,5*1000);
        }
    };



    @Override
    public void log(String log) {
        entity.setLog(log);
    }

    @Override
    public void onConnectionStateChange(int newState, BluetoothGatt gatt) {
        if(newState == BluetoothGatt.STATE_CONNECTED){

        }else {
            if(entity.getId()!=0){
                stop();
            }

            if (mService!=null){
                mService.scan(type,null,-prefs.getInt("rssi",100));
            }
        }
    }


    @Override
    public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
        Log.e(TAG,"onCharacteristicRead    rssi:"+rssi);
        entity.setRssi(rssi);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:{
                Intent intent = new Intent(this,FilterActivity.class);
                intent.putExtra("type",type);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
