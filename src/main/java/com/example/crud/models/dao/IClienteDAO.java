package com.example.crud.models.dao;

import java.util.List;

import com.example.crud.models.entity.Cliente;

public interface IClienteDAO {
    /*Metodos CRUD */
    public List<Cliente> all();
    public int save(Cliente cliente);
    public Cliente find(int id);
    public int update(Cliente cliente);
    public int delete(int id);
}
