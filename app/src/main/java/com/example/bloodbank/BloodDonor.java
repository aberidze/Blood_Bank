package com.example.bloodbank;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BloodDonor {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "Donor_Name")
    public String name;

    @ColumnInfo(name = "Phone_Number")
    public int phoneNum;

    @ColumnInfo(name = "Address")
    public String address;

    @ColumnInfo(name = "Blood_type")
    public String bloodType;

    @ColumnInfo(name = "Last_Donation")
    public String lastDon;

    @ColumnInfo(name = "Next_Donation")
    public int nextDon;

    @ColumnInfo(name = "HI")
    public boolean HI;

    @ColumnInfo(name = "HI Type")
    public String HItype;


    public BloodDonor(String name, int phoneNum, String address, String bloodType, String lastDon, int nextDon, boolean HI, String HItype) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
        this.bloodType = bloodType;
        this.lastDon = lastDon;
        this.nextDon = nextDon;
        this.HI = HI;
        this.HItype = HItype;
    }
}
