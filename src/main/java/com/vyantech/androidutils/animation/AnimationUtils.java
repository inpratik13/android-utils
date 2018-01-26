package com.vyantech.androidutils.animation;

import android.view.View;
import android.view.animation.Animation;

import com.vyantech.androidutils.R;
import com.vyantech.androidutils.animation.support.GoneOnAnimationComplete;
import com.vyantech.androidutils.animation.support.RemoveOnAnimationComplete;
import com.vyantech.androidutils.animation.support.VisibleOnAnimationComplete;

/**
 * Created by iCon on 2/25/2017.
 */

public class AnimationUtils {
    private AnimationUtils(){}

    public static void fadeOut(View view, boolean removeAfter){
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_out);
        if(removeAfter) {
            anim.setAnimationListener(new RemoveOnAnimationComplete(view));
        }
        view.startAnimation(anim);
    }

    public static void fadeOutAndHide(View view){
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_out);
        anim.setAnimationListener(new GoneOnAnimationComplete(view));
        view.startAnimation(anim);
    }

    public static void fadeIn(View view){
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_in);
        anim.setAnimationListener(new VisibleOnAnimationComplete(view));
        view.startAnimation(anim);
    }

    public static void slideDown(View view){
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_down);
        view.startAnimation(anim);
    }

    public static void slideDownAndFade(View view){
        Animation anim = android.view.animation.AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_down_and_fade);
        view.startAnimation(anim);
    }
}
