package chaniagame.nanter1986.com.chaniagame.samaria.ferry;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 10/8/2016.
 */
public class OnTheShipRestaurant extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,OnTheShipTv.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("cabinkey").equals("yes")){
            dialogCreator("Just a restaurant.");
            exitForward();
        } else if(esH.readEvent("knoworder").equals("yes")){
            knoworder();
        }
    }

    private void knoworder() {
        dialogCreator("Do you want to order food?");
        bOpt1.setText("Order");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderfood();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noorderfood();
            }
        });
    }

    private void noorderfood() {
        setStartingText();
    }

    private void orderfood() {
        dialogCreator("After 15 minutes...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyplate();
            }
        });
    }

    private void keyplate() {
        esH.updateEvent("cabinkey","yes");
        dialogCreator("There is a key on the plate.\nYou obtained the cabin key.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.ferryfive);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
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
