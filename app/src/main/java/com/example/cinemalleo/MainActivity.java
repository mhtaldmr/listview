package com.example.cinemalleo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    private Button mbutton= null;
    private String status = "";
    int order=0;
    public static final int DATA_REQUEST= 1;
    private TextView mSelectedView = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSelectedView =  findViewById(R.id.userSelection);

        mbutton = findViewById(R.id.button1);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Main2Activity.class);
                i.putExtra("KeyForSending","Some data to show");
                startActivityForResult(i,DATA_REQUEST);
            }
        });

        status = "Activity Created";
        displayStatus();


        Intent httpIntent = getIntent();
        String aksiyon = httpIntent.getAction();
        if(aksiyon !=null  &&  aksiyon.equals(Intent.ACTION_VIEW)){
            Uri data=httpIntent.getData();
            if(data != null){
                mSelectedView.setText(data.toString());
            }
        }
    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//       if(resultCode==RESULT_OK && resultCode==DATA_REQUEST) {
//           if (data.hasExtra("KeyForReturning")) {
               String myValue = data.getExtras().getString("KeyForReturning");
               mSelectedView.setText(myValue);
           }




    @Override
    protected void onStart() {
        //activity resumed
        super.onStart();
        status = "Activity Started";
      //  displayStatus();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //restoring instance state
        super.onRestoreInstanceState(savedInstanceState);
        status = "Restoring Instance";
      //  displayStatus();

    }

    @Override
    protected void onResume() {
        //activity resumed
        super.onResume();
        status = "Activity Resumed";
     //   displayStatus();
    }

    @Override
    protected void onPause() {
        //activity paused
        super.onPause();
        status = "Activity Paused";
     //   displayStatus();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //saving instance state
        super.onSaveInstanceState(outState);
        status = "Saving Instance";
     //   displayStatus();

    }

    @Override
    protected void onStop() {
        //activity stopped
        super.onStop();
        status = "Activity Stopped";
      //  displayStatus();
    }

    @Override
    protected void onDestroy() {
        //activity destroyed
        super.onDestroy();
        status = "Activity Destroyed";
      //  displayStatus();
    }

    @Override
    protected void onRestart() {
        //activity destroyed
        super.onRestart();
        status = "Activity Restarted";
     //   displayStatus();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    public void displayStatus(){
        order++;
        String message = String.valueOf(order) + ": " + status;
        //t.setText(status);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
