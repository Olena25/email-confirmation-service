package com.intellias.emailsender.db;

import com.intellias.emailsender.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
