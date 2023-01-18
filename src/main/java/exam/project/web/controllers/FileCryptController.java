package exam.project.web.controllers;

import exam.project.web.lists.CryptOptionsList;
import exam.project.web.lists.MainOptionsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crypt")
public class FileCryptController {

    private final CryptOptionsList cryptOptionsList;
    @Autowired
    public FileCryptController(CryptOptionsList cryptOptionsList) {
        this.cryptOptionsList = cryptOptionsList;
    }

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("optionsList", cryptOptionsList.showOptions());
        return "crypt";
    }
    @GetMapping("/encrypt")
    public String encrypt(Model model) {
        return "redirect:/crypt/encrypt/upload";
    }
    @GetMapping("/decrypt")
    public String decrypt(Model model) {
        return "redirect:/crypt/decrypt/upload";
    }
}
