package exam.project.web.lists;

public class Option {
    private String name;
    private String id;

    Option(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
