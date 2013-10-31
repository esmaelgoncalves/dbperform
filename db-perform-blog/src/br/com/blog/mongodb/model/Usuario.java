package br.com.blog.mongodb.model;

import javax.xml.bind.annotation.XmlTransient;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 *
 * @author ESMAEL
 */

@Entity("usuarios")
public class Usuario {

    @Id
    @XmlTransient
    private ObjectId id;
    private String nome;
    private String apelido;
    private String email;
    private String nascimento;
    
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + id + ", NOME=" + nome + ", APELIDO=" + apelido + ", EMAIL=" + email + ", NASCIMENTO=" + nascimento + '}';
    }
    
    
   
}
