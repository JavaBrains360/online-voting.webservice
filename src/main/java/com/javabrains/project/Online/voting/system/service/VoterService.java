package com.javabrains.project.Online.voting.system.service;

import com.javabrains.project.Online.voting.system.model.Voter;
import com.javabrains.project.Online.voting.system.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;


    public Voter registerVoter(Voter voter) {
        return voterRepository.save(voter);
    }


}
