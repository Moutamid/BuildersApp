package dev.moutamid.buildersapp;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.Scroller;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {
    private static final String TAG = "OnBoardingActivity";

    private ViewPagerFragmentAdapter adapter;
    private ViewPager viewPager;

    private Button getStartedBtn;
//    private TextView swipeTextView;

    private SpringDotsIndicator dotsIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.onBoarding_walkThrough_view_pager);
//        swipeTextView = findViewById(R.id.swipeTextview);
//        skipBtn = findViewById(R.id.skip_btn_onBoarding_walkThrough);
        getStartedBtn = findViewById(R.id.previous_btn_onBoarding_walkThrough);
        dotsIndicator = findViewById(R.id.dots_indicator_onBoarding);
//        nextTxt = findViewById(R.id.next_text_onBoarding_walkThrough);

//        nextBtn.setOnClickListener(nextBtnListener());
//        getStartedBtn.setOnClickListener(getstartedListener());
//        skipBtn.setOnClickListener(skipBtnListener());

        adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());

        // Setting up the view Pager
        setupViewPager(viewPager);

        dotsIndicator.setViewPager(viewPager);


    }

//    private View.OnClickListener skipBtnListener() {
//
//        return new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                finish();
////                startActivity(new Intent(ActivityMain.this, ActivityGradeSelection.class));
//            }
//        };
//
//    }

//    private View.OnClickListener getstartedListener() {
//        return new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (viewPager.getCurrentItem() == 1) {
//
//                    viewPager.setCurrentItem(0, true);
//
//                } else if (viewPager.getCurrentItem() == 2) {
//
//                    viewPager.setCurrentItem(1, true);
//
//                } else if (viewPager.getCurrentItem() == 3) {
//
//                    viewPager.setCurrentItem(2, true);
//
//                }
//
//            }
//        };
//    }

//    private View.OnClickListener nextBtnListener() {
//
//        return new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                // Video Lectures Page
//                if (viewPager.getCurrentItem() == 0) {
//
//                    viewPager.setCurrentItem(1, true);
//
//                    // Past Papers Page
//                } else if (viewPager.getCurrentItem() == 1) {
//
//                    viewPager.setCurrentItem(2, true);
//
//                    // Book Guide Page
//                } else if (viewPager.getCurrentItem() == 2) {
//
//                    viewPager.setCurrentItem(3, true);
//
//                    // Book Guide Page
//                } else if (viewPager.getCurrentItem() == 3) {
//
//                    finish();
////                    startActivity(new Intent(ActivityMain.this, ActivityGradeSelection.class));
//
//                }
//
//            }
//        };
//
//    }

    private void setupViewPager(ViewPager viewPager) {

        // Adding Fragments to Adapter
        adapter.addFragment(new FragmentOnBoardingSpace());
        adapter.addFragment(new FragmentOnBoardingVision());
        adapter.addFragment(new FragmentOnBoardingDreams());
        adapter.addFragment(new FragmentOnBoardingLogoFinal());

        // Setting Adapter To ViewPager
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(adapter);

        Log.d(TAG, "setupViewPager: adapter attached");

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {

                switch (position) {

                    case 0:
                    case 1:
                    case 2:
                        // Page 3 (Past Papers)
//
//                        utils.changeStatusBarColor(ActivityMain.this, (R.color.yellow));
//
                        // Page 2 (Video Lectures)
//
//                        utils.changeStatusBarColor(ActivityMain.this, (R.color.darkSkyBlue));

                        // Showing previous Button
                        // Page 1 (Welcome)

//                        utils.changeStatusBarColor(ActivityMain.this, R.color.pinkish);

                        // Hiding previous Button
                        getStartedBtn.setVisibility(View.GONE);
//                        swipeTextView.setVisibility(View.VISIBLE);

                        break;

                    // Animately change text of Next Button
//                        nextTxt.setText("Next");

                    case 3:
                        // Page 3 (Guides and More)

//                        utils.changeStatusBarColor(ActivityMain.this, (R.color.indigo));

                        // Showing previous Button
                        getStartedBtn.setVisibility(View.VISIBLE);
//                        swipeTextView.setVisibility(View.GONE);

                        // Animately change text of Next Button
//                        animateNextBtn();

                        break;
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

//    private void animateNextBtn() {
//
//        Animation animation = AnimationUtils.loadAnimation(ActivityMain.this, R.anim.blink_anim);
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                nextTxt.setText("Get started");
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//
//        nextBtn.startAnimation(animation);
//
//    }

    @Override
    public void onBackPressed() {

        if (viewPager.getCurrentItem() == 0) super.onBackPressed();

        else viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);

    }

    public static class NonSwipableViewPager extends ViewPager {


        public NonSwipableViewPager(@NonNull Context context) {
            super(context);
        }

        public NonSwipableViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return false;
        }

        @Override
        public boolean onTouchEvent(MotionEvent ev) {
            return false;
        }

        public void setMyScroller() {

            try {
                Class<?> viewpager = ViewPager.class;
                Field scroller = viewpager.getDeclaredField("mScroller");
                scroller.setAccessible(true);
                scroller.set(this, new MyScroller(getContext()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public class MyScroller extends Scroller {

            public MyScroller(Context context) {
                super(context, new DecelerateInterpolator());
            }

            @Override
            public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                super.startScroll(startX, startY, dx, dy, 350);
            }
        }
    }

    public static class ViewPagerFragmentAdapter extends FragmentStatePagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        public ViewPagerFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

}