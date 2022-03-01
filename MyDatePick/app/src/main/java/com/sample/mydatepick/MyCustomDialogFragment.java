package com.sample.mydatepick;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

public class MyCustomDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Activity activity = requireActivity();
        ConstraintLayout layout = (ConstraintLayout) LayoutInflater.from(activity)
                .inflate(R.layout.dialog_body,null);
        TextView txtMsg = layout.findViewById(R.id.txtMsg);
        txtMsg.setText(requireArguments().getString("txtName"));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        return builder.setTitle("カスタムダイアログ")
                .setView(layout)
                .setIcon(R.drawable.wings)
                .create();
    }
}
