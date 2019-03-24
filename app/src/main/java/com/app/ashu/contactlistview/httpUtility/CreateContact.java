package com.app.ashu.contactlistview.httpUtility;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class CreateContact {

    public static JSONObject output;

    public void validateNumberList(JSONObject jsonObj, Context ctx)
    {
        System.out.println("In request body");
        RequestQueue queue = Volley.newRequestQueue(ctx);
        String url ="http://www.google.com";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,jsonObj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // your implementation
                System.out.println("Response is: "+ response);
                output=response;
                //System.out.println(presentMember);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // your implementation
                System.out.println("That didn't work!");
            }
        });

// Request a string response from the provided URL.
        /*StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //textView.setText("Response is: "+ response.substring(0,500));
                        System.out.println("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
                System.out.println("That didn't work!");
            }


        });*/

// Add the request to the RequestQueue.
        //queue.add(stringRequest);


    }

}
