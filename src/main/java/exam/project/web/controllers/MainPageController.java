package exam.project.web.controllers;

import exam.project.web.lists.MainOptionsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final MainOptionsList mainOptionsList;
    @Autowired
    public MainPageController(MainOptionsList mainOptionsList) {
        this.mainOptionsList = mainOptionsList;
    }

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("optionsList", mainOptionsList.showOptions());
        return "main";
    }
}
