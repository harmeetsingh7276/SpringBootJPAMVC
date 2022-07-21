package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;

	@RequestMapping("home")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int id) {
		ModelAndView mv=new ModelAndView("showAlien.jsp");
		Alien al=repo.findById(id).orElse(new Alien());
		mv.addObject("alien",al);
		return mv;
	}
	
	@GetMapping(path="/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	public Optional<Alien> getAlienAPI(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	@PostMapping("/alien")
	public Alien postAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@RequestMapping("/deleteAlien")
	public ModelAndView deleteAlien(@RequestParam("aid") int id) {
		ModelAndView mv=new ModelAndView("showAlien.jsp");
		repo.deleteById(id);
		return mv;
	}
	
	@RequestMapping("/updateAlien")
	public ModelAndView updateAlien(Alien alien) {
		ModelAndView mv=new ModelAndView("showAlien.jsp");
		Alien al=repo.findById(alien.getAid()).orElse(new Alien());
		al=alien;
		repo.save(al);
		return mv;
	}
}
