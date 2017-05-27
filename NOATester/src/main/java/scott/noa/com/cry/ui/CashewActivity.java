package scott.noa.com.cry.ui;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.WindowManager;

import scott.noa.com.cry.R;
import scott.noa.com.cry.bluetooth.UUIDHelper;
import scott.noa.com.cry.databinding.ActivityCashewBinding;

/**
 * Created by noalabs on 2017/5/23.
 */

public class CashewActivity extends BaseActivity {
    private final String TAG = CashewActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        ActivityCashewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_cashew);

        type = getIntent().getStringExtra("type");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(type);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        prefs = getSharedPreferences(type, Context.MODE_PRIVATE);

        entity.setAuto(getBoolKey(prefs, "auto"));
        binding.setHandler(new BaseActivity.Handlers());
        binding.setSensor(entity);
    }


    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        BluetoothDevice device = gatt.getDevice();
        entity.setId(getIntKey(prefs,"id"));
        entity.setName(device.getName());
        entity.setMac(device.getAddress());

        if(mService!=null){
            mService.registerNotify(UUIDHelper.uuidFromString("FFDA"),UUIDHelper.uuidFromString("FFD2"));
        }
    }

    @Override
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        if(mService!=null){
            mService.write(UUIDHelper.uuidFromString("FFDA"),UUIDHelper.uuidFromString("FFD1"),"RBATT=?");
            handler.postDelayed(runnable,1000);
        }
    }

    @Override
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        byte[] d = characteristic.getValue();
        String data = new String(d).trim();
        if(data.contains("RBATT=")){
            entity.setBattery(Double.parseDouble(data.substring(data.indexOf("=") + 1, data.length())));
        }else if(data.contains("CASHEWRELOAD,OK")){
            entity.setState(true);
            entity.setDesc("测试通过");
        }else{
            entity.setData(data+","+entity.getData());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        Log.e(TAG,"onCharacteristicRead    status:"+status);
    }
}
