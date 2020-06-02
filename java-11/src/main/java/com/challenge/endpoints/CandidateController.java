package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  private CandidateService candidateService;

  @Autowired
  private CandidateMapper candidateMapper;

  @GetMapping("/{userId}/{accelerationId}/{companyId}")
  public ResponseEntity<CandidateDTO> findById(
    @PathVariable Long userId,
    @PathVariable Long accelerationId,
    @PathVariable Long companyId) {

    Optional<Candidate> candidate = this.candidateService.findById(userId, companyId, accelerationId);
    return ResponseEntity.ok(candidateMapper.map(candidate.get()));
  }

  @GetMapping
  public ResponseEntity<List<CandidateDTO>> findByCompanyIdOrByAccelerationId(
    @RequestParam(name = "companyId", required = false) Optional<Long> companyId,
    @RequestParam(name = "accelerationId", required = false) Optional<Long> accelerationId) {

    return companyId.isPresent()
      ? ResponseEntity.ok(this.candidateMapper.map(this.candidateService.findByCompanyId(companyId.get())))
      : ResponseEntity.ok(this.candidateMapper.map(this.candidateService.findByAccelerationId(accelerationId.get())));
  }

}
