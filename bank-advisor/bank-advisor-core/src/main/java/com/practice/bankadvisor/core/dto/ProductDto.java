package com.practice.bankadvisor.core.dto;

import com.practice.bankadvisor.core.domain.PortfolioDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDto {
    private Long id;

    private String name;

    private PortfolioDomain domain;

    private List<UserDto> users = new ArrayList<>();

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

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto product = (ProductDto) o;
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
