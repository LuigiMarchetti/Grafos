//Luigi G. Marchetti

public class Main {
    public static void main(String[] args) {
        int[][] matriz1 = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        int[][] matriz2 = {
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 0, 1, 0}
        };

        int[][] matriz3 = {
                {0, 1, 0},
                {1, 0, 1},
                {1, 1, 0}
        };

        System.out.println("Matriz 1:");
        imprimir(matriz1);
        System.out.println(tipoDoGrafo(matriz1));

        System.out.println("\nMatriz 2:");
        imprimir(matriz2);
        System.out.println(tipoDoGrafo(matriz2));

        System.out.println("\nMatriz 3:");
        imprimir(matriz3);
        System.out.println(tipoDoGrafo(matriz3));


    }

    public static String tipoDoGrafo(int[][] matriz) {
        //Dirigido ou Não-Dirigido
        //Nulo
        Boolean isDirigo = false;
        Boolean isNulo = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    isDirigo = true;
                }

                if (matriz[i][j] != 0) {
                    isNulo = false;
                }
            }
        }

        //Simples ou Multigrafo
        String simplesOuMulti = "Simples";
            primalLoop: for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    if (matriz[i][j] > 1) {
                        simplesOuMulti = "Multigrafo";
                        break primalLoop;
                    }
                    if (i == j && matriz[i][j] != 0) {
                        simplesOuMulti = "Multigrafo";
                        break primalLoop;
                    }
                    if (isDirigo && matriz[i][j] > 0 && matriz[j][i] > 0) {
                        simplesOuMulti = "Multigrafo";
                        break primalLoop;
                    }
                }
            }


        //Grafo Regular
        String regular = "Regular";
        int linha1;
        int linha2 = 0;
        primalLoop: for (int i = 0; i < matriz.length; i++) {
            linha1 = 0;
            for (int j = 0; j < matriz.length; j++) {
                linha1 += matriz[i][j];
            }
            if (linha1 != linha2 && i != 0){
                regular = "Não Regular";
                break primalLoop;
            }
            linha2 = linha1;
        }

        //Grafo Completo
        String completo = "Completo";
        primalLoop: for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != 1 && !(i == j && matriz[i][j] == 0)) {
                    completo = "Não Completo";
                }
            }
        }




        String ret = dirigidoOuNao + " - " + simplesOuMulti + " - " + regular + " - " + completo;
        return ret;
    }

    public static void imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
