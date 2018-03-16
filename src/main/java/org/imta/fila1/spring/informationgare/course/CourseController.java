package org.imta.fila1.spring.informationgare.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CourseController {

	private static String templates = "src/main/ressources/";

	@Autowired
	private CourseService courseService;

	@RequestMapping("/arrivees/{gare}")
	public ModelAndView getArrivees(@PathVariable String gare) {
		ModelAndView vView = new ModelAndView("arriveesView");
        vView.addObject("courses", courseService.getArrivees(gare));
        return vView;
	}
	
	@RequestMapping("/departs/{gare}")
	public ModelAndView getDeparts(String gare) {
		ModelAndView vView = new ModelAndView("departsView");
        vView.addObject("courses", courseService.getDeparts(gare));
        return vView;

	}

	@RequestMapping("/salut")
	public String getSalut() {
		return "salut cedric";

	}
	
}
