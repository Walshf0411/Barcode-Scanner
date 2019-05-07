package com.walshfernandes.barcodescannerexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public static final int REQUEST_CODE = 9003;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivityForResult(
                                new Intent(Main2Activity.this, MainActivity.class),
                                REQUEST_CODE
                        );
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE ) {
            // result is received from our activity
            if (resultCode == RESULT_OK) {
                // result is OK.
                String barcode = data.getStringExtra("barcode");
                Toast.makeText(Main2Activity.this, "Scanned Barcode: " + barcode, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
