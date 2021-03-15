package com.example.vacation.service;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vacation.exception.ResourceNotFoundException;
import com.example.vacation.model.Annual;
import com.example.vacation.model.User;
import com.example.vacation.model.Vacation;
import com.example.vacation.payload.UserInfo;
import com.example.vacation.repository.AnnualRepository;
import com.example.vacation.repository.UserRepository;
import com.example.vacation.repository.VacationRepository;

@Service
public class UserService{
    
	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AnnualRepository annualRepository;
    
    @Autowired
    private VacationRepository vacationRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserInfo getUserInfo(String username) {
    	User user = userRepository.findByUsername(username)
    			.orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		// 전체휴가일수 조회
		Annual annual = annualRepository.findByUserIdAndYear(user.getId(), Integer.toString(year));
		Double totalDays = annual.getDays();

		// 사용휴가일수 조회
		Double useDays = vacationRepository.findAllByUserAnnualId(annual.getId());

		UserInfo userInfo = new UserInfo(user.getId(), user.getUsername(), user.getName(), totalDays, useDays, totalDays-useDays);
		return userInfo;
	}
}


