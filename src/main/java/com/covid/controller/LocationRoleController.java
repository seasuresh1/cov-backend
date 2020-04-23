package com.covid.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.covid.dto.LocationAndRoleDto;
import com.covid.service.LocationRoleService;

@Controller
@RequestMapping("/web/api")
public class LocationRoleController {

	@Autowired
	LocationRoleService locationService;

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);

	@GetMapping("/getLocationAndRole")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ModelMap getLocationAndRole(@RequestParam int userId) {
		ModelMap model = new ModelMap();
		List<LocationAndRoleDto> locRole = new ArrayList<LocationAndRoleDto>();
		try {
			locRole = locationService.getLocationAndRole(userId);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_LocationRole", ex);
			throw new RuntimeException("REC_NOT_FOUND");

		}
		model.addAttribute("locationHierarchy", locRole);
		return model;
	}
}
