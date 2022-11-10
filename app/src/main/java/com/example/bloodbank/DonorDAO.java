package com.example.bloodbank;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DonorDAO {
    @Insert
    void insertAll(BloodDonor... Donor);

    @Query("SELECT * FROM BloodDonor")
    List<BloodDonor> getAllDonors();
}
