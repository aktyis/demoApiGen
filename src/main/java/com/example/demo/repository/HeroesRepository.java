package com.example.demo.repository;

import com.example.demo.model.Heroes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface HeroesRepository extends JpaRepository<Heroes, Long> {

    Heroes findById(long Id);

    @Override
    void delete(Heroes heroes);
}
