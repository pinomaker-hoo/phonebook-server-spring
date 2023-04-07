package pinomaker.phonebook.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import pinomaker.phonebook.domain.Phone;
import pinomaker.phonebook.domain.User;

import java.util.List;
import java.util.Optional;

public interface PhoneJpaRepository extends JpaRepository<Phone, Long> {
    List<Phone> findAllByUser(User user);

    Optional<Phone> findByIdx(Long idx);
}
