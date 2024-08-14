import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Random numAleatorio = new Random();

        for(int i = 0; i < 100;i++){
            arvore.inserir(numAleatorio.nextInt(101));
        }

        System.out.println("arvore original em ordem");
        arvore.EmOrdem();
        arvore.balancearDsw();

        System.out.println("arvore balanceada em ordem");
        arvore.EmOrdem();

        for(int i = 0; i < 20; i++) {
            arvore.inserir(numAleatorio.nextInt(101));
        }

        System.out.println("adição de 20 números em ordem");
        arvore.EmOrdem();

        arvore.balancearDsw();

        System.out.println("arvore balanceada com os novos números");
        arvore.EmOrdem();
    }
}