package med.voll.api.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MdedicoController {
    @PostMapping
    public void cadastrar(@RequestBody String JSON) {
        System.out.println(JSON);
    }
}
