package exam.project.web.lists;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArchiveArchiveOptionsList extends OptionsList {
    {
        options = new ArrayList<Option>();
        options.add(new Option("ZIP.", "archive/archive/zip"));
        options.add(new Option("RAR.", "archive/archive/rar"));
        options.add(new Option("JAR.", "archive/archive/jar"));
        options.add(new Option("Back.", ""));
    }

}
