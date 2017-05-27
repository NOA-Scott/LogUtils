package scott.noa.com.cry.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/**
 * Created by noalabs on 2017/5/12.
 */

public interface ServiceCallback {
    void log(String log);

    void onConnectionStateChange(int newState, BluetoothGatt gatt);

    void onServicesDiscovered(BluetoothGatt gatt, int status);

    void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status);

    void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic);

    void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status);

    void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status);
}
