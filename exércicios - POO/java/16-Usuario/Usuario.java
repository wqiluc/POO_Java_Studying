/*
 * Exercício 2 (3ª Lista)
 * Classe Usuario implements Autenticavel: atributos login e senha
 * (privados). Implemente autenticar comparando a senha informada com a
 * senha do usuário. Use @Override obrigatoriamente.
 */

public class Usuario implements Autenticavel
{

    private String login_usuario;
    private String senha_usuario;

    public Usuario(String login_usuario, String senha_usuario)
    {
        this.login_usuario = login_usuario;
        this.senha_usuario = senha_usuario;
    }

    public String getLoginUsuario()
    {
        return login_usuario;
    }

    public void setLoginUsuario(String login_usuario)
    {
        this.login_usuario = login_usuario;
    }

    public void setSenhaUsuario(String senha_usuario)
    {
        this.senha_usuario = senha_usuario;
    }

    @Override // implementa o método da interface Autenticavel
    public boolean autenticar(String senha)
    {
        return this.senha_usuario.equals(senha);
    }

    public void validarUsuario(String senha)
    {
        if (autenticar(senha))
        {
            System.out.println("Acesso Liberado ✅");
        }
        else
        {
            System.out.println("Acesso Negado ❌");    
        }
    }

    @Override // método de sobreescrever
    public String toString()
    {
        return "Usuario [login: " + login_usuario + "]";
    }

    public static void main(String[] args) 
    {
        Usuario usuario1 = new Usuario("lucas", "1234");

        System.out.println(usuario1);

        System.out.print("Tentando com a senha \"1234\": ");
        usuario1.validarUsuario("1234");

        System.out.print("Tentando com a senha \"0000\": ");
        usuario1.validarUsuario("0000");

        usuario1.setSenhaUsuario("abcd");
        System.out.print("Após trocar a senha, tentando com \"abcd\": ");
        usuario1.validarUsuario("abcd");
    }
}