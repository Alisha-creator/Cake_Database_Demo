package alisha.digipodium.cake_database_demo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Cake.class},version = 1,exportSchema = false)
public abstract class CakeDatabase extends RoomDatabase {

    public abstract CakeDao cakeDao();

    private static volatile CakeDatabase INSTANCE;
    private static final int NUMBER_OF_THREAD = 4;
    static final ExecutorService databaseWriteExeEXECUTOR_SERVICE = Executors.newFixedThreadPool(NUMBER_OF_THREAD);

    static CakeDatabase getDatabse(final Context context){
        if (INSTANCE == null){
            synchronized (CakeDatabase.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context,CakeDatabase.class,"cake_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
