package sample;

public class winCheck {



        public boolean winCheck(int[] input) {
            boolean winnerFound = false;
            for (int i = 1; i < 8; i = i + 3) {
                if (input[i] == input[i + 1] && input[i + 1] == input[i + 2] && input[i] != -1) {
                    winnerFound = true;
                    System.out.println(winnerFound);

                    return winnerFound;


                }

            }


            for (int i = 1; i < 4; i++) {
                if (input[i] == input[i + 3] && input[i + 3] == input[i + 6] && input[i] != -1) {
                    winnerFound = true;
                    System.out.println(winnerFound);

                    return winnerFound;
                }

            }


            if (input[1] == input[5] && input[5] == input[9] && input[1] != -1) {
                winnerFound = true;
                System.out.println(winnerFound);

                return winnerFound;


            }
            return winnerFound;
        }
    }


