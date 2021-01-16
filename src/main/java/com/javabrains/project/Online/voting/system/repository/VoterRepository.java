package com.javabrains.project.Online.voting.system.repository;

import com.javabrains.project.Online.voting.system.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Integer> {


}
