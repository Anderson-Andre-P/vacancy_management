package br.com.andershow.vacancy_management.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "The filed (username) must be not allowed space character")
    private String username;

    @Email(message = "The field (email) must be contains a valid email")
    private String email;

    @Length(min = 10, max = 100, message = "The password must be contain between 10 and 100 characters")
    private String password;

    private String description;
    private String resume;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
