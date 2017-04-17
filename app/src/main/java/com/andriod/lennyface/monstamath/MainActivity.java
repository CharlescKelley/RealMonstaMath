package com.andriod.lennyface.monstamath;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.andriod.lennyface.monstamath.database.DB_helper;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database_SaveGame; // reference to database object

    // main menu screen

        //Buttons (Start the game, go to options menu or go to extras menu)
    Button playGame;
    Button optionsMainMenu;
    Button extras;

    // character select screen

        //Buttons (Numbers player can choose to use, characters player can play as and back button)
    Button numZero;
    Button numOne;
    Button numTwo;
    Button numThree;
    Button numFour;
    Button numFive;
    Button numSix;
    Button numSeven;
    Button numEight;
    Button numNine;
    Button characterSelectBack;
    Button addition;
    Button subtraction;
    Button multiplication;
    Button division;
    Button bAllMath;

        // TextViews ( Show the names of the character and what math they do )
    TextView additionName;
    TextView subtractionName;
    TextView multiplicationName;
    TextView divisionName;
    TextView tAllMath;



    // options menu

        //Buttons (back button and go to music select)
    Button optionsBack;
    Button musicSelection;

        // TextViews ( Text to display music names)
    TextView musicOne;
    TextView musicTwo;
    TextView musicThree;
    TextView musicFour;
    TextView musicFive;
    TextView musicSix;
    TextView musicSeven;
    TextView musicEight;
    TextView musicNine;
    TextView musicTen;




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




    //Level Change Screen

        //Buttons (continue button)
    Button next; // cant write continue, guessing its a ... one of them words u cant use

        //TextView ()
    TextView lvCorrAns;
    TextView lvWrongAns;
    TextView ansPercent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteOpenHelper dbHelpler = new DB_helper(this); // instance  casted as the super class to
                                                          // call methods of super class easier
        database_SaveGame = dbHelpler.getWritableDatabase();

    }
}
