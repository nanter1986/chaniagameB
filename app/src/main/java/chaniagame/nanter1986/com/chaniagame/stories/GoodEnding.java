package chaniagame.nanter1986.com.chaniagame.stories;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;

/**
 * Created by nanter1986 on 14/11/2016.
 */
public class GoodEnding extends StoryTeller{
    @Override
    protected void setMusic() {

    }

    @Override
    public void setAreaSong() {
        areasong = JukeBox.SWEET;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void setStartingText() {
        dialogCreator("Is it really over?", R.drawable.lab,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ge1();
            }
        });
    }

    private void ge1() {
        dialogCreator("[TOM]You saved me...", R.drawable.lab,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ge2();
            }
        });
    }

    private void ge2() {
        dialogCreator("I know you'd do the same for me", R.drawable.lab,"red");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ge3();
            }
        });
    }

    private void ge3() {
        dialogCreator("",R.drawable.the_end,"red");
    }
}
