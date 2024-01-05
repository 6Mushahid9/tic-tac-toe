import java.util.*; 
/**
 * tic_tac_toe by MUSHAHID
 */
public class tic_tac_toe {
    static boolean used[]=new boolean[9];
    static boolean winnerFound=false;
    static char gameBoard[][]={{' ','|',' ','|',' '},
                            {'-','+','-','+','-'},
                            {' ','|',' ','|',' '},
                            {'-','+','-','+','-'},
                            {' ','|',' ','|',' '}};
    public static void main(String[] args) {    
        createBoard();
        System.out.println("\n\nThanks for playing :)");
    }

    static void createBoard(){
        Scanner in=new Scanner(System.in);
        Random cpu= new Random();
        System.out.print("Enter your name: ");
        String name=in.next();
        display();
        for(int i=0; i<5; i++){
            if(!winnerFound){
                int pos;
                while (true) { 
                    System.out.print("\nEnter position: ");
                    pos=in.nextInt();
                    boolean found=insert(pos, 1);
                    if(!found)  continue;
                    else    break;
                }
                won();
                if(winnerFound){
                    display();
                    System.out.println(name+" won!");
                    break;
                }
                if(i==4){
                    display();
                    System.out.println("        Tie !");
                    break;
                }    
                while(true){
                    pos= cpu.nextInt(9)+1;
                    boolean found=insert(pos, 0);
                    if(!found)  continue;
                    else    break;
                }
                won();
                if(winnerFound){
                    display();
                    System.out.println("cpu won!");
                    break;
                }
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                display();
            }
        }
    }

    static boolean insert(int user,int w){
        char s='X';
        if(w==0)    s='O';
        if(!used[user-1]){
                switch (user) {
                case 1:
                    used[0]=true;
                    gameBoard[0][0]=s;
                    break;
                case 2:
                    used[1]=true;
                    gameBoard[0][2]=s;
                    break;
                case 3:
                    used[2]=true;
                    gameBoard[0][4]=s;
                    break;
                case 4:
                    used[3]=true;
                    gameBoard[2][0]=s;
                    break;
                case 5:
                    used[4]=true;
                    gameBoard[2][2]=s;
                    break;
                case 6:
                    used[5]=true;
                    gameBoard[2][4]=s;
                    break;
                case 7:
                    used[6]=true;
                    gameBoard[4][0]=s;
                    break;
                case 8:
                    used[7]=true;
                    gameBoard[4][2]=s;
                    break;
                case 9:
                    used[8]=true;
                    gameBoard[4][4]=s;
                    break;
        
                default:
                    break;
                }
            }   
            else{
                if(w==1)     System.out.println("already taken !    Please try again.");
                return false;
            }
            return true;
    }

    static void won(){
        for(int i=0; i<6; i+=2){
            String row="",col="",c1="",c2="",x="XXX",o="OOO";
            int t=0;
            for(int j=4; j>=0; j-=2){
                c2+=gameBoard[t][j];
                t+=2;
            }
            for(int j=0; j<6; j+=2){
            c1+=gameBoard[j][j];
            row+=gameBoard[i][j];
            col+=gameBoard[j][i];
            }
            if(row.equals(x) || col.equals(x) || c1.equals(x) || c2.equals(x))  winnerFound=true;
            if(row.equals(o) || col.equals(o) || c1.equals(o) || c2.equals(o))  winnerFound=true;
        }
    }
        
    static void display(){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }
}
