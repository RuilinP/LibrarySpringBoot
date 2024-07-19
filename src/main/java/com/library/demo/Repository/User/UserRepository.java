package com.library.demo.Repository.User;

import com.library.demo.Entity.User.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository extends CrudRepository<User, Integer> {
}
