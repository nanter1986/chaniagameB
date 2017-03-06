package chaniagame.nanter1986.com.chaniagame.mpalos;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 27/9/2016.
 */
public class MpalosInsideChurchOne extends RoomMaker{
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,Mpalos.class);

    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("mpalosCrystalBallGreen").equals("no")){
            esH.updateEvent("mpalosCrystalBallGreen","yes");
            dialogCreator("You obtained the green crystal ball.");
            exitForward();
        }

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.mpaloschurchoneinside);
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
