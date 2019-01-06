package Star.CS.whu.SpringBootBook.repository;

import Star.CS.whu.SpringBootBook.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentHashMap<Long, User> users = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if(id== null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.users.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.users.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.users.get(id);
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<>(this.users.values());
    }
}
