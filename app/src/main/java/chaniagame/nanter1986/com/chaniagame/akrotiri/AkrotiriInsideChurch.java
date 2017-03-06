package chaniagame.nanter1986.com.chaniagame.akrotiri;

import android.view.View;

import chaniagame.nanter1986.com.chaniagame.JukeBox;
import chaniagame.nanter1986.com.chaniagame.R;
import chaniagame.nanter1986.com.chaniagame.RoomMaker;

/**
 * Created by nanter1986 on 23/8/2016.
 */
public class AkrotiriInsideChurch extends RoomMaker {
    private String passwordZodiac;

    @Override
    public void north(View north) {

    }

    @Override
    public void south(View south) {
        intentCreator(this,AkrotiriEight.class);
    }

    @Override
    public void west(View west) {

    }

    @Override
    public void east(View east) {

    }

    @Override
    public void investigate(View investigate) {
        dialogCreator("What would you like to investigate?");
        bOpt1.setText("Painting 1");
        bOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintingOne();
            }
        });
        bOpt2.setText("Painting 2");
        bOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintingTwo();
            }
        });
        bOpt3.setText("Painting 3");
        bOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintingThree();
            }
        });
        bOpt4.setText("Painting 4");
        bOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintingFour();
            }


        });
        bOpt5.setText("Big Painting");
        bOpt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintingBig();
            }
        });
    }

    private void paintingBig() {
        if(esH.readEvent("talisman").equals("no")) {
            dialogCreator("There is a 4 digit password panel under the painting.\nDo you want to enter a password?");
            b.setImageResource(R.drawable.zodiactriple);
            bOpt1.setText("Yes");
            bOpt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    yesEnterPassword();
                }
            });
            bOpt2.setText("No");
            bOpt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    noEnterPassword();
                }
            });
        }else{
            dialogCreator("The big painting panel is open and empty.");
            exitForward();
        }
    }

    private void noEnterPassword() {
        setStartingText();
    }

    private void yesEnterPassword() {
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
        passwordZodiac = et.getText().toString();
        String lowpassword = toLower(passwordZodiac);
        if (lowpassword.equals("1086")) {
            etState("off");
            et.setText("");
            dialogCreator("Correct password.\nYou obtained the talisman.", R.drawable.blackpic, "red");
            esH.updateEvent("talisman", "yes");
            exitForward();


        } else {
            etState("off");
            et.setText("");
            dialogCreator("Incorrect password", R.drawable.blackpic, "red");
            exitForward();
        }
    }

    private void paintingFour() {
        dialogCreator("The number 4 is written at the bottom");
        b.setImageResource(R.drawable.zodiactaurus);
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setImageResource(R.drawable.akrotiriinsidechurch);
                setStartingText();
            }
        });
    }

    private void paintingThree() {
        dialogCreator("The number 0 is written at the bottom");
        b.setImageResource(R.drawable.zodiacpisces);
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setImageResource(R.drawable.akrotiriinsidechurch);
                setStartingText();
            }
        });
    }

    private void paintingTwo() {
        dialogCreator("The number 4 is written at the bottom");
        b.setImageResource(R.drawable.zodiaclibra);
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setImageResource(R.drawable.akrotiriinsidechurch);
                setStartingText();
            }
        });
    }

    private void paintingOne() {
        dialogCreator("The number 4 is written at the bottom");
        b.setImageResource(R.drawable.zodiacaquarius);
        bForward.setText(">>");
        bForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setImageResource(R.drawable.akrotiriinsidechurch);
                setStartingText();
            }
        });
    }

    @Override
    public void setBack() {
        b.setImageResource(R.drawable.akrotiriinsidechurch);
    }

    @Override
    public void setStartingTextOptions() {
        dialogCreator("There is a big painting above the door,\nand a few small ones around in the walls.");
    }

    @Override
    public void onNavOn() {
        navigationAssigner(false,true,false,false);
    }



    @Override
    public void setAreaSong() {
        areasong= JukeBox.REALDANGER;
        esH.updateEvent("song",areasong.getName());
    }
}
