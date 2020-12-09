import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.Scanner;

public class pr5951 {
    private static Logger logger;
    public static void main(String[] args) {
        try(FileInputStream configFile = new FileInputStream("C:\\logger.config")){
            LogManager.getLogManager().readConfiguration(configFile);
            logger = Logger.getLogger(pr5951.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
        Scanner read = new Scanner(System.in);
        int M7 = 0;
        int M3 = 0;
        int M21 = 0;
        int MAX = 0;
        int RES = 0;

        System.out.println("Введите N: ");
        int N = read.nextInt();
        logger.log(Level.INFO, "Присвоение N");

        for (int i = 0; i < N; i++) {

            System.out.println("Введите DAT: ");
            int DAT = read.nextInt();
            logger.log(Level.INFO, "Присвоение DAT");

            if (DAT % 7 == 0 & DAT % 3 > 0 & DAT > M7) {
                M7 = DAT;
            }
            if (DAT % 3 == 0 & DAT > M3) {
                M3 = DAT;
            }
            if (DAT % 21 == 0 & DAT > M21) {
                if (M21 > MAX) {
                    MAX = M21;
                    M21 = DAT;
                } else if (DAT > MAX) {
                    MAX = DAT;
                }
            }
            System.out.println("Введите R: ");
            int R = read.nextInt();
            logger.log(Level.INFO, "Присвоение R");
            if (M7 * M3 < M21 * MAX) {
                RES = M21 * MAX;
            } else {
                RES = M3 * M7;
            }
            logger.log(Level.INFO, "Вычисление контрольного значения");
            System.out.println("Вычисленное контрольное значение: " + RES);
            if (R == RES) {
                System.out.println("Контроль пройден");
            } else {
                System.out.println("Контроль не пройден");
            }

        }
    }
}

