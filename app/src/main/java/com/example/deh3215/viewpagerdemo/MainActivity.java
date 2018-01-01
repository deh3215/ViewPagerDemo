package com.example.deh3215.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Member> memberList;
    private ViewPager vpMember;
    int[] Img={R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6,
               R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10, R.drawable.h11, R.drawable.h12};
    int[] Name={R.string.h1, R.string.h2, R.string.h3, R.string.h4, R.string.h5, R.string.h6,
                R.string.h7, R.string.h8, R.string.h9, R.string.h10, R.string.h11, R.string.h12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Member>memberList = getMemberList();
        MemberAdapter memberAdapter = new MemberAdapter(getSupportFragmentManager(), memberList);
        vpMember = (ViewPager) findViewById(R.id.vpMember);
        vpMember.setAdapter(memberAdapter);
    }

    private List<Member> getMemberList()    {
        memberList = new ArrayList<>();

        for(int i=0; i<Img.length; i++)
            memberList.add(new Member((i+1), Img[i], getString(Name[i])));

        //memberList.add(new Member(23, R.drawable.h2,"Jack"));

        return memberList;
    }

    private class MemberAdapter extends FragmentStatePagerAdapter {
        List<Member> memberList;

        public MemberAdapter(FragmentManager fm, List<Member> memberList) {
            super(fm);
            this.memberList = memberList;
        }

        @Override
        public Fragment getItem(int position) {
            return MemberFragment.newInstance(memberList.get(position));
        }

        @Override
        public int getCount() {
            return memberList.size();
        }
    }
    int i=0;
    public void onNextClick(View view)  {
        Log.d("Next", ""+i);
        i++;
        if(i>=memberList.size() || i==-1)
            i=0;
        vpMember.setCurrentItem(i);

    }

    public void onPrevClick(View view)  {
        Log.d("Prev", ""+i);
        i--;
        if(i<=-1 )
            i=memberList.size()-1;
        vpMember.setCurrentItem(i);
    }
}
