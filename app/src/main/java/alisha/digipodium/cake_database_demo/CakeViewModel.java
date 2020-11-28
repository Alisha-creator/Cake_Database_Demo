package alisha.digipodium.cake_database_demo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CakeViewModel extends AndroidViewModel {

    private final LiveData<List<Cake>> allCakes;
    private CakeRepository cakeRepository;

    //Constructor
    public CakeViewModel(@NonNull Application application) {
        super(application);
        cakeRepository = new CakeRepository(application);
        allCakes = cakeRepository.getAllCakes();
    }

    //getter

    public LiveData<List<Cake>> getAllCakes() {
        return allCakes;
    }

    //insert
    public void insert(Cake cake){
        cakeRepository.insert(cake);
    }
}