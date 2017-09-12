package com.java.xxii.mvp.ui.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.java.xxii.App;
import com.java.xxii.R;
import com.java.xxii.greendao.BanKeyword;
import com.java.xxii.greendao.BanKeywordDao;
import com.java.xxii.greendao.BanNewsDao;
import com.java.xxii.mvp.ui.activities.NewsDetailActivity;

import java.util.ArrayList;

import static com.java.xxii.App.getBanKeywordDao;
import static java.lang.Boolean.FALSE;

/**
 * Created by Hao on 12/09/2017.
 */

public class BanKeywordFragment extends DialogFragment {
    boolean[] mSelect;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] mItems = getArguments().getStringArray("KeywordList");
        mSelect = new boolean[mItems.length];
        for(int i = 0;i<mSelect.length;i++)
            mSelect[i] = FALSE;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title
        builder.setTitle("您还想屏蔽哪些内容？")
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setMultiChoiceItems(mItems, mSelect,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                 mSelect[which] = isChecked;
                            }
                        })
                // Set the action buttons
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        BanKeywordDao banKeywordDao = getBanKeywordDao();
                        BanKeyword banKeyword;
                        for (int i = 0;i<mSelect.length;i++){
                            if(mSelect[i]){
                                banKeyword = new BanKeyword(mItems[i]);
                                if(banKeywordDao.queryBuilder().where(BanKeywordDao.Properties.Keyword.eq(mItems[i])).list().size() != 0)
                                    banKeywordDao.update(banKeyword);
                                else banKeywordDao.insert(banKeyword);
                            }
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }

}
