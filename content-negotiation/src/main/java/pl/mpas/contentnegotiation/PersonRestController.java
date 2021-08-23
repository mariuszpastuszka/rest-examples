package pl.mpas.contentnegotiation;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    @GetMapping(value = "/persons", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE, MimeTypeUtils.APPLICATION_XML_VALUE })
    List<Person> getAllPersons() {
        return List.of(
                new Person(1L, "Olaf", "W.", 15),
                new Person(2L, "Irek", "K.", 45)
        );
    }
}
