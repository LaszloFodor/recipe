package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitRepository extends CrudRepository<Unit, Integer> {

    Optional<Unit> findByUnit(String unit);

}
