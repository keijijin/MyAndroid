package com.sample.mydialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyFialogFragment extends DialogFragment {
    int selected = 0;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Activity activity = requireActivity();
        //Bundle args = requireArguments();
        //String txtName = args.getString("txtName");
        //final String[] items = {"A型","B型","O型","AB型"};
        final String[] items ={"電車","バス","徒歩","マイカー","自転車","その他"};
        final boolean[] selected = {true, true, true, false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        return builder.setTitle("通勤手段")
                //.setMessage(String.format("%sさんは、JavaでAndroid開発できますか？", txtName))
                .setIcon(R.drawable.wings)
                .setMultiChoiceItems(items, selected, (dialog, which, isChecked) -> {
                    selected[which] = isChecked;
                        })
                .setPositiveButton("OK", (dialog, which) -> {
                    //Toast.makeText(activity, "正解です！", Toast.LENGTH_SHORT).show();
                    String msg = "";
                    for(int i = 0; i < items.length; i++) {
                        if(selected[i]) {
                            msg += items[i] + ",";
                        }
                    }
                    Toast.makeText(activity,
                            String.format("「%s」が選択されました。",
                                    msg.substring(0, msg.length() - 1)),
                            Toast.LENGTH_SHORT).show();
                })
                /*
                .setNegativeButton("いいえ", (dialog, which) -> {
                    Toast.makeText(activity, "間違いです。。。", Toast.LENGTH_SHORT)
                            .show();
                })
                //.setNeutralButton("キャンセル", (dialog, which) -> {})


                .setItems(items, (dialog, which) -> {
                    Toast.makeText(activity,
                            String.format("「%s」が選択されました。", items[which]),
                            Toast.LENGTH_SHORT).show();
                })*/
                .create();
    }
}
