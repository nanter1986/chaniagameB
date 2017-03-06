package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.media.MediaPlayer;
import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 18/8/2016.
 */
public class AkrotiriNine extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this, AkrotiriTen.class);
    }

    @Override
    public void west(View west) {
        intentCreator(this, AkrotiriEight.class);
    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        if (esH.readEvent("akrotiriknowchurchkey").equals("yes")) {
            dialogCreator("Do you want to search the water?");
            bOpt1.setText("Yes");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchWater();
                }
            });
            bOpt2.setText("No");
            bOpt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setStartingText();
                }
            });
        } else {
            dialogCreator("A beautiful beach called the devil's port.");
            exitForward();
        }
    }

    private void searchWater() {
        if (esH.readEvent("akrotirichurchkey").equals("yes")) {
            dialogCreator("The hand is still open.");
            exitForward();
        } else if (esH.readEvent("akrotirihandopen").equals("no") && esH.readEvent("akrotiriring").equals("no")) {
            dialogCreator("There is a stone hand at the bottom\nthat holds a key.\nI can't make it open.");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ring();
                }
            });
        } else if (esH.readEvent("akrotirihandopen").equals("no") && esH.readEvent("akrotiriring").equals("yes")) {
            dialogCreator("There is a stone hand at the bottom\nthat holds a key.\nI can't make it open.");
            exitForward();
        } else {
            handOpen();
        }

    }

    private void ring() {
        esH.updateEvent("akrotiriring","yes");
        dialogCreator("You obtained the stone hand ring");
        exitForward();
    }


    private void handOpen() {
        esH.updateEvent("akrotirichurchkey", "yes");
        dialogCreator("The hand is open.\nYou obtained the church key.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.akrotirinine);
    }

    @Override
    public void setStartingTextOptions() {
        if (esH.readEvent("akrotiriairportfirst").equals("yes")) {
            dialogCreator("You hear a voice in the air....");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voice();
                }
            });
        }
    }

    private void voice() {
        esH.updateEvent("akrotiriknowfisherman", "yes");
        dialogCreator("Enter the monastery with the fisherman's help...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voice2();
            }
        });
    }

    private void voice2() {
        dialogCreator("Enter the monastery with the fisherman's help...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voice3();
            }
        });
    }

    private void voice3() {

        dialogCreator("Enter the .......\nThe message repeats itself.");
        exitForward();
    }

    @Override
    public void onNavOn() {
        navigationAssigner(false, true, false, true);
    }



    @Override
    public void setAreaSong() {
        areasong = JukeBox.HELPINGHAND;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void setEffects() {
        effect1 = MediaPlayer.create(this, R.raw.waves);
        effect2 = MediaPlayer.create(this, R.raw.emptysound);
        effect1.setLooping(true);
        effect1.setVolume(0.5f, 0.5f);
        effect1.start();
    }
}
