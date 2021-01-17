package com.javabrains.project.Online.voting.system.service;

import com.javabrains.project.Online.voting.system.model.LoginDetails;
import com.javabrains.project.Online.voting.system.model.Voter;
import com.javabrains.project.Online.voting.system.repository.VoterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.Optional;

@Service
@Slf4j
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private PasswordEncoder encoder;

    public Voter registerVoter(Voter voter) {
        voter.setPassword(encoder.encode(voter.getPassword()));
        return voterRepository.save(voter);
    }


    public void loginVoter(LoginDetails loginDetails) {
        Optional<Voter> voter = voterRepository.findByEmail(loginDetails.getEmail());

        encoder.matches(loginDetails.getPassword(),voter.get().getPassword());

        if(encoder.matches(loginDetails.getPassword(),voter.get().getPassword())){
           log.info("Login successfull");
        }
    }

    public Voter getVoterDetailsBuEmail(String email){
        return voterRepository.findByEmail(email).get();
    }
}
