package com.pikecape.springboot.testing.service;

import com.pikecape.springboot.testing.repository.DuckEntity;
import com.pikecape.springboot.testing.repository.DuckJpaRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DuckService {
  private final DuckJpaRepository repository;

  private static final String DUCK_NOT_FOUND = "Duck not found";

  public List<DuckEntity> findAll() {
    return repository.findAll();
  }

  public DuckEntity findById(UUID uid) {
    return repository.findById(uid)
        .orElseThrow(() -> new RuntimeException(DUCK_NOT_FOUND));
  }

  public DuckEntity create(DuckEntity duck) {
    return repository.create(duck);
  }

  public DuckEntity update(UUID uid, DuckEntity duck) {
    repository.findById(uid)
        .orElseThrow(() -> new RuntimeException(DUCK_NOT_FOUND));

    return repository.update(duck);
  }

  public void deleteByUid(UUID uid) {
    DuckEntity duck = repository.findById(uid)
        .orElseThrow(() -> new RuntimeException(DUCK_NOT_FOUND));

    repository.delete(duck);
  }
}
