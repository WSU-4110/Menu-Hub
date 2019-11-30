package com.example.menuhub;

import android.graphics.Color;

import org.junit.Test;

import gr.net.maroulis.library.EasySplashScreen;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Color;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;
import static org.junit.Assert.*;

public class SplashScreenActivityTest {

    @Test
    public void onCreate() {
        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(LoginActivity.class)
                .withSplashTimeOut(2000)
                .withBackgroundColor(Color.parseColor("#1a1b29"))
                .withHeaderText("")
                .withFooterText("")
                .withBeforeLogoText("")
                .withAfterLogoText("Menu Hub")
                .withLogo(R.mipmap.ic_launcher2);

        config.getHeaderTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);

        assertEquals(config.withSplashTimeOut(), 2000);

    }
}