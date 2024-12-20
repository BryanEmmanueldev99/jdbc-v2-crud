package com.example.crud.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.crud.models.entity.Cliente;

@Service
public class ClienteDAOImpl implements IClienteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cliente> all() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cliente.class));

        return clientes;
    }

    @Override
    public int save(Cliente cliente) {
        String sql = "INSERT INTO cliente(nombre, apellidos, correo) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, cliente.getNombre(), cliente.getApellidos(), cliente.getCorreo());
    }

    @Override
    public Cliente find(int id) {
        String sql = "SELECT * FROM cliente WHERE idcliente = ?";
        Cliente cliente = jdbcTemplate.queryForObject(sql, new Object[] {id},
        BeanPropertyRowMapper.newInstance(Cliente.class));

        return cliente;
    }

    @Override
    public int update(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre=?, apellidos=?, correo=? WHERE idcliente = ?";
        return jdbcTemplate.update(sql, cliente.getNombre(), cliente.getApellidos(), cliente.getCorreo(),
        cliente.getIdcliente());
    }

    @Override
    public int delete(int id) {
        String sql="DELETE FROM cliente WHERE idcliente = ?";
        return jdbcTemplate.update(sql, id);
    }

}
