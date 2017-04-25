package com.andriod.lennyface.monstamath;


import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;

import static com.andriod.lennyface.monstamath.R.layout.character_select;
import static com.andriod.lennyface.monstamath.R.layout.gamemain;


public class GameMain  extends AppCompatActivity {



    //Buttons ( Num select for answering questions, button to go to options menu, enter answer
    // and back button for if player enters the wrong num by accident)

    //Button optionsDuringGame = (Button) findViewById(R.id.optionsButton);
    ImageButton gameNumZero, gameNumOne, gameNumTwo, gameNumThree, gameNumFour, gameNumFive;
    ImageButton gameNumSix, gameNumSeven, gameNumEight, gameNumNine, gameBack, gameEnter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(gamemain);

        gameNumZero = (ImageButton) findViewById(R.id.zeroBtn);
        gameNumOne = (ImageButton) findViewById(R.id.oneBtn);
        gameNumTwo = (ImageButton) findViewById(R.id.twoBtn);
        gameNumThree = (ImageButton) findViewById(R.id.threeBtn);
        gameNumFour = (ImageButton) findViewById(R.id.fourBtn);
        gameNumFive = (ImageButton) findViewById(R.id.fiveBtn);
        gameNumSix = (ImageButton) findViewById(R.id.sixBtn);
        gameNumSeven = (ImageButton) findViewById(R.id.sevenBtn);
        gameNumEight = (ImageButton) findViewById(R.id.eightBtn);
        gameNumNine = (ImageButton) findViewById(R.id.nineBtn);
        gameBack = (ImageButton) findViewById(R.id.backBtn);
        gameEnter = (ImageButton) findViewById(R.id.eightBtn);
    }
