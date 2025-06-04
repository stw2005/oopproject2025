package com.adminportal.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminportal.domain.Disease;
import com.adminportal.domain.AssignedDoctors;
import com.adminportal.domain.Doctor;
import com.adminportal.domain.Patient;
import com.adminportal.service.DiseaseService;
import com.adminportal.service.AssignedDoctorsService;
import com.adminportal.service.DoctorService;
import com.adminportal.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AssignedDoctorsService assignedDoctorService;
	
	@Autowired
	private DiseaseService diseaseService;
	
	@Autowired
	private DoctorService doctorService;
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPatient(Model model) {
		
		Patient patient = new Patient();
		List<Disease> diseaseTypeList = diseaseService.findAll();
		List<Doctor> doctorNameList = doctorService.findAll();
		patient.setDiseaseTypeList(diseaseTypeList);
		patient.setDoctorNameList(doctorNameList);
		model.addAttribute("patient", patient);
		
		return "addPatient";
	}//end add-GET 
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPatientPost(@ModelAttribute("patient") Patient patient, HttpServletRequest request) {
		
		
		AssignedDoctors doctor= new AssignedDoctors();
		
		
		doctor.setDoctorName(patient.getDoctorName());
		
		patient.setDoctor(doctor);
		
		doctor.setPatient(patient);
		
		patientService.save(patient);
		
		return "redirect:/";
		
	}//end add-POST

	
	
	@RequestMapping("/patientInfo")
	public String patientInfo(@RequestParam("id") Long id, Model model) {
		
		Patient patient = patientService.findOne(id);
		model.addAttribute("patient", patient);
		
		return "patientInfo";
	}//end patientInfo.
	
	
	@RequestMapping("/updatePatient")
	public String updatePatient(@RequestParam("id") Long id, Model model) {
		
		Patient patient = patientService.findOne(id);
		
		List<Disease> diseaseTypeList = diseaseService.findAll();
		List<Doctor> doctorNameList = doctorService.findAll();
		patient.setDiseaseTypeList(diseaseTypeList);
		patient.setDoctorNameList(doctorNameList);
		
		model.addAttribute("patient", patient);
		
		return "updatePatient";
		
	}//end updatePatient - GET.
	
	
	
	@RequestMapping(value="/updatePatient", method=RequestMethod.POST)
	public String updatePatientPost(@ModelAttribute("patient") Patient patient, HttpServletRequest request) {
	
		AssignedDoctors doctor=new AssignedDoctors();
		
		doctor.setDoctorName(patient.getDoctorName());
		doctor.setPatient(patient);
		doctor.setId(patient.getId());		assignedDoctorService.save(doctor);	
		patientService.save(patient);
		
		return "redirect:/";
		
	}//end updatePatient - POST.
	
	@RequestMapping("/patientList")
	public String patientList(Model model) {
		
		List<Patient> patientList = patientService.findAll();

		for (Patient patient : patientList) {

			patient.setDoctorName(assignedDoctorService.findOne(patient.getId()).getDoctorName());

		}

		model.addAttribute("patientList", patientList);
		
		return "patientList";

	}//end patientList.
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("id") String id, Model model) {
		
		patientService.removeOne(Long.parseLong(id.substring(8)));
		List<Patient> patientList = patientService.findAll();
		model.addAttribute("patientList", patientList);
		
		return "redirect:/patient/patientList";
		
	}//end remove.
	
	

}
