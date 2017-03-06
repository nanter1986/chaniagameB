package chaniagame.nanter1986.com.chaniagame.stories;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;

/**
 * Created by nanter1986 on 25/10/2016.
 */
public class BadEnding extends StoryTeller{
    @Override
    protected void setMusic() {

    }

    @Override
    public void setAreaSong() {
        areasong = JukeBox.REALDANGER;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void setStartingText() {
        dialogCreator("My mind is trapped on this island for ever.", R.drawable.theodoroi_cave,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                be1();
            }
        });

    }

    private void be1() {
        dialogCreator("I failed...", R.drawable.the_end,"red");

    }
}
