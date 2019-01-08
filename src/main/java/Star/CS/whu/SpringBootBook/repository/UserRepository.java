package Star.CS.whu.SpringBootBook.repository;

import Star.CS.whu.SpringBootBook.domain.User;
import org.springframework.data.repository.CrudRepository;


/**
 * 这个地方继承了这个类就可以了，不需要实现！甚至不需要声明函数！
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
