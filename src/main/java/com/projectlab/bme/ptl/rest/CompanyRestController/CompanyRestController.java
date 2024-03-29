package com.projectlab.bme.ptl.rest.CompanyRestController;

import com.projectlab.bme.ptl.domain.company.Company;
import com.projectlab.bme.ptl.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class CompanyRestController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public Iterable<Company> findAll(Pageable pageable) {
        return companyService.findAll(pageable);
    }

    @PostMapping("/companies")
    public Company createCompany(@Valid @RequestBody Company theCompany) {
        return companyService.saveCompany(theCompany);
    }

    @PutMapping("/companies/{companyId}")
    public Company updateCompany(@PathVariable int companyId, @Valid @RequestBody Company theCompany) {
        return companyService.updateCompany(companyId, theCompany);
    }

    @DeleteMapping("/companies/{companyId}")
    public ResponseEntity<?> deleteCompany(@PathVariable int companyId) {
        companyService.delete(companyId);
        return ResponseEntity.ok().build();
    }


}
