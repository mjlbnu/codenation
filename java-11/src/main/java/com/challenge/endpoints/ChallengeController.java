package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

  @Autowired
  private ChallengeService challengeService;

  @GetMapping
  public List<Challenge> findByAccelerationIdAndUserId(
    @RequestParam(name = "accelerationId") Optional<Long> accelerationId,
    @RequestParam(name = "userId") Optional<Long> userId) {

    return this.challengeService.findByAccelerationIdAndUserId(accelerationId.get(), userId.get());
  }

}
