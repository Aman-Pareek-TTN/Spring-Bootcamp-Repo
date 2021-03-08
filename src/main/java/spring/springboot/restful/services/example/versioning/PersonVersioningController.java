package spring.springboot.restful.services.example.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    // Uri Versioning
    @GetMapping("v1/person")
    public PersonVersion1 personV1() {
        return new PersonVersion1("Bob Charlie");
    }

    // Uri Versioning
    @GetMapping("v2/person")
    public PersonVersion2 personV2() {
        return new PersonVersion2(new Name("Shyam", "Lal"));
    }

    //Request Parameter Versioning
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonVersion1 paramV1() {
        return new PersonVersion1("Shyam Lal");
    }

    //Request Parameter Versioning
    @GetMapping(value = "/person/param", params = "version=2")
    public PersonVersion2 paramV2() {
        return new PersonVersion2(new Name("Shyam", "Lal"));
    }

    //Header Versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonVersion1 headerV1() {
        return new PersonVersion1("Shyam Lal");
    }

    //Header Versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonVersion2 headerV2() {
        return new PersonVersion2(new Name("Shyam", "Lal"));
    }

    //MIME/Media Type Versioning
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonVersion1 producesV1() {
        return new PersonVersion1("Shyam Lal");
    }

    //MIME/Media Type Versioning
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonVersion2 producesV2() {
        return new PersonVersion2(new Name("Shyam", "Lal"));
    }

}