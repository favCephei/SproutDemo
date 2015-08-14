package studiocephei.sprouttech;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import studiocephei.sprouttech.Tabs.SlidingTabLayout;

public class InvestmentActivity extends AppCompatActivity {

    private SeekBar mSeekBar;
    public int mChoice;
    private Bitmap mBitmap;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment);
        setTitle("Invest");
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setViewPager(mPager);
        mSeekBar = (SeekBar) findViewById(R.id.sk_bar);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Fragment frag = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.pager + ":" + mPager.getCurrentItem());
                //image fragment
                if (mPager.getCurrentItem() == 0){
                    ((FragmentImage)frag).update(mChoice);
                }
                else if (mPager.getCurrentItem() == 1){
                    ((FragmentTechnical)frag).update(mChoice);

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Fragment frag = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.pager + ":" + mPager.getCurrentItem());
                //image fragment
                mChoice = progress;
                if (mPager.getCurrentItem() == 0){
                    ((FragmentImage)frag).update(progress);
                }
                else if (mPager.getCurrentItem() == 1){
                    ((FragmentTechnical)frag).update(progress);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

        public int getChoice(){
        return mChoice;
    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] tabs;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return FragmentImage.newInstance();
                case 1: return FragmentTechnical.newInstance();
                default: return FragmentImage.newInstance();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return 2;
        }

        public void update(){

        }
    }
}
