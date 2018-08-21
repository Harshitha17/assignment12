import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.harshitha.sharedpreferences.R;

public class MainActivity extends Activity
{
    private static final int SETTINGS_RESULT = 1;
    // declaring variables
    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // defining btnSettings button
         btnSettings=(Button)findViewById(R.id.buttonSettings);
        // start the UserSettingActivity when user clicks on Button
        btnSettings.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // change to user_settings activity
                Intent i = new Intent(getApplicationContext(), UserSettingActivity.class);
                startActivityForResult(i, SETTINGS_RESULT);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==SETTINGS_RESULT)
        {
            displayUserSettings();
        }

    }


    private void displayUserSettings()
    {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        //setting string with password text by getting and coverting to string format
        String  settings = "";
        settings=settings+"Password: " + sharedPrefs.getString("prefUserPassword", "NOPASSWORD");

        //If lock is not switched on Remind for update is set as false
        settings=settings+"\nRemind For Update:"+ sharedPrefs.getBoolean("prefLockScreen", false);

        settings=settings+"\nUpdate Frequency: "
                + sharedPrefs.getString("prefUpdateFrequency", "NOUPDATE");

        TextView textViewSetting = (TextView) findViewById(R.id.textViewSettings);

        textViewSetting.setText(settings);
    }

}


