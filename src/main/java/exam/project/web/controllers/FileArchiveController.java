package exam.project.web.controllers;

import exam.project.web.lists.ArchiveArchiveOptionsList;
import exam.project.web.lists.ArchiveOptionsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/archive")
public class FileArchiveController {

    private final ArchiveOptionsList archiveOptionsList;
    private final ArchiveArchiveOptionsList archiveArchiveOptionsList;
    @Autowired
    public FileArchiveController(ArchiveOptionsList archiveOptionsList, ArchiveArchiveOptionsList archiveArchiveOptionsList) {
        this.archiveOptionsList = archiveOptionsList;
        this.archiveArchiveOptionsList = archiveArchiveOptionsList;
    }

    @GetMapping()
    public String show(Model model) {
        model.addAttribute("optionsList", archiveOptionsList.showOptions());
        return "archive";
    }

    @GetMapping("/archive")
    public String archive(Model model) {
        model.addAttribute("optionsList", archiveArchiveOptionsList.showOptions());
        return "archive-archive";
    }

    @GetMapping("/unarchive")
    public String unarchive(Model model) {
        //model.addAttribute("optionsList", archiveOptionsList.showOptions());
        return "redirect:/archive/unarchive/upload";
    }
    @GetMapping("/archive/zip")
    public String zip(Model model) {
        return "redirect:/archive/archive/zip/upload";
    }
    @GetMapping("/archive/rar")
    public String rar(Model model) {
        return "redirect:/archive/archive/rar/upload";
    }
    @GetMapping("/archive/jar")
    public String jar(Model model) {
        return "redirect:/archive/archive/jar/upload";
    }
}
