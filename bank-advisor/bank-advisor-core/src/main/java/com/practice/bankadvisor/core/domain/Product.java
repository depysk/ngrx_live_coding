package com.practice.bankadvisor.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_seq_id", allocationSize = 1)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PortfolioDomain domain;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "PRODUCT_USER",
            joinColumns = { @JoinColumn(name = "PRODUCT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID") }
    )
    private List<User> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PortfolioDomain getDomain() {
        return domain;
    }

    public void setDomain(PortfolioDomain domain) {
        this.domain = domain;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                domain == product.domain &&
                Objects.equals(users, product.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, domain, users);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", domain=" + domain +
                ", users=" + users +
                '}';
    }
}
