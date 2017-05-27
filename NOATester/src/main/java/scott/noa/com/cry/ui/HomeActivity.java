package scott.noa.com.cry.ui;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

import scott.noa.com.cry.R;
import scott.noa.com.cry.adapter.Menu;
import scott.noa.com.cry.adapter.MenuViewHolder;
import scott.noa.com.cry.adapter.RecycleViewDivider;
import scott.noa.com.cry.adapter.RecyclerViewAdapter;
import scott.noa.com.cry.databinding.ActivityHomeBinding;

/**
 * Created by noalabs on 2017/5/13.
 */

public class HomeActivity extends Base {

    public final static String TAG = HomeActivity.class.getName();

    private int EXTERNAL_STORAGE_REQ_CODE = 100;
    private int REQUEST_CODE_BLUETOOTH_ON=101;

    protected BluetoothAdapter bluetoothAdapter;

    private List<Menu> menus = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (bluetoothAdapter == null) {
            android.bluetooth.BluetoothManager manager = (BluetoothManager)getSystemService(Context.BLUETOOTH_SERVICE);
            bluetoothAdapter = manager.getAdapter();
        }

        if (actionBar != null) {
            actionBar.setTitle(R.string.Home);
        }

        Menu menu = new Menu();
        menu.setIcon(R.mipmap.ic_launcher);
        menu.setTitle("FenSens Sensor");
        menu.setDesc("FenSens Sensor 测试");
        menu.setType("FenSens");
        menus.add(menu);

        menu = new Menu();
        menu.setIcon(R.mipmap.ic_launcher);
        menu.setTitle("FenSens Button");
        menu.setDesc("FenSens Button 测试");
        menu.setType("Button");
        menus.add(menu);

        menu = new Menu();
        menu.setIcon(R.mipmap.ic_launcher);
        menu.setTitle("Cashew");
        menu.setDesc("Cashew 测试");
        menu.setType("Cashew");
        menus.add(menu);
        homeBinding.menus.setLayoutManager(new LinearLayoutManager(this));
        homeBinding.menus.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL, 2, getResources().getColor(R.color.colorAccent)));
        homeBinding.menus.setHasFixedSize(true);

        final int variableId = BR.menu;
        RecyclerViewAdapter<Menu> adapter = new RecyclerViewAdapter<Menu>(R.layout.item, variableId, menus) {
            @Override
            public void convert(MenuViewHolder holder, Menu menu) {
                holder.setBinding(variableId, menu);
            }

            @Override
            public void onClick(View view, int position) {
                if(bluetoothAdapter!=null && bluetoothAdapter.isEnabled()){
                    Intent intent = new Intent();
                    switch (position) {
                        case 0:
                        case 1:
                            intent.setClass(HomeActivity.this, Test1Activity.class);
                            break;
                        case 2: {
                            intent.setClass(HomeActivity.this, CashewActivity.class);
                            break;
                        }
                    }
                    intent.putExtra("type", menus.get(position).getType());
                    startActivity(intent);
                }else{
                    Intent requestBluetoothOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    HomeActivity.this.startActivityForResult(requestBluetoothOn,REQUEST_CODE_BLUETOOTH_ON);
                }
            }
        };
        homeBinding.menus.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //requestPermission();
            String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION};
            requestPermissions(permissions, EXTERNAL_STORAGE_REQ_CODE);
        }
    }


    /*
    public void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //没有授权,判断权限申请是否曾经被拒绝过
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "你曾经拒绝过此权限,需要重新获取", Toast.LENGTH_SHORT).show();
                //进行权限请求
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_REQ_CODE);
            } else {
                //进行权限请求
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_REQ_CODE);
            }
        }

        //校验是否已具有模糊定位权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //没有授权,判断权限申请是否曾经被拒绝过
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                Toast.makeText(this, "你曾经拒绝过此权限,需要重新获取", Toast.LENGTH_SHORT).show();
                //进行权限请求
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_ACCESS_COARSE_LOCATION_CODE);
            } else {
                //进行权限请求
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_ACCESS_COARSE_LOCATION_CODE);
            }
        }
    }
    */
}
