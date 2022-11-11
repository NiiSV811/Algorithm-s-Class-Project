package battleship.model;
import java.util.Random;


/**
 * This class search a empty area in a BattleBoard board,
 * and change matrix board positions to assign char to boats
 *
 *@author Nicolas Sarmiento Vargas
 *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
 *@version 1.0
 */
public class BoatUtil {

    /**
     * This modify a Battle Board object to put boats in
     * board, the boats are create randomly and in a different
     * positions
     * @param board Battle Board Object
     * @param boatSize Size of the boat to create
     */
    public void BoatGenerator(BattleBoard board, int boatSize) {
        Random random = new Random();
        boolean isGenerated = false;
        int posX = 0;
        int posY = 0;
        int boatMedium = 0;
        int boatDirection = 0;
        if (boatSize == 1 || boatSize == 2) {
            boatMedium = boatSize;
        } else {
            boatMedium = (boatSize - 1) / 2;
        }
        while (!isGenerated) {
            posX = random.nextInt(board.getColumns() - (2 * boatMedium)) + boatMedium;
            posY = random.nextInt(board.getRows() - (2 * boatMedium)) + boatMedium;
            isGenerated = searchArea(board, posX, posY, boatMedium);
        }

        boatDirection = random.nextInt(4);

        if (boatSize == 1) {
            board.setPos(posY, posX, '■');
        } else if (boatSize == 2) {
            int[] leftOrRigth = new int[]{-1,1};
            int randomChoice = random.nextInt(2);
            board.setPos(posY, posX, '■');
            switch (boatDirection) {
                case 0: //Horizontal
                    board.setPos(posY,(posX+leftOrRigth[randomChoice]),'■');
                    break;
                case 1://Vertical
                    board.setPos((posY+leftOrRigth[randomChoice]),(posX),'■');
                    break;
                case 2: // Diagonal \
                    board.setPos((posY+leftOrRigth[randomChoice]),(posX+leftOrRigth[randomChoice]),'■');
                    break;
                case 3: // Diagonal /
                    board.setPos((posY+leftOrRigth[randomChoice]),(posX-leftOrRigth[randomChoice]),'■');
                    break;
            }
        } else {
            switch (boatDirection) {
                case 0: //Horizontal
                    for (int x = posX - boatMedium; x <= posX + boatMedium; x++) {
                        board.setPos(posY, x, '■');
                    }
                    break;
                case 1://Vertical
                    for (int y = posY - boatMedium; y <= posY + boatMedium; y++) {
                        board.setPos(y, posX, '■');
                    }
                    break;
                case 2: // Diagonal \
                    for (int increase = -boatMedium; increase <= boatMedium; increase++) {
                        board.setPos((posY + increase), (posX + increase), '■');
                    }
                    break;
                case 3: // Diagonal /
                    for (int increase = -boatMedium; increase <= boatMedium; increase++) {
                        board.setPos((posY - increase), (posX + increase), '■');
                    }
                    break;
            }
        }
    }

    /**
     * This function only uses for BoatGenerator,
     * its purpose is to verify if the random coordinates
     * are in a empty area.
     *
     *@author Nicolas Sarmiento Vargas
     *  Git Hub: <a href="https://github.com/NiiSV811">...</a>
     * @param board Battle Board Object
     * @param posY row position
     * @param posX column position
     * @param boatMedium the middle of the boat Size.
     * @return if the random coordinates are in a empty area
     */


    private boolean searchArea(BattleBoard board, int posX, int posY, int boatMedium){
        for(int y = posY-boatMedium ; y <= posY+boatMedium ; y++){
            for (int x = posX-boatMedium ; x <= posX+boatMedium ; x++){
                if(board.getPos(y,x) == '■' ){
                    return false;
                }
            }
        }
        return true;
    }

}
