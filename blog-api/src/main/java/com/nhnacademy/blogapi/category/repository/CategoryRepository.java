package com.nhnacademy.blogapi.category.repository;

import com.nhnacademy.blogapi.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
