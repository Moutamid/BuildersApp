package dev.moutamid.buildersapp;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Scroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    private OnBoardingActivity.ViewPagerFragmentAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView middleImage, profileimage, homeimage, nightmodeimage;
        middleImage = findViewById(R.id.middlebtn);
        profileimage = findViewById(R.id.profileiconimage);
        homeimage = findViewById(R.id.homeiconimage);
        nightmodeimage = findViewById(R.id.nightmodeimage);

        middleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                middleImage.setImageResource(R.drawable.ic_search_selected);
                profileimage.setImageResource(R.drawable.ic_profile_unselected);
                homeimage.setImageResource(R.drawable.ic_home_unselected);

                viewPager.setCurrentItem(1);
            }
        });
        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                middleImage.setImageResource(R.drawable.ic_search_unselected);
                profileimage.setImageResource(R.drawable.ic_profile_selected);
                homeimage.setImageResource(R.drawable.ic_home_unselected);


                viewPager.setCurrentItem(2);
            }
        });
        homeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                middleImage.setImageResource(R.drawable.ic_search_unselected);
                profileimage.setImageResource(R.drawable.ic_profile_unselected);
                homeimage.setImageResource(R.drawable.ic_home_selected);

                viewPager.setCurrentItem(0);
            }
        });

        nightmodeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

            }
        });

        viewPager = findViewById(R.id.homeViewpager);
        adapter = new OnBoardingActivity.ViewPagerFragmentAdapter(getSupportFragmentManager());

        // Setting up the view Pager
        setupViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {

        // Adding Fragments to Adapter
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new SearchFragment());
        adapter.addFragment(new ProfileFragment());

        // Setting Adapter To ViewPager
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);

        Log.d(TAG, "setupViewPager: adapter attached");

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

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
                scroller.set(this, new HomeActivity.NonSwipableViewPager.MyScroller(getContext()));
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