package com.example.transientbehaviour;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DummyEntityRepository extends JpaRepository<DummyEntity, Long> {

}
