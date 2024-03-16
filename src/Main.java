import java.util.*;


public class Main {

    static int scelta;
    static int vite;
    static int punteggioMax;

    static List<Integer> numeroDaIndovinare;

    static Random random = new Random();

    static Scanner sc = new Scanner(System.in);

    static String sceltaGioco;

    static boolean continuazione = true;

    static List<Integer> sceltePrecedenti = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("scegli un numero compreso tra 0 e 100");
        scelta = sc.nextInt();
        sceltePrecedenti.add(scelta);
        vite = 20;
        numeroDaIndovinare = Arrays.asList(
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100),
                random.nextInt(100)
        );

        while (continuazione) {
            while (vite > 1) {
                if (numeroDaIndovinare.contains(scelta)) {
                    System.out.println("complimenti! hai indovinato il numero!");
                    if (punteggioMax < vite) {
                        punteggioMax = vite;
                    }
                    System.out.println("i numeri erano: " + numeroDaIndovinare);
                    System.out.println("il tuo punteggio massimo è: " + punteggioMax);
                    break;
                } else {
                    if (sceltePrecedenti.contains(scelta)) {
                        System.out.println("hai già inserito questi numeri: " + sceltePrecedenti);
                    }
                    vite--;
                    System.out.println("il numero è sbagliato, ti rimangono " + vite + " vite");
                    scelta = sc.nextInt();
                    sceltePrecedenti.add(scelta);


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
            numeroDaIndovinare = Arrays.asList(
                    random.nextInt(100),
                    random.nextInt(100),
                    random.nextInt(100),
                    random.nextInt(100),
                    random.nextInt(100),
                    random.nextInt(100),
                    random.nextInt(100),
                    random.nextInt(100),
                    random.nextInt(100),
                    random.nextInt(100)
            );
            System.out.println("scegli un numero compreso tra 0 e 100");
            scelta = sc.nextInt();
            sceltePrecedenti.add(scelta);
        } else if (Objects.equals(sceltaGioco, "no")) {
            System.out.println("partita terminata");
            continuazione = false;
        } else {
            System.out.println("scegli si o no");
        }
    }
}