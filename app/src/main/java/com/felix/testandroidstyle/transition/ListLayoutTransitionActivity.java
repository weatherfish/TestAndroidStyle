package com.felix.testandroidstyle.transition;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;

import com.felix.testandroidstyle.R;

public class ListLayoutTransitionActivity extends ListActivity {

    private ArrayAdapter<String> adapter;
    private LayoutAnimationController lac;
    private ScaleAnimation sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout_transition);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"test1", "test2", "weatherfish", "felix", "wangqiang"});

        setListAdapter(adapter);

//        sa = new ScaleAnimation(0, 1, 0, 1);
//        sa.setDuration(2000);
//
//        lac = new LayoutAnimationController(sa);
//        getListView().setLayoutAnimation(lac);

    }
}
