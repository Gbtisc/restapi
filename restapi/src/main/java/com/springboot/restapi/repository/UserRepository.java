package com.springboot.restapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springboot.restapi.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {//By default JPA made JPARepo @Transactional
	@Query(value = "SELECT * FROM USERS u WHERE u.user_name LIKE %?1% AND u.user_email LIKE %?2%", nativeQuery = true)
	public List<User> searchByUserNameAndUserEmailLike(@Param("user_name") String userName, @Param("user_email") String userEmail);
}