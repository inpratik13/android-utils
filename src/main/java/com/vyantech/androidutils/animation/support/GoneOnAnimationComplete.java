package com.vyantech.androidutils.animation.support;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/**
 * Created by iCon on 2/25/2017.
 */

public class GoneOnAnimationComplete implements Animation.AnimationListener {
    private View view;

    public GoneOnAnimationComplete(View view){
        this.view = view;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        view.setVisibility(View.GONE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
