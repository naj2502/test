package com.example.youssef.testtechnique;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
    ParseValue parseValue = new ParseValue();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("test", "");
        setContentView(R.layout.activity_main);
        findViewById(R.id.my_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        final String[] filltext = new String[1];
        Button b = (Button) findViewById(R.id.my_button);
        final EditText editText = (EditText) findViewById(R.id.my_edit);
        parseValue = new ParseValue();
        EditText user = (EditText) findViewById(R.id.enteruser);
        String url = "https://api.github.com/users/"+user.getText()+"/repos";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseValue.setResponse(response);
                        editText.setText(parseValue.parseresponse());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
                editText.setText("didn't work");
                System.out.println(error);
            }
        });
        queue.add(stringRequest);
        b.setClickable(true);
    }
}