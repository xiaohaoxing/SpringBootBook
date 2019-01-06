package Star.CS.whu.SpringBootBook.repository;

import Star.CS.whu.SpringBootBook.domain.User;

import java.util.List;

public interface UserRepository {
    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> listUser();
}
