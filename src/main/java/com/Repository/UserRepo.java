package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.BatteryUser;

public interface UserRepo extends JpaRepository<BatteryUser, Integer>{

}
