package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class Graveyard extends RoomMaker {


    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this, Garden.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this, Kounoupidiana.class);
    }

    @Override
    public void investigate(View investigate) {

        dialogCreator("Do you want to enter?");
        bOpt1.setText("Yes");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no();
            }
        });

    }

    private void yes() {
        intentCreator(this, ChildGrave.class);
    }

    private void no() {
        setStartingText();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.graveyard);
    }


    @Override
    public void setStartingTextOptions() {
        dialogCreator("This city's graveyard", R.drawable.blackpic, "red");

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
        areasong= JukeBox.SAD;
        esH.updateEvent("song",areasong.getName());
    }


}
