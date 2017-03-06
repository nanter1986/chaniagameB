package chaniagame.nanter1986.com.chaniagame.stories;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.StoryTeller;
import chaniagame.nanter1986.com.chaniagame.xaniacity.Ktel;

/**
 * Created by nanter1986 on 27/9/2016.
 */
public class BraceletStory extends StoryTeller{
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
        dialogCreator("What is this place?\nThis can't be any real place...", R.drawable.redcave,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave1();
            }
        });

    }

    private void cave1() {
        dialogCreator("You are right...\nWere you expecting any of your brother's memories...", R.drawable.redcave,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave2();
            }
        });
    }

    private void cave2() {
        dialogCreator("Who are you?\n What do you want from my brother?", R.drawable.redcave,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave3();
            }
        });
    }

    private void cave3() {
        dialogCreator("I guess you are partly right...\nI was created by your brother's memories,\nand now you come at my home,\nand you try to kill me.", R.drawable.blackcoat,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave4();
            }
        });
    }

    private void cave4() {
        dialogCreator("What do you expect me to do?", R.drawable.blackcoat,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave5();
            }
        });
    }

    private void cave5() {
        dialogCreator("And you are trying to take over my brother's mind,\nand then his body. \nWhat do you expect me to do?", R.drawable.redcave,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave6();
            }
        });
    }

    private void cave6() {
        dialogCreator("I'm glad you came.\nIt would have taken me years to take over your brother's body.\nThe brain's defenses are hard to take down.", R.drawable.blackcoat,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave7();
            }
        });
    }

    private void cave7() {
        dialogCreator("But you are here without your body or brain...\nI can absorb you and with your energy it will be easy to break your brother's defenses.", R.drawable.blackcoat,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave8();
            }
        });
    }

    private void cave8() {
        dialogCreator("Ok then,let's settle  this here and now...", R.drawable.redcave,"white");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave9();
            }
        });
    }

    private void cave9() {
        dialogCreator("Not here...\nnot now.\nCome and meet me on the island across the city...\nWe will settle this the old way....\nThe only way...", R.drawable.blackcoat,"green");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cave10();
            }
        });
    }

    private void cave10() {
        esH.updateEvent("bracelet","used");
        esH.updateEvent("donempalos","yes");
        esH.updateEvent("allFiveDonesDone","yes");
        intentCreator(this,Ktel.class);
    }


}
