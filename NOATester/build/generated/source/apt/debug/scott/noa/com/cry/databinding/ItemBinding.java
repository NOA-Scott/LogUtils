package scott.noa.com.cry.databinding;
import scott.noa.com.cry.R;
import scott.noa.com.cry.BR;
import android.view.View;
public class ItemBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.icon, 3);
    }
    // views
    public final android.widget.TextView desc;
    public final android.widget.ImageView icon;
    private final android.support.v7.widget.CardView mboundView0;
    public final android.widget.TextView title;
    // variables
    private scott.noa.com.cry.adapter.Menu mMenu;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.desc = (android.widget.TextView) bindings[2];
        this.desc.setTag(null);
        this.icon = (android.widget.ImageView) bindings[3];
        this.mboundView0 = (android.support.v7.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.title = (android.widget.TextView) bindings[1];
        this.title.setTag(null);
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
            case BR.menu :
                setMenu((scott.noa.com.cry.adapter.Menu) variable);
                return true;
        }
        return false;
    }

    public void setMenu(scott.noa.com.cry.adapter.Menu Menu) {
        updateRegistration(0, Menu);
        this.mMenu = Menu;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.menu);
        super.requestRebind();
    }
    public scott.noa.com.cry.adapter.Menu getMenu() {
        return mMenu;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMenu((scott.noa.com.cry.adapter.Menu) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMenu(scott.noa.com.cry.adapter.Menu Menu, int fieldId) {
        switch (fieldId) {
            case BR.title: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
            case BR.desc: {
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
        scott.noa.com.cry.adapter.Menu menu = mMenu;
        java.lang.String menuDesc = null;
        java.lang.String menuTitle = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (menu != null) {
                        // read menu.desc
                        menuDesc = menu.getDesc();
                    }
            }
            if ((dirtyFlags & 0xbL) != 0) {

                    if (menu != null) {
                        // read menu.title
                        menuTitle = menu.getTitle();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.desc, menuDesc);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.title, menuTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemBinding>inflate(inflater, scott.noa.com.cry.R.layout.item, root, attachToRoot, bindingComponent);
    }
    public static ItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(scott.noa.com.cry.R.layout.item, null, false), bindingComponent);
    }
    public static ItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): menu
        flag 1 (0x2L): menu.title
        flag 2 (0x3L): menu.desc
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}