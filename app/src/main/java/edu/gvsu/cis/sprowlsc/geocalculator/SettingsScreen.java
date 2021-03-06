package edu.gvsu.cis.sprowlsc.geocalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static java.lang.Integer.valueOf;

public class SettingsScreen extends AppCompatActivity {

    private int distanceSelection = 0;
    private int bearingSelection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        distanceSelection = getIntent().getIntExtra("distanceSelection", 0);
        System.out.println(distanceSelection);
        bearingSelection = getIntent().getIntExtra("bearingSelection", 0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener((View v) -> {
                Intent intent = new Intent();
                intent.putExtra("distanceSelection", distanceSelection);
                intent.putExtra("bearingSelection", bearingSelection);
                setResult(RESULT_OK, intent);
                finish();
        });

        Spinner spinnerDistance = findViewById(R.id.distanceUnits);
        Spinner spinnerBearing = findViewById(R.id.bearingUnits);

        ArrayAdapter<CharSequence> adapterDistance = ArrayAdapter.createFromResource(this,
                R.array.unitsDistance, android.R.layout.simple_spinner_item);

        adapterDistance.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistance.setAdapter(adapterDistance);
        spinnerDistance.post(() -> {
            spinnerDistance.setSelection(distanceSelection);
        });
        spinnerDistance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                distanceSelection = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //spinnerDistanece
        ArrayAdapter<CharSequence> adapterBearing = ArrayAdapter.createFromResource(this,
                R.array.unitsBearing, android.R.layout.simple_spinner_item);

        adapterBearing.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBearing.setAdapter(adapterBearing);
        spinnerBearing.post(() -> {
            spinnerBearing.setSelection(bearingSelection);
        });
        spinnerBearing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bearingSelection = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
