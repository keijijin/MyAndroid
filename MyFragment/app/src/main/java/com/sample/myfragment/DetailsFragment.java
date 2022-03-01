package com.sample.myfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Map;

public class DetailsFragment extends Fragment {
    private boolean isTwoPane = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(requireActivity().findViewById(R.id.detailsFrame) != null) {
            isTwoPane = true;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        Bundle bundle;
        if(isTwoPane) {
            bundle = requireArguments();
        } else {
            Intent intent = requireActivity().getIntent();
            bundle = intent.getExtras();
        }
        String name = bundle.getString("name");
        Map<String, String> item = ListDataSource.getInfoByName(name);
        ((TextView)view.findViewById(R.id.name)).setText(name);
        ((TextView)view.findViewById(R.id.info)).setText(item.get(name));
        return view;
    }
}
