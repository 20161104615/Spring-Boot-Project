package com.ys.demo.mapper;

import com.ys.demo.bean.FavoriteSongs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteSongsRepository extends JpaRepository<FavoriteSongs, Long> {
}