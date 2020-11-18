package com.example.no_brain___my_pain.Model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pain.class}, version = 1)
public abstract class SufferingDatabase extends RoomDatabase {
    public abstract FrustrationDAO getPainDAO();
}
