package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByUserNameAndPassword(String userName, String passWord);

    List<User> findAllByUserTypeEquals(String userType);

    @Transactional
    void deleteByUserName(String userName);
}