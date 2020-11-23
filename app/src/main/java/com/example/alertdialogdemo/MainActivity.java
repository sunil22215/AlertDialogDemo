package com.example.alertdialogdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bindLayoutView();
        setUpDataWithView();
    }

    private void bindLayoutView() {
     button = (Button) findViewById(R.id.button);   
    }
    
    private void setUpDataWithView() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExampleAlertDialog();
            }
        });
    }

    private void showExampleAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.dailog_massage).setTitle(R.string.dailog_title);

                builder.setMessage("Do you want to close this app");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        Toast.makeText(getApplicationContext(), "you choose yes action for alertbox", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        Toast.makeText(getApplicationContext(), "you selected No action for alertbox", Toast.LENGTH_LONG).show();

                    }
                });
                AlertDialog alert = builder.create();

                alert.setTitle("Alert dialog Example");
                alert.show();
    }
}
