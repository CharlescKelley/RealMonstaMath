package com.andriod.lennyface.monstamath;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andriod.lennyface.monstamath.database.DB_helper;

import org.w3c.dom.Text;

import static com.andriod.lennyface.monstamath.R.layout.activity_main;
import static com.andriod.lennyface.monstamath.R.layout.character_select;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database_SaveGame; // reference to database object

    // main menu screen

        //Buttons (Start the game, go to options menu or go to extras menu)
    Button playGame;
    Button optionsMainMenu;
    Button extras;

    // character select screen

        //Buttons (Numbers player can choose to use, characters player can play as and back button)
//    Button numZero;
//    Button numOne;
//    Button numTwo;
//    Button numThree;
//    Button numFour;
//    Button numFive;
//    Button numSix;
//    Button numSeven;
//    Button numEight;
//    Button numNine;
//    Button characterSelectBack;
//    Button additionClass = (Button) findViewById(R.id.additionButton);
//    Button subtractionClass = (Button) findViewById(R.id.subtractionButton);
//    Button multiplicationClass = (Button) findViewById(R.id.multiplicationButton);
//    Button divisionClass = (Button) findViewById(R.id.divisionButton);
//    Button bAllMath = (Button) findViewById(R.id.bAllMath);;

        // TextViews ( Show the names of the character and what math they do )
//    TextView additionName;
//    TextView subtractionName;
//    TextView multiplicationName;
//    TextView divisionName;
//    TextView tAllMath;



    // options menu

        //Buttons (back button and go to music select)
    Button optionsBack;
    Button musicSelection;

        // TextViews ( Text to display music names)





    // Extras

        //Buttons ( Player statistics, Monster/math symbols guide and back button)
    Button statistics;
    Button beastiary;
    Button extrasBack;

        //TextView ()
    TextView numAnsCorr;
    TextView numAnsWrong;
    TextView ansPercentage;
    TextView charactersCompleted;






        // Variables

    int[] pickedNums = new int[10];
    boolean isrunning = false;
    String mathType = "";



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

        SQLiteOpenHelper dbHelpler = new DB_helper(this); // instance  casted as the super class to
                                                          // call methods of super class easier


        database_SaveGame = dbHelpler.getWritableDatabase();



        //GameMain game = new GameMain(pickedNums, isrunning, mathType);

    }

    private void changeToCharacterSelect()
    {
        getWindow().setBackgroundDrawableResource(R.drawable.brown_background);
        setContentView(character_select);
    }

}
