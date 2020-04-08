package com.aoher.repository;

import com.aoher.persistence.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JPAClients extends JpaRepository<ClientEntity, Long> {
}
