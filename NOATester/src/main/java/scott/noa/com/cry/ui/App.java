package scott.noa.com.cry.ui;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;

import rx.Scheduler;
import scott.noa.com.cry.service.BluetoothBleService;

/**
 * Created by scottwang on 17/5/5.
 */

public class App extends Application {
    @Override
    public void onCreate() {

    }
}
