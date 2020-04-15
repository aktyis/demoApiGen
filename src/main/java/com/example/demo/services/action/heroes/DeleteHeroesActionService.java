package com.example.demo.services.action.heroes;


import com.example.demo.repository.HeroesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aman.ullah on 4/14/2020.
 */
@Service
@Component
public class DeleteHeroesActionService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HeroesRepository heroesRepository;

    @Transactional
    public String heroDelete(long id) {
        String message = "Student Deleted Successfully!";
        logger.error("-----------Student Selected---------");
        heroesRepository.delete(heroesRepository.findById(id));
        return message;
    }
}
