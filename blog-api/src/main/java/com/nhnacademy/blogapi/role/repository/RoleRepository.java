package com.nhnacademy.blogapi.role.repository;

import com.nhnacademy.blogapi.role.doamin.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

}
