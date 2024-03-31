package br.com.andershow.vacancy_management.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andershow.vacancy_management.exceptions.UserFoundException;
import br.com.andershow.vacancy_management.modules.candidate.CandidateEntity;
import br.com.andershow.vacancy_management.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidate")
public class CandidatesController {
    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public @Valid CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}
