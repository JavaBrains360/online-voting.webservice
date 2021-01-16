package com.javabrains.project.Online.voting.system.controller;

import com.javabrains.project.Online.voting.system.model.Voter;
import com.javabrains.project.Online.voting.system.service.VoterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voter")
@Slf4j
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/register")
    public ResponseEntity<Voter> registerVoter(@RequestBody Voter voter){
        log.info("Going to register voter with details {}"+ voter);
        Voter savedVoter = voterService.registerVoter(voter);
        return new ResponseEntity<>(savedVoter, HttpStatus.CREATED);
    }
}