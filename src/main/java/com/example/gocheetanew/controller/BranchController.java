package com.example.gocheetanew.controller;

import com.example.gocheetanew.dto.BranchDto;
import com.example.gocheetanew.dto.CategoryDto;
import com.example.gocheetanew.model.Branch;
import com.example.gocheetanew.model.Category;
import com.example.gocheetanew.model.Vehicle;
import com.example.gocheetanew.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/v1/branch")
public class BranchController {

    private BranchService branchService;

    @PostMapping("/create")
    public ResponseEntity<Branch> create(@RequestBody BranchDto branchDto){
        HttpStatus response  = HttpStatus.EXPECTATION_FAILED;

        if(branchDto==null){
            response = HttpStatus.BAD_REQUEST;
        }else{
            response = HttpStatus.CREATED;
        }

        Branch branch = new Branch();
        branch.setBrnachName(branchDto.getBranchName());
        branch.setContactNo(branchDto.getContactNo());
        branch.setLocation(branchDto.getLocation());
        return new ResponseEntity<>(branchService.addNewBranch(branch),response);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Branch>> findAll(){
        return new ResponseEntity<>(branchService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Branch> update(@RequestBody BranchDto branchDto) {

        HttpStatus response  = HttpStatus.EXPECTATION_FAILED;

        if(branchDto == null){
            throw new RuntimeException("id cannot be null");
        }else{
            response = HttpStatus.CREATED;

        }

        Branch branch = new Branch();
        branch.setId(branchDto.getId());
        branch.setBrnachName(branchDto.getBranchName());
        branch.setContactNo(branchDto.getContactNo());
        branch.setLocation(branchDto.getLocation());
        return new ResponseEntity<>(branchService.addNewBranch(branch),response);


    }

    @DeleteMapping("/delete")
    public ResponseEntity<Branch> delete(@RequestParam(name = "id") long id) {

        HttpStatus response = HttpStatus.EXPECTATION_FAILED;
        Branch deleted = branchService.findById(id);

        try{
            branchService.delete(id);
            response = HttpStatus.ACCEPTED;

        }catch (Exception e){
            response = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(deleted, response);

    }

    @GetMapping("/findById")
    public ResponseEntity<Branch> findById(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(branchService.findById(Long.parseLong(id)),HttpStatus.OK);
    }


}
