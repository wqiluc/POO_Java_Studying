/*
 * Exercício 2 — Encapsulamento com getters e setters (validação)
 *
 * Uma rede social precisa cadastrar usuários com segurança.
 * Crie a classe Usuario com atributos PRIVADOS: nome, email, senha e idade.
 *
 * Regras (validadas nos setters, que devem ser usados no construtor):
 * - nome não pode ser nulo nem vazio;
 * - email precisa conter "@";
 * - senha precisa ter no mínimo 8 caracteres;
 * - idade entre 0 e 130.
 * Se o valor for inválido, imprima uma mensagem e NÃO altere o atributo.
 *
 * IMPORTANTE: NÃO crie getSenha(). Em vez disso, crie
 * boolean autenticar(String senha_digitada) que retorna se a senha confere.
 *
 * No main, crie um usuário válido e tente setar valores inválidos.
 */


public class Usuario 
{
    private String nome_usuario;
    private String email_usuario;
    private String senha_usuario;
    private int idade_usuario;

    public Usuario(String nome_usuario, String email_usuario, 
    String senha_usuario, int idade_usuario)
    {
        setNomeUsuario(nome_usuario);
        setEmailUsuario(email_usuario);
        setSenhaUsuario(senha_usuario);
        setIdadeUsuario(idade_usuario);
    }

    public String getNomeUsuario()
    {
        return nome_usuario;
    }

    public void setNomeUsuario(String nome_usuario)
    {
        if (nome_usuario == null || nome_usuario.isBlank())
        {
            System.err.println("Nome NÃO PODE SER NULO NEM VAZIO!");
            return;
        }

        this.nome_usuario = nome_usuario;
    }

    public String getEmailUsuario()
    {
        return email_usuario;
    }

    public void setEmailUsuario(String email_usuario)
    {
        if (email_usuario == null || !email_usuario.contains("@"))
        {
            System.err.println("O E-mail PRECISA TER @");
            return;
        }

        this.email_usuario = email_usuario;
    }

    public void setSenhaUsuario(String senha_usuario)
    {
        if (senha_usuario == null || senha_usuario.length() < 8)
        {
            System.err.println("A senha precisa ter, PELO MENOS, 8 caracteres");
            return;
        }

        this.senha_usuario = senha_usuario;
    }

    public int getIdadeUsuario()
    {
        return idade_usuario;
    }

    public void setIdadeUsuario(int idade_usuario)
    {
        if (idade_usuario < 0 || idade_usuario > 130)
        {
            System.err.println("A idade do usuário precisa estar entre 0 e 130");
            return;
        }

        this.idade_usuario = idade_usuario;
    }

    public boolean autenticar(String senha_digitada)
    {
        if (senha_usuario != null && senha_usuario.equals(senha_digitada))
        {
            System.out.println("Acesso Liberado ✅");
            return true;
        }
        else
        {
            System.out.println("Acesso Negado ❌");
        }
    }

    @Override
    public String toString()
    {
        return "Usuario [nome=" + nome_usuario + ", email=" + email_usuario
            + ", idade=" + idade_usuario + "]";
    }

    public static void main(String[] args) 
    {
        Usuario u = new Usuario("Lucas", "lucas@email.com", "senha1234", 20);
        System.out.println(u);

        System.out.println("\n--- Tentando valores inválidos ---");
        u.setNomeUsuario("");
        u.setEmailUsuario("lucasemail.com");
        u.setSenhaUsuario("123");
        u.setIdadeUsuario(200);
        System.out.println(u); // nada mudou

        System.out.println("\n--- Autenticação ---");
        u.autenticar("senhaErrada");
        u.autenticar("senha1234");
    }
}