package edu.feicui.app.phone.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import edu.feicui.app.phone.R;

public class LeaderActivity extends AppCompatActivity {
    ImageView mImgAlpha,mImgScale,mImgRotate,mImgTranslate;
AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        System.out.println();
        mImgAlpha=(ImageView) findViewById(R.id.iv_alpha);
        Animation mScale=AnimationUtils.loadAnimation(this,R.anim.any1);

        mImgAlpha.startAnimation(mScale);
//
//        mImgAlpha.setAnimation(mScale);
//        AlphaAnimation mApAnm=new AlphaAnimation(0.1f,1f);
//        mImgAlpha.startAnimation(mApAnm);



//        mImgScale=(ImageView) findViewById(R.id.iv_scale);
//        mImgAlpha=(ImageView) findViewById(R.id.iv_alpha);
//        mImgRotate=(ImageView) findViewById(R.id.iv_rotate);
//        mImgTranslate=(ImageView) findViewById(R.id.iv_translate);
//        Animator animator=AnimatorInflater.loadAnimator(this,R.animator.test);
//        animator.setTarget(mImgAlpha);
//        animator.start();
//        Animator mAm= AnimatorInflater.loadAnimator(this,R.animator.animany);
//
//        mAm.setTarget(mImgTranslate);
//        mAm.start();



//           mImgScale.setImageResource(R.drawable.zhen);
//        anim=(AnimationDrawable) mImgScale.getDrawable();
//        anim.start();



//        Animation animScale= AnimationUtils.loadAnimation(LeaderActivity.this,R.anim.any);
//        mImgScale.startAnimation(animScale);

//        Animation animAlpha= AnimationUtils.loadAnimation(LeaderActivity.this,R.anim.alpha);
//        mImgAlpha.startAnimation(animAlpha);
//        Animation animRotate= AnimationUtils.loadAnimation(LeaderActivity.this,R.anim.totate);
//        mImgRotate.startAnimation(animRotate);
//        Animation animTranslate= AnimationUtils.loadAnimation(LeaderActivity.this,R.anim.translate);
//        mImgTranslate.startAnimation(animTranslate);

//        ScaleAnimation scaleAnimation=new ScaleAnimation(0f,5.4f,0f,5.4f,0.5f,0.5f);
//        scaleAnimation.setDuration(5000);
//        scaleAnimation.setRepeatCount(Animation.INFINITE);
//        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
//          alphaAnimation.setRepeatCount(Animation.INFINITE);
//
//        AnimationSet set=new AnimationSet(true);
//        set.addAnimation(scaleAnimation);
//        set.addAnimation(alphaAnimation);
//        set.setDuration(5000);
//
//        mImgScale.startAnimation(set);
//        mImgScale.startAnimation(scaleAnimation);
//        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
//        alphaAnimation.setDuration(5000);
//        alphaAnimation.setRepeatCount(Animation.INFINITE);
//        mImgAlpha.startAnimation(alphaAnimation);
//        RotateAnimation rotateAnimation=new RotateAnimation(0,-360,1,1);
//        rotateAnimation.setDuration(5000);
//        rotateAnimation.setRepeatCount(Animation.INFINITE);
//        mImgRotate.startAnimation(rotateAnimation);
//        TranslateAnimation translateAnimation=new TranslateAnimation(0,100,0,100);
//        translateAnimation.setDuration(5000);
//        translateAnimation.setRepeatCount(Animation.INFINITE);
//        mImgTranslate.startAnimation(translateAnimation);

    }

//
//    public void playxml(View v){
//
//        ObjectAnimator oa = ObjectAnimator.ofFloat(mImgRotate, "translationX", 10, 50,20,100);
//        oa.setDuration(2000);
//        oa.start(); //开始动画
//    }
//    public void scale(View v) {
//        ObjectAnimator oa = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.test);
//        oa.setTarget(mImgAlpha);
//        oa.start();
//    }
//    public void scale(View v){
//        ObjectAnimator mOjAnt=ObjectAnimator.ofFloat(mImgScale,"alpha",0,1);
//        mOjAnt.setDuration(3000);
//        mOjAnt.start();
//    }
}
