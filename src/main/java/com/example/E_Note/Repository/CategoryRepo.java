package com.example.E_Note.Repository;

import com.example.E_Note.DTO.CategoryDto;
import com.example.E_Note.Entity.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {


    public static List<Category> findByIsActiveTrue() {
        return null;
    }

    Optional<Category> findByIdAndIsDeletedFalse(Integer id);
}
