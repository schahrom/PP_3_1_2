package ru.mirzoahmedov.spring.service;


import ru.mirzoahmedov.spring.model.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUser();

    void save(UserEntity userEntity);

    UserEntity show(Long id);

    void update(Long id, UserEntity userEntity);

    void delete(Long id);
}
