package com.example.MiniProject.Bo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MiniProject.Model.Bookdata;



@Repository
public interface BookdataBo extends JpaRepository<Bookdata, Integer> {

}
