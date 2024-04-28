package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BillingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] courses = { "C", "Data structures Data structures Data structures",
            "Interview prep", "Algorithms",
            "DSA with java", "OS" };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billing_activity);
       /* LinearLayout item = (LinearLayout) findViewById(R.id.parentLayout);
        LayoutInflater layoutInflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custome_layout, item );*/
        Spinner spinnerItem = findViewById(R.id.item_spinner_1);

        spinnerItem.setOnItemSelectedListener(this);

        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                R.layout.spinner_item,
                courses);
        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spinnerItem.setAdapter(ad);
    }
    public void onItemSelected(AdapterView arg,
                               View arg1,
                               int position,
                               long id)
    {

        // make toastof name of course
        // which is selected in spinner
        Toast.makeText(getApplicationContext(),
                        courses[position],
                        Toast.LENGTH_LONG)
                .show();
    }


    public void onNothingSelected(AdapterView arg0)
    {
        // Auto-generated method stub
    }
}
