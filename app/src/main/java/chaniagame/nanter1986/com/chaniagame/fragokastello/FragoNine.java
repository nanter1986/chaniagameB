package chaniagame.nanter1986.com.chaniagame.fragokastello;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;
import chaniagame.nanter1986.com.chaniagame.stories.StoryAfterFrago;

/**
 * Created by nanter1986 on 17/8/2016.
 */
public class FragoNine extends RoomMaker {
    @Override
    public void north(View north) {
        intentCreator(this,FragoNineOne.class);
    }

    @Override
    public void south(View south) {

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
        b.setImageResource(R.drawable.fragonine);
    }

    @Override
    public void setStartingTextOptions() {

        dialogCreator("You leave the watch down.\nEverything brightens up and you are transferred...");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStory();
            }
        });
    }

    private void goToStory() {
        intentCreator(this,StoryAfterFrago.class);
    }

    @Override
    public void onNavOn() {
        navigationAssigner(true,false,false,false);
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
