package scott.noa.com.cry.databinding;
import scott.noa.com.cry.R;
import scott.noa.com.cry.BR;
import android.view.View;
public class ActivityMainBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.checkBox, 15);
        sViewsWithIds.put(R.id.idBox, 16);
    }
    // views
    public final android.widget.CheckBox checkBox;
    public final android.support.v7.widget.AppCompatEditText idBox;
    private final android.widget.LinearLayout mboundView0;
    private final android.widget.TextView mboundView1;
    private final android.widget.TextView mboundView10;
    private final android.widget.TextView mboundView12;
    private final android.widget.TextView mboundView2;
    private final android.widget.TextView mboundView3;
    private final android.widget.TextView mboundView4;
    private final android.widget.TextView mboundView5;
    private final android.widget.TextView mboundView6;
    private final android.widget.TextView mboundView7;
    private final android.widget.TextView mboundView8;
    private final android.widget.TextView mboundView9;
    public final android.support.v7.widget.AppCompatButton sendId;
    public final android.widget.Button start;
    public final android.widget.Button stop;
    // variables
    private scott.noa.com.cry.ui.Test1Activity mItem;
    private scott.noa.com.cry.bean.SensorEntity mSensor;
    private scott.noa.com.cry.ui.Test1Activity.Handlers mHandler;
    // values
    // listeners
    private OnClickListenerImpl mHandlerOnClickViewAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityMainBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds);
        this.checkBox = (android.widget.CheckBox) bindings[15];
        this.idBox = (android.support.v7.widget.AppCompatEditText) bindings[16];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView10 = (android.widget.TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView12 = (android.widget.TextView) bindings[12];
        this.mboundView12.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.TextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.TextView) bindings[9];
        this.mboundView9.setTag(null);
        this.sendId = (android.support.v7.widget.AppCompatButton) bindings[11];
        this.sendId.setTag(null);
        this.start = (android.widget.Button) bindings[13];
        this.start.setTag(null);
        this.stop = (android.widget.Button) bindings[14];
        this.stop.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20000L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.item :
                setItem((scott.noa.com.cry.ui.Test1Activity) variable);
                return true;
            case BR.sensor :
                setSensor((scott.noa.com.cry.bean.SensorEntity) variable);
                return true;
            case BR.handler :
                setHandler((scott.noa.com.cry.ui.Test1Activity.Handlers) variable);
                return true;
        }
        return false;
    }

    public void setItem(scott.noa.com.cry.ui.Test1Activity Item) {
        this.mItem = Item;
    }
    public scott.noa.com.cry.ui.Test1Activity getItem() {
        return mItem;
    }
    public void setSensor(scott.noa.com.cry.bean.SensorEntity Sensor) {
        updateRegistration(0, Sensor);
        this.mSensor = Sensor;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.sensor);
        super.requestRebind();
    }
    public scott.noa.com.cry.bean.SensorEntity getSensor() {
        return mSensor;
    }
    public void setHandler(scott.noa.com.cry.ui.Test1Activity.Handlers Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public scott.noa.com.cry.ui.Test1Activity.Handlers getHandler() {
        return mHandler;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSensor((scott.noa.com.cry.bean.SensorEntity) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSensor(scott.noa.com.cry.bean.SensorEntity Sensor, int fieldId) {
        switch (fieldId) {
            case BR.filter: {
                synchronized(this) {
                        mDirtyFlags |= 0x8L;
                }
                return true;
            }
            case BR.id: {
                synchronized(this) {
                        mDirtyFlags |= 0x10L;
                }
                return true;
            }
            case BR.name: {
                synchronized(this) {
                        mDirtyFlags |= 0x20L;
                }
                return true;
            }
            case BR.mac: {
                synchronized(this) {
                        mDirtyFlags |= 0x40L;
                }
                return true;
            }
            case BR.left: {
                synchronized(this) {
                        mDirtyFlags |= 0x80L;
                }
                return true;
            }
            case BR.right: {
                synchronized(this) {
                        mDirtyFlags |= 0x100L;
                }
                return true;
            }
            case BR.battery: {
                synchronized(this) {
                        mDirtyFlags |= 0x200L;
                }
                return true;
            }
            case BR.v: {
                synchronized(this) {
                        mDirtyFlags |= 0x400L;
                }
                return true;
            }
            case BR.rssi: {
                synchronized(this) {
                        mDirtyFlags |= 0x800L;
                }
                return true;
            }
            case BR.data: {
                synchronized(this) {
                        mDirtyFlags |= 0x1000L;
                }
                return true;
            }
            case BR.desc: {
                synchronized(this) {
                        mDirtyFlags |= 0x2000L;
                }
                return true;
            }
            case BR.state: {
                synchronized(this) {
                        mDirtyFlags |= 0x4000L;
                }
                return true;
            }
            case BR.enabled: {
                synchronized(this) {
                        mDirtyFlags |= 0x8000L;
                }
                return true;
            }
            case BR.log: {
                synchronized(this) {
                        mDirtyFlags |= 0x10000L;
                }
                return true;
            }
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String sensorData = null;
        double sensorBattery = 0.0;
        boolean sensorState = false;
        java.lang.String stringValueOfJavaLangStringRSSISensorRssi = null;
        java.lang.String javaLangStringDataSensorData = null;
        java.lang.String sensorDesc = null;
        int sensorRight = 0;
        java.lang.String stringValueOfJavaLangStringDataSensorData = null;
        int sensorLeft = 0;
        scott.noa.com.cry.bean.SensorEntity sensor = mSensor;
        java.lang.String javaLangStringRSSISensorRssi = null;
        double sensorV = 0.0;
        java.lang.String sensorLog = null;
        java.lang.String javaLangStringMacSensorMac = null;
        android.view.View.OnClickListener handlerOnClickViewAndroidViewViewOnClickListener = null;
        scott.noa.com.cry.ui.Test1Activity.Handlers handler = mHandler;
        java.lang.String stringValueOfJavaLangStringNameSensorName = null;
        java.lang.String javaLangStringIdSensorId = null;
        java.lang.String stringValueOfJavaLangStringMacSensorMac = null;
        java.lang.String javaLangStringNameSensorName = null;
        java.lang.String stringValueOfJavaLangStringBatterySensorBattery = null;
        int sensorRssi = 0;
        java.lang.String sensorFilter = null;
        java.lang.String stringValueOfJavaLangStringIdSensorId = null;
        int sensorId = 0;
        boolean sensorEnabled = false;
        java.lang.String javaLangStringVSensorV = null;
        int sensorStateViewVISIBLEViewGONE = 0;
        boolean SensorEnabled1 = false;
        java.lang.String javaLangStringBatterySensorBattery = null;
        java.lang.String stringValueOfJavaLangStringVSensorV = null;
        java.lang.String sensorMac = null;
        java.lang.String stringFormatJavaLangStringLRSSSensorLeftSensorRight = null;
        java.lang.String sensorName = null;

        if ((dirtyFlags & 0x3fff9L) != 0) {


            if ((dirtyFlags & 0x21001L) != 0) {

                    if (sensor != null) {
                        // read sensor.data
                        sensorData = sensor.getData();
                    }


                    // read ("Data:") + (sensor.data)
                    javaLangStringDataSensorData = ("Data:") + (sensorData);


                    // read String.valueOf(("Data:") + (sensor.data))
                    stringValueOfJavaLangStringDataSensorData = java.lang.String.valueOf(javaLangStringDataSensorData);
            }
            if ((dirtyFlags & 0x20201L) != 0) {

                    if (sensor != null) {
                        // read sensor.battery
                        sensorBattery = sensor.getBattery();
                    }


                    // read ("Battery:") + (sensor.battery)
                    javaLangStringBatterySensorBattery = ("Battery:") + (sensorBattery);


                    // read String.valueOf(("Battery:") + (sensor.battery))
                    stringValueOfJavaLangStringBatterySensorBattery = java.lang.String.valueOf(javaLangStringBatterySensorBattery);
            }
            if ((dirtyFlags & 0x24001L) != 0) {

                    if (sensor != null) {
                        // read sensor.state
                        sensorState = sensor.isState();
                    }
                if((dirtyFlags & 0x24001L) != 0) {
                    if(sensorState) {
                            dirtyFlags |= 0x80000L;
                    }
                    else {
                            dirtyFlags |= 0x40000L;
                    }
                }


                    // read sensor.state ? View.VISIBLE : View.GONE
                    sensorStateViewVISIBLEViewGONE = ((sensorState) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x22001L) != 0) {

                    if (sensor != null) {
                        // read sensor.desc
                        sensorDesc = sensor.getDesc();
                    }
            }
            if ((dirtyFlags & 0x20181L) != 0) {

                    if (sensor != null) {
                        // read sensor.right
                        sensorRight = sensor.getRight();
                        // read sensor.left
                        sensorLeft = sensor.getLeft();
                    }


                    // read String.format("L-R:%s-%s", sensor.left, sensor.right)
                    stringFormatJavaLangStringLRSSSensorLeftSensorRight = java.lang.String.format("L-R:%s-%s", sensorLeft, sensorRight);
            }
            if ((dirtyFlags & 0x20401L) != 0) {

                    if (sensor != null) {
                        // read sensor.v
                        sensorV = sensor.getV();
                    }


                    // read ("V:") + (sensor.v)
                    javaLangStringVSensorV = ("V:") + (sensorV);


                    // read String.valueOf(("V:") + (sensor.v))
                    stringValueOfJavaLangStringVSensorV = java.lang.String.valueOf(javaLangStringVSensorV);
            }
            if ((dirtyFlags & 0x30001L) != 0) {

                    if (sensor != null) {
                        // read sensor.log
                        sensorLog = sensor.getLog();
                    }
            }
            if ((dirtyFlags & 0x20801L) != 0) {

                    if (sensor != null) {
                        // read sensor.rssi
                        sensorRssi = sensor.getRssi();
                    }


                    // read ("RSSI:") + (sensor.rssi)
                    javaLangStringRSSISensorRssi = ("RSSI:") + (sensorRssi);


                    // read String.valueOf(("RSSI:") + (sensor.rssi))
                    stringValueOfJavaLangStringRSSISensorRssi = java.lang.String.valueOf(javaLangStringRSSISensorRssi);
            }
            if ((dirtyFlags & 0x20009L) != 0) {

                    if (sensor != null) {
                        // read sensor.filter
                        sensorFilter = sensor.getFilter();
                    }
            }
            if ((dirtyFlags & 0x20011L) != 0) {

                    if (sensor != null) {
                        // read sensor.id
                        sensorId = sensor.getId();
                    }


                    // read ("Id:") + (sensor.id)
                    javaLangStringIdSensorId = ("Id:") + (sensorId);


                    // read String.valueOf(("Id:") + (sensor.id))
                    stringValueOfJavaLangStringIdSensorId = java.lang.String.valueOf(javaLangStringIdSensorId);
            }
            if ((dirtyFlags & 0x28001L) != 0) {

                    if (sensor != null) {
                        // read sensor.enabled
                        sensorEnabled = sensor.isEnabled();
                    }


                    // read !sensor.enabled
                    SensorEnabled1 = !sensorEnabled;
            }
            if ((dirtyFlags & 0x20041L) != 0) {

                    if (sensor != null) {
                        // read sensor.mac
                        sensorMac = sensor.getMac();
                    }


                    // read ("Mac:") + (sensor.mac)
                    javaLangStringMacSensorMac = ("Mac:") + (sensorMac);


                    // read String.valueOf(("Mac:") + (sensor.mac))
                    stringValueOfJavaLangStringMacSensorMac = java.lang.String.valueOf(javaLangStringMacSensorMac);
            }
            if ((dirtyFlags & 0x20021L) != 0) {

                    if (sensor != null) {
                        // read sensor.name
                        sensorName = sensor.getName();
                    }


                    // read ("Name:") + (sensor.name)
                    javaLangStringNameSensorName = ("Name:") + (sensorName);


                    // read String.valueOf(("Name:") + (sensor.name))
                    stringValueOfJavaLangStringNameSensorName = java.lang.String.valueOf(javaLangStringNameSensorName);
            }
        }
        if ((dirtyFlags & 0x20004L) != 0) {



                if (handler != null) {
                    // read handler::onClickView
                    handlerOnClickViewAndroidViewViewOnClickListener = (((mHandlerOnClickViewAndroidViewViewOnClickListener == null) ? (mHandlerOnClickViewAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mHandlerOnClickViewAndroidViewViewOnClickListener).setValue(handler));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x20009L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, sensorFilter);
        }
        if ((dirtyFlags & 0x22001L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView10, sensorDesc);
        }
        if ((dirtyFlags & 0x24001L) != 0) {
            // api target 1

            this.mboundView10.setVisibility(sensorStateViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x30001L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView12, sensorLog);
        }
        if ((dirtyFlags & 0x20011L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, stringValueOfJavaLangStringIdSensorId);
        }
        if ((dirtyFlags & 0x20021L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, stringValueOfJavaLangStringNameSensorName);
        }
        if ((dirtyFlags & 0x20041L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, stringValueOfJavaLangStringMacSensorMac);
        }
        if ((dirtyFlags & 0x20181L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, stringFormatJavaLangStringLRSSSensorLeftSensorRight);
        }
        if ((dirtyFlags & 0x20201L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, stringValueOfJavaLangStringBatterySensorBattery);
        }
        if ((dirtyFlags & 0x20401L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, stringValueOfJavaLangStringVSensorV);
        }
        if ((dirtyFlags & 0x20801L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, stringValueOfJavaLangStringRSSISensorRssi);
        }
        if ((dirtyFlags & 0x21001L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, stringValueOfJavaLangStringDataSensorData);
        }
        if ((dirtyFlags & 0x28001L) != 0) {
            // api target 1

            this.sendId.setEnabled(sensorEnabled);
            this.start.setEnabled(SensorEnabled1);
            this.stop.setEnabled(sensorEnabled);
        }
        if ((dirtyFlags & 0x20004L) != 0) {
            // api target 1

            this.sendId.setOnClickListener(handlerOnClickViewAndroidViewViewOnClickListener);
            this.start.setOnClickListener(handlerOnClickViewAndroidViewViewOnClickListener);
            this.stop.setOnClickListener(handlerOnClickViewAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private scott.noa.com.cry.ui.Test1Activity.Handlers value;
        public OnClickListenerImpl setValue(scott.noa.com.cry.ui.Test1Activity.Handlers value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClickView(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityMainBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityMainBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMainBinding>inflate(inflater, scott.noa.com.cry.R.layout.activity_main, root, attachToRoot, bindingComponent);
    }
    public static ActivityMainBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityMainBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(scott.noa.com.cry.R.layout.activity_main, null, false), bindingComponent);
    }
    public static ActivityMainBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityMainBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_main_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMainBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): sensor
        flag 1 (0x2L): item
        flag 2 (0x3L): handler
        flag 3 (0x4L): sensor.filter
        flag 4 (0x5L): sensor.id
        flag 5 (0x6L): sensor.name
        flag 6 (0x7L): sensor.mac
        flag 7 (0x8L): sensor.left
        flag 8 (0x9L): sensor.right
        flag 9 (0xaL): sensor.battery
        flag 10 (0xbL): sensor.v
        flag 11 (0xcL): sensor.rssi
        flag 12 (0xdL): sensor.data
        flag 13 (0xeL): sensor.desc
        flag 14 (0xfL): sensor.state
        flag 15 (0x10L): sensor.enabled
        flag 16 (0x11L): sensor.log
        flag 17 (0x12L): null
        flag 18 (0x13L): sensor.state ? View.VISIBLE : View.GONE
        flag 19 (0x14L): sensor.state ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}