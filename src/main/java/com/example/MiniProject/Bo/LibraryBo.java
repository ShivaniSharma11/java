package com.example.MiniProject.Bo;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MiniProject.Model.*;

@Repository
public interface LibraryBo extends JpaRepository<Userdata, Integer>{

	

}
