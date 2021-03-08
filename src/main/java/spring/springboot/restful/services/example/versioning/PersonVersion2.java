package spring.springboot.restful.services.example.versioning;

public class PersonVersion2 {
    private Name name;

    public PersonVersion2() {
        super();
    }

    public PersonVersion2(Name name) {
        super();
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

}
