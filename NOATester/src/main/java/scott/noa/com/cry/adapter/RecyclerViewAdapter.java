package scott.noa.com.cry.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by noalabs on 2017/5/16.
 */

public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<MenuViewHolder> implements View.OnClickListener{

    public final static String LOG_TAG=RecyclerViewAdapter.class.getName();
    protected List<T> mDatas;
    protected int mLayoutId;
    protected int mVariableId;


    public RecyclerViewAdapter(int layoutId , int variableId , List<T> datas) {
        mDatas = datas;
        mVariableId = variableId;
        mLayoutId = layoutId;
    }


    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
        v.setOnClickListener(this);
        return new MenuViewHolder(v);
    }


    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        convert(holder , mDatas.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public void onClick(View v) {
        onClick(v,(int)v.getTag());
    }

    public abstract void convert(MenuViewHolder holder, T t);
    public abstract void onClick(View view, int position);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
