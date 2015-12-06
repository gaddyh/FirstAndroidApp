package com.example.gaddy.myapplication;

import android.content.Intent;
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
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    private Button scanBtn;
    private TextView formatTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);

        scanBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button p1_button = (Button) findViewById(R.id.scan_button);
                //double i;
               // i = Math.random() * 1000;
                //p1_button.setText("bla bla BLA".toLowerCase() + i);

                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                //integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
                //integrator.setPrompt("Scan a barcode");
                //integrator.setCameraId(0);  // Use a specific camera of the device
                //integrator.setBeepEnabled(false);
                //integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();
            }
        });


        }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
       IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
       if (scanResult != null) {
           String scanContent = scanResult.getContents();
           String scanFormat = scanResult.getFormatName();
        //   formatTxt.setText("FORMAT: " + scanFormat);
           Log.i("FORMAT", scanFormat);
           contentTxt.setText("CONTENT: " + scanContent);
           Log.i("CONTENT", scanContent);
       }
       // else continue with any other code you need in the method
     }




        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    public boolean onClick() {
        Button p1_button = (Button) findViewById(R.id.button);
        p1_button.setText("bla");
        return true;
    }
}
