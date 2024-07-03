package com.seek.pruebaseek.application;

import com.seek.pruebaseek.domain.model.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> getAllCandidates();

    Candidate getCandidateById(Integer id);

    Candidate createCandidate(Candidate candidate);

    Candidate updateCandidate(Integer id, Candidate candidate);

    void deleteCandidate(Integer id);
}
