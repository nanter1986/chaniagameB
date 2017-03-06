package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class SamariaPrison extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,SamariaBlood.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaTunnel.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("What do you want to investigate?", R.drawable.blackpic, "red");
        bOpt1.setText("Cell 1");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cellone();
            }
        });
        bOpt2.setText("Cell 2");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celltwo();
            }
        });
        bOpt3.setText("Cell 3");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cellthree();
            }
        });
        exitForward();
    }

    private void cellthree() {
        dialogCreator("Some words are carved on the wall:\nI was here for a long time.\nPlease help me.\nTOM");
        exitForward();
    }

    private void celltwo() {
        dialogCreator("Some blood on the floor");
        exitForward();
    }

    private void cellone() {
        dialogCreator("Some words are carved on the wall:\nHELP\nWHY?\ntHEY ARE INSANE");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.samariaprison);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("Forward");
            bSouth.setText("Back");
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
