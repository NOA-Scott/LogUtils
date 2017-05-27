package scott.noa.com.cry.bean;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import scott.noa.com.cry.BR;


/**
 * Created by noalabs on 2017/5/12.
 */

public class SensorEntity extends BaseObservable {
    private int id;
    private String name;
    private String mac;
    private double battery;
    private int rssi;
    private double v;
    private int left;
    private int right;
    private boolean enabled;
    private boolean auto;
    private String data;
    private String log;

    private String filter;

    private boolean state;
    private String desc;

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getMac() {
        if (mac == null) {
            return "";
        }
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
        notifyPropertyChanged(BR.mac);
    }

    @Bindable
    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
        notifyPropertyChanged(BR.battery);
    }

    @Bindable
    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
        notifyPropertyChanged(BR.rssi);
    }

    @Bindable
    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
        notifyPropertyChanged(BR.v);
    }

    @Bindable
    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
        notifyPropertyChanged(BR.left);
    }

    @Bindable
    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
        notifyPropertyChanged(BR.right);
    }

    @Bindable
    public String getLog() {
        if (log == null) {
            return "";
        }
        return log;
    }

    public void setLog(String log) {
        this.log = log + "\n" + getLog();
        notifyPropertyChanged(BR.log);
    }

    @Bindable
    public String getName() {
        if (name == null) {
            return "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        notifyPropertyChanged(BR.enabled);
    }

    @Bindable
    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
        notifyPropertyChanged(BR.auto);
    }

    @Bindable
    public String getData() {
        if (data == null) {
            return "";
        }
        return data;
    }

    public void setData(String data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }

    @Bindable
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
        notifyPropertyChanged(BR.desc);
    }

    @Bindable
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
        notifyPropertyChanged(BR.state);
    }
    @Bindable
    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
        notifyPropertyChanged(BR.filter);
    }
}
