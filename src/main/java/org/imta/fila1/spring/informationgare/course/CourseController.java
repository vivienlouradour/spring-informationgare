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

	@RequestMapping("/{type}/{gare}")
	public ModelAndView getCourse(@PathVariable String type, @PathVariable String gare) {
		
		ModelAndView vView = new ModelAndView("errorView");

		boolean vIsDepart = type.contains("dep");
		boolean vIsArrivee = type.contains("arr");
		
		if ( vIsArrivee || vIsArrivee && gare != null) {
		
			vView = new ModelAndView("coursesView");
			vView.addObject("courses", courseService.getDeparts(gare));
			vView.addObject("gare", gare);
			
			String vType = vIsDepart ? "departs" : "arrivees";
			
			vView.addObject("type", vType);
		
		}else {
		
			vView.addObject("error", "Requête invalide !");
			
		}
		
		return vView;
        
	}
		
}
