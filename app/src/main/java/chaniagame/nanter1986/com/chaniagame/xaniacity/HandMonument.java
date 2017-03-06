package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.os.Handler;
import android.view.View;

import java.util.Random;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 4/10/2016.
 */
public class HandMonument extends RoomMaker{
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,NeaXwra.class);
    }

    @Override
    public void east(View east) {
        if (esH.readEvent("killedBarwoman").equals("yes")) {
            dialogCreator("The bar is closed.");
            Handler h=new Handler();
            Runnable r=new Runnable() {
                @Override
                public void run() {
                    runOutside();
                }
            };
            h.postDelayed(r,3000);
        } else {
            intentCreator(this, Bar.class);

        }

    }

    private void runOutside() {
        intentCreator(this,Port.class);
    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.handmonument);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("gotTzamiNecklace").equals("yes")){
            gotNecklace();
        }else if(esH.readEvent("killedBarwoman").equals("yes")){
            killedBarwoman();
        }else{
            meetFirst();
        }

    }

    private void killedBarwoman() {
        esH.updateEvent("tzamiDoorUnlocked","yes");
        dialogCreator("[UNLOCKER]It's already unlocked.\nGood job.");
    }

    private void gotNecklace() {
        dialogCreator("Nothing interesting here.");
    }

    private void meetFirst() {
        if(esH.readEvent("handGun").equals("yes")){
           nothingInteresting();
        }else{
            meetfirst1();
        }

    }

    private void nothingInteresting() {
        dialogCreator("Nothing interesting here.");
    }

    private void meetfirst1() {
        dialogCreator("Ok,to the right of the monument with my hands crossed.\nAnd now we wait.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wait1();
            }
        });
    }

    private void wait1() {
        dialogCreator("...............................\n..................\n................");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wait2();
            }
        });
    }

    private void wait2() {
        dialogCreator("After 10 minutes....");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meet();
            }
        });
    }

    private void meet() {
        int handNumber;
        Random r = new Random();
        handNumber = r.nextInt(5)+1;
        switch (handNumber){
            case 1:
                dialogCreator("[UNLOCKER]What is the best football team in Greece?",R.drawable.blackpic,"green");
                break;
            case 2:
                dialogCreator("[UNLOCKER]What is the tallest mountain in Greece?",R.drawable.blackpic,"green");

                break;
            case 3:
                dialogCreator("[UNLOCKER]What is the best Greek food?",R.drawable.blackpic,"green");

                break;
            case 4:
                dialogCreator("[UNLOCKER]What is your name?",R.drawable.blackpic,"green");

                break;
            case 5:
                dialogCreator("[UNLOCKER]How old are you?",R.drawable.blackpic,"green");

                break;
            default:
                dialogCreator("[UNLOCKER]Hmmmmm",R.drawable.blackpic,"green");

                break;
        }
        bOpt1.setText("Answer");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer();
            }
        });
        exitForward();
    }

    private void answer() {
        dialogCreator("Type answer", R.drawable.blackpic, "red");
        etState("on");
        bOpt1.setText("Confirm");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
            }
        });
        exitForward();
    }

    private void confirm() {
        dialogCreator("", R.drawable.blackpic, "red");
        password = et.getText().toString();
        String lowpassword = toLower(password);
        if (lowpassword.equals("ticket")) {
            etState("off");
            et.setText("");
            dialogCreator("[UNLOCKER]Ok,tell me what do you want.", R.drawable.blackpic, "green");
            esH.updateEvent("saidTicket", "yes");
            bOpt1.setText("Tell");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tellNeed();
                }
            });


        } else {
            etState("off");
            et.setText("");
            dialogCreator("Incorrect password", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    private void tellNeed() {
        dialogCreator("[UNLOCKER]You want to enter the mosque...\nPeople say there is a reason that it's locked...\nSo the price is high...", R.drawable.blackpic, "green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellNeed2();
            }
        });
    }

    private void tellNeed2() {
        dialogCreator("[YOU]What do you want?", R.drawable.blackpic, "red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellNeed3();
            }
        });
    }

    private void tellNeed3() {
        esH.updateEvent("handGun","yes");
        dialogCreator("[UNLOCKER]You have to take this gun and shoot the barwoman\nin the Andromeda bar.", R.drawable.blackpic, "green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellNeed4();
            }
        });
    }

    private void tellNeed4() {
        dialogCreator("[YOU]I can't kill someone for a door...", R.drawable.blackpic, "red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellNeed5();
            }
        });
    }

    private void tellNeed5() {
        dialogCreator("[UNLOCKER]It's your choice.\nCome back here if and when she's dead and I will open the door for you.", R.drawable.blackpic, "green");
       exitForward();
    }

    @Override
    public void onNavOn() {
        navigationAssigner(false,false,true,true);
    }

    @Override
    public void setAreaSong() {
        areasong = JukeBox.AGORAANDROID;
        esH.updateEvent("song", areasong.getName());
    }
}
