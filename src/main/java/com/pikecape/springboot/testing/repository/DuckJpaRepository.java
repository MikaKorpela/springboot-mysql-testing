package com.pikecape.springboot.testing.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuckJpaRepository extends JpaRepository<DuckEntity, UUID> {
  default DuckEntity create(DuckEntity duck) {
    return save(duck);
  }

  default DuckEntity update(DuckEntity duck) {
    return save(duck);
  }
}
