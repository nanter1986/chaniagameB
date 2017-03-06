package chaniagame.nanter1986.com.chaniagame.stories;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;
import chaniagame.nanter1986.com.chaniagame.xaniacity.Ktel;

/**
 * Created by nanter1986 on 27/9/2016.
 */
public class EarringStory extends StoryTeller{

    @Override
    protected void setMusic() {

    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setStartingText() {
        dialogCreator("Oliver is on the ground with blood running from his head.\nHe is not moving.\nEveryone is screaming and running away.", R.drawable.schoolyard,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                murder1();
            }
        });
    }

    private void murder1() {
        dialogCreator("Oh no....\nSo my brother killed him...\n now everything makes sense...", R.drawable.schoolyard,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                murder2();
            }
        });
    }

    private void murder2() {
        dialogCreator("And why we moved to a different country,\nand my brother went to a special 'school'.", R.drawable.schoolyard,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                murder3();
            }
        });
    }

    private void murder3() {
        dialogCreator("That's why he is trying to erase the memory...", R.drawable.schoolyard,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                murder4();
            }
        });
    }

    private void murder4() {
        dialogCreator("Everything blurs out...", R.drawable.schoolyard,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveOut();
            }
        });
    }

    private void moveOut() {
        esH.updateEvent("earring","used");
        esH.updateEvent("elafonisiFishingRod","used");
        esH.updateEvent("doneelafonisi","yes");
        intentCreator(this,Ktel.class);
    }
}
