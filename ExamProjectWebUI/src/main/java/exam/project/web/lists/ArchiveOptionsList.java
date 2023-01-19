package exam.project.web.lists;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArchiveOptionsList extends OptionsList {
    {
        options = new ArrayList<Option>();
        options.add(new Option("Archive file.", "archive/archive"));
        options.add(new Option("Unarchive file.", "archive/unarchive"));
        options.add(new Option("Back.", ""));
    }

}
