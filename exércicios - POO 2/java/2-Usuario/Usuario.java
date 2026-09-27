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
        if (nome_usuario == null || nome_usuario.trim().isEmpty())
        {
            System.out.println("Nome inválido!! O nome não pode ser nulo nem vazio.");
            return;
        }

        this.nome_usuario = nome_usuario.trim();
    }

    public String getEmailUsuario()
    {
        return email_usuario;
    }

    public void setEmailUsuario(String email_usuario)
    {
        if (email_usuario == null || !email_usuario.contains("@"))
        {
            System.out.println("Email inválido!! O email precisa conter \"@\".");
            return;
        }

        this.email_usuario = email_usuario.trim();
    }

    public void setSenhaUsuario(String senha_usuario)
    {
        if (senha_usuario == null || senha_usuario.length() < 8)
        {
            System.out.println("Senha inválida!! A senha precisa ter no mínimo 8 caracteres.");
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
            System.out.println("Idade inválida!! A idade deve estar entre 0 e 130.");
            return;
        }

        this.idade_usuario = idade_usuario;
    }

    public boolean autenticar(String senha_digitada)
    {
        return senha_usuario != null && senha_usuario.equals(senha_digitada);
    }

    @Override
    public String toString()
    {
        return "Usuario { nome: " + nome_usuario
            + " | email: " + email_usuario
            + " | idade: " + idade_usuario
            + " | senha: ******** }";
    }


    public static void main(String[] args)
    {
        Usuario u1 = new Usuario("Lucas", "lucas@email.com", "senhaForte123", 20);
        Usuario u2 = new Usuario("Maria", "maria@email.com", "maria2024!", 35);

        System.out.println(u1);
        System.out.println(u2);

        System.out.println("\n--- Testando valores inválidos no u1 ---");
        u1.setNomeUsuario("   ");
        u1.setEmailUsuario("lucasemail.com");
        u1.setSenhaUsuario("123");
        u1.setIdadeUsuario(150);
        System.out.println(u1);

        System.out.println("\n--- Testando valores inválidos no u2 ---");
        u2.setNomeUsuario(null);
        u2.setIdadeUsuario(-5);
        System.out.println(u2);

        System.out.println("\n--- Autenticação ---");
        System.out.println("u1 com senha correta: " + u1.autenticar("senhaForte123"));
        System.out.println("u1 com senha errada:  " + u1.autenticar("123"));
        System.out.println("u2 com senha correta: " + u2.autenticar("maria2024!"));
        System.out.println("u2 com senha errada:  " + u2.autenticar("maria"));
    }
}