package scott.noa.com.cry.service;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import java.util.UUID;

import scott.noa.com.cry.bluetooth.ServiceCallback;
import scott.noa.com.cry.bluetooth.message.BluetootheCallback;
import scott.noa.com.cry.bluetooth.message.Peripheral;
import scott.noa.com.cry.bluetooth.scan.LegacyScanManager;
import scott.noa.com.cry.bluetooth.scan.LollipopScanManager;
import scott.noa.com.cry.bluetooth.scan.ScanCallback;
import scott.noa.com.cry.bluetooth.scan.ScanManager;

import static android.os.Build.VERSION_CODES.LOLLIPOP;

/**
 * Create date：17/5/11 on 上午3:55
 * Description:
 * Author:Scott Wang
 */
public class BluetoothBleService extends Service implements ScanCallback,BluetootheCallback {

    public static String TAG = BluetoothBleService.class.getName();

    public LocalBinder localBinder = new LocalBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    private ScanManager scanManager;

    public ServiceCallback callback;

    private Peripheral peripheral;


    public void setCallback(ServiceCallback callback){
        this.callback = callback;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= LOLLIPOP) {
            scanManager = new LollipopScanManager(this);
        } else {
            scanManager = new LegacyScanManager(this);
        }
    }

    @Override
    public void invoke(String msg) {
        callback.log(msg);
    }

    public class LocalBinder extends Binder {
        public BluetoothBleService getService() {
            // Return this instance of LocalService so clients can call public methods
            return BluetoothBleService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        if(peripheral!=null){
            scanManager.stopScan();
            peripheral.disconnect(this);
            peripheral=null;
        }
        return super.onUnbind(intent);
    }

    private int rssi = -100;

    public void scan(String name,String uuid,int rssi){
        this.rssi = rssi;
        //如果已经在scan 则stop
        scanManager.stopScan(name,uuid,this);
    }

    public void disConnected(){
        peripheral.disconnect(null);
    }

    public void disConnected(Context context){
        peripheral.disconnect(context);
    }

    @Override
    public void scanMode(String name,String uuid,int mode) {
        if(callback!=null){
            callback.log("开始扫描 ..........");
        }
        scanManager.scan(UUID.randomUUID(),name,this);
    }

    @Override
    public void scan(BluetoothDevice device, int rssi, byte[] scanRecord) {
        if(callback!=null && rssi>this.rssi){//满足条件 开始连接
            callback.log(device.getName()+"  "+device.getAddress()+"  "+rssi);
            scanManager.stopScan();
            if(peripheral==null){
                peripheral = new Peripheral();
                peripheral.connect(BluetoothBleService.this,device,BluetoothBleService.this);
            }
        }
    }

    public void readRssi(){
        peripheral.readRssi();
    }

    @Override
    public void onConnectionStateChange(int newState, BluetoothGatt gatt) {
        if(callback!=null){
            callback.onConnectionStateChange(newState,gatt);
            BluetoothDevice device = gatt.getDevice();
            if(newState == BluetoothGatt.STATE_CONNECTED){
                callback.log(device.getName()+" 设备连接成功，MAC:"+device.getAddress()+" 正在查找服务");
            }else{
                if(peripheral!=null){
                    callback.log(device.getName()+" 设备连接断开");
                    peripheral.disconnect(this);
                    peripheral=null;
                }
                gatt.disconnect();
                gatt.close();

            }
        }else{
            if(gatt!=null){
                gatt.disconnect();
                gatt.close();
                gatt=null;
            }
        }
    }

    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        BluetoothDevice device = gatt.getDevice();
        if(callback!=null){
            callback.onServicesDiscovered(gatt,status);
        }
        callback.log(device.getName()+" 发现服务, 开始注册notify");
    }

    @Override
    public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
        if(callback!=null){
            callback.onReadRemoteRssi(gatt,rssi,status);
        }
    }

    @Override
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        if(callback!=null){
            callback.onDescriptorWrite(gatt,descriptor,status);
        }
    }

    public void registerNotify(UUID serviceUUID, UUID characteristicUUID){
        peripheral.registerNotify(serviceUUID,characteristicUUID,BluetoothBleService.this);
    }

    public void write(UUID serviceUUID, UUID characteristicUUID,String data){
        byte[] datas = data.getBytes();
        peripheral.write(serviceUUID,characteristicUUID,datas,datas.length,3,BluetoothBleService.this, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
    }

    public void read(UUID serviceUUID, UUID characteristicUUID){
        peripheral.read(serviceUUID,characteristicUUID,BluetoothBleService.this);
    }

    @Override
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        if(callback!=null){
            callback.onCharacteristicChanged(gatt,characteristic);
        }
    }

    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status){
        if(callback!=null){
            callback.onCharacteristicRead(gatt,characteristic,status);
        }
    }
}
