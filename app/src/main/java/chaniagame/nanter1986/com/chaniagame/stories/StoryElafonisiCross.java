package chaniagame.nanter1986.com.chaniagame.stories;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;
import chaniagame.nanter1986.com.chaniagame.elafonisi.ElafonisiCross;

/**
 * Created by nanter1986 on 26/9/2016.
 */
public class StoryElafonisiCross extends StoryTeller {
    @Override
    protected void setMusic() {

    }

    @Override
    public void setAreaSong() {
        areasong = JukeBox.SAD;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void setStartingText() {
        dialogCreator("You appear in a lifesaving boat into a storm.\nThe waves around you are huge.",R.drawable.elafonisiwreck,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1();
            }
        });
    }

    private void text1() {
        dialogCreator("There are around 40 people on the boat.",R.drawable.elafonisiwreck,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2();
            }
        });
    }

    private void text2() {
        dialogCreator("The winds are strong.",R.drawable.elafonisiwreck,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text3();
            }
        });
    }

    private void text3() {
        dialogCreator("There is a child that seems out of place.\nHer clothes are different.",R.drawable.elafonisiwreck,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text4();
            }
        });
    }

    private void text4() {
        dialogCreator("You hold the child's hand and say:",R.drawable.elafonisiwreck,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text5();
            }
        });
    }

    private void text5() {
        dialogCreator("Let's go to your mother.",R.drawable.elafonisiwreck,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wayOut();
            }
        });
    }

    private void wayOut() {
        esH.updateEvent("elafonisiDaughter","yes");
        intentCreator(this, ElafonisiCross.class);
    }
}
