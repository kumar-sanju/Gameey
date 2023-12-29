package com.smart.gameey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.smart.gameey.sankeGame.SnakeActivity;
import com.smart.gameey.spaceShooter.Start;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        RelativeLayout mAdView = findViewById(R.id.adView);
        loadBannerAdsApp(mAdView);
    }

    public void loadBannerAdsApp(final RelativeLayout adContainerView) {
        if (Utlis.checkConnection(this)) {
            AdView mAdView = new AdView(this);

            String adId = "";
            if (BuildConfig.DEBUG) {
//                adId = getString(R.string.ad_mob_banner_id_live);
                adId = getString(R.string.ad_mob_banner_id);
            } else {
//                adId = getString(R.string.ad_mob_banner_id);
                adId = getString(R.string.ad_mob_banner_id);
            }

            if(adId == null){
                return;
            }
            if(adId.isEmpty()){
                return;
            }
            Log.e("Ads ", "Banner id: " + adId);
            mAdView.setAdUnitId(adId);

            adContainerView.removeAllViews();
            adContainerView.addView(mAdView);

            AdSize adSize = getAdSize(this);
            mAdView.setAdSize(adSize);

            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    Log.e("Ads ", "Banner onAdFailedToLoad()" + loadAdError.getCode());
                    adContainerView.setVisibility(View.GONE);
                }

                @Override
                public void onAdLoaded() {
                    Log.e("Ads ", "Banner onAdLoaded()");
                    adContainerView.setVisibility(View.VISIBLE);
                }
            });
        }else {
            adContainerView.setVisibility(View.GONE);
        }

    }

    private AdSize getAdSize(Activity activity) {

        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
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