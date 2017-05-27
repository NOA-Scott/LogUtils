package scott.noa.com.cry.databinding;
import scott.noa.com.cry.R;
import scott.noa.com.cry.BR;
import android.view.View;
public class ActivityCashewBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    private final android.widget.LinearLayout mboundView0;
    private final android.widget.TextView mboundView1;
    private final android.widget.TextView mboundView2;
    private final android.widget.TextView mboundView3;
    private final android.widget.TextView mboundView4;
    private final android.widget.TextView mboundView5;
    private final android.widget.TextView mboundView6;
    private final android.widget.TextView mboundView7;
    private final android.widget.TextView mboundView8;
    private final android.widget.TextView mboundView9;
    public final android.widget.Button start;
    public final android.widget.Button stop;
    // variables
    private scott.noa.com.cry.bean.SensorEntity mSensor;
    private scott.noa.com.cry.ui.BaseActivity.Handlers mHandler;
    // values
    // listeners
    private OnClickListenerImpl mHandlerOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityCashewBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
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
        this.start = (android.widget.Button) bindings[10];
        this.start.setTag(null);
        this.stop = (android.widget.Button) bindings[11];
        this.stop.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2000L;
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
            case BR.sensor :
                setSensor((scott.noa.com.cry.bean.SensorEntity) variable);
                return true;
            case BR.handler :
                setHandler((scott.noa.com.cry.ui.BaseActivity.Handlers) variable);
                return true;
        }
        return false;
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
    public void setHandler(scott.noa.com.cry.ui.BaseActivity.Handlers Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public scott.noa.com.cry.ui.BaseActivity.Handlers getHandler() {
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
                        mDirtyFlags |= 0x4L;
                }
                return true;
            }
            case BR.id: {
                synchronized(this) {
                        mDirtyFlags |= 0x8L;
                }
                return true;
            }
            case BR.name: {
                synchronized(this) {
                        mDirtyFlags |= 0x10L;
                }
                return true;
            }
            case BR.mac: {
                synchronized(this) {
                        mDirtyFlags |= 0x20L;
                }
                return true;
            }
            case BR.battery: {
                synchronized(this) {
                        mDirtyFlags |= 0x40L;
                }
                return true;
            }
            case BR.rssi: {
                synchronized(this) {
                        mDirtyFlags |= 0x80L;
                }
                return true;
            }
            case BR.data: {
                synchronized(this) {
                        mDirtyFlags |= 0x100L;
                }
                return true;
            }
            case BR.desc: {
                synchronized(this) {
                        mDirtyFlags |= 0x200L;
                }
                return true;
            }
            case BR.state: {
                synchronized(this) {
                        mDirtyFlags |= 0x400L;
                }
                return true;
            }
            case BR.log: {
                synchronized(this) {
                        mDirtyFlags |= 0x800L;
                }
                return true;
            }
            case BR.enabled: {
                synchronized(this) {
                        mDirtyFlags |= 0x1000L;
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
        java.lang.String stringValueOfJavaLangStringDataSensorData = null;
        scott.noa.com.cry.bean.SensorEntity sensor = mSensor;
        java.lang.String javaLangStringRSSISensorRssi = null;
        java.lang.String sensorLog = null;
        java.lang.String javaLangStringMacSensorMac = null;
        scott.noa.com.cry.ui.BaseActivity.Handlers handler = mHandler;
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
        int sensorStateViewVISIBLEViewGONE = 0;
        android.view.View.OnClickListener handlerOnClickAndroidViewViewOnClickListener = null;
        boolean SensorEnabled1 = false;
        java.lang.String javaLangStringBatterySensorBattery = null;
        java.lang.String sensorMac = null;
        java.lang.String sensorName = null;

        if ((dirtyFlags & 0x3ffdL) != 0) {


            if ((dirtyFlags & 0x2101L) != 0) {

                    if (sensor != null) {
                        // read sensor.data
                        sensorData = sensor.getData();
                    }


                    // read ("Data:") + (sensor.data)
                    javaLangStringDataSensorData = ("Data:") + (sensorData);


                    // read String.valueOf(("Data:") + (sensor.data))
                    stringValueOfJavaLangStringDataSensorData = java.lang.String.valueOf(javaLangStringDataSensorData);
            }
            if ((dirtyFlags & 0x2041L) != 0) {

                    if (sensor != null) {
                        // read sensor.battery
                        sensorBattery = sensor.getBattery();
                    }


                    // read ("Battery:") + (sensor.battery)
                    javaLangStringBatterySensorBattery = ("Battery:") + (sensorBattery);


                    // read String.valueOf(("Battery:") + (sensor.battery))
                    stringValueOfJavaLangStringBatterySensorBattery = java.lang.String.valueOf(javaLangStringBatterySensorBattery);
            }
            if ((dirtyFlags & 0x2401L) != 0) {

                    if (sensor != null) {
                        // read sensor.state
                        sensorState = sensor.isState();
                    }
                if((dirtyFlags & 0x2401L) != 0) {
                    if(sensorState) {
                            dirtyFlags |= 0x8000L;
                    }
                    else {
                            dirtyFlags |= 0x4000L;
                    }
                }


                    // read sensor.state ? View.VISIBLE : View.GONE
                    sensorStateViewVISIBLEViewGONE = ((sensorState) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x2201L) != 0) {

                    if (sensor != null) {
                        // read sensor.desc
                        sensorDesc = sensor.getDesc();
                    }
            }
            if ((dirtyFlags & 0x2801L) != 0) {

                    if (sensor != null) {
                        // read sensor.log
                        sensorLog = sensor.getLog();
                    }
            }
            if ((dirtyFlags & 0x2081L) != 0) {

                    if (sensor != null) {
                        // read sensor.rssi
                        sensorRssi = sensor.getRssi();
                    }


                    // read ("RSSI:") + (sensor.rssi)
                    javaLangStringRSSISensorRssi = ("RSSI:") + (sensorRssi);


                    // read String.valueOf(("RSSI:") + (sensor.rssi))
                    stringValueOfJavaLangStringRSSISensorRssi = java.lang.String.valueOf(javaLangStringRSSISensorRssi);
            }
            if ((dirtyFlags & 0x2005L) != 0) {

                    if (sensor != null) {
                        // read sensor.filter
                        sensorFilter = sensor.getFilter();
                    }
            }
            if ((dirtyFlags & 0x2009L) != 0) {

                    if (sensor != null) {
                        // read sensor.id
                        sensorId = sensor.getId();
                    }


                    // read ("Id:") + (sensor.id)
                    javaLangStringIdSensorId = ("Id:") + (sensorId);


                    // read String.valueOf(("Id:") + (sensor.id))
                    stringValueOfJavaLangStringIdSensorId = java.lang.String.valueOf(javaLangStringIdSensorId);
            }
            if ((dirtyFlags & 0x3001L) != 0) {

                    if (sensor != null) {
                        // read sensor.enabled
                        sensorEnabled = sensor.isEnabled();
                    }


                    // read !sensor.enabled
                    SensorEnabled1 = !sensorEnabled;
            }
            if ((dirtyFlags & 0x2021L) != 0) {

                    if (sensor != null) {
                        // read sensor.mac
                        sensorMac = sensor.getMac();
                    }


                    // read ("Mac:") + (sensor.mac)
                    javaLangStringMacSensorMac = ("Mac:") + (sensorMac);


                    // read String.valueOf(("Mac:") + (sensor.mac))
                    stringValueOfJavaLangStringMacSensorMac = java.lang.String.valueOf(javaLangStringMacSensorMac);
            }
            if ((dirtyFlags & 0x2011L) != 0) {

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
        if ((dirtyFlags & 0x2002L) != 0) {



                if (handler != null) {
                    // read handler::onClick
                    handlerOnClickAndroidViewViewOnClickListener = (((mHandlerOnClickAndroidViewViewOnClickListener == null) ? (mHandlerOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mHandlerOnClickAndroidViewViewOnClickListener).setValue(handler));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x2005L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, sensorFilter);
        }
        if ((dirtyFlags & 0x2009L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, stringValueOfJavaLangStringIdSensorId);
        }
        if ((dirtyFlags & 0x2011L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, stringValueOfJavaLangStringNameSensorName);
        }
        if ((dirtyFlags & 0x2021L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, stringValueOfJavaLangStringMacSensorMac);
        }
        if ((dirtyFlags & 0x2041L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, stringValueOfJavaLangStringBatterySensorBattery);
        }
        if ((dirtyFlags & 0x2081L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, stringValueOfJavaLangStringRSSISensorRssi);
        }
        if ((dirtyFlags & 0x2101L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, stringValueOfJavaLangStringDataSensorData);
        }
        if ((dirtyFlags & 0x2201L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, sensorDesc);
        }
        if ((dirtyFlags & 0x2401L) != 0) {
            // api target 1

            this.mboundView8.setVisibility(sensorStateViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x2801L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, sensorLog);
        }
        if ((dirtyFlags & 0x3001L) != 0) {
            // api target 1

            this.start.setEnabled(SensorEnabled1);
            this.stop.setEnabled(sensorEnabled);
        }
        if ((dirtyFlags & 0x2002L) != 0) {
            // api target 1

            this.start.setOnClickListener(handlerOnClickAndroidViewViewOnClickListener);
            this.stop.setOnClickListener(handlerOnClickAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private scott.noa.com.cry.ui.BaseActivity.Handlers value;
        public OnClickListenerImpl setValue(scott.noa.com.cry.ui.BaseActivity.Handlers value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClick(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityCashewBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityCashewBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityCashewBinding>inflate(inflater, scott.noa.com.cry.R.layout.activity_cashew, root, attachToRoot, bindingComponent);
    }
    public static ActivityCashewBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityCashewBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(scott.noa.com.cry.R.layout.activity_cashew, null, false), bindingComponent);
    }
    public static ActivityCashewBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityCashewBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_cashew_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityCashewBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): sensor
        flag 1 (0x2L): handler
        flag 2 (0x3L): sensor.filter
        flag 3 (0x4L): sensor.id
        flag 4 (0x5L): sensor.name
        flag 5 (0x6L): sensor.mac
        flag 6 (0x7L): sensor.battery
        flag 7 (0x8L): sensor.rssi
        flag 8 (0x9L): sensor.data
        flag 9 (0xaL): sensor.desc
        flag 10 (0xbL): sensor.state
        flag 11 (0xcL): sensor.log
        flag 12 (0xdL): sensor.enabled
        flag 13 (0xeL): null
        flag 14 (0xfL): sensor.state ? View.VISIBLE : View.GONE
        flag 15 (0x10L): sensor.state ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}