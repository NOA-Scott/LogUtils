package scott.noa.com.cry.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by noalabs on 2017/5/16.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder{

    private ViewDataBinding mBinding;

    public MenuViewHolder(View v) {
        super(v);
        mBinding = DataBindingUtil.bind(v);
    }

    public MenuViewHolder setBinding(int variableId , Object object){
        mBinding.setVariable(variableId , object);
        mBinding.executePendingBindings();
        return this;
    }
}
