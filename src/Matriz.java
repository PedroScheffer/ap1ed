public class Matriz {
    private int[][] matriz;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new int[linhas][colunas];
    }

    public void preencherMatriz(int[][] valores) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = valores[i][j];
            }
        }
    }

    public void inserirElemento(int linha, int coluna, int valor) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = valor;
        }
    }

    public void removerElemento(int linha, int coluna) {
        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
            matriz[linha][coluna] = 0; // ou outro valor padrão
        }
    }

    public void exibirMatriz() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void bubbleSortLinha(int linha) {
        for (int i = 0; i < colunas - 1; i++) {
            for (int j = 0; j < colunas - i - 1; j++) {
                if (matriz[linha][j] > matriz[linha][j + 1]) {
                    int temp = matriz[linha][j];
                    matriz[linha][j] = matriz[linha][j + 1];
                    matriz[linha][j + 1] = temp;
                }
            }
        }
    }

    public void bubbleSortColuna(int coluna) {
        for (int i = 0; i < linhas - 1; i++) {
            for (int j = 0; j < linhas - i - 1; j++) {
                if (matriz[j][coluna] > matriz[j + 1][coluna]) {
                    int temp = matriz[j][coluna];
                    matriz[j][coluna] = matriz[j + 1][coluna];
                    matriz[j + 1][coluna] = temp;
                }
            }
        }
    }

    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public void ordenarLinha(int linha) {
        bubbleSortLinha(linha);
    }

    public void ordenarColuna(int coluna) {
        bubbleSortColuna(coluna);
    }

    public void ordenarTodasLinhas() {
        for (int i = 0; i < linhas; i++) {
            bubbleSortLinha(i);
        }
    }

    public void ordenarTodasColunas() {
        for (int i = 0; i < colunas; i++) {
            bubbleSortColuna(i);
        }
    }

    public void ordenarMatrizCompleta() {
        int[] array = new int[linhas * colunas];
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                array[index++] = matriz[i][j];
            }
        }
        mergeSort(array, 0, array.length - 1);
        index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = array[index++];
            }
        }
    }
}