package com.example.recycleview.demo2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mac on 2020-04-05.
 */
public abstract class TypeAbstracViewHolder extends RecyclerView.ViewHolder {


    public TypeAbstracViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(DataModel dataModel);


}
