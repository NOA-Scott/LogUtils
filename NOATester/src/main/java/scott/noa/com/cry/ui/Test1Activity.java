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
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scott.noa.com.cry.R;
import scott.noa.com.cry.bluetooth.UUIDHelper;
import scott.noa.com.cry.databinding.ActivityMainBinding;

public class Test1Activity extends BaseActivity {
    private final static String TAG = Test1Activity.class.getName();

    private ActivityMainBinding binding;
    private List<Integer> lefts = new ArrayList<>();
    private List<Integer> rights=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        type= getIntent().getStringExtra("type");
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null){
            actionBar.setTitle(type);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        prefs = getSharedPreferences(type, Context.MODE_PRIVATE);

        entity.setAuto(getBoolKey(prefs,"auto"));
        binding.setSensor(entity);
        binding.setHandler(new Handlers());
        binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                binding.idBox.setVisibility(isChecked?View.VISIBLE:View.GONE);
                binding.sendId.setVisibility(isChecked?View.VISIBLE:View.GONE);
            }
        });
    }

    public class Handlers {
        public void onClickView(View view) {
            switch (view.getId()){
                case R.id.sendId:{

                    break;
                }
                case R.id.start:{
                    entity.setEnabled(true);
                    if (mService!=null){
                        mService.scan(type,null,-prefs.getInt("rssi",100));
                    }
                    break;
                }
                case R.id.stop:{
                    entity.setEnabled(false);
                    StringBuffer sb=new StringBuffer();
                    sb.append(entity.getId());
                    sb.append(",");
                    sb.append(entity.getName());
                    sb.append(",");
                    sb.append(entity.getMac());
                    sb.append(",");
                    if(type.equals("FenSnes")){
                        sb.append(Collections.max(lefts));
                        sb.append("-");
                        sb.append(Collections.min(lefts));
                        sb.append(",");
                        sb.append(Collections.max(rights));
                        sb.append("-");
                        sb.append(Collections.min(rights));
                        sb.append(",");
                        sb.append(entity.getV());
                    }else{
                        sb.append(entity.getData());
                    }
                    sb.append(",");
                    sb.append(entity.getRssi());

                    if(folder(type,sb)){
                        Log.e(TAG,"数据写入成功....");
                    }else{
                        Log.e(TAG,"数据写入失败 ....");
                    }
                    mService.disConnected(Test1Activity.this);
                    handler.removeCallbacks(runnable);
                    handler.postDelayed(stopRunable,2000);

                    lefts.clear();
                    rights.clear();
                    break;
                }
            }
        }
    }


    Runnable stopRunable = new Runnable() {
        @Override
        public void run() {
            entity.setEnabled(true);
            if (mService!=null){
                mService.scan(type,null,-prefs.getInt("rssi",100));
            }
        }
    };

    @Override
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        BluetoothDevice device = gatt.getDevice();
        entity.setId(getIntKey(prefs,"id"));
        entity.setName(device.getName());
        entity.setMac(device.getAddress());

        if(mService!=null){
            mService.registerNotify(UUIDHelper.uuidFromString("180F"),UUIDHelper.uuidFromString("2A19"));
        }
    }

    @Override
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        if(mService!=null){
            boolean isBattery = descriptor.getCharacteristic().getUuid().equals(UUIDHelper.uuidFromString("2A19"));
            boolean isNoa = descriptor.getCharacteristic().getUuid().equals(UUIDHelper.uuidFromString("2AF0"));
            if(isBattery){
                mService.registerNotify(UUIDHelper.uuidFromString("1820"),UUIDHelper.uuidFromString("2AF0"));
            }else if(isNoa){
                mService.read(UUIDHelper.uuidFromString("180F"),UUIDHelper.uuidFromString("2A19"));
                handler.postDelayed(runnable,1000);
            }
        }
    }



    @Override
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        byte[] data = characteristic.getValue();

        if(characteristic.getUuid().equals(UUIDHelper.uuidFromString("2A19"))){
            int battery = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, 0);
            entity.setBattery(battery);
        }else{
            if(type.equals("FenSens")){
                if(data.length>2){
                    int left = ((data[0] & 0xFF) << 8) + (data[1] & 0xFF);
                    lefts.add(left);
                    int right = ((data[2] & 0xFF) << 8) + (data[3] & 0xFF);
                    rights.add(right);

                    entity.setLeft(left);
                    entity.setRight(right);
                }else if(data.length==2){
                    int battery = ((data[0] & 0xFF) << 8) + (data[1] & 0xFF);
                    entity.setV(battery);
                    mService.write(UUIDHelper.uuidFromString("1820"),UUIDHelper.uuidFromString("2AF1"),"AT+START");
                }
            }else if(type.equals("Button")){
                if(data.length==2){
                    int battery = ((data[0] & 0xFF) << 8) + (data[1] & 0xFF);
                    entity.setV(battery);
                }else{
                    entity.setData(new String(data).trim());
                    entity.setState(true);
                }
            }
        }
    }

    @Override
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        int battery = characteristic.getIntValue(BluetoothGattCharacteristic.FORMAT_UINT8, 0);
        entity.setBattery(battery);
        Log.e(TAG," -- > onCharacteristicRead:"+battery+"  "+characteristic.getUuid());

        boolean isBattery = characteristic.getUuid().equals(UUIDHelper.uuidFromString("2A19"));
        if(isBattery){
            mService.write(UUIDHelper.uuidFromString("1820"),UUIDHelper.uuidFromString("2AF1"),"AT+BATT");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
