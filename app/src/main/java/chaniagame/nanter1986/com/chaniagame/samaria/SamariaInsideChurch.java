package chaniagame.nanter1986.com.chaniagame.samaria;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

public class SamariaInsideChurch extends RoomMaker {


    private String churchkeynumber;

    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,SamariaChurch.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("What do you want to investigate?", R.drawable.blackpic, "red");
        bOpt1.setText("Wooden\nBox");
        bOpt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                woodenbox();
            }
        });
        bOpt2.setText("Left\nPicture");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftpicture();
            }
        });
        bOpt3.setText("Right\nPicture");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightpicture();
            }
        });
        exitForward();
    }

    private void rightpicture() {
        dialogCreator("Something is written at the bottom:\nEA");
        exitForward();
    }

    private void leftpicture() {
        dialogCreator("Something is written at the bottom:\nAF");
        exitForward();
    }

    private void woodenbox() {
        if(esH.readEvent("churchtrapdoor").equals("no")) {
            dialogCreator("The box opens and it has an iron trapdoor inside.\nOn it there is a numerical lock with 4 digits.\nDo you want to enter a number?");
            bOpt1.setText("Yes");
            bOpt1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    yeswoodenbox();
                }
            });
            bOpt2.setText("No");
            bOpt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nowoodenbox();
                }
            });
            exitForward();
        }else if(esH.readEvent("churchtrapdoor").equals("yes")){
            gointunnel();
        }
    }

    private void nowoodenbox() {
        setStartingText();
    }

    private void yeswoodenbox() {
        dialogCreator("Enter key number...", R.drawable.blackpic, "red");
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
        churchkeynumber = et.getText().toString();
        String lowkey = toLower(churchkeynumber);
        if (lowkey.equals("0540")) {
            etState("off");
            et.setText("");
            esH.updateEvent("churchtrapdoor","yes");
            dialogCreator("Correct password.\nSound of gears grinding...", R.drawable.blackpic, "red");
            bForward.setText(">>");
            bForward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opentrapdoor();
                }
            });


        } else {
            etState("off");
            et.setText("");
            dialogCreator("Incorrect key number", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    private void opentrapdoor() {
        dialogCreator("The trapdoor opened.");
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gointunnel();
            }
        });
    }

    private void gointunnel() {
        intentCreator(this,SamariaTunnel.class);
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.insidechurch);
    }

    @Override
    public void setStartingTextOptions() {

    }

    @Override
    public void onNavOn() {
        if (nav.equals("on")) {
            bSouth.setText("Out");
        } else {
            bNorth.setText("----");
            bSouth.setText("----");
            bWest.setText("----");
            bEast.setText("----");
        }
    }

    @Override
    public void setAreaSong() {
        areasong= JukeBox.DANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
