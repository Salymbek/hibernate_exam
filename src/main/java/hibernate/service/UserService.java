package hibernate.service;

import hibernate.model.InstagramAccount;
import hibernate.model.User;

public interface UserService {
    void saveUser(User user);
    User getUserById (Long id);
    String deleteUser(Long userId);
    User updateUser(Long id , User user);

}
