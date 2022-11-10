package com.example.bloodbank;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BloodDonor.class}, version = 1)
public abstract class DonorDatabase extends RoomDatabase {
    public abstract DonorDAO donorDAO();
}
