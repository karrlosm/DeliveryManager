package Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="Pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="nome_pedido")
    private String nomeDoPedido;
    @Column(name="data")
    @Temporal(TemporalType.DATE)
    private Date dataDaCompra;
    @Column(name="nome_comprador")
    private String comprador;
    @Column(name="preco")
    private float preco;

    @ManyToOne
    @JoinColumn(name="userPedido",nullable = false)
    @org.hibernate.annotations.ForeignKey(name = "userpedido_fk")
    private UserPedido userPedido;
    
    public Long getId() {
		return id;
	}

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    private String descricao;

    public Pedido(){

    }

    public Pedido(String nomeDoPedido, Date dataDaCompra,
                  String comprador, float preco,
                  String descricao, UserPedido userPedido) {
        this.nomeDoPedido = nomeDoPedido;
        this.dataDaCompra = dataDaCompra;
        this.comprador = comprador;
        this.preco = preco;
        this.descricao = descricao;
        this.userPedido = userPedido;
    }

    public UserPedido getUserPedido() {
        return userPedido;
    }

    public void setUserPedido(UserPedido userPedido) {
        this.userPedido = userPedido;
    }

    public String getNomeDoPedido() {
        return nomeDoPedido;
    }

    public void setNomeDoPedido(String nomeDoPedido) {
        this.nomeDoPedido = nomeDoPedido;
    }

    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "id='"+this.id+"', nomeDoPedido='" + nomeDoPedido + '\'' +
                ", dataDaCompra=" + dataDaCompra +
                ", comprador='" + comprador + '\'';
    }
}


