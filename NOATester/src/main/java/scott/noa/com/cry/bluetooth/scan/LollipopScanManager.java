package scott.noa.com.cry.bluetooth.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import scott.noa.com.cry.service.BluetoothBleService;

/**
 * Created by scottwang on 17/5/10.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class LollipopScanManager extends ScanManager{

    public static String TAG = BluetoothBleService.class.getName();

    private ScanCallback callback;
    private String name;

    public LollipopScanManager(Context context) {
        super(context);
    }

    @Override
    public void stopScan() {
        getBluetoothAdapter().getBluetoothLeScanner().stopScan(mScanCallback);
    }

    @Override
    public void stopScan(String name, String uuid, ScanCallback callback) {
        int model = getBluetoothAdapter().getScanMode();
        if(model == BluetoothAdapter.STATE_CONNECTING){
            getBluetoothAdapter().getBluetoothLeScanner().stopScan(mScanCallback);
        }
        callback.scanMode(name,uuid,model);
    }

    @Override
    public void scan(UUID uuid, String name, ScanCallback callback) {
        this.callback = callback;
        this.name = name;

        List<ScanFilter> filters = new ArrayList<>();
        ScanSettings.Builder scanSettingsBuilder = new ScanSettings.Builder();

        getBluetoothAdapter().getBluetoothLeScanner().startScan(filters, scanSettingsBuilder.build(), mScanCallback);
    }


    android.bluetooth.le.ScanCallback mScanCallback = new android.bluetooth.le.ScanCallback() {

        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
            BluetoothDevice device = result.getDevice();
            if(name==null) {
                callback.scan(device,result.getRssi(),result.getScanRecord().getBytes());
            }else{
                if(device.getName()!=null && device.getName().indexOf(name)!=-1){
                    callback.scan(result.getDevice(),result.getRssi(),result.getScanRecord().getBytes());
                }
            }
        }

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            super.onBatchScanResults(results);
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
        }
    };

}
