package com.from206.cloudmusic.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * 播放动画工具类
 * Created by 75232 on 2019/2/1
 * Email：752323877@qq.com
 */
public class AnimationTool {
    private static final String TAG = "AnimationTool";

    /**
     * 缩放view
     */
    public static void scaleView(View view){
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 2.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator1).with(objectAnimator2);
        animatorSet.setDuration(500);
        animatorSet.start();

    }

}
