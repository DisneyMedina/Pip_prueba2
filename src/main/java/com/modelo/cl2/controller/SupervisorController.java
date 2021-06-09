package com.modelo.cl2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.modelo.cl2.entity.Supervisor;
import com.modelo.cl2.service.SucursalService;
import com.modelo.cl2.service.SupervisorService;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {
	@Autowired
	private SucursalService sucursalService;

	@Autowired
	private SupervisorService supervisorService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("sucursales", sucursalService.listAll());
		return "supervisor";
	}

	@RequestMapping(value = "/consulta", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public List<Supervisor> consulta(@RequestParam("codSucu") int sucursal) {
		return supervisorService.listAllSupervisorxSucursal(sucursal);
	}

	@RequestMapping("/eliminar")
	public String consulta(@RequestParam("codigo") int cod, RedirectAttributes redirect) {
		try {
			supervisorService.delete(cod);
			redirect.addFlashAttribute("MENSAJE", "Supervisor eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/supervisor/";
	}

}
