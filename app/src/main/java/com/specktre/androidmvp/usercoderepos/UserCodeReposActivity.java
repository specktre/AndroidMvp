package com.specktre.androidmvp.usercoderepos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.specktre.androidmvp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserCodeReposActivity extends AppCompatActivity {

    private static final String USERNAME_EXTRA = "com.specktre.androidmvp.usercoderepos.username_extra";

    public static Intent newIntent(Context sourceContext, String username) {
        Intent intent = new Intent(sourceContext, UserCodeReposActivity.class);
        intent.putExtra(USERNAME_EXTRA, username);
        return intent;
    }

    @Bind(R.id.fragment_container)
    FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_code_repos);
        ButterKnife.bind(this);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if(fragment == null) {
            fragment = UserCodeReposActivityFragment.newFragment(getIntent().getStringExtra(USERNAME_EXTRA));
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_code_repos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
