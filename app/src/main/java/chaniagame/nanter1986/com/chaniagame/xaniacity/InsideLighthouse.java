package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class InsideLighthouse extends RoomMaker {


    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {
        intentCreator(this,Faros.class);
    }

    @Override
    public void investigate(View investigate) {
        bOpt1.setText("Altar");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                altar();
            }
        });
        bOpt2.setText("Walls");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                walls();
            }
        });
        bOpt3.setText("Statues");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statue();
            }
        });
        exitForward();
    }

    private void altar() {
        if(esH.readEvent("bracelet").equals("no")) {
            dialogCreator("A stone altar with blood steins.\nThere is a bracelet on it.");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bracelet();
                }
            });
        }else{
            dialogCreator("A stone altar with blood steins.");
            exitForward();
        }
    }

    private void bracelet() {
        esH.updateEvent("bracelet","yes");
        dialogCreator("You obtained the bracelet");
        exitForward();
    }

    private void statue() {
        dialogCreator("Is this a demon?\nOr an angel?");
        exitForward();
    }

    private void walls() {
        dialogCreator("Something is written on the wall:\nNEVER WANDERS IN MY BLOOD");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.insidelighthouse);
    }



    @Override
    public void setStartingTextOptions() {

        dialogCreator("There is an altar.", R.drawable.blackpic, "red");

    }

    private void firstTime() {

    }


    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
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
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
