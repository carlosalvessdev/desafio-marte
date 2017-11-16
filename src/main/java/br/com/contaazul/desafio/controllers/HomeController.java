package br.com.contaazul.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contaazul.desafio.business.RobotExplorerBO;
import br.com.contaazul.desafio.model.RobotExplorer;


@RestController
public class HomeController
{
	
   @GetMapping("/")
   public String index()
   {
      return "home/index";
   }
   
   @Autowired
   RobotExplorerBO robotExplorer;
   
   @RequestMapping("/mars/{direction}")
	public RobotExplorer navigation(@PathVariable String direction) throws Exception {

       RobotExplorer robotOuput = robotExplorer.navigation(direction);
       return robotOuput;
	}
}
