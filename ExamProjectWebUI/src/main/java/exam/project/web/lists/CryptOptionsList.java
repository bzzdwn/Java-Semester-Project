package exam.project.web.lists;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CryptOptionsList extends OptionsList {
    {
        options = new ArrayList<Option>();
        options.add(new Option("Encrypt file.", "crypt/encrypt"));
        options.add(new Option("Decrypt file.", "crypt/decrypt"));
        options.add(new Option("Back.", ""));
    }

}
