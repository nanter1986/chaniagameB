package chaniagame.nanter1986.com.chaniagame.stories;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;
import chaniagame.nanter1986.com.chaniagame.xaniacity.NeaXwra;

public class StoryFirst extends StoryTeller {



    @Override
    protected void setMusic() {
        setBackAudio(R.raw.agoraandroid);
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.DROP;
        esH.updateEvent("song",areasong.getName());
    }

    @Override
    public void setStartingText() {
        dialogCreator("You wake up on the beach.",R.drawable.neaxwra,"red");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story1();
            }
        });
    }

    private void story1() {
        dialogCreator("You remember nothing.",R.drawable.neaxwra,"red");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story2();
            }
        });
    }

    private void story2() {
        dialogCreator("You just find a note in your pocket.",R.drawable.neaxwra,"red");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story3();
            }
        });
    }

    private void story3() {
        dialogCreator("Find the watch,the ring,the necklace,the bracelet and the earrings.",R.drawable.neaxwra,"red");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story4();
            }
        });
    }

    private void story4() {
        dialogCreator("Then I will find you at the bus station.",R.drawable.neaxwra,"red");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                story5();
            }
        });
    }

    private void story5() {
        dialogCreator("Don't try to make sense of what's going on.There is no time.Just do it.",R.drawable.neaxwra,"red");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentCreator(getBaseContext(),NeaXwra.class);
            }
        });
    }
}
