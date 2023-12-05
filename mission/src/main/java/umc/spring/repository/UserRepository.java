package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
