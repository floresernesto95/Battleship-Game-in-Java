package ar.edu.utn.frc.tup.lciii;

/**
 * Hello, BATALLA NAVAL
 *
 */
public class App 
{

    private static BattleShipMatch battleShipMatch = new BattleShipMatch();

    /**
     * This is the main program
     *
     * IMPORTANTE: Este metodo no necesita ser modificado
     */
    public static void main( String[] args ) {
        System.out.println("Hello, BATALLA NAVAL.");
        battleShipMatch.welcomeMessage();
        Player player = battleShipMatch.createNewPlayer();
        Player appPlayer = battleShipMatch.createAppPlayer();
        Boolean playAgain = true;
        // Bucle principal
        do {
            BattleShipGame battleShipGame = new BattleShipGame(player, appPlayer);
            battleShipGame.getPlayerFleetPositions();
            battleShipGame.generateAppFleetPositions();
            Boolean keepPlaying;
            System.out.println("Estamos listos para la batalla!!!");
            // Bucle del juego
            do {
                battleShipGame.getPlayerShot();
                battleShipGame.generateAppShot();
                battleShipGame.drawPlayerBoards();
                battleShipGame.printGameStatus();
                keepPlaying = battleShipMatch.continuePlaying();
            } while (!battleShipGame.isFinish(keepPlaying) && keepPlaying);
            battleShipGame.calculateScores();
            battleShipGame.goodbyeMessage();
            playAgain = battleShipMatch.wantPlayAgain();
        } while (playAgain);
    }
}
