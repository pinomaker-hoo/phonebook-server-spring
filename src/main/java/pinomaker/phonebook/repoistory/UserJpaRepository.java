package pinomaker.phonebook.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import pinomaker.phonebook.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
