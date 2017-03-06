package chaniagame.nanter1986.com.chaniagame;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SaveManager extends Activity {

    Button bExit;
    Button bDelete;
    Button bYes;
    Button bNo;
    TextView t;
    eventSaver esH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_save_manager);

        esH = new eventSaver(this);

        bExit = (Button)findViewById(R.id.bsExit);
        bDelete = (Button)findViewById(R.id.bsDelete);
        bYes = (Button)findViewById(R.id.bsYes);
        bNo = (Button)findViewById(R.id.bsNo);
        t = (TextView)findViewById(R.id.tSave);

        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteq1();
            }
        });

    }

    private void deleteq1() {
        t.setText("Do you want to delete your save file?");
        bExit.setOnClickListener(null);
        bExit.setText("----");
        bDelete.setOnClickListener(null);
        bDelete.setText("----");
        bYes.setText("Yes");
        bYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes();
            }
        });
        bNo.setText("No");
        bNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no();
            }
        });
    }

    private void no() {
        t.setText("");
        bYes.setText("----");
        bYes.setOnClickListener(null);
        bNo.setText("----");
        bNo.setOnClickListener(null);
        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteq1();
            }
        });
    }

    private void yes() {
        t.setText("Do you really want to delete your save file?");
        bYes.setText("Really\nYes");
        bYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reallyyes();
            }
        });
        bNo.setText("Not\nReally");
        bNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notreally();
            }
        });
    }

    private void notreally() {
        t.setText("");
        bYes.setText("----");
        bYes.setOnClickListener(null);
        bNo.setText("----");
        bNo.setOnClickListener(null);
        bExit.setText("EXIT");
        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });
        bDelete.setText("Delete Save File");
        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteq1();
            }
        });
    }

    private void reallyyes() {
        Handler h = new Handler();
        Runnable rb = new Runnable() {
            @Override
            public void run() {
                exit();
            }
        };
        bYes.setText("----");
        bYes.setOnClickListener(null);
        bNo.setText("----");
        bNo.setOnClickListener(null);
        bExit.setOnClickListener(null);
        bDelete.setOnClickListener(null);
        esH.deleteTable();
        t.setText("Save deleted");
        h.postDelayed(rb,1000);


    }

    private void exit() {
        Intent s = new Intent(getBaseContext(), MainMenuAct.class);
        startActivity(s);
        overridePendingTransition(0, 0);
        finish();
    }


}
