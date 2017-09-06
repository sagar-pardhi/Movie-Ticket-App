package com.example.android.movieticketsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class ScanActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {

    BarcodeReader barcodeReader;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        barcodeReader = (BarcodeReader)getSupportFragmentManager()
                .findFragmentById(R.id.barcode_scanner);
    }

    public void onScanned(Barcode barcode){
        barcodeReader.playBeep();

        Intent intent = new Intent(ScanActivity.this, TicketResultActivity.class);
        intent.putExtra("code", barcode.displayValue);
        startActivity(intent);
    }

    public void onScannedMultiple(List<Barcode> list) {

    }

    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    public void onScanError(String s){
        Toast.makeText(getApplicationContext(), "Error occured while scanning" + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
