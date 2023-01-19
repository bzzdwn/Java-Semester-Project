package exam.project.web.lists;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MainOptionsList extends OptionsList {

    {
        options = new ArrayList<Option>();
        options.add(new Option("Read arithmetic expression from file.", "read"));
        options.add(new Option("Archive/Unarchive file.", "archive"));
        options.add(new Option("Encrypt/Decrypt file.", "crypt"));
    }


}
