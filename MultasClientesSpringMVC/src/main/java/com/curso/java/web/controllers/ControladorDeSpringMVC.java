package com.curso.java.web.controllers;

//import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.java.oo.ejercicio01oo.model.Alumno;
import com.curso.java.oo.ejercicio01oo.model.Aula;
import com.curso.java.oo.ejercicio01oo.model.PuestoDeTrabajo;

import ejercicio03Negocio.GestionDeAulas;

@Controller
@Scope("request")
public class ControladorDeSpringMVC {

	@Autowired
	private Aula aula1;
	@Autowired
	private Aula aula2;
	@Autowired
	private GestionDeAulas gestionAulas;

	@RequestMapping("verFormularioSpringMVC")
	public ModelAndView verFormulario() {
		// Llamo al negocio y en el model and view le pongo los datos.
		return new ModelAndView("formularioSpringMVC");
	}

	@RequestMapping("listaAlumnos")
	public ModelAndView listaAlumnos(@RequestParam("nombre") String nombre, HttpServletRequest request) {

		PuestoDeTrabajo puesto1 = new PuestoDeTrabajo();
		puesto1.setOrdenador(true);
		PuestoDeTrabajo puesto2 = new PuestoDeTrabajo();
		puesto2.setOrdenador(true);
		PuestoDeTrabajo puesto3 = new PuestoDeTrabajo();
		puesto3.setOrdenador(true);
		PuestoDeTrabajo puesto4 = new PuestoDeTrabajo();
		puesto4.setOrdenador(true);
		PuestoDeTrabajo puesto5 = new PuestoDeTrabajo();
		puesto4.setOrdenador(true);

		aula1.setNombre("kepler");
		aula1.getPuestosDeAlumnos().add(puesto1);
		aula1.getPuestosDeAlumnos().add(puesto2);
		aula1.getPuestosDeAlumnos().add(puesto3);
		aula1.getPuestosDeAlumnos().add(puesto4);
		gestionAulas.registrarAula(aula1);

		aula2.setNombre("Galileo");
		aula2.getPuestosDeAlumnos().add(puesto1);
		aula2.getPuestosDeAlumnos().add(puesto2);
		aula2.getPuestosDeAlumnos().add(puesto3);
		aula2.getPuestosDeAlumnos().add(puesto4);
		aula2.getPuestosDeAlumnos().add(puesto5);
		gestionAulas.registrarAula(aula2);

		System.out.println("-- Lista de Aulas --");
		List<Aula> aula = gestionAulas.getAula();
		for (Aula siguienteAula : aula) {
			System.out.println(siguienteAula);
		}

		System.out.println();
		gestionAulas.eliminarAula("kepler");
		System.out.println("Aula Eliminada ");

		System.out.println();
		System.out.println("-- Lista de Aulas --");
		List<Aula> aulaList = gestionAulas.getAula();
		for (Aula siguienteAula : aulaList) {
			System.out.println(siguienteAula);
		}

		Alumno alumno1 = new Alumno();
		alumno1.setNombre("Junior");
		Alumno alumno2 = new Alumno();
		alumno2.setNombre("Manuel");
		Alumno alumno3 = new Alumno();
		alumno3.setNombre("Jose");
		Alumno alumno4 = new Alumno();
		alumno4.setNombre("Pepe");
		Alumno alumno5 = new Alumno();
		alumno5.setNombre("Maria");

		gestionAulas.asignarAlumnoAlAula(alumno1, aula2);
		gestionAulas.asignarAlumnoAlAula(alumno2, aula2);
		gestionAulas.asignarAlumnoAlAula(alumno3, aula2);
		gestionAulas.asignarAlumnoAlAula(alumno4, aula2);
		gestionAulas.asignarAlumnoAlAula(alumno5, aula2);

		System.out.println();
		System.out.println("-- Lista de Alumnos en sala Galileo --");
		List<Alumno> alumnos = (List<Alumno>) gestionAulas.listaDeAlumnoPorAula(nombre);
//		request.setAttribute("listaDeAlumnos", alumnos);
		ModelAndView modelAndView = new ModelAndView("listaAlumnos");
		if (alumnos.size() > 0) {
			int i = 0;
			for (Alumno siguienteAlumno : alumnos) {
				System.out.println(siguienteAlumno);
				i++;
				modelAndView.addObject("alumno" + i, siguienteAlumno.getNombre());

			}
		} else {
			modelAndView.addObject("mensaje", "No hay alumnos o Aula no existe");
		}
		modelAndView.addObject("aula", aula2.getNombre());
		return modelAndView;

	}

}
