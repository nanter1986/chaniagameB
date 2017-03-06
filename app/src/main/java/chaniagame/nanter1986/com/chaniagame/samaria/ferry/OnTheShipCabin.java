package chaniagame.nanter1986.com.chaniagame.samaria.ferry;

import android.os.Handler;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.xaniacity.Ktel;

/**
 * Created by nanter1986 on 10/8/2016.
 */
public class OnTheShipCabin extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,OnTheShipTv.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,OnTheShipBenches.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("");
        if(esH.readEvent("cabindoor").equals("yes")){
            b.setImageResource(R.drawable.ferrythree);
            explorecabin();
        }else if(esH.readEvent("cabinkey").equals("yes")){
            esH.updateEvent("cabinkey","used");
            esH.updateEvent("cabindoor","yes");
            dialogCreator("You used the cabin key to unlock the door.");
            Handler h = new Handler();
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    b.setImageResource(R.drawable.ferrythree);
                    explorecabin();
                }
            };
            h.postDelayed(r,1500);
        }else if(esH.readEvent("cabinkey").equals("no")){
            dialogCreator("It's locked");
            exitForward();
        }
    }

    private void explorecabin() {
        dialogCreator("What do you want to investigate?");
        bOpt1.setText("Beds");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                beds();
            }
        });
        bOpt2.setText("Desk");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desk();
            }
        });
        bOpt3.setText("Closet");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closet();
            }
        });
        exitForward();
    }

    private void closet() {
        if(esH.readEvent("closetdoor").equals("yes")){
            goincloset();
        } else if(esH.readEvent("closetkey").equals("yes")){
            esH.updateEvent("closetkey","used");
            esH.updateEvent("closetdoor","yes");
            dialogCreator("You unlock the closet.");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goincloset();
                }
            });
        }else if(esH.readEvent("closetkey").equals("no")){
            dialogCreator("It's locked");
            exitForward();
        }
    }

    private void goincloset() {
        dialogCreator("It's dark and it seems empty.\nDo you want to enter?");
        bOpt1.setText("Yes");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesenter();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               noenter();
            }
        });
    }

    private void noenter() {
        setStartingText();
    }

    private void yesenter() {
        esH.updateEvent("donesamaria","yes");
        intentCreator(this,Ktel.class);
    }

    private void desk() {
        esH.updateEvent("knowtv","yes");
        dialogCreator("A note:\nBehind the TV.");
        exitForward();
    }

    private void beds() {
        dialogCreator("Are these the same shoes that were\nunder the bed in the blue house in samaria?");
        exitForward();
    }

    @Override
    public void setBack() {
        if(esH.readEvent("cabindoor").equals("no")){
            b.setImageResource(R.drawable.shipcabindoor);
        }else if(esH.readEvent("cabindoor").equals("yes")){
            b.setImageResource(R.drawable.ferrythree);
        }
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");
            bSouth.setText("South");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {

    }
}
