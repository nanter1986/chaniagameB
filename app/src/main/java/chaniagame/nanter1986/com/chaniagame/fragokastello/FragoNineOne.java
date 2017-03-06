package chaniagame.nanter1986.com.chaniagame.fragokastello;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 6/9/2016.
 */
public class FragoNineOne extends RoomMaker {
    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {

    }

    @Override
    public void west(View west) {
        intentCreator(this, FragoEight.class);
    }

    @Override
    public void east(View east) {
        intentCreator(this, FragoTen.class);
    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.fragonineone);
    }

    @Override
    public void setStartingTextOptions() {
        if (esH.readEvent("riddle1").equals("no") ||
                esH.readEvent("riddle4").equals("no") ||
                esH.readEvent("riddle5").equals("no") ||
                esH.readEvent("riddle6").equals("no") ||
                esH.readEvent("riddle7").equals("no") ||
                esH.readEvent("riddle10").equals("no") ||
                esH.readEvent("riddle11").equals("no")
                ) {
            dialogCreator("The castle is blocked by some short of magic field.\nI can't enter.");
        } else {
            dialogCreator("The magic field is gone.\nDo you want to enter the castle?");
            bOpt1.setText("Yes");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    yesEnter();
                }
            });
        }
    }

    private void yesEnter() {
        intentCreator(this, FragoNine.class);
    }

    @Override
    public void onNavOn() {
        navigationAssigner(false, false, true, true);
    }

    @Override
    public void setAreaSong() {
        areasong = JukeBox.MEMORIES;
        esH.updateEvent("song", areasong.getName());
    }
}
