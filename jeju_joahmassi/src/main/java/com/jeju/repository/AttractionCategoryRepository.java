package com.jeju.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeju.entity.AttractionCategory;

public interface AttractionCategoryRepository extends JpaRepository<AttractionCategory, Long> {

}
