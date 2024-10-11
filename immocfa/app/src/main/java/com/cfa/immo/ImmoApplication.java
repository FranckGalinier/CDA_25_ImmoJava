package com.cfa.immo;

import com.cfa.immo.model.Bien;
import com.cfa.immo.service.AgentService;
import com.cfa.immo.service.BienService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import com.cfa.immo.model.Agent;
import java.util.List;

@Controller
@SpringBootApplication
public class ImmoApplication {

	@Autowired
	private AgentService agentService;

	@Autowired
	private BienService bienService; // Injection du BienService

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("version", "version 1 du logiciel");
		return "about";
	}

	@GetMapping("/agent/{id}")
	public String detailAgent(@PathVariable(value="id") Long id) {
		String html = "<h2>Détail Agent</h2>";
		Agent agent = agentService.getAgentById(id);

		if (agent != null) { // Vérification si l'agent existe
			html += agent.toString();
		} else {
			html += "<p>Agent non trouvé.</p>";
		}

		return html;
	}

	@GetMapping("/agent")
	public String listAgent(Model model) {
		StringBuilder html = new StringBuilder(); // Utilisation de StringBuilder pour la performance
		List<Agent> agents = agentService.findAllAgent();

		html.append("<ul>");
		for (Agent a : agents) { // Boucle for-each pour simplifier
			html.append("<li>").append(a.getFullName()).append("</li>");
		}
		html.append("</ul>");

	model.addAttribute("agents", agents);
		return "agents";
	}

	@GetMapping("/biens")
	public String listBiens() {
		StringBuilder html = new StringBuilder(); // Utilisation de StringBuilder pour la performance
		List<Bien> biens = bienService.findAllBien();

		html.append("<ul>");
		for (Bien b : biens) { // Boucle for-each pour simplifier
			html.append("<li>").append(b.toString()).append("</li>");
		}
		html.append("</ul>");

		return html.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(ImmoApplication.class, args);
	}
}
