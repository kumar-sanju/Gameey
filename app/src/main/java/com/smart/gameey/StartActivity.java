package com.smart.gameey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.smart.gameey.sankeGame.SnakeActivity;
import com.smart.gameey.spaceShooter.Start;

import java.util.HashMap;

public class StartActivity extends AppCompatActivity {

    FloatingActionButton addIcon, shareApp, rateApp, copyAppLink;
    boolean fabVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final FirebaseRemoteConfig mFirebaseRemoteConfig;

        HashMap<String, Object> defaultsRate = new HashMap<>();
        defaultsRate.put("gameey_version_code", String.valueOf(getVersionCode()));

        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(10) // change to 3600 on published app
                .build();

        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.setDefaultsAsync(defaultsRate);

        mFirebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
            @Override
            public void onComplete(@NonNull Task<Boolean> task) {
                if (task.isSuccessful()) {
                    final String gameey_version_code = mFirebaseRemoteConfig.getString("gameey_version_code");

                    if(Integer.parseInt(gameey_version_code) > getVersionCode())
                        showTheDialog(getApplication().getPackageName(), gameey_version_code );
                }
                else Log.e("MYLOG", "mFirebaseRemoteConfig.fetchAndActivate() NOT Successful");

            }
        });


        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        addIcon = findViewById(R.id.addIcon);
        shareApp = findViewById(R.id.shareApp);
        rateApp = findViewById(R.id.rateApp);
        copyAppLink = findViewById(R.id.copyAppLink);
        addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fabVisible) {
                    rateApp.setVisibility(View.VISIBLE);
                    shareApp.setVisibility(View.VISIBLE);

                    addIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_close));
                    fabVisible = true;
                } else {
                    rateApp.setVisibility(View.GONE);
                    shareApp.setVisibility(View.GONE);

                    addIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_add));
                    fabVisible = false;
                }
            }
        });

        rateApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent rateIntent = rateIntentForUrl("market://details");
                    startActivity(rateIntent);
                }
                catch (ActivityNotFoundException e) {
                    Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details");
                    startActivity(rateIntent);
                }
            }
        });

        shareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Download this amazing Gameey App ");
                    String shareMessage= "\nfrom play store\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

    }

    private Intent rateIntentForUrl(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21)
        {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        }
        else
        {
            //noinspection deprecation
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.expandable_menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_item1:
                        showMessage("Item 1 Clicked");
                        return true;

                    case R.id.action_item2:
                        showMessage("Item 2 Clicked");
                        return true;

                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }

    private void showMessage(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    private PackageInfo pInfo;
    private int getVersionCode() {
        pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.i("sanju", "NameNotFoundException: "+e.getMessage());
        }
        return pInfo.versionCode;
    }

    private void showTheDialog(final String appPackageName, String versionFromRemoteConfig) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View customLayout = getLayoutInflater().inflate(R.layout.update_alert, null);
        builder.setView(customLayout);
        TextView updateText = customLayout.findViewById(R.id.text_dialog);
        Button updateBtn = customLayout.findViewById(R.id.updateBtn);
//        updateText.setText("This current version "+getVersionCode()+" is obsolete, please update the new version: " + versionFromRemoteConfig);
//        updateText.setText("This app version is obsolete, update the app now.");
        updateText.setText("This current version is obsolete, please update the new version");

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.setCancelable(false);

    }

    public void spaceShooter(View view) {
        Intent intent = new Intent(StartActivity.this, Start.class);
        startActivity(intent);
//        finish();
    }

    public void snake(View view) {
        Intent intent = new Intent(StartActivity.this, SnakeActivity.class);
        startActivity(intent);
//        finish();
    }

    public void tictacPlay(View view) {
        Intent intent = new Intent(StartActivity.this, TictactoeActivity.class);
        startActivity(intent);
//        finish();
    }

    public void brainQuizplay(View view) {
        Intent intent = new Intent(StartActivity.this, BrainQuizActivity.class);
        startActivity(intent);
//        finish();
    }

    public void roulette(View view) {
        Intent intent = new Intent(StartActivity.this, RouletteActivity.class);
        startActivity(intent);
//        finish();
    }
}