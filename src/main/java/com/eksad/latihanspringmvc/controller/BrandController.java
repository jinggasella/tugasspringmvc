package com.eksad.latihanspringmvc.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.latihanspringmvc.model.Brand;
import com.eksad.latihanspringmvc.repository.BrandRepositoryDAO;



@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	BrandRepositoryDAO brandRepositoryDAO;

//Menampilkan Tabel Brand
	@RequestMapping("")
	public String index(Model model) {
		
		List<Brand> listBrand = brandRepositoryDAO.findAll();
		
		model.addAttribute("listbrand", listBrand);
		
		return "listbrand";
	}
	
//Menambahkan Isi Table Brand
	@RequestMapping("/add")
	public String addBrand(Model model) {
		Brand brand = new Brand();
		
		model.addAttribute("brand", brand);
		
		return "addbrand";
	}
	
//Menyimpan Tabel brand	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Brand brand) {
		brandRepositoryDAO.save(brand);
		
		return "redirect:/brand";
	}

//Memeperbaharui Table Brand
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBrand(@PathVariable Long id, Model model) {
		Brand brand = brandRepositoryDAO.findOne(id);
		model.addAttribute("brand", brand);
		
		return "addbrand";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteBrand(@PathVariable("id") long id) {
		Brand brand = brandRepositoryDAO.getOne(id);
		if (brand==null) {
			throw new EntityNotFoundException("entity.department.NotFound");
		}
		brandRepositoryDAO.delete(brand);
		return "redirect:/brand/";
	}
}
