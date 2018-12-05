package com.liumeng.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {


    private FloatingActionButton mFadNormal;

    public BookFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        setupFab(view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.jumpbookdetail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),BookDetailActivity.class));
            }
        });
    }

    private void setupFab(View view) {
        mFadNormal = (FloatingActionButton) view.findViewById(R.id.fad_normal);
        mFadNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //需要添加依赖 compile 'com.github.afollestad.material-dialogs:core:0.8.5.7'
                new MaterialDialog.Builder(getActivity())
                        .title(R.string.search)
                        //.inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                        .input(R.string.input_hint, R.string.input_prefill, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something
                                if (!TextUtils.isEmpty(input)) {
                                    doSearch(input.toString());
                                }
                            }
                        }).show();
            }
        });
    }

    private void doSearch(String string) {
        Toast.makeText(getContext(),"搜索",Toast.LENGTH_LONG).show();
    }

}
