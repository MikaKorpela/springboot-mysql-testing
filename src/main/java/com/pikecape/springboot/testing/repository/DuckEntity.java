package com.pikecape.springboot.testing.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "duck")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class DuckEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uid;
  private String name;
}
