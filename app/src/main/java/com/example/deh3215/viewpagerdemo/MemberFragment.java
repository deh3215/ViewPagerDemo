package com.example.deh3215.viewpagerdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemberFragment extends Fragment {
    private Member member;


    public static MemberFragment newInstance(Member member) {
        MemberFragment fragment = new MemberFragment();
        Bundle bd = new Bundle();
        bd.putSerializable("member", member);
        fragment.setArguments(bd);
        return fragment;
    }

    public MemberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_fragment, container, false);
        ImageView iv = (ImageView) view.findViewById(R.id.imageView);
        iv.setImageResource(Integer.valueOf(member.getImage()));
        TextView tv = (TextView) view.findViewById(R.id.tvid);
        tv.setText(Integer.toString(member.getId()));
        TextView tv1 = (TextView)  view.findViewById(R.id.tvName);
        tv1.setText(member.getName());
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            member = (Member) getArguments().getSerializable("member");
        }
    }
}
