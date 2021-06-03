package cn.cqu.edu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cn.cqu.edu.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}