package org.imta.fila1.spring.informationgare.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/departs/{gare}")
	public ModelAndView getDeparts(@PathVariable String gare) {
		return getCourse("departs", gare);
	}

	@RequestMapping("/arrivees/{gare}")
	public ModelAndView getArrivees(@PathVariable String gare) {
		return getCourse("arrivees", gare);
	}
	
	public ModelAndView getCourse(String aType, String aGare) {
		ModelAndView vView = new ModelAndView("errorView");
		if (aGare != null) {
			vView = new ModelAndView("coursesView");
			vView.addObject("courses", courseService.getDeparts(aGare));
			vView.addObject("gare", aGare);
			vView.addObject("type", aType);
		}
		return vView;
	}
		
}
