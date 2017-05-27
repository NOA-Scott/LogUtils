package scott.noa.com.cry.bluetooth.scan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;

import java.util.UUID;

/**
 * Created by scottwang on 17/5/10.
 */

public class LegacyScanManager extends ScanManager {

    private ScanCallback callback;
    private String name;
    public LegacyScanManager(Context context) {
        super(context);
    }

    @Override
    public void stopScan() {
        getBluetoothAdapter().stopLeScan(mLeScanCallback);
    }

    @Override
    public void stopScan(String name,String uuid,ScanCallback callback) {
        int model = getBluetoothAdapter().getScanMode();
        if(model ==BluetoothAdapter.STATE_CONNECTING){
            getBluetoothAdapter().stopLeScan(mLeScanCallback);
        }
        callback.scanMode(name,uuid,model);
    }

    @Override
    public void scan(UUID uuid, String name, ScanCallback callback) {
        this.callback = callback;
        this.name = name;
        getBluetoothAdapter().startLeScan(mLeScanCallback);
    }

    private BluetoothAdapter.LeScanCallback mLeScanCallback =new BluetoothAdapter.LeScanCallback(){
        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            if(callback!=null){
                if(name==null) {
                    callback.scan(device, rssi, scanRecord);
                }else{
                    if(device.getName()!=null && device.getName().indexOf(name)!=-1){
                        callback.scan(device,rssi,scanRecord);
                    }
                }
            }
        }
    };
}