//
//    //Level Change Screen
//
//    //Buttons (continue button)
//    Button next; // cant write continue, guessing its a ... one of them words u cant use
//
//    //TextView ()
//    TextView lvCorrAns;
//    TextView lvWrongAns;
//    TextView ansPercent;
//
//    //TextView
//
//    TextView textCharacterName = (TextView) findViewById(R.id.displayCharacterName);
//    TextView textMonsterName = (TextView) findViewById(R.id.displayMonsterName);
//    TextView textTimer =(TextView) findViewById(R.id.displayTimer);
//    TextView textPlayerHealth = (TextView) findViewById(R.id.displayPlayerHealth);
//    TextView textMonsterHealth = (TextView) findViewByid(R.id.displayMonsterHealth);
//    TextView textPlayerNum = (TextView) findViewById(R.id.displayPlayerNum);
//    TextView textMonsterNum = (TextView) findViewById(R.id.displayMonsterNum);
//    TextView textMathSymbol = (TextView) findViewById(R.id.displayMathSymbol);
//    TextView textDeath = (TextView) findViewById(R.id.displayDeathMessage);
//    TextView textWin = (TextView) findViewById(R.id.displayWinMessage);
//
//    // EditText
//    EditText playerAnswer = (EditText) findViewById(R.id.displayPlayerAns);
//
//    // Variables
//        // Game variables
//    int lv = 1;
//    int lives = 3;
//    int monsterCount;
//    int[] nums = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
//    int userIntAnswer = 0;
//    String playerType = "";
//    String monsterName = "";
//    String userStringAnswer = "";
//    boolean run;
//    boolean endRound = false;
//    Random rand = new Random();
//
//
//
//        // Character varaibles
//    private int playerHealth =  100;
//    private int playerDamage = 4;
//        // Monster variables
//    private int monsterHealth = 50;
//    private int monsterDamage = 5;
//
//    // Constructors
//    Player player = new Player(playerHealth, playerDamage, lv, lives);
//    Monster monster = new Monster(monsterHealth, monsterDamage, lv);
//    MathLogic mathProblem = new MathLogic(nums);
//    Battle battle = new Battle();
//    Timer timer = new Timer(lv, playerType);
//
//
//    public GameMain(int[] pickedNums, boolean isRunning, String mathType)
//    {
//        for(int i = 0; i <= 9; i++)
//        {
//            nums[i] = pickedNums[i];
//        }
//
//        run = isRunning;
//        playerType = mathType;
//    }
//
//
//    private void runGame(boolean run)
//    {
//        if(run == true)
//        {
//            game();
//        }
//        //else //display title screen;
//
//    }
//
//    private void game()
//    {
//        String dead = "YOU DIED!";
//        String winLv = "YOU WON.... this level. ON TO THE NEXT!!";
//        String winMath = "YOU WON.... this math version. ON TO THE NEXT!!";
//        String megaWin = "YOU BEAT THE WHOLE GAME!!!";
//        if(lives != 0) {
//
//            timer.setTime();
//            time();
//            nameOfMonsterForDisplay();
//            setTextViews();
//
//            gameEnter.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    userIntAnswer = Integer.parseInt(userStringAnswer);
//                }
//            });
//
//
//            if(playerType != "allMath" && lv < 15 )
//            {
//
//                gameRound(dead, winLv, winMath);
//
//
//            }
//            else if (playerType == "allMath")
//            {
//                gameRound(dead, winLv, megaWin);
//            }
//            run = true;
//            runGame(run);
//
//        }
//        else if (lives == 0)
//        {
//            textDeath.setText("YOU DIED AND HAVE NO MORE LIVES LEFT!!");
//            run = false;
//            runGame(run);
//        }
//
//
//    }
//
//    private void setTextViews()
//    {
//        mathProblem.createPlayerNum();
//        mathProblem.createMonsterNum();
//
//        textCharacterName.setText(playerType);
//        textMonsterName.setText(monster.setMonster());
//        textMonsterNum.setText(mathProblem.monsterNum);
//        textPlayerNum.setText(mathProblem.playerNum);
//        textPlayerHealth.setText(player.setHealth());
//        textMonsterHealth.setText(monster.setHealth());
//        if(playerType == "addition")
//        {
//            textMathSymbol.setText("+");
//        }
//        else if(playerType == "subtraction")
//        {
//            textMathSymbol.setText("-");
//        }
//        else if(playerType == "multiplication")
//        {
//            textMathSymbol.setText("x");
//        }
//        else textMathSymbol.setText("/");
//    }
//
//    private void nameOfMonsterForDisplay()
//    {
//        if(lv <= 13)
//        {
//            monster.chooseMonster();
//        }
//        else if (lv == 14 && playerType != "allMath")
//        {
//            switch(playerType)
//            {
//                case "addition":
//                    monster.chooseBoss(0);
//                    break;
//
//                case "subtraction":
//                    monster.chooseBoss(1);
//                    break;
//
//                case "multiplication":
//                    monster.chooseBoss(2);
//                    break;
//
//                case "division":
//                    monster.chooseBoss(3);
//                    break;
//            }
//
//        }
//        else if(lv >= 14 && playerType == "allMath")
//        {
//            switch(lv)
//            {
//                case 14:
//                    monster.chooseBoss(0);
//                    break;
//                case 15:
//                    monster.chooseBoss(1);
//                    break;
//                case 16:
//                    monster.chooseBoss(2);
//                    break;
//                case 17:
//                    monster.chooseBoss(3);
//                    break;
//                case 18:
//                    monster.chooseBoss(4);
//                    break;
//            } // switch
//
//        } // end else if
//    } // end method nameOfMonsterForDisplay
//
//
//    private void time()
//    {
//
//        CountDownTimer countDown = new CountDownTimer(timer.getStartTime(), timer.getInterval()) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                textTimer.setText((int) (millisUntilFinished/1000));
//            }
//
//            @Override
//            public void onFinish() {
//                endRound = true;
//            }
//        }.start();
//
//    }
//
//    private void getUserInput()
//    {
//        gameNumZero.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "0";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//
//        gameNumOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "1";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//
//        gameNumTwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "2";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//
//        gameNumThree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "3";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//
//        gameNumFour.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "4";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//
//        gameNumFive.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "5";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//
//        gameNumSix.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "6";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//
//        gameNumSeven.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "7";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//
//        gameNumEight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "8";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//
//        gameNumNine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(userStringAnswer.length() <= 2) {
//                    userStringAnswer += "9";
//                    playerAnswer.setText(userStringAnswer);
//                }
//            }
//        });
//    }
//
//    private void gameRound(String death, String miniWin, String bigWin)
//    {
//        int correctAnswer = mathProblem.mathSwitch(playerType);
//        int pH = player.setHealth();
//        int mH = monster.setHealth();
//        int pD = player.setDamage();
//        int mD = monster.setDamage();
//        while ((pH != 0) && (mH != 0)) {
//
//            if (correctAnswer == userIntAnswer) {
//                mH = battle.round(pH, mH, pD, mD, true);
//            } else pH = battle.round(pH, mH, pD, mD, false);
//
//            textPlayerHealth.setText(pH);
//            textMonsterHealth.setText(mH);
//        }
//
//        if (pH == 0)
//        {
//            lives--;
//            textDeath.setText(death);
//            // display the death screen
//        } else if (mH == 0 && lv < 14)
//        {
//            textWin.setText(miniWin);
//            // display the lv break screen
//        }
//        else if (mH == 0 && lv == 14 && playerType != "allMath")
//        {
//            textWin.setText(bigWin);
//            // display the win screen
//        }
//        else if (mH == 0 && lv == 18 && playerType == "allMath")
//        {
//            textWin.setText(bigWin);
//            // display the best win screen
//        }
//    }
}
