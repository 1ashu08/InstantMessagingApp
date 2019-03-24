package com.app.ashu.contactlistview;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageViewHolder> {

    private List<Message> messageList=null;

    public ChatMessageAdapter(List<Message> messageList)
    {
        this.messageList=messageList;
    }

    @Override
    public ChatMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.message_display, parent, false);
        return new ChatMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatMessageViewHolder holder, int position) {
        Message msg = this.messageList.get(position);
        if(msg.TYPE_RECEIVED.equals(msg.getMessageType()))
        {
            holder.leftMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.leftMsgTextView.setText(msg.getMessage());
            holder.rightMsgLayout.setVisibility(LinearLayout.INVISIBLE);
        }
        else if(msg.TYPE_SENT.equals(msg.getMessageType()))
        {
            holder.rightMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.rightMsgTextView.setText(msg.getMessage());
            holder.leftMsgLayout.setVisibility(LinearLayout.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        if(messageList==null)
        {
            messageList=new ArrayList<Message>();
        }
        return messageList.size();
    }
}
