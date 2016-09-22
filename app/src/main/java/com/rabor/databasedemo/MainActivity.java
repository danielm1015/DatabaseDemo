/*
 * Copyright (c) 2016. All Rights Reserved.
 */

package com.rabor.databasedemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    EditText inputEditText;
    EditText descEditText;
    Button showAllButton;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        descEditText = (EditText) findViewById(R.id.descEditText);
        inputEditText = (EditText) findViewById(R.id.inputEditText);
        showAllButton = (Button) findViewById(R.id.showAllButton);

        dbHandler = new MyDBHandler(this);

    }

    // add a product to the database
    public void addClick(View view) {
        Products products = new Products(inputEditText.getText().toString());
        dbHandler.addProduct(products);
    }

    // delete items
    public void deleteClick(View view) {
        String inputText = inputEditText.getText().toString();
        dbHandler.deleteProduct(inputText);
    }

    public void displayClick(View view) {
        List<Products> dbString = dbHandler.databaseToString();
        String log="";
        for (Products pn : dbString) {
            log += "\nName: " + pn.get_productname() + "\n";

          }

        Intent i = new Intent(this, DisplayListActivity.class);

        i.putExtra("log", log);
        startActivity(i);

        inputEditText.setText("");
        descEditText.setText("");

    }

}
