package Realtest1_2023;

public class SangJunctionMap {
    public int[][] map;

    public SangJunctionMap(int[][] map){
        this.map = map;
    }

    public boolean hasOneWayStreet(){
        for (int i = 0; i < map.length;i++){
            for (int j = i; j < map.length; j++){
                if (map[i][j] != map[j][i]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasDeadEnd(){
        for (int i = 0; i < map.length;i++){
            boolean deadEnd = true;
            for (int j = 0; j < map.length; j++){
                deadEnd = (map[i][j] == 0) ? deadEnd && true : false;
            }
            if (deadEnd){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SangJunctionMap map = new SangJunctionMap(new int[][] {{0,1,1,0},{0,0,0,1},{0,1,0,0},{0,0,1,0}});
        System.out.println(map.hasOneWayStreet());
        System.out.println(map.hasDeadEnd());
    }
}
