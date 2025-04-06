public class Main {
    public static void main(String[] args) {
        Matriz matriz = new Matriz(4, 4);
        int[][] valores = {
                {5, 26, 35, 64},
                {12, 24, 27, 29},
                {48, 86, 87, 91},
                {1, 32, 43, 55}
        };
        matriz.preencherMatriz(valores);
        matriz.exibirMatriz();
        System.out.println("Ordenando todas as linhas:");
        matriz.ordenarTodasLinhas();
        matriz.exibirMatriz();
        System.out.println("Ordenando todas as colunas:");
        matriz.ordenarTodasColunas();
        matriz.exibirMatriz();
        System.out.println("Ordenando matriz completa:");
        matriz.ordenarMatrizCompleta();
        matriz.exibirMatriz();
    }
}