package com.andriod.lennyface.monstamath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

import static com.andriod.lennyface.monstamath.R.layout.activity_main;
import static com.andriod.lennyface.monstamath.R.layout.character_select;

public class Character_Select extends AppCompatActivity {
    // Array list because when i send the choosen numbers as an intent it likes arraylist better for some reason not sure why
    // boolean to tell is the start button is pushed
    // string for the type of the math the palyer chppses to do
    ArrayList<Integer> pickedNums = new ArrayList<>();
    boolean isrunning = false;
    String mathType = "";

    // Buttons for the corrispoding layout so they can be assigned to do something when they are clicked
    Button bAllMath;
    ImageButton numZero, numOne, numTwo, numThree, numFour, numFive, numSix, numSeven, numEight, numNine;
    ImageButton additionClass, subtractionClass, multiplicationClass, divisionClass;
    ImageButton characterSelectBack, startGame;
    // game constructor
    GameMain game;

       // when the activity is created it will initialize all the buttons, get the window background for the layout, 
       // and have what all the buttons do when they are clicked
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(character_select);
        getWindow().setBackgroundDrawableResource(R.drawable.brown_background);


        numZero = (ImageButton) findViewById(R.id.zeroBtn);
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



    }

        // puts the numbers the player picks into the picknums arraylist
    public void setPickedNums(int num)
    {
        int n = 0;
        if(n < 10)
        {
            pickedNums.add(num);
            n++;
        }
        // test to make sure that the numbers are being put into the arraylist
        Log.d("yea","here it is " + num);
    }
    // puts all the numbers in the array list
    public void setAllNumsPicked()
    {
        for(int i = 0; i < 10; i++)
        {

            pickedNums.add(i);
            // test to see if the numbers are actually in the arraylist
            Log.d("yea","here it is " + pickedNums.get(i));
        }
    }
    // sets the math type to what the player wants
    public void pickClass(String localMathClass)
    {
        mathType = localMathClass;
        // test to see is the math type is correct
        Log.d("yea","here it is " + mathType);
    }
    // sets the boolean run to true, makes an intent that for the game and sends over the arraylist, mathtype, and boolean to GameMain
    public void runGame()
    {
        isrunning = true;
        Intent gameMain_intent = new Intent(this, GameMain.class);
        gameMain_intent.putExtra("character", mathType);
        gameMain_intent.putExtra("boolean", isrunning);
        gameMain_intent.putIntegerArrayListExtra("int array",pickedNums);
        Log.d("character", pickedNums.toString());
        startActivity(gameMain_intent);
    }
       // back button which goes to previous screen
    public void goBack()
    {
        finish();
    }


}
