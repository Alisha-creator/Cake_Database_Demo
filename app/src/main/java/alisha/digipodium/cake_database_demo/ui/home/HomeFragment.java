package alisha.digipodium.cake_database_demo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import alisha.digipodium.cake_database_demo.Cake;
import alisha.digipodium.cake_database_demo.CakeViewModel;
import alisha.digipodium.cake_database_demo.R;

public class HomeFragment extends Fragment {

    private CakeViewModel cakeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cakeViewModel = new ViewModelProvider(this).get(CakeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvCakes =view.findViewById(R.id.rvCakes);
        CakeListAdaptor adaptor = new CakeListAdaptor(getActivity(),R.layout.row_cake);
        rvCakes.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCakes.setAdapter(adaptor);

        //observer
        cakeViewModel.getAllCakes().observe(getViewLifecycleOwner(), new Observer<List<Cake>>() {
            @Override
            public void onChanged(List<Cake> cakes) {
                adaptor.setCakes(cakes);
            }
        });
    }
}