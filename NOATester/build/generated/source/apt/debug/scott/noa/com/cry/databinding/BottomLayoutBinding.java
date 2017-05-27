package scott.noa.com.cry.databinding;
import scott.noa.com.cry.R;
import scott.noa.com.cry.BR;
import android.view.View;
public class BottomLayoutBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    private final android.widget.RelativeLayout mboundView0;
    public final android.widget.Button start;
    public final android.widget.Button stop;
    // variables
    private scott.noa.com.cry.bean.SensorEntity mSensor;
    private scott.noa.com.cry.ui.BaseActivity.Handlers mHandler;
    // values
    // listeners
    private OnClickListenerImpl mHandlerOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public BottomLayoutBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.start = (android.widget.Button) bindings[1];
        this.start.setTag(null);
        this.stop = (android.widget.Button) bindings[2];
        this.stop.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            case BR.enabled: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
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
        scott.noa.com.cry.bean.SensorEntity sensor = mSensor;
        scott.noa.com.cry.ui.BaseActivity.Handlers handler = mHandler;
        boolean sensorEnabled = false;
        android.view.View.OnClickListener handlerOnClickAndroidViewViewOnClickListener = null;
        boolean SensorEnabled1 = false;

        if ((dirtyFlags & 0xdL) != 0) {



                if (sensor != null) {
                    // read sensor.enabled
                    sensorEnabled = sensor.isEnabled();
                }


                // read !sensor.enabled
                SensorEnabled1 = !sensorEnabled;
        }
        if ((dirtyFlags & 0xaL) != 0) {



                if (handler != null) {
                    // read handler::onClick
                    handlerOnClickAndroidViewViewOnClickListener = (((mHandlerOnClickAndroidViewViewOnClickListener == null) ? (mHandlerOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mHandlerOnClickAndroidViewViewOnClickListener).setValue(handler));
                }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.start.setEnabled(SensorEnabled1);
            this.stop.setEnabled(sensorEnabled);
        }
        if ((dirtyFlags & 0xaL) != 0) {
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

    public static BottomLayoutBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static BottomLayoutBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<BottomLayoutBinding>inflate(inflater, scott.noa.com.cry.R.layout.bottom_layout, root, attachToRoot, bindingComponent);
    }
    public static BottomLayoutBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static BottomLayoutBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(scott.noa.com.cry.R.layout.bottom_layout, null, false), bindingComponent);
    }
    public static BottomLayoutBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static BottomLayoutBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/bottom_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new BottomLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): sensor
        flag 1 (0x2L): handler
        flag 2 (0x3L): sensor.enabled
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}