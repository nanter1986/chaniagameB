package chaniagame.nanter1986.com.chaniagame.samaria;

import android.os.Handler;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.samaria.ferry.OnTheShip;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class Roumeli extends RoomMaker {


    @Override
    public void north(View north) {
        intentCreator(this,SamariaTree.class);
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
        if(esH.readEvent("necklace").equals("used")){
            dialogCreator("I guess I have to enter that ship");
            Handler h = new Handler();
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    goonboat();
                }
            };
            h.postDelayed(r,2000);
        }else{
            dialogCreator("I can't leave yet.");
            exitForward();
        }
    }

    private void goonboat() {
        intentCreator(this,OnTheShip.class);
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.roumeli);
    }



    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("keyforblue").equals("no")){
            esH.updateEvent("knowshovel","yes");
            dialogCreator("You see letters forming on the sea out of something red.\nDIG UNDER THE STONE BRIDGE.");
        }else {
            dialogCreator("The ferry boats take the tourists \nto a nearby bus station.", R.drawable.blackpic, "red");
        }

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bNorth.setText("North");

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
