
package android.databinding;
import scott.noa.com.cry.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 21;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case scott.noa.com.cry.R.layout.bottom_layout:
                    return scott.noa.com.cry.databinding.BottomLayoutBinding.bind(view, bindingComponent);
                case scott.noa.com.cry.R.layout.item:
                    return scott.noa.com.cry.databinding.ItemBinding.bind(view, bindingComponent);
                case scott.noa.com.cry.R.layout.activity_main:
                    return scott.noa.com.cry.databinding.ActivityMainBinding.bind(view, bindingComponent);
                case scott.noa.com.cry.R.layout.activity_home:
                    return scott.noa.com.cry.databinding.ActivityHomeBinding.bind(view, bindingComponent);
                case scott.noa.com.cry.R.layout.activity_cashew:
                    return scott.noa.com.cry.databinding.ActivityCashewBinding.bind(view, bindingComponent);
                case scott.noa.com.cry.R.layout.activity_filter:
                    return scott.noa.com.cry.databinding.ActivityFilterBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 739172106: {
                if(tag.equals("layout/bottom_layout_0")) {
                    return scott.noa.com.cry.R.layout.bottom_layout;
                }
                break;
            }
            case 450490505: {
                if(tag.equals("layout/item_0")) {
                    return scott.noa.com.cry.R.layout.item;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return scott.noa.com.cry.R.layout.activity_main;
                }
                break;
            }
            case 293647131: {
                if(tag.equals("layout/activity_home_0")) {
                    return scott.noa.com.cry.R.layout.activity_home;
                }
                break;
            }
            case -762419935: {
                if(tag.equals("layout/activity_cashew_0")) {
                    return scott.noa.com.cry.R.layout.activity_cashew;
                }
                break;
            }
            case -1508187980: {
                if(tag.equals("layout/activity_filter_0")) {
                    return scott.noa.com.cry.R.layout.activity_filter;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"auto"
            ,"battery"
            ,"data"
            ,"desc"
            ,"enabled"
            ,"filter"
            ,"handler"
            ,"icon"
            ,"id"
            ,"item"
            ,"left"
            ,"log"
            ,"mac"
            ,"menu"
            ,"name"
            ,"right"
            ,"rssi"
            ,"sensor"
            ,"state"
            ,"title"
            ,"v"};
    }
}