package com.app.ashu.contactlistview.Holder;

import android.graphics.drawable.Icon;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.ashu.contactlistview.R;

public class UserHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView number;
    public ImageView displayPic;
    public UserHolder(View itemView)
    {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.name);
        number=(TextView)itemView.findViewById(R.id.number);
        displayPic=(ImageView)itemView.findViewById(R.id.imageView);
    }
}
