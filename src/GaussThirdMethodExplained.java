
public class GaussThirdMethodExplained {

    private static void printMatrix(double[][] M) {
        for (double[] row : M) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.printf("%10.4f ", row[j]);
                if (j == M[0].length - 2) System.out.print("| ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void pause() {
        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public static double[] solve(double[][] A, double[] b) {
        int n = A.length;
        double[][] M = new double[n][n + 1];

        // Sudarome išplėstinę matricą [A|b]
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, M[i], 0, n);
            M[i][n] = b[i];
        }

        System.out.println("=== Pradinė matrica [A|b] ===");
        printMatrix(M);
        pause();

        // Tiesioginė eiga
        for (int k = 0; k < n - 1; k++) {
            System.out.println("==== ŽINGSNIS " + (k + 1) + " ====");
            pause();

            // 1. Normalizavimas
            for (int i = k; i < n; i++) {
                double max = 0;
                for (int j = k; j < n; j++)
                    max = Math.max(max, Math.abs(M[i][j]));
                if (max != 0) {
                    System.out.printf("Eilutė %d dalijama iš max |a| = %.4f%n", i + 1, max);
                    for (int j = k; j <= n; j++)
                        M[i][j] /= max;
                } else {
                    System.out.printf("Eilutė %d praleidžiama (visi koeficientai = 0)%n", i + 1);
                }
            }

            System.out.println("\nPo normalizavimo:");
            printMatrix(M);
            pause();

            // 2. Eilutės pasirinkimas su mažiausia modulių suma
            int minRow = k;
            double minSum = Double.MAX_VALUE;
            for (int i = k; i < n; i++) {
                double sum = 0;
                for (int j = k; j < n; j++) sum += Math.abs(M[i][j]);
                if (sum < minSum) {
                    minSum = sum;
                    minRow = i;
                }
            }

            if (minRow != k) {
                System.out.printf("Mažiausią Σ|a| = %.4f turi eilutė %d → sukeičiam su eilute %d%n",
                        minSum, minRow + 1, k + 1);
                System.out.println("Priežastis: keičiamos eilutės, kai norima sumažinti apvalinimo paklaidas.");
                System.out.println("Pasirenkama eilutė, kurioje bendra koeficientų suma mažiausia (stabilesnė eilutė).");
                double[] temp = M[k];
                M[k] = M[minRow];
                M[minRow] = temp;
            } else {
                System.out.println("Eilutės nekeistos – dabartinė eilutė jau turi mažiausią Σ|a|.");
            }

            System.out.println("\nPo eilučių parinkimo:");
            printMatrix(M);
            pause();

            // 3. Pagrindinio elemento parinkimas
            int pivotCol = k;
            double maxVal = Math.abs(M[k][k]);
            for (int j = k + 1; j < n; j++) {
                if (Math.abs(M[k][j]) > maxVal) {
                    maxVal = Math.abs(M[k][j]);
                    pivotCol = j;
                }
            }

            if (pivotCol != k) {
                System.out.printf("Pagrindinis elementas |a|=%.4f rastas stulpelyje %d → sukeičiam su stulpeliu %d%n",
                        maxVal, pivotCol + 1, k + 1);
                System.out.println("Priežastis: keičiami stulpeliai, kai didžiausias moduliu koeficientas yra ne pagrindinėje įstrižainėje.");
                System.out.println("Tai daroma, kad gautume didesnį pagrindinį elementą ir išvengtume dalybos iš mažo skaičiaus (stabilumo didinimas).");

                for (int i = 0; i < n; i++) {
                    double tmp = M[i][k];
                    M[i][k] = M[i][pivotCol];
                    M[i][pivotCol] = tmp;
                }
            } else {
                System.out.println("Stulpeliai nekeisti – pagrindinis elementas jau didžiausias moduliu.");
            }

            System.out.println("\nPo pagrindinio elemento pasirinkimo:");
            printMatrix(M);
            pause();

            // 4. Nuliai žemiau pagrindinio elemento
            for (int i = k + 1; i < n; i++) {
                double factor = M[i][k] / M[k][k];
                System.out.printf("Eilutė %d = Eilutė %d - (%.4f)*Eilutė %d%n", i + 1, i + 1, factor, k + 1);
                for (int j = k; j <= n; j++)
                    M[i][j] -= factor * M[k][j];
            }

            System.out.println("\nPo nulinių elementų formavimo:");
            printMatrix(M);
            pause();
        }

        // Atbulinė eiga
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = M[i][n];
            for (int j = i + 1; j < n; j++)
                sum -= M[i][j] * x[j];
            x[i] = sum / M[i][i];
        }

        System.out.println("==== Galutinė trikampė matrica ====");
        printMatrix(M);
        pause();

        System.out.println("==== Sprendinys ====");
        for (int i = 0; i < n; i++)
            System.out.printf("x%d = %.6f%n", i + 1, x[i]);

        return x;
    }

    public static void main(String[] args) {
        double[][] A = {
                {10, 1, -3, -5},
                {-1, 6, 2, 2},
                {-5, -1, 8, -1},
                {-1, -2, 2, 6}
        };
        double[] b = {25, 6, -33, -26};

        solve(A, b);
    }
}
