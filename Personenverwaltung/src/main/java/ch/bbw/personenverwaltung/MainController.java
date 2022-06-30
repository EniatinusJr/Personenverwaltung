package ch.bbw.personenverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class MainController {
    private DataRepository dataRepository;
    @Autowired

    public MainController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    @GetMapping("person")
    public String person(Model model) {
        model.addAttribute("persons", dataRepository.findAll());
        return "person";
    }

    @GetMapping("personForm/{id}")
    public String personFrom(@PathVariable Long id, Model model) {
        Person person = new Person();
        person.setBirthdate(LocalDate.now());
        person.setEmail("test@test.com");
        person.setName("lololol");
        person.setLastname("no no");

        if(id > 0){
            model.addAttribute("person", dataRepository.findById(id).get());
        } else {
            model.addAttribute("person", new Person());
        }

        return "personForm";
    }

    @GetMapping("person/delete/{id}")
    public String deletePerson(@PathVariable Long id, Model model) {
        dataRepository.deleteById(id);
        return "redirect:/person";
    }

    @PostMapping("/create/{id}")
    public String create(@PathVariable Long id, @ModelAttribute Person person){
        person.setId(id);
        System.out.println(person.getId());
        dataRepository.save(person);
        return "redirect:/person";
    }

    private void update(Long id){
    }

}
