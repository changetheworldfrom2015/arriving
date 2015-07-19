package com.changetheworldfrom2015.arriving;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.parse.ParseUser;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_view();

        findViewById(R.id.logout_button).setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                ParseUser.logOut();

                // FLAG_ACTIVITY_CLEAR_TASK only works on API 11, so if the user
                // logs out on older devices, we'll just exit.
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    Intent intent = new Intent(MainActivity.this,
                            DispatchActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                            | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    finish();
                }
            }
        });
    }

    public void init_view(){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new EventsFragment()).commit();
        RadioGroup myTabRg = (RadioGroup) findViewById(R.id.tab_menu);
        myTabRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbEvents:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new EventsFragment()).commit();
                        break;
                    case R.id.rbContacts:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new ContactsFragment()).commit();
                        break;
                    case R.id.rbSettings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new SettingsFragment()).commit();
                        break;
                    case R.id.rbMore:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new MoreFragment()).commit();
                        break;
                    default:
                        break;
                }

            }
        });
    }
}
