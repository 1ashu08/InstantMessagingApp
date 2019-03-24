package com.app.ashu.contactlistview.utility;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.ashu.contactlistview.Holder.UserHolder;
import com.app.ashu.contactlistview.Message;
import com.app.ashu.contactlistview.R;

import java.util.ArrayList;
import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<UserHolder> {

    private List<String> userList=null;

    public ContactListAdapter(List<String> userList)
    {
        this.userList=userList;
    }
    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.contact_display, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        String userInfo=userList.get(position);
        holder.number.setText(userInfo.split(":")[0]);
        holder.name.setText(userInfo.split(":")[1]);
    }

    @Override
    public int getItemCount() {
        if(userList==null)
        {
            userList=new ArrayList<String>();
            return 0;
        }
        return userList.size();
    }
}
