import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.harshitha.sharedpreferences.R;

public class UserSettingActivity extends PreferenceActivity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResourse(R.xml.user_settings);


    }

}
