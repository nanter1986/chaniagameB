package chaniagame.nanter1986.com.chaniagame.stories;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;

/**
 * Created by nanter1986 on 14/11/2016.
 */
public class BadEndingB extends StoryTeller{
    @Override
    protected void setMusic() {

    }

    @Override
    public void setAreaSong() {
        areasong = JukeBox.HOPELESS;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void setStartingText() {
        dialogCreator("I failed and also killed an innocent woman...", R.drawable.the_end,"red");
    }
}
