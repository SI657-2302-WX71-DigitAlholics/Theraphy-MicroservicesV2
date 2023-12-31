package com.digitalholics.therapyservice.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TheraphyResource {
    private Integer id;
    private String theraphyName;
    private String startAt;
    private String finishAt;
    private Integer patientId;
    private Integer physiotherapistId;
//    private PatientResource patient;
//    private PhysiotherapistResource physiotherapist;
}
