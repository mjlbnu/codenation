package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CompanyService companyService;

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    Optional<Company> company = this.companyService.findById(id);
    return company.isPresent() ? ResponseEntity.ok(company) : ResponseEntity.notFound().build();
  }

  @GetMapping
  public List<Company> findByAccelerationIdOrUserId(
    @RequestParam(name = "accelerationId") Optional <Long> accelerationId,
    @RequestParam(name = "userId") Optional <Long> userId) {

    return accelerationId.isPresent()
      ? this.companyService.findByAccelerationId(accelerationId.get())
      : this.companyService.findByUserId(userId.get());
  }

}
