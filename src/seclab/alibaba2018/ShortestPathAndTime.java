package seclab.alibaba2018;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/11
 * Time: 19:54
 * Description:
 */
public class ShortestPathAndTime {

    static int currentMin = 0;
    static int currentCost = 0;
    static final int NORTH = 0;
    static final int SOUTH = 1;
    static final int WEST = 2;
    static final int EAST = 3;

    public static void main(String[] args) {

    }

    public static int shortestTime(int x, int y, int direction, int endX, int endY, int endDirection) {
        if (x == endX && y == endY) {
            if (direction == endDirection) {
                if (currentMin > currentCost) {
                    currentMin = currentCost;
                }
            } else {
                int time = getTime(direction, endDirection);
                currentCost += time;
                if (currentMin > currentCost) {
                    currentMin = currentCost;
                }
            }
            return currentMin;
        }

        return currentMin;
    }

    public static int getTime(int fromDi, int toDi) {
        switch (fromDi) {
            case NORTH:
                if (toDi == SOUTH) return 2;
                return 1;
            case SOUTH:
                if (toDi == NORTH) return 2;
                return 1;
            case WEST:
                if (toDi == EAST) return 2;
                return 1;
            case EAST:
                if (toDi == WEST) return 2;
                return 1;
        }
        return 0;
    }
}
