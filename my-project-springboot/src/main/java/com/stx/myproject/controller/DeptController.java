package com.stx.myproject.controller;

import com.stx.myproject.entity.Dept;
import com.stx.myproject.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptRepository deptRepository;
    @GetMapping("/findAll/{page}/{size}")
    @ResponseBody
    public Page<Dept> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page, size);
        return deptRepository.findAll(request);
    }
    @PostMapping("/save")
    @ResponseBody
    public  String save(@RequestBody Dept dept){
        Dept result = deptRepository.save(dept);
        if(result!=null){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{deptno}")
    @ResponseBody
    public Dept findById(@PathVariable("deptno") Integer deptno){
        Dept dept = deptRepository.findById(deptno).get();
//        System.out.println(dept);

        return dept;
    }
    @PutMapping("update")
    @ResponseBody
    public  String update(@RequestBody Dept dept){
        Dept result = deptRepository.save(dept);
        if(result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/delete/{deptno}")
    @ResponseBody
    public void removeId(@PathVariable("deptno") Integer deptno){
        deptRepository.deleteById(deptno);

    }

}
