package com.bhasad.api.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bhasad.api.domain.model.Employee;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
    //@Procedure(name = "return_salesRep")
    //public ResultSet returnSalesRep(String in1);
	
    @Query(nativeQuery = true,value = "call return_salesRep(:job)")   // call store procedure with arguments
    ResultSet returnSalesRep(@Param("job")String job);
    
   
}
