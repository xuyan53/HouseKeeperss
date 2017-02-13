package edu.feicui.app.phone.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.entity.SaveInstance;
import edu.feicui.app.phone.service.SingBindService;

public class LeaderActivity extends AppCompatActivity {
//    ImageView mImgAlpha,mImgScale,mImgRotate,mImgTranslate;
//AnimationDrawable anim;
    ViewPager mVpLeader;
    TextView mTxtJump;
    ImageView mImgDot1,mImgDot2,mImgDot3;
    Context mCtx;
    SingBindService singBindService;
    ServiceConnection conn1=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            singBindService=((SingBindService.Mbind) service).getService();
            singBindService.play();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        mVpLeader=(ViewPager)findViewById(R.id.vp_leader);
        mTxtJump=(TextView)findViewById(R.id.txt_jump);
        mImgDot1=(ImageView)findViewById(R.id.img_dot1);
        mImgDot2=(ImageView)findViewById(R.id.img_dot2);
        mImgDot3=(ImageView)findViewById(R.id.img_dot3);
        mCtx=this;
        Intent service=new Intent();
        service.setClass(LeaderActivity.this,SingBindService.class);
        bindService(service,conn1,BIND_AUTO_CREATE);
        startService(service);

        if(!SaveInstance.getSaveInstance(this).getStringvalue("leader").equals("1")){
            Intent intent=new Intent(LeaderActivity.this,LogoActivity.class);
            startActivity(intent);
            finish();
        }


        mTxtJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveInstance.getSaveInstance(mCtx).putStringvalue("leader","2");
                Intent intent=new Intent(LeaderActivity.this,LogoActivity.class);
                unbindService(conn1);
                startActivity(intent);

            }
        });
        mTxtJump.setVisibility(View.INVISIBLE);
        ArrayList<View> views=initView();
        ViewPagerAdapter adapter=new ViewPagerAdapter(this);
        adapter.setViews(views);
        mVpLeader.setAdapter(adapter);
        mVpLeader.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("#############", "onPageSelected1" + position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.i("#############", "onPageSelected2" + position);
                switch (position){
                    case 0:
                        mTxtJump.setVisibility(View.INVISIBLE);
                        mImgDot3.setImageResource(R.mipmap.adware_style_selected);
                        mImgDot2.setImageResource(R.mipmap.adware_style_default);
                        mImgDot1.setImageResource(R.mipmap.adware_style_default);
                        break;
                    case 1:
                        mTxtJump.setVisibility(View.INVISIBLE);
                        mImgDot3.setImageResource(R.mipmap.adware_style_default);
                        mImgDot2.setImageResource(R.mipmap.adware_style_selected);
                        mImgDot1.setImageResource(R.mipmap.adware_style_default);
                        break;
                    case 2:
                        mTxtJump.setVisibility(View.VISIBLE);
                        mImgDot3.setImageResource(R.mipmap.adware_style_default);
                        mImgDot2.setImageResource(R.mipmap.adware_style_default);
                        mImgDot1.setImageResource(R.mipmap.adware_style_selected);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
ArrayList<View> initView(){
    ArrayList<View> views=new ArrayList<View>();
View view=getLayoutInflater().inflate(R.layout.leader_cell1,null);
    views.add(view);
    view=getLayoutInflater().inflate(R.layout.leader_cell2,null);
    views.add(view);
    view=getLayoutInflater().inflate(R.layout.leader_cell3,null);
    views.add(view);
    return views;
}
    class ViewPagerAdapter extends PagerAdapter{
        Context ctx;
        ArrayList<View> views=new ArrayList<View>();
        ViewPagerAdapter(Context context){
            ctx=context;
        }
        public void setViews(ArrayList<View> views){
            this.views=views;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view=views.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
    }













































//        System.out.println();
//        mImgAlpha=(ImageView) findViewById(R.id.iv_alpha);
//        Animation mScale=AnimationUtils.loadAnimation(this,R.anim.any1);
//
//        mImgAlpha.startAnimation(mScale);
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
