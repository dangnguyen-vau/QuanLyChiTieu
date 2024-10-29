package com.example.quanlychitieu.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.quanlychitieu.mdel.ChiTieu;
import com.example.quanlychitieu.mdel.DanhMuc;
import com.example.quanlychitieu.mdel.LoaiTienTe;
import com.example.quanlychitieu.mdel.ViTien;

@Database(entities = {DanhMuc.class, LoaiTienTe.class, ViTien.class, ChiTieu.class}, version = 1, exportSchema = false)
@TypeConverters(Converter.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DanhMucDao danhMucDao();

    public abstract LoaiTienTeDao loaiTienTeDao();

    public abstract ViTienDao viTienDao();

    public abstract ChiTieuDao chiTieuDao();

    private static volatile AppDatabase INSTANCE;

    static AppDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database")
                            .createFromAsset("database/database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
