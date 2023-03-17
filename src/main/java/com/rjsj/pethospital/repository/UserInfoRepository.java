package com.rjsj.pethospital.repository;

import com.rjsj.pethospital.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByUserName(String userName);

}
