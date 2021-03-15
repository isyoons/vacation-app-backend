package com.example.vacation.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vacation.exception.AppException;
import com.example.vacation.model.Annual;
import com.example.vacation.model.Vacation;
import com.example.vacation.repository.AnnualRepository;
import com.example.vacation.repository.VacationRepository;

@Service
public class VacationService{
    
    @Autowired
    private VacationRepository vacationRepository;
    
    @Autowired
    private AnnualRepository annualRepository;

    private static final Logger logger = LoggerFactory.getLogger(VacationService.class);

    public List<Vacation> selectVacation(Long id) {
		return vacationRepository.findByUserAnnualId(id);
	}
    
    public Vacation insertVacation(Vacation vacation) throws Exception{
    	Optional<Annual> annual = annualRepository.findById(vacation.getUserAnnualId());
    	
    	Double totalDays = annual.get().getDays();
    	Double useDays = vacationRepository.findAllByUserAnnualId(vacation.getUserAnnualId());
    	
    	if(vacation.getUseDays() <= totalDays-useDays) {
    		return vacationRepository.save(vacation);
    	} else {
    		throw new AppException("잔여휴가일자가 부족합니다.");
    	}
    }
    
    public int deleteVacation(Vacation vacation) throws Exception{
    	Optional<Vacation> vc = vacationRepository.findById(vacation.getId());
    	
    	SimpleDateFormat format = new SimpleDateFormat ("yyyyMMdd");
    	Calendar time = Calendar.getInstance();
    	String today = format.format(time.getTime());
    	
    	int compare = today.compareTo(vc.get().getStartDt());
    	if(compare < 0) {
    		return vacationRepository.deleteAllById(vacation.getId());
    	} else {
    		throw new AppException("휴가시작일자가 지났습니다.");
    	}
    }
}
