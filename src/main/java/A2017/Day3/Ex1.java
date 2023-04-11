package A2017.Day3;

public class Ex1 {
    public static void main(String[] args) {
        int input = 347991;
        int longueur = 1;
        int result;
        //calcul de la taille du carre
        while(Math.pow(longueur,2) <= input ){
            longueur+=2;
        }
        System.out.println("Taille carré : " + longueur);

        int nbMax = (int)Math.pow(longueur,2) ;
        System.out.println("Nombre nbMax : " + nbMax);

        int nombreMaxCote = 0;
        int milieuCote = 0;

        //Voir qu'elle côté il est (AB-BC-CD-DA)
        //DA = nbMAX ---- CD = nbmax-longueur ---- BC = nbmax-2longueur ---- AB = nbmax-3longueur
        for (int i = 0; i < 4; i++) {
            if (nbMax -i * (longueur-1) < input) {
                break;
            }
            nombreMaxCote = nbMax -i * (longueur-1);
            milieuCote = nombreMaxCote - longueur / 2;
        }
        System.out.println("Nombre max du cote : " + nombreMaxCote);
        System.out.println("Nombre milieu du cote : " + milieuCote);

        result = longueur / 2 + Math.abs(milieuCote - input);

        System.out.println("Nombre pas : " + result);

    }
}
