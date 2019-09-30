package com.geekbrains.geekmarket.repositories;

import com.geekbrains.geekmarket.entities.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long > {
    List<Student> findAllByExamgradeBetween(int min, int max);

    @Query(value = "SELECT * FROM `students` WHERE `examgrade`IN (SELECT MAX(`examgrade`) FROM `students`)", nativeQuery = true)
    List<Student> findAllByExamgradeInMAX();

    @Query(value ="SELECT * FROM `students` WHERE `examgrade`IN (SELECT MIN(`examgrade`) FROM `students`)", nativeQuery = true)
    List<Student> findAllByExamgradeInMIN();

    @Query(value = "SELECT  MAX(`examgrade`) FROM `students`",nativeQuery = true)
    public int findMAXExamgrade();

    @Query(value = "SELECT  MIN(`examgrade`) FROM `students`",nativeQuery = true)
    public int findMINExamgrade();

}
