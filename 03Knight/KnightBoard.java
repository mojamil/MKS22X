import java.util.*;
public class KnightBoard{
    private static int[][] board;
    public KnightBoard(int startingRows,int startingCols){
	board=new int[startingRows][startingCols];
    }

    public String toString(){
      String Board="";
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
          if(board[i][j]<10){
            Board+=" "+board[i][j]+" ";
          }
          else{
            Board+=board[i][j]+" ";
          }
        }
        Board+="\n";
      }
      return Board;
    
    }
    private static int[][] possibleMoves(int r, int c){
	int[][] sols=new int[8][2];
	int x=r;
	int y=c;
	int count=0;
	int incR=2;
	int incC=1;
	for(int i=0;i<8;i++){
	    if(i==1||i==5){
		incC=0-incC;
	    }
	    if(i==2||i==6){
		incR=0-incR;
	    }
	    if(i==3||i==7){
		incC=0-incC;
	    }
	    if(i==4){
		incC=2;
		incR=1;
	    }
      if(r+incR<board.length&&c+incC<board[0].length&&c+incC>=0&&r+incR>=0&&board[r+incR][c+incC]==0){
        sols[count][0]=r+incR;
        sols[count][1]=c+incC;
      }
	    count+=1;
  }
	return sols;
    }
    public boolean solve(){      
      return solver(0,0,1);
    }
    public int countSolutions(){
	return 0;
    }
    private boolean solver(int r ,int c, int level){
  if(level==board.length*board[0].length){
    board[r][c]=level;
	    return true;
	}
  for(int i=0;i<possibleMoves(r,c).length;i++){
    if(possibleMoves(r,c)[i][0]!=0||possibleMoves(r,c)[i][1]!=0){
      board[r][c]=level;
      if(solver(possibleMoves(r,c)[i][0],possibleMoves(r,c)[i][1],level+1)){
        return true;
      }
      else{
        board[r][c]=0;
      }
    }
  }
	return false;
    }
    public static void main(String[] args){
      KnightBoard k= new KnightBoard(7,6);
	System.out.println(k);
	System.out.println(Arrays.deepToString(k.possibleMoves(0,0)));
	System.out.println(k.solve());
	System.out.println(k);
    }
}
