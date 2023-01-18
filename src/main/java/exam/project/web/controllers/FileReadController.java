package exam.project.web.controllers;

import exam.project.web.lists.ReaderOptionsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/read")
public class FileReadController {

    private final ReaderOptionsList readerOptionsList;
    @Autowired
    public FileReadController(ReaderOptionsList readerOptionsList) {
        this.readerOptionsList = readerOptionsList;
    }

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("optionsList", readerOptionsList.showOptions());
        return "read";
    }
    @GetMapping("/txt")
    public String txt(Model model) {
        return "redirect:/read/txt/upload";
    }
    @GetMapping("/json")
    public String json(Model model) {
        return "redirect:/read/json/upload";
    }
    @GetMapping("/xml")
    public String xml(Model model) {
        return "redirect:/read/xml/upload";
    }
}