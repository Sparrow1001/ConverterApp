package com.example.progint_1.repository.Room.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.progint_1.repository.Model.MoneyDTO;

@Dao
public interface MoneyDAO {

    @Insert
    void addMoney(MoneyDTO money);

    @Delete
    void deleteMoney(MoneyDTO money);

    @Update
    void updateMoney(MoneyDTO money);



}
