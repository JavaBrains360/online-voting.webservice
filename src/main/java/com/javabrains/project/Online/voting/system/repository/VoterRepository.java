package com.javabrains.project.Online.voting.system.repository;

import com.javabrains.project.Online.voting.system.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Integer> {
    Optional<Voter> findByEmailAndPassword(String email,String password);
    Optional<Voter> findByEmail(String email);
}
