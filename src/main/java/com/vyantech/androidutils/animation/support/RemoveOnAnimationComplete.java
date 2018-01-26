package com.vyantech.androidutils.animation.support;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/**
 * Created by iCon on 2/25/2017.
 */

public class RemoveOnAnimationComplete implements Animation.AnimationListener {
    private View view;

    public RemoveOnAnimationComplete(View view){
        this.view = view;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        ((ViewGroup)view.getParent()).removeView(view);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
