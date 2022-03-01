package com.sample.myfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class ListFragment extends Fragment {
    private boolean isTwoPane = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(requireActivity().findViewById(R.id.detailsFrame) != null) {
            isTwoPane = true;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Activity activity = requireActivity();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                activity, android.R.layout.simple_list_item_1,
                ListDataSource.getAllNames());
        ListView list = view.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, v, pos, id) -> {
            DetailsFragment fragment = new DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", (String) parent.getItemAtPosition(pos));
            if(isTwoPane) {
                fragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.detailsFrame, fragment)
                        .commit();
            } else {
                Intent intent = new Intent(requireActivity(), DetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }


}
