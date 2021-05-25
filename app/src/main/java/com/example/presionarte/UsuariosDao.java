package com.example.presionarte;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsuariosDao {
    @Query("SELECt * FROM usuarios")
    List<Usuarios> getAll();

    @Query("SELECT * FROM usuarios WHERE id IN (:userIds)")
    List<Usuarios> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM usuarios WHERE usuario LIKE :usuario LIMIT 1")
    Usuarios findByName(String usuario);

    @Insert
    Long insert (Usuarios usuarios);

    ///@Query("SELECT * VALOR ")
}
