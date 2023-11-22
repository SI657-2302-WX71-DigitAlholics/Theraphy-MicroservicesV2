package com.digitalholics.physiotherapistservice.api.rest;

import com.digitalholics.physiotherapistservice.domain.service.PhysiotherapistService;
import com.digitalholics.physiotherapistservice.mapping.PhysiotherapistMapper;
import com.digitalholics.physiotherapistservice.resources.CreatePhysiotherapistResource;
import com.digitalholics.physiotherapistservice.resources.PhysiotherapistResource;
import com.digitalholics.physiotherapistservice.resources.UpdatePhysiotherapistResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/physiotherapists", produces = "application/json")
@Tag(name = "Physiotherapists", description = "Create, read, update and delete physiotherapists")
public class PhysiotherapistController {
    private final PhysiotherapistService physiotherapistService;

    private final PhysiotherapistMapper mapper;

    public PhysiotherapistController(PhysiotherapistService physiotherapistService, PhysiotherapistMapper mapper) {
        this.physiotherapistService = physiotherapistService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<PhysiotherapistResource> getAllPhysiotherapist(Pageable pageable) {
        return mapper.modelListPage(physiotherapistService.getAll(), pageable);
    }

    @PostMapping("registration-physiotherapist")
    public ResponseEntity<PhysiotherapistResource> createPhysiotherapist(@RequestBody CreatePhysiotherapistResource resource) {
        return new ResponseEntity<>(mapper.toResource(physiotherapistService.create(resource)), HttpStatus.CREATED);
    }

    @GetMapping("{physiotherapistId}")
    //@PreAuthorize("hasAuthority('patient:read')")
    public PhysiotherapistResource getPhysiotherapistById(@PathVariable Integer physiotherapistId) {
        return mapper.toResource(physiotherapistService.getById(physiotherapistId));
    }

    @PatchMapping("patch/{physiotherapistId}")
    public ResponseEntity<PhysiotherapistResource> patchPhysiotherapist(
            @PathVariable Integer physiotherapistId,
            @RequestBody UpdatePhysiotherapistResource request) {

        return new  ResponseEntity<>(mapper.toResource(physiotherapistService.update(physiotherapistId,request)), HttpStatus.OK);
    }

    @DeleteMapping("{physiotherapistId}")
    public ResponseEntity<?> deletePhysiotherapist(@PathVariable Integer physiotherapistId) {
        return physiotherapistService.delete(physiotherapistId);
    }
    @GetMapping("userId/{userId}")
    //@PreAuthorize("hasAuthority('patient:read')")
    public Integer getPhysiotherapistByUserId(@PathVariable Integer userId) {
        return physiotherapistService.getUserId(userId);
    }


    //se puede crear desde el mismo servicio de therapy xD eso creo
//    @PostMapping("/saveTherapy/{physiotherapistId}/{patientId}")
//    public ResponseEntity<Therapy> saveTherapy(@PathVariable("physiotherapistId") Integer physiotherapistId, @PathVariable("patientId") Integer patientId, @RequestBody Therapy therapy){
//        if(physiotherapistService.getById(physiotherapistId) == null){
//            return ResponseEntity.notFound().build();
//        }
//        if(physiotherapistService.getPatientById(patientId)==null){
//            return ResponseEntity.notFound().build();
//        }
//        Therapy newTherapy = physiotherapistService.saveTherapyToPatientAndPhysiotherapist(physiotherapistId, patientId,therapy);
//        return ResponseEntity.ok(therapy);
//    }

    //se unio con :
//query did not return a unique result: 2
//    @GetMapping("/getTherapy/{physiotherapistId}")
//    public ResponseEntity<Therapy> getTherapyByPhysiotherapistId(@PathVariable("physiotherapistId") Integer physiotherapistId){
//        Therapy therapy = physiotherapistService.getTherapyByPhysiotherapistId(physiotherapistId);
//        return ResponseEntity.ok(therapy);
//    }


}
