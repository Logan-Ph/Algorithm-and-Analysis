package Realtest1_2023;

public class SangDiamondBox {
    public String configuration;

    public SangDiamondBox(String configuration){
        this.configuration = configuration;
    }
        
    public boolean isValid(){
        int j = -1;

        for (int i = 0; i < configuration.length(); i++){
            char c = configuration.charAt(i);
            if ( c == '['){
                j++;
            }else if (c == ']'){
                if (j >=0 ){
                    j--;
                }else{
                    return false;
                }

                if (i != configuration.length()-1 && j==-1){
                    return false;
                }
            }
        }
        return (j == -1)? true : false;
    }

    public int deepestLevel(){
        int maxLevel = 0;
        int currentLevel = 0;
        for (int i = 0; i < configuration.length(); i++){
            char c = configuration.charAt(i);
            if (c == '[') currentLevel++;
            else if (c == ']') currentLevel--;

            maxLevel = Math.max(currentLevel, maxLevel);
        }

        return maxLevel;
    }

    public int maxDiamond(){
        int maxDiamondNum = 0;
        char[] stackConfig = new char[configuration.length()];
        int j = -1; // index of the stackConfig
        for (int i = 0; i < configuration.length(); i++){
            char c = configuration.charAt(i);
            if ( c == '[' || c == '*'){
                stackConfig[++j] = c;
            }else{
                int currentDiamond = 0;
                while (stackConfig[j] != '[') {
                    currentDiamond++;
                    j--;
                }
                j--;
                maxDiamondNum = Math.max(maxDiamondNum, currentDiamond);
            }
        }
        return maxDiamondNum;
    }



    public static void main(String[] args) {
        SangDiamondBox box1 = new SangDiamondBox("[*]"); // valid
        SangDiamondBox box2 = new SangDiamondBox("[[*]]"); // valid
        SangDiamondBox box3 = new SangDiamondBox("[**[**]*]"); // valid
        SangDiamondBox box4 = new SangDiamondBox("[[[*]**]*]"); // valid
        SangDiamondBox box5 = new SangDiamondBox("[]*"); // invalid
        SangDiamondBox box6 = new SangDiamondBox("[[*]"); // invalid
        SangDiamondBox box7 = new SangDiamondBox("[**][*]"); // invalid
        System.out.println(box1.isValid());
        System.out.println(box2.isValid());
        System.out.println(box3.isValid());
        System.out.println(box4.isValid());
        System.out.println(box5.isValid());
        System.out.println(box6.isValid());
        System.out.println(box7.isValid());

        if (box1.isValid()){
            System.out.println("box1: ");
            System.out.println("The deepset level is "+ box1.deepestLevel());
            System.out.println("The maximum number of diamond is " + box1.maxDiamond());
        }

        if (box2.isValid()){
            System.out.println("box2: ");
            System.out.println("The deepset level is "+ box2.deepestLevel());
            System.out.println("The maximum number of diamond is " + box2.maxDiamond());
        }

        if (box3.isValid()){
            System.out.println("box3: ");
            System.out.println("The deepset level is "+ box3.deepestLevel());
            System.out.println("The maximum number of diamond is " + box3.maxDiamond());
        }

        if (box4.isValid()){
            System.out.println("box4: ");
            System.out.println("The deepset level is "+ box4.deepestLevel());
            System.out.println("The maximum number of diamond is " + box4.maxDiamond());
        }

        if (box5.isValid()){
            System.out.println("box5: ");
            System.out.println("The deepset level is "+ box5.deepestLevel());
            System.out.println("The maximum number of diamond is " + box5.maxDiamond());
        }

        if (box6.isValid()){
            System.out.println("box6: ");
            System.out.println("The deepset level is "+ box6.deepestLevel());
            System.out.println("The maximum number of diamond is " + box6.maxDiamond());
        }

        if (box7.isValid()){
            System.out.println("box7: ");
            System.out.println("The deepset level is "+ box7.deepestLevel());
            System.out.println("The maximum number of diamond is " + box7.maxDiamond());
        }
    }
}
