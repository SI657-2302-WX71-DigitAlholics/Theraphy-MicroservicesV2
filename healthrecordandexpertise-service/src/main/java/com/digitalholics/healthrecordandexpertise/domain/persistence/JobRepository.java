package com.digitalholics.healthrecordandexpertise.domain.persistence;

import com.digitalholics.healthrecordandexpertise.domain.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    Optional<Job> findById(Integer jobId);
}
