package ch.bbw.personenverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private DataRepository dataRepository;
    @Autowired

    public MainController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    @GetMapping("person")
    public String homepage(Model model) {
        model.addAttribute("persons", dataRepository.findAll());
        return "index";
    }
}
