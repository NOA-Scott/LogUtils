package scott.noa.com.cry.bluetooth.scan;

import android.bluetooth.BluetoothDevice;

/**
 * Created by noalabs on 2017/5/12.
 */

public interface ScanCallback {
    void scanMode(String name,String uuid,int mode);
    void scan(BluetoothDevice device, int rssi, byte[] scanRecord);
}
