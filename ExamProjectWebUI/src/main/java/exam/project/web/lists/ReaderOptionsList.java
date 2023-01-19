package exam.project.web.lists;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ReaderOptionsList extends OptionsList{
    {
        options = new ArrayList<Option>();
        options.add(new Option("TXT file.", "read/txt"));
        options.add(new Option("JSON file.", "read/json"));
        options.add(new Option("XML file.", "read/xml"));
        options.add(new Option("Back.", ""));
    }
}
