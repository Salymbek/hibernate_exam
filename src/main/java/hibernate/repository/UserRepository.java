package hibernate.repository;

import hibernate.model.InstagramAccount;
import hibernate.model.User;

public interface UserRepository {
    void saveUser(User user);
    User getUserById (Long id);
    String deleteUser(Long userId);
    User updateUser(Long id , User user);

}
