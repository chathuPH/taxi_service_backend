package com.example.gocheetanew.service;

import com.example.gocheetanew.model.Branch;
import com.example.gocheetanew.repository.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;

    public Branch addNewBranch(Branch branch ) {
        return branchRepository.save(branch);
    }

    public List<Branch> findAll(){
        return branchRepository.findAll();
    }

    public void delete(long id){
        branchRepository.deleteById(id);
    }

    public Branch findById(long id) {
        return branchRepository.findById(id).orElseThrow(()->new RuntimeException("branch not found"));
    }
}
