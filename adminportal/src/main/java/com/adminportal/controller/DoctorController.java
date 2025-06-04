package com.adminportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminportal.domain.Doctor;
import com.adminportal.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping("/doctorList")
	public String doctorList(Model model) {
		List<Doctor> doctorList = doctorService.findAll();
		model.addAttribute("doctorList", doctorList);
		return "doctorList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addDoctor(Model model) {
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "addDoctor";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addDoctorPost(@ModelAttribute("doctor") Doctor doctor) {
		doctorService.save(doctor);
		return "redirect:/doctor/doctorList";
	}

	@RequestMapping("/doctorInfo")
	public String doctorInfo(@RequestParam("id") Long id, Model model) {
		Doctor doctor = doctorService.findOne(id);
		model.addAttribute("doctor", doctor);
		return "doctorInfo";
	}

	@RequestMapping("/updateDoctor")
	public String updateDoctor(@RequestParam("id") Long id, Model model) {
		Doctor doctor = doctorService.findOne(id);
		model.addAttribute("doctor", doctor);
		return "updateDoctor";
	}

	@RequestMapping(value = "/updateDoctor", method = RequestMethod.POST)
	public String updateDoctorPost(@ModelAttribute("doctor") Doctor doctor) {
		doctorService.save(doctor);
		return "redirect:/doctor/doctorInfo?id=" + doctor.getId();
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeDoctor(@ModelAttribute("id") String id) {
		doctorService.removeOne(Long.parseLong(id.substring(8)));
		return "redirect:/doctor/doctorList";
	}

	@RequestMapping(value = "/removeList", method = RequestMethod.POST)
	public String removeDoctorList(@ModelAttribute("doctorIdList") String doctorIdList) {
		String[] doctorIdArray = doctorIdList.split(",");
		for (String doctorId : doctorIdArray) {
			doctorService.removeOne(Long.parseLong(doctorId));
		}
		return "redirect:/doctor/doctorList";
	}
}
