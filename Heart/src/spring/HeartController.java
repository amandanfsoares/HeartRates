package spring;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeartController {
	@RequestMapping("/heart")
	public String get() {
		return "formulario";
	}

	@RequestMapping("/cadastrarpaciente")
	public String adiciona(HeartRates heart) throws SQLException {
		HeartDao dao = new HeartDao();
		dao.Adiciona(heart);
		return "redirect:listapacientes";
	}

	@RequestMapping("/listapacientes")
	public String lista(Model model) {
		HeartDao dao = new HeartDao();
		model.addAttribute("heart", dao.getList());
		return "lista";
	}

	@RequestMapping("/removepaciente")
	public String remover(HeartRates heart) throws SQLException {
		HeartDao dao = new HeartDao();
		dao.Remover(heart);
		return "redirect:listapacientes";
	}
	  @RequestMapping("/updatepaciente")
      public String update (int id, Model model) {
          HeartDao dao = new HeartDao();
          model.addAttribute("heart", dao.buscaPorId(id));
          return "mostra";
      }
	  @RequestMapping("/alterarpaciente")
      public String atualiza(HeartRates heart) {
		  HeartDao dao = new HeartDao();
          dao.altera(heart);
          return "redirect:listapacientes";
      }
	 
}
