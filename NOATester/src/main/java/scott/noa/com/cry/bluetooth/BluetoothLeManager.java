package scott.noa.com.cry.bluetooth;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import scott.noa.com.cry.bluetooth.message.BluetootheCallback;
import scott.noa.com.cry.bluetooth.message.Peripheral;
import scott.noa.com.cry.bluetooth.scan.LegacyScanManager;
import scott.noa.com.cry.bluetooth.scan.LollipopScanManager;
import scott.noa.com.cry.bluetooth.scan.ScanManager;

import static android.os.Build.VERSION_CODES.LOLLIPOP;

/**
 * Created by scottwang on 17/5/8.
 */

public class BluetoothLeManager {

    public static final String LOG_TAG = BluetoothLeManager.class.getName();

    public Map<String, Peripheral> peripherals = new LinkedHashMap<>();

    private ScanManager scanManager;


    public void BluetoothLeManager() {

    }

    public ScanManager onScanManager(Context context) {
        if (Build.VERSION.SDK_INT >= LOLLIPOP) {
            scanManager = new LollipopScanManager(context);
        } else {
            scanManager = new LegacyScanManager(context);
        }
        return scanManager;
    }

    public void scan(UUID serviceUUIDs, final int scanSeconds, boolean allowDuplicates) {

    }

    public void stopScan(){

    }

    public void connect(){

    }

    public void disconnect(){

    }

    public void startNotification(String deviceUUID, String serviceUUID, String characteristicUUID, BluetootheCallback callback) {
        Log.d(LOG_TAG, "startNotification");

        Peripheral peripheral = peripherals.get(deviceUUID);
        if (peripheral != null){
            peripheral.registerNotify(UUIDHelper.uuidFromString(serviceUUID), UUIDHelper.uuidFromString(characteristicUUID),callback);
        } else {
            //callback.invoke("Peripheral not found");
        }
    }

    public void stopNotification(String deviceUUID, String serviceUUID, String characteristicUUID, BluetootheCallback callback) {
        Log.d(LOG_TAG, "stopNotification");

        Peripheral peripheral = peripherals.get(deviceUUID);
        if (peripheral != null){
            peripheral.removeNotify(UUIDHelper.uuidFromString(serviceUUID), UUIDHelper.uuidFromString(characteristicUUID), callback);
        } else{
            callback.invoke("Peripheral not found");
        }
    }

    public void read(String deviceUUID, String serviceUUID, String characteristicUUID,BluetootheCallback callback) {
        Log.d(LOG_TAG, "Read from: " + deviceUUID);
        Peripheral peripheral = peripherals.get(deviceUUID);
        if (peripheral != null){
            peripheral.read(UUIDHelper.uuidFromString(serviceUUID), UUIDHelper.uuidFromString(characteristicUUID),callback);
        } else {
            callback.invoke("Peripheral not found");
        }
    }

    public void writeWithoutResponse(String deviceUUID, String serviceUUID, String characteristicUUID, String message, Integer maxByteSize, Integer queueSleepTime,BluetootheCallback callback) {
        Log.d(LOG_TAG, "Write without response to: " + deviceUUID);

        Peripheral peripheral = peripherals.get(deviceUUID);
        if (peripheral != null){
            byte[] decoded = Base64.decode(message.getBytes(), Base64.DEFAULT);
            peripheral.write(UUIDHelper.uuidFromString(serviceUUID), UUIDHelper.uuidFromString(characteristicUUID), decoded, maxByteSize, queueSleepTime,callback, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        } else {
            callback.invoke("Peripheral not found");
        }
    }

    public void write(String deviceUUID, String serviceUUID, String characteristicUUID, String message, Integer maxByteSize, BluetootheCallback callback) {

        Peripheral peripheral = peripherals.get(deviceUUID);
        if (peripheral != null){
            byte[] decoded = Base64.decode(message.getBytes(), Base64.DEFAULT);
            peripheral.write(UUIDHelper.uuidFromString(serviceUUID), UUIDHelper.uuidFromString(characteristicUUID), decoded, maxByteSize, null, callback, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        } else{
            callback.invoke("Peripheral not found");
        }
    }

}
