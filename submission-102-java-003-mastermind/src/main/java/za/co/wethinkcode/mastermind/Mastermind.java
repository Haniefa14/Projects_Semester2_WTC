package za.co.wethinkcode.mastermind;

public class Mastermind {
    private final String code;
    private final Player player;

    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }
    public Mastermind(){ this(new CodeGenerator(), new Player()); }

    public void runGame(){
        String codeString = code;
        int i = 12;
        while (i != 0){
            if (i < 12) {
                System.out.printf("Turns left: %s%n", i);
            }
            String userInput = player.getGuess();

            if (userInput.equals("exit")){
                System.exit(0);
            }
            int NumOfPlace = 0;
            int NumNotinPlace = 0;

            //Checks and compares generated code to User Input
            for (int iter = 0; iter < 4; iter++) {
                boolean right = false;
                if (userInput.charAt(iter) == codeString.charAt(iter)) {
                    NumOfPlace = NumOfPlace + 1;
                    right = true;
                }
                if (!right && userInput.contains(((Character) codeString.charAt(iter)).toString())) {
                    NumNotinPlace = NumNotinPlace + 1;
                }

            }

            //Checks digits in correct and incorrect places
            System.out.printf("Number of correct digits in correct place: %d", NumOfPlace);
            System.out.println();
            System.out.printf("Number of correct digits not in correct place: %d", NumNotinPlace);
            System.out.println();


            //Exit or Quit game

            if (userInput.equals(codeString)){
                System.out.println("Congratulations! You are a codebreaker!");
                //System.exit(0);
                break;
            }

            i--;
        }


        if (i == 0) {
            System.out.println("No more turns left.");

        }
        System.out.printf("The code was: %s%n", codeString);
    }
    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}