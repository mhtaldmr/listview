package com.example.cinemalleo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    public Button previousPageButton = null;
    public Spinner mSpinner = null;
    public Button mPerformButton = null;
    public Button nextPageButton = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String detailValue = extras.getString("KeepForSending");
            if (detailValue != null) {
            Toast.makeText(this,detailValue,Toast.LENGTH_SHORT).show();
            }
        }

        nextPageButton = findViewById(R.id.nextpagebutton);
        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextpage= new Intent(view.getContext(), AppListView.class);
                startActivity(nextpage);
            }
        });

        mSpinner = findViewById(R.id.spinnerSelection);
        previousPageButton = findViewById(R.id.button2);
        previousPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Intent returnIntent = new Intent();
                String mySelection = mSpinner.getSelectedItem().toString();
                returnIntent.putExtra("KeyForReturning",mySelection);
                setResult(RESULT_OK,returnIntent);
                finish();
             */
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });


        mPerformButton = (Button) findViewById(R.id.button3);
        mPerformButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                     int position = mSpinner.getSelectedItemPosition();
                     Intent implicitIntent = null;
                     switch(position){
                         case 0:
                         //nothing selected
                         break;
                         case 1:
                         //deltaprogram.us
                         implicitIntent = new Intent(Intent.ACTION_VIEW,
                              Uri.parse("http://formula1.com"));
                         break;
                         case 2:
                         //Call someone
                         implicitIntent = new Intent(Intent.ACTION_DIAL,
                             Uri.parse("tel:(+90)5546543689"));
                         break;
                         case 3:
                        //Map of YETspace using geo intent
                         implicitIntent = new Intent(Intent.ACTION_VIEW,
                             Uri.parse("geo:30.2715,-97.742"));
                         break;
                         case 4:
                         //take a picture (not returning it here tho)
                         implicitIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                         break;
                           case 5:
                         //edit first contact
                         implicitIntent = new Intent(Intent.ACTION_EDIT,
                                 Uri.parse("content://photos/1"));
                         break;
                     }
                        if(implicitIntent != null){
                        if(isIntentAvailable(implicitIntent) == true){
                         startActivity(implicitIntent);
                         }else{
                         Toast.makeText(view.getContext(),"no application available",Toast.LENGTH_LONG).show();
                         }
                     }
                 }
         });


         }




     public boolean isIntentAvailable(Intent intent){
         PackageManager packageManager = getPackageManager();
         List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,0);
         boolean isIntentSafe = activities.size() > 0;
         return isIntentSafe;
         }


}