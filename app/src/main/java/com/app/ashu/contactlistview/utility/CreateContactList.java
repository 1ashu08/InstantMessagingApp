package com.app.ashu.contactlistview.utility;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.ashu.contactlistview.httpUtility.CreateContact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateContactList {

    List<String> nonMember;
    List<String> presentMember;

    public CreateContactList()
    {
        nonMember=new ArrayList<String>();
        presentMember=new ArrayList<String>();
    }

    public ArrayList<String> fetchContact(Context ctx){

        ArrayList<String> numberList=new ArrayList<String>();

        Cursor cursor = ctx.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

        while (cursor.moveToNext()) {
            //String phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            String phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


            numberList.add(name + " "  + ":" + " " + phonenumber);
        }

        cursor.close();

        return numberList;

    }

    public ArrayList<String> filterNumberList(List<String> numberList)
    {
        ArrayList<String> newList=new ArrayList<String>();
        for(String data:numberList)
        {
            if(!newList.contains(data))
            {
                newList.add(data);
            }
        }
        return newList;
    }

    public JSONObject getJSONObject(String number) {
        JSONObject obj = new JSONObject();
        try
        {

            obj.put("Id",number);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public JSONObject prepareJsonObject(List<String> numberList)
    {
        //JSONArray jsonArray = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        for (int i = 0; i < numberList.size(); i++) {

            try {
                jsonObj.put("data:" + String.valueOf(i + 1),getJSONObject(numberList.get(i)));
                //jsonArray.put(getJSONObject(numberList.get(i)));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return jsonObj;
    }


    public HashMap<String,ArrayList<String>> getContactList(Context ctx)
    {
        ArrayList<String> allContact=fetchContact(ctx);
        allContact=filterNumberList(allContact);

        JSONObject jsonObj=prepareJsonObject(allContact);
        CreateContact contact=new CreateContact();

        contact.validateNumberList(jsonObj,ctx);

        System.out.println(CreateContact.output);
        HashMap<String,ArrayList<String>> ret=new HashMap<String,ArrayList<String>>();

        ArrayList<String> activeContact=new ArrayList<String>();
        ArrayList<String> inActiveContact=new ArrayList<String>();
        for(int i=0;i<allContact.size();i++)
        {
            if(i%2==0)
            {
                activeContact.add(allContact.get(i));
            }
            else
            {
                inActiveContact.add(allContact.get(i));
            }
        }
        ret.put("Active",activeContact);
        ret.put("InActive",inActiveContact);

        return ret;
    }
}


