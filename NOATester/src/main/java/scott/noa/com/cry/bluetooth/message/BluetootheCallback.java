package scott.noa.com.cry.bluetooth.message;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/**
 * Created by scottwang on 17/5/10.
 */

public interface BluetootheCallback {
    enum Type{
        Write,
        B,
        C,
        D
    }

    void invoke(String msg);

    void onConnectionStateChange(int newState,BluetoothGatt gatt);

    void onServicesDiscovered(BluetoothGatt gatt, int status);

    void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status);

    void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic);

    void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status);

    void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status);
}
