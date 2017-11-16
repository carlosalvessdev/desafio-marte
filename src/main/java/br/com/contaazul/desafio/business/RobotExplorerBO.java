package br.com.contaazul.desafio.business;

import org.springframework.stereotype.Component;

import br.com.contaazul.desafio.model.RobotExplorer;
@Component
public interface RobotExplorerBO {
	
	public RobotExplorer navigation(String instructions) throws Exception;  

    public boolean isValidCommands(String instructions);

    public boolean isMoveCommand(char instruction);

    public boolean isRotateCommand(char instruction);

    public boolean isValidMove(int newXCord, int newYCord);
}
