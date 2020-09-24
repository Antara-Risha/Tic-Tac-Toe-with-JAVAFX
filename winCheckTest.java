package sample;

import static org.junit.jupiter.api.Assertions.*;

class winCheckTest {

    @org.junit.jupiter.api.Test
    void winCheck() {
        winCheck check = new winCheck();
        int[] row_1_Ai = {0,   0,0,0,1,-1,1,0,-1,-1};
        int[] row_3_Player = {0,  1,0,1,1,-1,1,1,1,1};
        int[] col_1_Ai = {0,  0,0,1, 0,-1,1, 0,-1,-1};
        int[] col_3_Player = {0,  1,0,1, 0,-1,1, 1,0,1};



        Boolean win_1_Ai = check.winCheck(row_1_Ai);
        Boolean win_3_Player = check.winCheck(row_3_Player);
        Boolean win_4_Ai = check.winCheck(col_1_Ai);
        Boolean win_6_Player = check.winCheck(col_3_Player);


        assertEquals(true,win_1_Ai);

    }
}