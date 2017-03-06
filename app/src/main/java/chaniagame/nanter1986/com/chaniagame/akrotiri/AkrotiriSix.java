package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class AkrotiriSix extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,AkrotiriFive.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this,AkrotiriSeven.class);
    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("akrotiriring").equals("no")) {
            dialogCreator("There is a small hole in the center of the wall.");
            exitForward();
        }else if(esH.readEvent("akrotiriring").equals("yes")){
            openTheHand();
        }else{
            ringShining();
        }
    }

    private void ringShining() {
        dialogCreator("The ring is shining with a deep red color...\nYou hear a buzzing sound in the distance");
    }

    private void openTheHand() {
        esH.updateEvent("akrotiriring","placed");
        esH.updateEvent("akrotirihandopen","yes");
        dialogCreator("You place the ring in the hole in the wall...\nYou hear a buzzing sound in the distance");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.akrotirisix);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        navigationAssigner(false,false,true,true);
    }



    @Override
    public void setAreaSong() {
        areasong= JukeBox.HELPINGHAND;
        esH.updateEvent("song",areasong.getName());
    }
}
