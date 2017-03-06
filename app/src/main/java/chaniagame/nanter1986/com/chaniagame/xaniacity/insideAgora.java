package chaniagame.nanter1986.com.chaniagame.xaniacity;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class insideAgora extends RoomMaker {


    @Override
    public void north(View north) {

    }

    public void south(View south) {

        intentCreator(this, AgoraAct.class);

    }

    @Override
    public void west(View west) {

    }


    @Override
    public void setStartingTextOptions() {
        dialogCreator("Inside the city market", R.drawable.blackpic, "red");
    }

    private void riddleDemon() {
        dialogCreator("Tell me my colorful name and I will give you this magic notebook.\n");
        bOpt1.setText("Tell");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameGive();
            }
        });
    }

    private void nameGive() {
        dialogCreator("Enter Password...", R.drawable.blackpic, "red");
        etState("on");
        bOpt1.setText("Confirm");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
            }
        });
        exitForward();
    }

    private void confirm() {
        dialogCreator("", R.drawable.blackpic, "red");
        password = et.getText().toString();
        String lowpassword = toLower(password);
        if (lowpassword.equals("sinner")) {
            etState("off");
            et.setText("");
            dialogCreator("This is my name.\nHere,take it.\nYou can check it for hints in your inventory.", R.drawable.blackpic, "red");
            esH.updateEvent("gotMagicNotebook", "yes");
            exitForward();


        } else {
            etState("off");
            et.setText("");
            dialogCreator("That's not my name.", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
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
        areasong = JukeBox.AGORAANDROID;
        esH.updateEvent("song", areasong.getName());
    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {

    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.insideagora);
    }
}
