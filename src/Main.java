//Luigi G. Marchetti

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static Boolean isDirigo;
    public static void main(String[] args) {
        int[][] matriz1 = {
                {0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] matriz2 = {
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 0, 1, 0}
        };

        int[][] matriz3 = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };

        System.out.println("Matriz 1:");
        imprimir(matriz1);
        System.out.println(tipoDoGrafo(matriz1));
        System.out.println(arestasDoGrafo(matriz1));
        System.out.println(grausDoVertice(matriz1));

        System.out.println("\n\nMatriz 2:");
        imprimir(matriz2);
        System.out.println(tipoDoGrafo(matriz2));
        System.out.println(arestasDoGrafo(matriz2));
        System.out.println(grausDoVertice(matriz2));

        System.out.println("\n\nMatriz 3:");
        imprimir(matriz3);
        System.out.println(tipoDoGrafo(matriz3));
        System.out.println(arestasDoGrafo(matriz3));
        System.out.println(grausDoVertice(matriz3));
    }

    public static String tipoDoGrafo(int[][] matriz) {
        //Dirigido ou Não-Dirigido
        //Nulo
        isDirigo = false;
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

        if (isNulo) {
            return "Nulo";
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
        Boolean isRegular = true;
        int linha1;
        int linha2 = 0;
        primalLoop: for (int i = 0; i < matriz.length; i++) {
            linha1 = 0;
            for (int j = 0; j < matriz.length; j++) {
                linha1 += matriz[i][j];
            }
            if (linha1 != linha2 && i != 0){
                isRegular = false;
                break primalLoop;
            }
            linha2 = linha1;
        }

        //Grafo Completo
        Boolean isCompleto = true;
        primalLoop: for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if ((matriz[i][j] != 1 && !(i == j && matriz[i][j] == 0)) || (i == j && matriz[i][j] != 0)) {
                    isCompleto = false;
                    break primalLoop;
                }
            }
        }

        //Grafo Bipartido
        Boolean isBipartido = true;

        //Verifica se possui algum k3
        primalLoop: for (int i = 0; i < matriz.length; i++) {
            for (int j = i + 1; j < matriz.length; j++) {
                for (int k = j + 1; k < matriz.length; k++) {
                    if (matriz[i][j] == 1 && matriz[j][k] == 1 && matriz[i][k] == 1) {
                        isBipartido = false;
                        break primalLoop;
                    }
                }
            }
        }

        String ret = isDirigo ? "Dirigido": "Não-Dirigido";
        ret += " - " + simplesOuMulti + (isRegular ? " - Regular": "") + (isCompleto ? " - Completo": "") + (isBipartido ? " - Bipartido": "");
        return ret;
    }

    public static String arestasDoGrafo(int[][] matriz) {
        String ret = "";
        String conjuntoArestas = "{";
        int arestasCount = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > 0) {
                    int conjuntoAtualCount = matriz[i][j];
                    arestasCount += conjuntoAtualCount;
                    for (int count = 0; count < conjuntoAtualCount; count++) {
                        conjuntoArestas += " (" + (i+1) + ", " + (j+1) + ") ";
                    }

                }
            }
        }
        conjuntoArestas += "}";

        if (!isDirigo) {
            arestasCount /= 2;
        }
        ret = "Quantidade de Arestas: " + arestasCount ;
        ret += "\nConjunto de arestas: " + conjuntoArestas;
        return ret;
    }

    public static String grausDoVertice(int[][] matriz) {
        ArrayList listaDeGraus = new ArrayList<>();
        String ret = "";

        int grau;
        for (int i = 0; i < matriz.length; i++) {
            grau = 0;
            for (int j = 0; j < matriz.length; j++) {
                grau += matriz[i][j];
            }
            listaDeGraus.add(grau);
            ret += "Grau do vértice " + (i+1) + " = " + grau + "\n";
        }
        Collections.sort(listaDeGraus);
        ret += "Sequência de grau: " + listaDeGraus.toString();
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
