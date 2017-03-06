package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.os.Handler;
import android.view.View;

import java.util.Random;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class Bar extends RoomMaker {

    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        if (esH.readEvent("knowHandMonument").equals("no")) {
            intentCreator(this, NeaXwra.class);
        }else{
            intentCreator(this, HandMonument.class);
        }
    }


    @Override
    public void setStartingTextOptions() {
        int tableNumber;
        Random r = new Random();
        tableNumber = r.nextInt(2);

        if(tableNumber==0){
            dialogCreator("A bar playing greek music.\n" + "One third of the tables are occupied.", R.drawable.blackpic, "red");
        }else if(tableNumber==1){
            dialogCreator("A bar playing greek music.\n" + "Half of the tables are occupied.", R.drawable.blackpic, "red");
        }else{
            dialogCreator("A bar playing greek music.\n" + "All the tables are occupied.", R.drawable.blackpic, "red");
        }


    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bWest.setText("West");
            bEast.setText("East");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }



    @Override
    public void setAreaSong() {
        areasong= JukeBox.AGORAANDROID;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void east(View east) {

        intentCreator(this,Port.class);


    }

    @Override
    public void investigate(View investigate) {


        dialogCreator("What do you want to investigate?", R.drawable.blackpic, "red");
        bOpt1.setText("Barwoman");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               yes();
            }
        });
        bOpt2.setText("Bar");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar();
            }
        });
        bOpt3.setText("Toilet");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toilet();
            }
        });
        if(esH.readEvent("crowbar").equals("no") && esH.readEvent("drinkgarden").equals("no") && esH.readEvent("knowdrink").equals("yes")) {
            bOpt4.setText("Order");
            bOpt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    order();
                }
            });
        }
    }

    private void order() {
        dialogCreator("You want the whole bottle?\nHere you go.", R.drawable.barwoman, "green");
        esH.updateEvent("drinkgarden","yes");
        exitForward();
    }

    private void toilet() {
        dialogCreator("Something is written on the wall:\nROW AND STRUGGLE IN THE MILK?",R.drawable.blackpic,"red");
        exitForward();
    }

    private void bar() {
        if(esH.readEvent("sleepingpills").equals("no") && esH.readEvent("knowpills").equals("yes")) {
            dialogCreator("There are bottles, glasses, \nand a small container with pills.", R.drawable.blackpic, "red");
            bOpt1.setText("Take");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    take();
                }
            });
            exitForward();
        }else{
            dialogCreator("There are bottles and glasses.", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    private void take() {
        dialogCreator("You stole the pills",R.drawable.blackpic,"red");
        esH.updateEvent("sleepingpills","yes");
        exitForward();
    }

    private void yes() {
        if(esH.readEvent("handGun").equals("yes")){
            shootingOption();
        }else if(esH.readEvent("handGun").equals("used")){
            afterDecision();
        }else{
            yes1();
        }


    }

    private void afterDecision() {

    }

    private void shootingOption() {
        dialogCreator("Do you want to shoot the barwoman?");
        bOpt1.setText("Yes");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                killingHer();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStartingText();
            }
        });
    }

    private void killingHer() {
        esH.updateEvent("killedBarwoman","yes");
        esH.updateEvent("handGun","used");
        dialogCreator("You shoot her 5 times to make sure she's dead.\nThen you run.");
        Handler h=new Handler();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                runOutside();
            }
        };
        h.postDelayed(r,3000);

    }

    private void runOutside(){
        intentCreator(this,Port.class);
    }

    private void yes1() {
        if(esH.readEvent("allFiveDonesDone").equals("yes")){
            pillsBoatMan();
        }else{
            pillsChoice();
        }
    }

    private void pillsBoatMan() {
        if(esH.readEvent("talkToBoatMan").equals("yes")){
            barwomanBoatman();
            
        }else{
            barwomanPillsCaught();
        }
    }

    private void barwomanPillsCaught() {
        dialogCreator("It was you who stole my pills right?\nYou could have just asked man...",R.drawable.barwoman,"green");
        exitForward();
    }

    private void barwomanBoatman() {
        dialogCreator("What do I know about the boat driver?\nHmmmmm\nLet's see...",R.drawable.barwoman,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barwomanBoatman1();
            }
        });
    }

    private void barwomanBoatman1() {
        dialogCreator("One night I heard him say that his wife wanted a necklace from the museum.\nBut unfortunately they don't sell it.",R.drawable.barwoman,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barwomanBoatman2();
            }
        });
    }

    private void barwomanBoatman2() {
        esH.updateEvent("knowAboutNecklace","yes");
        dialogCreator("Actually I think that's illegal...",R.drawable.barwoman,"green");
        exitForward();
    }

    private void pillsChoice() {
        if(esH.readEvent("sleepingpills").equals("no")) {
            dialogCreator("I have trouble sleeping after work so I take sleeping pills.", R.drawable.barwoman, "green");
            exitForward();
        }else{
            dialogCreator("Someone stole my pills.\nHow am I gonna sleep tonight?", R.drawable.barwoman, "green");
            exitForward();
        }
    }


    @Override
    public void setBack() {
        b.setImageResource(R.drawable.ellibar);
    }
}
