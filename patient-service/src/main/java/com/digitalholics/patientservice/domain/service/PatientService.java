package com.digitalholics.patientservice.domain.service;

import com.digitalholics.patientservice.domain.model.entity.Patient;
import com.digitalholics.patientservice.domain.model.entity.dto.Diagnosis;
import com.digitalholics.patientservice.domain.model.entity.dto.Physiotherapist;
import com.digitalholics.patientservice.domain.model.entity.dto.Therapy;
import com.digitalholics.patientservice.domain.model.entity.dto.User;
import com.digitalholics.patientservice.resource.CreatePatientResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {

    Patient create(CreatePatientResource patient);

    ResponseEntity<?> delete(Integer patientId);

    List<Patient> getAll();

    Page<Patient> getAll(Pageable pageable);

    Patient getById(Integer patientId);

    Patient update(Integer patientId, Patient request);

    Therapy saveTherapy(Integer patientId, Therapy therapy);

    List<Diagnosis> getDiagnosisByPatientId(Integer patientId);
    Boolean getUserById(Integer userId);
//    List<Physiotherapist> getPhysiotherapists();
    Boolean isExistsUserIdToPhysiotherapist(Integer userId);

    Integer getUserId(Integer userId);

}
