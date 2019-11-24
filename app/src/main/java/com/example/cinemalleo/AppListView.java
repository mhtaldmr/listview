package com.example.cinemalleo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class AppListView extends AppCompatActivity {

    Place [] myPlacesArray = new Place[]{
            new Place("Art Hourse",78701,"airport","This Place is tasty"),
            new Place("Bike Shop", 78702, "beach","Cool bikes"),
            new Place("Camera Fix", 78702, "bus","These guys always rip me off"),
            new Place("YETspace", 78702, "chair", "I LOVE this place"),
            new Place("Secret Space Pad", 94103, "lol","Not very secret, are they?"),
            new Place("Taylors Tailor",60610,"lure","Looking good"),
            new Place("Boathouse", 78701, "tower" ,"That place is full of pirates!"),
            new Place("Not Apple Store", 78702, "spade", "Android rules!"),
            new Place("Tool Battleground", 78702, "chair", "That place is dangerous"),
            new Place("Travelpediocity", 78702, "ticket" ,"This is where i booked my summer trip"),
            new Place("UFO Pick-a-part", 90210, "tower","Out of this world stuff here."),
            new Place("Spawrk’s House", 99999, "lol", "The music is always so good")
            };


    private Button  secondPage =null;
    private ListView mListView = null;
    private ArrayAdapter mArrayAdapter = null;
    private PlaceAdapter mPlaceAdapter = null;
 /*   String[] myStringArray = new  String[]{
            "Alex Albon",
            "Carlos Sainz",
            "Mick Shumi",
            "Mika Hakinen",
            "Lewis Hamilton",
            "Sebastian Vettel",
            "Charles Leclerc",
            "Fernando Alonso",
            "Nico Rosberg"
    };
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        mListView =  findViewById(R.id.myListView);
        /*
        mArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,myStringArray);
        */
        mPlaceAdapter = new PlaceAdapter(getApplicationContext(),R.layout.row,myPlacesArray);

        /*
        if(mListView !=null){
            mListView.setAdapter(mArrayAdapter);
        }
        */
        if(mListView !=null){
            mListView.setAdapter(mPlaceAdapter);
        }


/*
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("Place",myPlacesArray[position].mNameOfPlace);
            }
        });

 */

        /*
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Log.v("PLACE",myStringArray[position]);
            }
        });
        */

        secondPage = findViewById(R.id.secondpage);
        secondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(view.getContext(),Main2Activity.class);
                startActivity(s);
            }
        });

    }
}