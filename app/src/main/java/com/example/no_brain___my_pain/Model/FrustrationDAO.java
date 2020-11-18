package com.example.no_brain___my_pain.Model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FrustrationDAO {
    @Insert
    void insert(Pain... pain);

    @Query("SELECT * FROM pain")
    public List<Pain> getPain();
}
