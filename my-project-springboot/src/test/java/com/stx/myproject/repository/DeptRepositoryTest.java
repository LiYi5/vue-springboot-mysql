package com.stx.myproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeptRepositoryTest {
    @Autowired
    private DeptRepository deptRepository;
    @Test
    void findAll(){
        System.out.println(deptRepository.findAll());
    }
}