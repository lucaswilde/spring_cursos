package br.com.alura.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Controller // anotacoes do spring mvc
public class ConvidadoController {
	
	@Autowired
	private ConvidadoRepository repository;

	// anotacoes do spring mvc
    @RequestMapping("/")
    public String index(){
    	// retorna a pagina index.html, Thymeleaf (engine de templates encontra a pagina por causa da convencao (paginas ficam na pasta templates))
        return "index";
    }

    @RequestMapping("listaconvidados")
    public String listaconvidados(Model model) {
    	Iterable<Convidado> convidados = repository.findAll();
    	model.addAttribute("convidados", convidados);
    	
    	return "listaconvidados";
    }
}