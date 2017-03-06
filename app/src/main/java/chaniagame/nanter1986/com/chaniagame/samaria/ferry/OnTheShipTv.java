package chaniagame.nanter1986.com.chaniagame.samaria.ferry;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 10/8/2016.
 */
public class OnTheShipTv extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,OnTheShipRestaurant.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,OnTheShipCabin.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("closetkey").equals("yes")){
            dialogCreator("Just a TV.");
            exitForward();
        } else if(esH.readEvent("knowtv").equals("yes") && esH.readEvent("closetkey").equals("no")){
            searchtv();
        }else{

        }
    }

    private void searchtv() {
        dialogCreator("Search behind TV?");
        bOpt1.setText("Yes");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchyes();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchno();
            }
        });
    }

    private void searchno() {
        setStartingText();
    }

    private void searchyes() {
        esH.updateEvent("closetkey","yes");
        dialogCreator("The closet key is hidden here.\nYou obtained it.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.ferryfour);
    }

    @Override
    public void setStartingTextOptions() {
        dialogCreator("Passengers sitting.\nSome of them are watching TV.");
        exitForward();
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
