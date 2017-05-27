package scott.noa.com.cry.bluetooth.scan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;

import java.util.UUID;

/**
 * Created by scottwang on 17/5/10.
 */

public abstract class ScanManager {
    protected BluetoothAdapter bluetoothAdapter;
    protected Context context;
    public ScanManager(Context context){
        this.context = context;
    }

    protected BluetoothAdapter getBluetoothAdapter() {
        if (bluetoothAdapter == null) {
            android.bluetooth.BluetoothManager manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
            bluetoothAdapter = manager.getAdapter();
        }
        return bluetoothAdapter;
    }
    public abstract void stopScan();
    public abstract void stopScan(String name,String uuid,ScanCallback callback);

    public abstract void scan(UUID uuid, String name, ScanCallback callback);

}
