package com.app.ashu.contactlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SpecificUserMessage extends AppCompatActivity {


    static  String dName;
    EditText msgBx;
    TextView displayName;

    ArrayList<Message> messageList=new ArrayList<Message>();
    ChatMessageAdapter messageAdapter ;
    RecyclerView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_user_message);

        msgBx=(EditText)findViewById(R.id.messageBox);
        displayName=(TextView)findViewById(R.id.displayName);

        System.out.println("before message View");

        messageView=(RecyclerView)findViewById(R.id.messageView);

        messageView.setLayoutManager(new LinearLayoutManager(this));

        messageView.getLayoutManager().setMeasurementCacheEnabled(false);
        System.out.println("After view");

        messageAdapter= new ChatMessageAdapter(messageList);

        DisplayMetrics mt=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mt);



        msgBx.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(event.getAction()==KeyEvent.ACTION_DOWN && keyCode==KeyEvent.KEYCODE_ENTER)
                {

                    updateMessageList(msgBx.getText().toString());
                    //Toast.makeText(SpecificUserMessage.this,msgBx.getText().toString(), Toast.LENGTH_LONG).show();


                    System.out.println(msgBx.getText().toString());
                    return true;
                }
                return false;
            }
        });

        msgBx.setText("");
        msgBx.setWidth(mt.widthPixels);

        displayName.setWidth(mt.widthPixels);

        displayName.setText(dName);

        messageView.setAdapter(messageAdapter);

    }

    public void updateMessageList(String text)
    {
        Message msg=new Message(text);
        messageList.add(msg);
        msgBx.setText("");
        messageAdapter.notifyDataSetChanged();
    }
}
