package chaniagame.nanter1986.com.chaniagame.mpalos;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 27/9/2016.
 */
public class MpalosInsideChurchTwo extends RoomMaker{
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,MpalosThree.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("mpalosCrystalBallRed").equals("no")){
            esH.updateEvent("mpalosCrystalBallRed","yes");
            dialogCreator("You obtained the red crystal ball.");
            exitForward();
        }
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.mpaloschurchtwoinside);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        navigationAssigner(false,true,false,false);

    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
