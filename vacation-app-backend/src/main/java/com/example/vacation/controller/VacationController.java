package com.example.vacation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vacation.model.Vacation;
import com.example.vacation.security.CurrentUser;
import com.example.vacation.security.UserPrincipal;
import com.example.vacation.service.VacationService;

@RestController
@RequestMapping("/api/vacation")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    private static final Logger logger = LoggerFactory.getLogger(VacationController.class);

    // 휴가신청내역조회
    @GetMapping("/{id}")
    public List<Vacation> selectVacation(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
    	return vacationService.selectVacation(id);
    }
    
    // 휴가신청
    @PostMapping
    public ResponseEntity<Vacation> insertVacation(@Valid @RequestBody Vacation vacation) throws Exception {
    	Vacation vc = vacationService.insertVacation(vacation);
        return new ResponseEntity<Vacation>(vc, HttpStatus.OK);
    }
    
    // 휴가취소
    @DeleteMapping
    public ResponseEntity<Integer> deleteVacation(@Valid @RequestBody Vacation vacation) throws Exception {
        int cnt = vacationService.deleteVacation(vacation);
        return new ResponseEntity<Integer>(cnt, HttpStatus.OK);
    }
}
