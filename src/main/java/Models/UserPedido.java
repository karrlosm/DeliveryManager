package Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserPedido implements Serializable {

    @Id
    @GeneratedValue(strategy  = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nome;
    @Column(unique = true)
    private String email;
    @Column
    private String senha;

    @OneToMany(mappedBy = "userPedido",orphanRemoval = true)
    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
    private List<Pedido> pedidosDoUser;

    public UserPedido(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UserPedido() {
    }

    public List<Pedido> getPedidosDoUser() {
        return pedidosDoUser;
    }

    public void setPedidosDoUser(List<Pedido> pedidosDoUser) {
        this.pedidosDoUser = pedidosDoUser;
    }

    public String getNome() {
            return nome;
        }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
