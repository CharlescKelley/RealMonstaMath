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
import android.widget.ImageButton;
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
        Button titleScreen;

    // options menu

        //Buttons (back button and go to music select)
    Button optionsBack;
    Button musicSelection;

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

    int[] pickedNums = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    boolean isrunning = false;
    String mathType = "";

    Button bAllMath;
    ImageButton numZero, numOne, numTwo, numThree, numFour, numFive, numSix, numSeven, numEight, numNine;
    ImageButton additionClass, subtractionClass, multiplicationClass, divisionClass;
    ImageButton characterSelectBack, startGame;


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

        numZero = (ImageButton) character_select.findViewById(R.id.zeroBtn);
        numOne = (ImageButton) findViewById(R.id.oneBtn);
        numTwo = (ImageButton) findViewById(R.id.twoBtn);
        numThree = (ImageButton) findViewById(R.id.threeBtn);
        numFour = (ImageButton) findViewById(R.id.fourBtn);
        numFive = (ImageButton) findViewById(R.id.fiveBtn);
        numSix = (ImageButton) findViewById(R.id.sixBtn);
        numSeven = (ImageButton) findViewById(R.id.sevenBtn);
        numEight = (ImageButton) findViewById(R.id.eightBtn);
        numNine = (ImageButton) findViewById(R.id.nineBtn);
        characterSelectBack = (ImageButton) findViewById(R.id.backBtn);
        additionClass = (ImageButton) findViewById(R.id.additionBtn);
        subtractionClass = (ImageButton) findViewById(R.id.subtractionBtn);
        multiplicationClass = (ImageButton) findViewById(R.id.multiplicationBtn);
        divisionClass = (ImageButton) findViewById(R.id.divisionBtn);
        bAllMath = (Button) findViewById(R.id.allNumBtn);
        startGame = (ImageButton) findViewById(R.id.startBtn);


        numZero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(0);
            }
        });

        numOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(1);
            }
        });

        numTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(2);
            }
        });

        numThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(3);
            }
        });

        numFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(4);
            }
        });

        numFive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(5);
            }
        });

        numSix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(6);
            }
        });

        numSeven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(7);
            }
        });

        numEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(8);
            }
        });

        numNine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setPickedNums(9);
            }
        });

        bAllMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllNumsPicked();
            }
        });

        additionClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickClass("addition");
            }
        });

        subtractionClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickClass("subtraction");
            }
        });

        multiplicationClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickClass("multiplication");
            }
        });

        divisionClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickClass("division");
            }
        });

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runGame();
            }
        });

        characterSelectBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        //SQLiteOpenHelper dbHelpler = new DB_helper(this); // instance  casted as the super class to
        // call methods of super class easier

       // database_SaveGame = dbHelpler.getWritableDatabase();

       // GameMain game = new GameMain(pickedNums, isrunning, mathType);
    }

    private void changeToCharacterSelect()
    {
        getWindow().setBackgroundDrawableResource(R.drawable.brown_background);
        setContentView(character_select);
    }


    public void setPickedNums(int num)
    {
        int n = 0;
        if(n < pickedNums.length)
        {
            pickedNums[n] = num;
            n++;
        }

    }

    public void setAllNumsPicked()
    {
        for(int i = 0; i < pickedNums.length; i++)
        {
            pickedNums[i] = i;
        }
    }

    public void pickClass(String mathClass)
    {
        mathType = mathClass;
    }

    public void runGame()
    {
        isrunning = true;
        getWindow().setBackgroundDrawableResource(R.drawable.ui_normal);
    }

    public void goBack()
    {
        getWindow().setBackgroundDrawableResource(R.drawable.title_screen);
        setContentView(activity_main);
    }



}
