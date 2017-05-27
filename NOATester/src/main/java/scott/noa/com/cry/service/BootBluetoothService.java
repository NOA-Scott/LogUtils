package scott.noa.com.cry.service;

import android.app.Service;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import scott.noa.com.cry.bluetooth.ServiceCallback;

/**
 * Create date：17/5/11 on 上午3:55
 * Description:
 * Author:Scott Wang
 */
public class BootBluetoothService extends Service implements ServiceCallback {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent service = new Intent(this.getApplicationContext(),BluetoothBleService.class);
        this.bindService(service, connection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BluetoothBleService ss = ((BluetoothBleService.LocalBinder)service).getService();
            ss.setCallback(BootBluetoothService.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void log(String log) {

    }

    @Override
    public void onConnectionStateChange(int newState, BluetoothGatt gatt) {

    }

    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {

    }

    @Override
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {

    }

    @Override
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {

    }

    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status){

    }

    @Override
    public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {

    }
}
