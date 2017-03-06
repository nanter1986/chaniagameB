package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class PoliceGarage extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,PoliceOffice.class);
    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        bOpt1.setText("Floor");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floor();
            }
        });
        bOpt2.setText("Walls");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                walls();
            }
        });
        bOpt3.setText("Cars");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cars();
            }
        });
        exitForward();
    }

    private void cars() {
        dialogCreator("Just cars.\nNothing suspicious");
        exitForward();
    }

    private void walls() {
        dialogCreator("Something is written on the wall:\nEVER WONDERED WHY THE LEMONS?");
        exitForward();
    }

    private void floor() {
        if(esH.readEvent("watch").equals("no")) {
            dialogCreator("There is a black circle on the floor.\nLooks like it was burned.\nThere is a watch in the middle.");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    watch();
                }
            });
        }else{
            dialogCreator("There is a black circle on the floor.\nLooks like it was burned.");
            exitForward();
        }
    }

    private void watch() {
        esH.updateEvent("watch","yes");
        dialogCreator("You obtained the watch");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.policegarage);
    }

    @Override
    public void setStartingTextOptions() {

        dialogCreator("The garage of the police station.",R.drawable.blackpic,"red");
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {

            bNorth.setText("Up");
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
