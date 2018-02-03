package br.com.alura.listavip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadoService;

@Controller // anotacoes do spring mvc
public class ConvidadoController {
	
	
	@Autowired
	private ConvidadoService service;

	// anotacoes do spring mvc
    @RequestMapping("/")
    public String index(){
    	// retorna a pagina index.html, Thymeleaf (engine de templates encontra a pagina por causa da convencao (paginas ficam na pasta templates))
        return "index";
    }

    @RequestMapping("listaconvidados")
    public String listaconvidados(Model model) {
    	Iterable<Convidado> convidados = service.findAll();
    	model.addAttribute("convidados", convidados);
    	obterConvidadoPor("Lucas");
    	return "listaconvidados";
    }
    
    @RequestMapping(value="salvar", method=RequestMethod.POST)
    public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("telefone") String telefone
    		, Model model) {
    	
    	service.save(new Convidado(nome, email, telefone));
    	
    	//new EmailService().enviarEmail(nome, email);
    	
    	Iterable<Convidado> convidados = service.findAll();
    	model.addAttribute("convidados", convidados);
    	
    	return "listaconvidados";
    }
    
    public void obterConvidadoPor(String nome){

        List<Convidado> lista = service.findByNome(nome);
        System.out.println("pesquisando por nome, size: " + lista.size());
    }
}