package hibernate.service.impl;

import hibernate.model.InstagramAccount;
import hibernate.model.User;
import hibernate.repository.UserRepository;
import hibernate.repository.impl.UserRepositoryImpl;
import hibernate.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository repository = new UserRepositoryImpl();


    @Override
    public void saveUser(User user) {
        repository.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.getUserById(id);
    }

    @Override
    public String deleteUser(Long userId) {
        return repository.deleteUser(userId);
    }

    @Override
    public User updateUser(Long id, User user) {
        return repository.updateUser(id, user);
    }
}
