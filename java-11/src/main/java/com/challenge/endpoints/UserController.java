package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public User findById(@PathVariable("id") Long id) {
    return this.userService.findById(id).get();
  }

  @GetMapping
  public ResponseEntity<List<User>> findByAccelerationNameOrCompanyId(
    @RequestParam(name = "accelerationName", required = false) Optional<String> accelerationName,
    @RequestParam(name = "companyId", required = false) Optional<Long> companyId) {

    return accelerationName.isPresent()
      ? ResponseEntity.ok(this.userService.findByAccelerationName(accelerationName.get()))
      : ResponseEntity.ok(this.userService.findByCompanyId(companyId.get()));
  }

}
