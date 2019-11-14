package de.dhbw.jhelm.repository;


import de.dhbw.jhelm.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(@Param("id") String id);
}
