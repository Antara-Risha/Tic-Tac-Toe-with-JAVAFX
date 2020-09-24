
package sample;


import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;


public class Controller {

    public Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button button[] = new Button[10];
    winCheck checkWin = new winCheck();
    public Line horizontal_1,horizontal_2,horizontal_3,vertical_1,vertical_2,vertical_3,diagonal_1,diagonal_2;

    public void initialize() {
        button[1] = button1;
        button[2] = button2;
        button[3] = button3;
        button[4] = button4;
        button[5] = button5;
        button[6] = button6;
        button[7] = button7;
        button[8] = button8;
        button[9] = button9;
    }
    Line winLine[] = new Line[9];

    int count = 0;
    int[] input ={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    String playerSign=null;
    String aiSign=null;
    String moverSign=null;
    boolean highcontrast =false;
    boolean forest =false;
    boolean classic=false;



    public void mouseclick(MouseEvent mouseEvent) {
        System.out.println("Button is clicked");

    }

    public void onpress1() {

        commonClick(1,count);
        button1.setDisable(true);


    }

    public void onpress2() {
        commonClick(2,count);
        button2.setDisable(true);


    }

    public void onpress3() {

        commonClick(3,count);
        button3.setDisable(true);


    }

    public void onpress4() {

        commonClick(4,count);
        button4.setDisable(true);


    }

    public void onpress5() {

        commonClick(5,count);
        button5.setDisable(true);

    }

    public void onpress6() {

        commonClick(6,count);
        button6.setDisable(true);

    }

    public void onpress7() {

        commonClick(7,count);
        button7.setDisable(true);

    }


    public void onpress8() {


        commonClick(8,count);
        button8.setDisable(true);

    }

    public void onpress9() {

        commonClick(9,count);
        button9.setDisable(true);

    }
    public void commonClick(int boxNumber,int countNumber) {
        String moverSign;
        if (countNumber % 2 == 0) {
            moverSign = playerSign;
            input[boxNumber] = 1;
            setBoxTheme(button[boxNumber], moverSign);
            gameEndCheck();


        }
        else if(countNumber%2==1){
            moverSign=aiSign;
            input[boxNumber]=0;
            setBoxTheme(button[boxNumber],moverSign);
            gameEndCheck();

        }
        count++;
        Random_AI();
    }

    public void Random_AI()
    {
        while (count<9 && count%2==1)
        {
            int r=(int) ((Math.random()*9)+1);
            if (input[r]==-1)
            {
                if (r==1){
                    onpress1();
                    break;
                }
                if(r==2){
                    onpress2();
                    break;
                }
                if(r==3){
                    onpress3();
                    break;
                }
                if(r==4){
                    onpress4();

                    break;
                }
                if(r==5){
                    onpress5();
                    break;
                }
                if(r==6){
                    onpress6();
                    break;
                }
                if(r==7){
                    onpress7();
                    break;
                }
                if(r==8){
                    onpress8();
                    break;
                }
                if(r==9){
                    onpress9();

                    break;
                }

            }
        }

    }
    public void gameEndCheck() {

        boolean gameEnd = checkWin.winCheck(input);
        if(gameEnd)
        {
            for(int i=1;i<10;i++)
            {
                button[i].setDisable(true);
            }
        }
        winlineCheckRow();
        winlineCheckColumn();
        winlinCheckDiagonal();


    }


    public void startNewGame()
    {     count =0;
        for (int i =1; i<10; i++)
        {   input[i]=-1;
            button[i].setText("");
            button[i].setDisable(false);
            if (highcontrast)
            button[i].setStyle("-fx-background-color: lightgray");
        }


    }

    public void classic_pressed() {
          classic=true;
         highcontrast=false;
         forest =false;

        playerSign = "X";
        aiSign = "O";
        for (int i = 1; i < 10; i++) {
            button[i].setStyle("-fx-background-color: white");
            changeTheme(button[i],input,playerSign,aiSign);
            button[i].setOpacity(1);

        }


    }

    public void forest_pressed() {
        forest = true;
        highcontrast=false;
        classic =false;
        playerSign = "\uD83C\uDF3A";
        aiSign = "\uD83C\uDF4E";


        for(int i=1;i<10;i++){
            button[i].setStyle("-fx-background-color: lightgreen");
            changeTheme(button[i],input,playerSign,aiSign);
            button[i].setOpacity(1);

        }
    }

    public void highContrast_pressed() {
        highcontrast =true;
        forest = false;
        classic =false;
        playerSign = "-fx-background-color: black";
        aiSign = "-fx-background-color: white";
        for(int i=1;i<10;i++) {

            changeTheme(button[i], input, playerSign, aiSign);
            button[i].setStyle("-fx-background-color: lightgray");
            button[i].setOpacity(1);
        }

    }
    public void changeTheme(Button btn, int[] input, String playerSign, String aiSign)
    {
        if(highcontrast){
            for (int i =1;i<10;i++)
            {
                button[i].setText("");
            }
        }


        for(int i=1;i<10;i++)
        {
            if(input[i]==1)
            {
                if(highcontrast)
                    button[i].setStyle(playerSign);
                else
                    button[i].setText(playerSign);
            }
            else if(input[i]==0)
            {
                if(highcontrast)
                    button[i].setStyle(aiSign);
                else
                    button[i].setText(aiSign);
            }

        }
    }
    public void setBoxTheme(Button button,String moverSign)
    {    if(highcontrast)
        button.setStyle(moverSign);
    else
        button.setText(moverSign);
    }


    public void Random_AL_pressed()
    {
        startNewGame();
        horizontal_1.setVisible(false);
        horizontal_2.setVisible(false);
        horizontal_3.setVisible(false);
        vertical_1.setVisible(false);
        vertical_2.setVisible(false);
        vertical_3.setVisible(false);
        diagonal_1.setVisible(false);
        diagonal_2.setVisible(false);

    }

    public  void winlineCheckRow()
    {
        for(int i=1;i<8;i=i+3)
        {
            if(input[i]==input[i+1] && input[i+1]==input[i+2] && input[i]!=-1)
            {
                //winner found then line check
                if(i==1)
                    horizontal_2.setVisible(true);

                else if(i==4)
                    horizontal_1.setVisible(true);

                else if(i==7)
                    horizontal_3.setVisible(true);

            }

        }

    }
    public  void winlineCheckColumn()
    {
        for(int i=1;i<4;i++)
        {
            if(input[i]==input[i+3] && input[i+3]==input[i+6] && input[i]!=-1)
            {
                if(i==1)
                    vertical_1.setVisible(true);
                else if(i==2)
                    vertical_2.setVisible(true);
                else if(i ==3)
                    vertical_3.setVisible(true);

            }

        }
    }
     public void winlinCheckDiagonal()
    {
        if(input[1]==input[5] && input[5]==input[9] && input[1]!=-1)
        {
            diagonal_1.setVisible(true);

        }

        if(input[3]==input[5] && input[5]==input[7] && input[3]!=-1)
        {
            diagonal_2.setVisible(true);

        }
    }

    }

