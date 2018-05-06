package com.practice.bankadvisor.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PORTFOLIO")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "portfolio_generator")
    @SequenceGenerator(name = "portfolio_generator", sequenceName = "portfolio_seq_id", allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PortfolioDomain domain;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "PORTFOLIO_USER",
            joinColumns = { @JoinColumn(name = "PORTFOLIO_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID") }
    )
    private List<User> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(id, portfolio.id) &&
                domain == portfolio.domain &&
                Objects.equals(users, portfolio.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domain, users);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", domain=" + domain +
                ", users=" + users +
                '}';
    }
}
