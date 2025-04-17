package com.pikecape.springboot.testing.controller;

import com.pikecape.springboot.testing.repository.DuckEntity;
import com.pikecape.springboot.testing.service.DuckService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ducks")
@RequiredArgsConstructor
public class DuckController {
  private final DuckService service;

  @GetMapping
  public List<DuckEntity> findAll() {
    return service.findAll();
  }

  @GetMapping("/{uid}")
  public DuckEntity findById(@PathVariable UUID uid) {
    return service.findById(uid);
  }

  @PostMapping
  public DuckEntity create(@RequestBody DuckEntity duck) {
    return service.create(duck);
  }

  @PutMapping("/{uid}")
  public DuckEntity update(
      @PathVariable UUID uid,
      @RequestBody DuckEntity duck
  ) {
    return service.update(uid, duck);
  }

  @DeleteMapping("/{uid}")
  public void delete(@PathVariable UUID uid) {
    service.deleteByUid(uid);
  }
}
