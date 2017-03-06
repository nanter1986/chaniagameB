package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class SamariaTree extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,SamariaStone.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,Roumeli.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if(!esH.readEvent("samariashovel").equals("no")){
            dialogCreator("Just a tree");
            exitForward();
        }else if(esH.readEvent("knowshovel").equals("yes")){
            takeshovel();
        }else{
            dialogCreator("Someone is digging a hole with a shovel");
            exitForward();
        }
    }

    private void takeshovel() {
        dialogCreator("Ask for the shovel?");
        bOpt1.setText("Yes");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeshovelYes();
            }
        });
        bOpt2.setText("No");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeshovelNo();
            }
        });
    }

    private void takeshovelNo() {
        setStartingText();
    }

    private void takeshovelYes() {
        esH.updateEvent("samariashovel","yes");
        dialogCreator("He is giving it to you without any questions.\nI guess my brother wants me to have it.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.samariatree);
    }



    @Override
    public void setStartingTextOptions() {

        dialogCreator("A tree with a weird shape.",R.drawable.blackpic,"red");
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
