package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 9/8/2016.
 */
public class SamariaInsideBlue extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaBlue.class);
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
        bOpt1.setText("Drawer");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                drawer();
            }
        });
        bOpt2.setText("Bed");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bed();
            }
        });
        bOpt3.setText("Walls");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                walls();
            }
        });
        exitForward();
    }

    private void walls() {
        dialogCreator("Something is written in black paint:\nYOU CAN'T HELP HIM.");
        exitForward();
    }

    private void bed() {
        dialogCreator("There is a pair of shoes under the bed.");
        exitForward();
    }

    private void drawer() {
        if(esH.readEvent("bluekey").equals("no")) {
            dialogCreator("You obtained the blue key");
            esH.updateEvent("bluekey", "yes");
            exitForward();
        }else{
            dialogCreator("It's empty");
            exitForward();
        }
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.intheblue);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bSouth.setText("Out");
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
