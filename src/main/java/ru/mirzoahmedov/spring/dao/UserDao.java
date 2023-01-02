package ru.mirzoahmedov.spring.dao;

import ru.mirzoahmedov.spring.model.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> getAllUser();

    void save(UserEntity userEntity);

    UserEntity show(Long id);

    void update(Long id, UserEntity userEntity);

    void delete(Long id);
}
