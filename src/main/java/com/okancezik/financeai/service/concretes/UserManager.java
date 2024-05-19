package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.entity.concretes.User;
import com.okancezik.financeai.repository.abstracts.UserRepository;
import com.okancezik.financeai.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository repository;

    @Override
    public User findById(int id) {
        var data = this.repository.findById(id);
        return data.isPresent() ? data.get() : null;
    }
}
