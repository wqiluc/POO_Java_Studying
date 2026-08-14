import java.util.Scanner;

public class Main
{
    static Scanner leitor = new Scanner(System.in);

    public static String nomeusuario()
    {
        System.out.print("\n\t Digite o nome do usuário: ");
        return leitor.nextLine();
    }

    public static String senhausuario()
    {
        System.out.print("\n\t Digite a senha do usuário: ");
        return leitor.nextLine();
    }

    public static String duasetapas()
    {
        System.out.print("\n\t Digite o código de verificação em duas etapas: ");
        return leitor.nextLine();
    }

    public static void main(String[] args) throws Exception
    {
        String nome = nomeusuario();
        String senha = senhausuario();
        String codigo = duasetapas();

        System.out.println("\n\t O nome do usuário é: " + nome);
        System.out.println("\n\t A senha do usuário, nessa sessão, é: " + senha);
        System.err.println("\n\t A verificação de duas etapas do usuário deu: " + codigo);
    }
}
