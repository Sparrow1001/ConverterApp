package com.example.progint_1.repository.Room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.progint_1.repository.Model.MoneyDTO;
import com.example.progint_1.repository.Room.DAO.MoneyDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MoneyDTO.class}, version = 1, exportSchema = false)
public abstract class MoneyRoomDatabase extends RoomDatabase {

    public abstract MoneyDAO moneyDAO();

    private static volatile MoneyRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MoneyRoomDatabase getDatabase(final Context context){

        if (INSTANCE == null) {
            synchronized (MoneyRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MoneyRoomDatabase.class, "money_database")
                            .addCallback(new androidx.room.RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    databaseWriteExecutor.execute(() ->{
                                        MoneyDTO mon = new MoneyDTO();
                                        mon.setName("test");
                                        mon.setPrice(10.0);
                                        getDatabase(context).moneyDAO().addMoney(mon);

                                    });
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;

    }

}
