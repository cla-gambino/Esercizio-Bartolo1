import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

// todo una volta finita la partita chiedere al player se vuole continuare
// todo resettare le vite una volta che l'utente ha vinto
// todo impostare il punteggio massimo e stamparlo in console
// todo
public class Main {

    static int scelta;
    static int vite;
    static int punteggioMax;

    static int numeroDaIndovinare;

    static Random random = new Random();

    static Scanner sc = new Scanner(System.in);

    static String sceltaGioco;

    static boolean continuazione = true;


    public static void main(String[] args) {
        System.out.println("scegli un numero compreso tra 0 e 10");
        scelta = sc.nextInt();
        vite = 10;
        numeroDaIndovinare = random.nextInt(5);

        while (continuazione) {
            while (vite > 1) {
                if (scelta == numeroDaIndovinare) {
                    System.out.println("complimenti! hai indovinato il numero!");
                    if (punteggioMax < vite) {
                        punteggioMax = vite;
                    }
                    System.out.println("il tuo punteggio massimo è: " + punteggioMax);
                    break;
                } else {
                    if (scelta > numeroDaIndovinare) {
                        vite--;
                        System.out.println("il numero è scelto è troppo grande, ti rimangono " + vite + " vite");
                        scelta = sc.nextInt();
                    } else if (scelta < numeroDaIndovinare) {
                        vite--;
                        System.out.println("il mumero scelto è troppo piccolo, ti rimangono " + vite + " vite");
                        scelta = sc.nextInt();
                    }
                }
            }

            nuovaPartita();
        }
    }

    public static void nuovaPartita() {
        System.out.println("vuoi effettuare una nuova partita? si/no");
        sceltaGioco = sc.next();
        if (Objects.equals(sceltaGioco, "si")) {
            vite = 10;
            numeroDaIndovinare = random.nextInt(5);
            System.out.println("scegli un numero compreso tra 0 e 10");
            scelta = sc.nextInt();
        } else if (Objects.equals(sceltaGioco, "no")) {
            System.out.println("partita terminata");
            continuazione = false;
        } else {
            System.out.println("scegli si o no");
        }
    }
}