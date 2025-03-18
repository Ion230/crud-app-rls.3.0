package pixel.academy.crud_app.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

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
    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class, id);
    }
    @Override
    public List<Student> findAll() {
        //creare query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //returnam query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //crearea query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //setarea parametrilor pentru query
        theQuery.setParameter("theData",theLastName);

        //returnarea rezultatelor query
        return theQuery.getResultList();
    }

}
