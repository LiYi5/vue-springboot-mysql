package com.stx.myproject.repository;

import com.stx.myproject.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository  extends JpaRepository<Dept,Integer>{
}
