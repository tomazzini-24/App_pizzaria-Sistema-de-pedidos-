package br.com.segundotrab.apppizza;

public class Pizza {


   public int id;
    public String nome;
    public String endereco;
    public String sabor;
    private int telefone;

    public Pizza() {

    }

    public Pizza(String nome, String endereco, int telefone, String sabor) {
        this.nome = nome;
        this.endereco = endereco;
        this.setTelefone( telefone );
        this.sabor = sabor;

    }

    public Pizza(int id, String nome, int telefone, String endereco, String sabor) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.setTelefone( telefone );
        this.sabor = sabor;

    }

     public int getTelefone(){

        return telefone;
    }

     public void setTelefone(int telefone){
        this.telefone = telefone;
    }
 @Override
    public String toString() {
        return id + " - " + nome + " | " + sabor + " - " + endereco + " - " + telefone ;
    }
}
