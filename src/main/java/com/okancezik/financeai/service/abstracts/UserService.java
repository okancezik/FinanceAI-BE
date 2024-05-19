package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.entity.concretes.User;

public interface UserService {
    User findById(int id);
}
