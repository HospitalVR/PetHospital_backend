package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Paper;
import com.rjsj.pethospital.entity.Test;
import com.rjsj.pethospital.entity.User;
import com.rjsj.pethospital.repository.TestRepository;
import com.rjsj.pethospital.repository.UserRepository;
import com.rjsj.pethospital.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Test> findAll() {
        return testRepository.findAll();
    }

    @Override
    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public Test addTest(Test test, Paper paper, List<Long> user_id) {
        test.setTestpaper(paper);
        List<User> users = userRepository.findAll();
        List<User> testUsers = new ArrayList<>();
        for(User user : users){
            if(user_id.contains(user.getId()))
                testUsers.add(user);
        }
        test.setUsers(testUsers);
        return testRepository.save(test);
    }

    @Override
    public Test deleteTestPaper(Test test) {
        test.setTestpaper(null);
        return testRepository.save(test);
    }

    @Override
    public Test deleteTestStudent(Test test, List<Long> user_id) {
        List<User> users = new ArrayList<>();
        User user ;
        for(Long id : user_id){
            user = userRepository.findById(id).orElse(null);
            users.add(user);
        }
        test.setUsers(users);
        return testRepository.save(test);
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public void deleteById(Long id) {
        testRepository.deleteById(id);
    }
}
