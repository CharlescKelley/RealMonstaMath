package com.andriod.lennyface.monstamath;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.andriod.lennyface.monstamath.database.DB_helper;

import org.w3c.dom.Text;

import static com.andriod.lennyface.monstamath.R.layout.activity_main;


public class MainActivity extends AppCompatActivity {
    //SQLiteDatabase database_SaveGame; // reference to database object
//
//    // main menu screen
//
//        //Buttons (Start the game, go to options menu or go to extras menu)
//    Button playGame;
//    Button optionsMainMenu;
//    Button extras;
//
//    // character select screen
//
//        //Buttons (Numbers player can choose to use, characters player can play as and back button)
//
//
//    // options menu
//
//        //Buttons (back button and go to music select)
//    Button optionsBack;
//    Button musicSelection;
//
//    // Extras
//
//        //Buttons ( Player statistics, Monster/math symbols guide and back button)
//    Button statistics;
//    Button beastiary;
//    Button extrasBack;
//
//        //TextView ()
//    TextView numAnsCorr;
//    TextView numAnsWrong;
//    TextView ansPercentage;
//    TextView charactersCompleted;

        // Variables




    Button titleScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_main);


        getWindow().setBackgroundDrawableResource(R.drawable.title_screen);


        titleScreen = (Button) findViewById(R.id.titleScreenButton);
        titleScreen.setBackgroundColor(Color.TRANSPARENT);

        titleScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToCharacterSelect();

            }
        });



        //SQLiteOpenHelper dbHelpler = new DB_helper(this); // instance  casted as the super class to
        // call methods of super class easier

       // database_SaveGame = dbHelpler.getWritableDatabase();

       // GameMain game = new GameMain(character_select.pickedNums, isrunning, mathType);
    }

    private void changeToCharacterSelect()
    {
        Intent character_select_intent = new Intent(this, Character_Select.class);
        startActivity(character_select_intent);
    }


}
