package A2017.Day3;

public class Ex2 {
    public static void main(String[] args) {
        int input = 347991;
        int longueur = 0;
        int longueurprec = 1;
        int result;
        //Met input en taille pour être sur
        int[][] tableauCarre = new int[input][input];
        //Initialise la 1ere valeur
        tableauCarre[0][0] = 1;

        //Parcour chaque carre
        for (int i = 1; i < input; i+=2) {
            longueur = (int) Math.pow(i,2);

            //Le carre actuel
            for (int j = 0; j < longueur; j++) {
                if (j==0) {
                    //dernier element liste avant
                    tableauCarre[i][j] = tableauCarre[i-1][longueurprec*4-5];
                } else {
                    tableauCarre[i][j] = tableauCarre[i][j - 1];
                }
            }
            longueurprec = longueur;
        }


    }
}
