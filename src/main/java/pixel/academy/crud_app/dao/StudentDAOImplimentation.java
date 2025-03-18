package pixel.academy.crud_app.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud_app.entity.Student;

import javax.swing.text.html.parser.Entity;

@Repository
public class StudentDAOImplimentation implements StudentDAO {

    //Camp pentru EntituManager(va fi utilizat pentru interactiune cu baza de date)
    private EntityManager entityManager;

    //Injectare EntityManager prin constructor(practica recomandata pentru testabilitate si modularitate)
    @Autowired
    public StudentDAOImplimentation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implementarea metodei save pentru salvarea unui obiect Student in baza de date
    @Override
    @Transactional
    public void save(Student theStudent) {
            entityManager.persist(theStudent);
    }

}
