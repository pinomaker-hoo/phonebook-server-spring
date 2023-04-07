package pinomaker.phonebook.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import pinomaker.phonebook.domain.RefreshToken;

import java.util.Optional;

public interface RefreshJpaTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByAuthKeyAndType(String authKey, String type);
}
