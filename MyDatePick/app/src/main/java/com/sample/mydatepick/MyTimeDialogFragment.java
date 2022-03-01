package com.sample.mydatepick;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Locale;

public class MyTimeDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar cal = Calendar.getInstance();
        Activity activity = requireActivity();
        return new TimePickerDialog(
                activity, (view, hourOfDay, minute) -> {
            EditText txtTime = activity.findViewById(R.id.txtTime);
            txtTime.setText(String.format(Locale.JAPAN, "%02d:%02d", hourOfDay, minute));
        },
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
        );
    }
}
