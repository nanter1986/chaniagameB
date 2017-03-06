package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class SamariaBlue extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,SamariaWooden.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaStone.class);
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
        if(esH.readEvent("keyforblue").equals("yes")){
            esH.updateEvent("keyforblue","used");
            dialogCreator("You unlocked the door.");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    unlockblue();
                }
            });
        }else if(esH.readEvent("keyforblue").equals("used")){
            intentCreator(this,SamariaInsideBlue.class);
        }else if(esH.readEvent("keyforblue").equals("no")){
            dialogCreator("It's locked");
            exitForward();
        }
    }

    private void unlockblue() {
        intentCreator(this,SamariaInsideBlue.class);
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.samariablue);
    }



    @Override
    public void setStartingTextOptions() {

        dialogCreator("Ruins of an old house.",R.drawable.blackpic,"red");
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
        areasong= JukeBox.HOTEL;
        esH.updateEvent("song",areasong.getName());
    }
}
