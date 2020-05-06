package com.stx.myproject;

import com.stx.myproject.entity.Dept;
import com.stx.myproject.repository.DeptRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyprojectApplicationTests {
	@Autowired
	private DeptRepository deptRepository;

	@Test
	void save() {
		Dept dept=new Dept();
		dept.setDname("renshbu");
		dept.setLoc("beij");
		Dept dept1 = deptRepository.save(dept);
		System.out.println(dept1);
	}

}
