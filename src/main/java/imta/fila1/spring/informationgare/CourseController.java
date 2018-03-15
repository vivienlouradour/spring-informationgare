package imta.fila1.spring.informationgare;

import imta.fila1.spring.informationgare.modele.CourseService;
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
		ModelAndView vView = new ModelAndView(templates+"/arriveesView");
        vView.addObject("courses", courseService.getArrivees(gare));
        return vView;
	}
	
	@RequestMapping("/departs/{gare}")
	public ModelAndView getDeparts(String gare) {
		ModelAndView vView = new ModelAndView(templates+"/departsView");
        vView.addObject("courses", courseService.getDeparts(gare));
        return vView;
	
	}
	
}
