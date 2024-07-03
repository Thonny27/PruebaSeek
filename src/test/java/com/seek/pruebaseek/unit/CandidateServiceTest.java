package com.seek.pruebaseek.unit;

import com.seek.pruebaseek.application.service.CandidateServiceImpl;
import com.seek.pruebaseek.domain.model.Candidate;
import com.seek.pruebaseek.domain.repository.CandidateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CandidateServiceTest {

    @InjectMocks
    private CandidateServiceImpl candidateService;

    @Mock
    private CandidateRepository candidateRepository;

    private Candidate candidate;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        candidate = new Candidate(1, "John", "John@gmail.com", "maculino", 3500.00);
    }

    @Test
    public void testGetAllCandidates() {
        List<Candidate> candidates = Arrays.asList(candidate);
        when(candidateRepository.findAll()).thenReturn(candidates);

        List<Candidate> result = candidateService.getAllCandidates();
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());
    }

    @Test
    public void testGetCandidateById() {
       when(candidateRepository.findById(candidate.getId())).thenReturn(Optional.of(candidate));

        Candidate result = candidateService.getCandidateById(candidate.getId());
        assertNotNull(result);
        assertEquals("John", result.getName());
    }

    @Test
    public void testGetCandidateById_NotFound() {
        when(candidateRepository.findById(0)).thenReturn(Optional.empty());

        Candidate result = candidateService.getCandidateById(0);
        assertNull(result);
    }

    @Test
    public void testCreateCandidate() {
        when(candidateRepository.save(candidate)).thenReturn(candidate);

        Candidate result = candidateService.createCandidate(candidate);
        assertNotNull(result);
        assertEquals("John", result.getName());
    }

    @Test
    public void testUpdateCandidate_NotFound() {
        Candidate updatedCandidate = new Candidate(1,"Jane", "Jane@gmail.com", "femenino", 5000.00);

        when(candidateRepository.findById(candidate.getId())).thenReturn(Optional.empty());

        Candidate result = candidateService.updateCandidate(candidate.getId(), updatedCandidate);
        assertNull(result);
    }

    @Test
    public void testDeleteCandidate() {
        when(candidateRepository.findById(candidate.getId())).thenReturn(Optional.of(candidate));
        doNothing().when(candidateRepository).deleteById(candidate.getId());

        candidateService.deleteCandidate(candidate.getId());
        verify(candidateRepository, times(1)).deleteById(candidate.getId());
    }
}