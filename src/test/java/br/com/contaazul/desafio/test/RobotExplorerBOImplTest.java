package br.com.contaazul.desafio.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.contaazul.desafio.business.RobotExplorerBO;
import br.com.contaazul.desafio.business.impl.RobotExplorerBOImpl;

public class RobotExplorerBOImplTest {
	
	RobotExplorerBO robotExplorer = new RobotExplorerBOImpl();

    @Test
    public void navigationSucess() throws Exception {
        robotExplorer.navigation("MMMM");
        robotExplorer.navigation("MMRMMRMM");
        robotExplorer.navigation("MML");
    }

    @Test(expected = Exception.class)
    public void navigationInvalidInstructionError() throws Exception {
        robotExplorer.navigation("AA123MLR");
    }

    @Test(expected = Exception.class)
    public void navigationInvalidMoveError() throws Exception {
        robotExplorer.navigation("MMMMMMMMMMMMMMMMMMMMMMMM");
    }

    @Test
    public void isValidCommandsError() {
        assertEquals(robotExplorer.isValidCommands("MMMM"), true);
        assertEquals(robotExplorer.isValidCommands("MMRMMRMM"), true);
        assertEquals(robotExplorer.isValidCommands("MML"), true);
        assertEquals(robotExplorer.isValidCommands("AAA"), false);
        assertEquals(robotExplorer.isValidCommands("MMMMMMMMMMMMMMMMMMMMMMMM"), false);
    }
    
    @Test
    public void isRotateInstructionSucess() {
        assertEquals(robotExplorer.isRotateCommand('R'), true);
        assertEquals(robotExplorer.isRotateCommand('L'), true);
        assertEquals(robotExplorer.isRotateCommand('M'), false);
    }

    @Test
    public void isMoveInstructionSucess() {
        assertEquals(robotExplorer.isMoveCommand('M'), true);
        assertEquals(robotExplorer.isMoveCommand('L'), false);
    }


    @Test
    public void isValidMoveSucess() {
        assertEquals(robotExplorer.isValidMove(0, 0), true);
        assertEquals(robotExplorer.isValidMove(-1, -1), false);

    }

}
