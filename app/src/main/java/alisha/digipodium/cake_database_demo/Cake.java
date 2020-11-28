package alisha.digipodium.cake_database_demo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cake_table")
public class Cake {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="name")
    private String name;

    public Cake (String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}
