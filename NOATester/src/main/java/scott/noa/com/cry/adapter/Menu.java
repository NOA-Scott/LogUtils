package scott.noa.com.cry.adapter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import scott.noa.com.cry.BR;

/**
 * Created by noalabs on 2017/5/16.
 */

public class Menu extends BaseObservable {
    private int icon;
    private String title;
    private String desc;
    private String type;

    @Bindable
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
        notifyPropertyChanged(BR.icon);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
        notifyPropertyChanged(BR.desc);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
