package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.stories.StoryNecklace;

/**
 * Created by nanter1986 on 8/8/2016.
 */
public class SamariaBlood extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,SamariaLadder.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaPrison.class);
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
        bOpt1.setText("Wall");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                wall();
            }
        });
        bOpt2.setText("Fireplace");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fireplace();
            }
        });
        if(esH.readEvent("necklace").equals("yes")){
            bOpt3.setText("Necklace");
            bOpt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    necklace();
                }
            });
        }
        exitForward();
    }

    private void necklace() {
        dialogCreator("You leave the necklace on the floor.\nIt starts to shine with a bright green light.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storynecklace();
            }
        });
    }

    private void storynecklace() {
        intentCreator(this,StoryNecklace.class);
    }

    private void wall() {
        dialogCreator("There is a lot of blood and it looks\nlike it was splashed on the wall...\nThis scene reminds me of the incident back in school.");
        exitForward();
    }

    private void fireplace() {
        dialogCreator("There are burned clothes in the fireplace.\nI know these clothes.\nTom was wearing them that day.");
        exitForward();
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.samariablood);
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
