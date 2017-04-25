package com.andriod.lennyface.monstamath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static com.andriod.lennyface.monstamath.R.layout.activity_main;
import static com.andriod.lennyface.monstamath.R.layout.character_select;

public class Character_Select extends AppCompatActivity {

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



    public void setPickedNums(int num)
    {
        int n = 0;
        if(n < pickedNums.length)
        {
            pickedNums[n] = num;
            n++;
        }
        Log.d("yea","here it is " + num);
    }

    public void setAllNumsPicked()
    {
        for(int i = 0; i < pickedNums.length; i++)
        {
            pickedNums[i] = i;
        }
    }

    public void pickClass(String localMathClass)
    {
        mathType = localMathClass;
        Log.d("yea","here it is " + mathType);
    }

    public void runGame()
    {
        isrunning = true;
        Intent gameMain_intent = new Intent(this, GameMain.class);
        startActivity(gameMain_intent);
    }

    public void goBack()
    {
        finish();
    }


}
