package com.practice.bankadvisor.core.dto;

import com.practice.bankadvisor.core.domain.PortfolioDomain;

import java.util.List;
import java.util.Objects;

public class PortfolioDto {
    private Long id;
    private PortfolioDomain domain;
    private List<UserDto> users;

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
        PortfolioDto that = (PortfolioDto) o;
        return Objects.equals(id, that.id) &&
                domain == that.domain &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domain, users);
    }

    @Override
    public String toString() {
        return "PortfolioDto{" +
                "id=" + id +
                ", domain=" + domain +
                ", users=" + users +
                '}';
    }
}
