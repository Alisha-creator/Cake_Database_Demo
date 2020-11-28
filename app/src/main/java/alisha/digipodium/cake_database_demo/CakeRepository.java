package alisha.digipodium.cake_database_demo;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;

public class CakeRepository {

    private CakeDao cakeDao;
    private LiveData<List<Cake>> allCakes;

    public  CakeRepository(Application application){
        CakeDatabase db = CakeDatabase.getDatabse(application);
        cakeDao =db.cakeDao();
        allCakes = cakeDao.getAllCakes();
    }

    public LiveData<List<Cake>> getAllCakes() {
        return allCakes;
    }
    public void insert(Cake cake){
        CakeDatabase.databaseWriteExeEXECUTOR_SERVICE.execute(() ->{
                cakeDao.insert(cake);
        });
    }
}
