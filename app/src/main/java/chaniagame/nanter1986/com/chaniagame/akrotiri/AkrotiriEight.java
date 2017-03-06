package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class AkrotiriEight extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this,AkrotiriSeven.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this,AkrotiriNine.class);
    }

    @Override
    public void investigate(View investigate) {
        if(esH.readEvent("akrotirichurchdoor").equals("yes")){
            enterChurch();
        } else if(esH.readEvent("akrotirichurchkey").equals("no")) {
            dialogCreator("It's locked");
        }else if(esH.readEvent("akrotirichurchkey").equals("yes")){
            if(effect1==null){
                setEffects();
            }
            effect1.start();
            esH.updateEvent("akrotirichurchkey","used");
            esH.updateEvent("akrotirichurchdoor","yes");
            dialogCreator("You unlocked the door");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    enterChurch();
                }
            });
        }
    }

    private void enterChurch() {
        intentCreator(getApplicationContext(),AkrotiriInsideChurch.class);
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.unlock);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setVolume(0.5f, 0.5f);

    }



    @Override
    public void setBack() {
        b.setImageResource(R.drawable.akrotirieight);
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
