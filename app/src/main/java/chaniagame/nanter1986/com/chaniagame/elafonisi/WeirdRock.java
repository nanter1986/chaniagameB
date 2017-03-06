package chaniagame.nanter1986.com.chaniagame.elafonisi;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.stories.EarringStory;

/**
 * Created by nanter1986 on 12/8/2016.
 */
public class WeirdRock extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this, ElafonisiMonument.class);
    }

    @Override
    public void south(View south) {
        intentCreator(this, Kedrodasos.class);
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
        b.setImageResource(R.drawable.weirdrock);
    }

    @Override
    public void setStartingTextOptions() {
        if (esH.readEvent("elafonisiRedStone").equals("yes") && esH.readEvent("elafonisiBlueStone").equals("yes") && esH.readEvent("elafonisiGreenStone").equals("yes") && esH.readEvent("elafonisiBlackStone").equals("yes")) {

            eatItem();


        } else {
            dialogCreator("You hear a voice coming from the rock...\nFeed me 4 kinds of food and I will also\n eat what you came to get rid of.");

        }
    }

    private void eatItem() {
        dialogCreator("You hear a voice coming from the rock...\nGive me the earring to learn the truth...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eatItem1();
            }
        });
    }

    private void eatItem1() {
        dialogCreator("Everything blurs out...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eatItemOut();
            }
        });
    }

    private void eatItemOut() {
        esH.updateEvent("elafonisiBlueStone", "used");
        esH.updateEvent("elafonisiRedStone", "used");
        esH.updateEvent("elafonisiGreenStone", "used");
        esH.updateEvent("elafonisiBlackStone", "used");
        intentCreator(this,EarringStory.class);
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
        areasong= JukeBox.BITTERSWEET;
        esH.updateEvent("song",areasong.getName());
    }
}
