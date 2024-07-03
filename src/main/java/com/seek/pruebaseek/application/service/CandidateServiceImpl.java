package com.seek.pruebaseek.application.service;

import com.seek.pruebaseek.application.CandidateService;
import com.seek.pruebaseek.domain.model.Candidate;
import com.seek.pruebaseek.domain.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate getCandidateById(Integer id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Integer id, Candidate candidate) {
        if (candidateRepository.existsById(id)) {
            candidate.setId(id);
            return candidateRepository.save(candidate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCandidate(Integer id) {
        candidateRepository.deleteById(id);
    }
}
