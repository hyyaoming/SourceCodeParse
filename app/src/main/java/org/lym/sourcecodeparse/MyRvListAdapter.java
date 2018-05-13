package org.lym.sourcecodeparse;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/4/16
 */

public class MyRvListAdapter extends RecyclerView.Adapter<MyRvListAdapter.MyViewHolder> {

    private Class[] mClazz;
    private String[] mName;
    private Context mContext;

    MyRvListAdapter(Context context, Class[] clazz, String[] name) {
        this.mClazz = clazz;
        this.mName = name;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rv_list_item, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.mTv.setText(mName[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, mClazz[position]));
            }
        });
    }


    @Override
    public int getItemCount() {
        return mClazz.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTv;

        MyViewHolder(View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.tv_list);
        }
    }
}
