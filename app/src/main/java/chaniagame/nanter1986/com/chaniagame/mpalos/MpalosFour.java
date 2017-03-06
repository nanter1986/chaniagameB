package chaniagame.nanter1986.com.chaniagame.mpalos;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.stories.BraceletStory;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class MpalosFour extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,MpalosFourOne.class);

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

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.mpalosfourmpalosview);
    }

    @Override
    public void setStartingTextOptions() {
        if(esH.readEvent("mpalosCrystalBallBlue").equals("yes") && esH.readEvent("mpalosCrystalBallGreen").equals("yes") && esH.readEvent("mpalosCrystalBallRed").equals("yes")){
            activateBalls();
        }else{
            dialogCreator("There are three colored spheres over the mountain.\n2 meters in diameter each.");
        }
    }

    private void activateBalls() {
        dialogCreator("The crystal balls fly inside the colored spheres...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toStory();
            }
        });
    }

    private void toStory() {
        dialogCreator("Everything blurs out...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                story();
            }
        });
    }

    private void story() {
        esH.updateEvent("mpalosCrystalBallBlue","used");
        esH.updateEvent("mpalosCrystalBallGreen","used");
        esH.updateEvent("mpalosCrystalBallRed","used");


        intentCreator(this,BraceletStory.class);
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
        areasong= JukeBox.WAR;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.unlock);
        effect1.setLooping(true);
        effect1.setVolume(0.8f, 0.8f);
        effect1.start();
    }
}
