/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monitoramento.ferramental.repository;

import com.monitoramento.ferramental.model.FerramentaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class FerramentaRepository {

    public int salvar(FerramentaDTO ferramenta) {
        int linhas = 0;

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO ferramental (nome, horasUso, vidaUtilMaxima) values (?,?,?)");
            stmt.setString(1, ferramenta.getNome());
            stmt.setInt(2, ferramenta.getHorasUso());
            stmt.setInt(3, ferramenta.getVidaUtilMaxima());

            linhas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linhas;

    }

    public List<FerramentaDTO> listaFerramenta() {
        List<FerramentaDTO> listaFerramenta = new ArrayList<>();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * from ferramental");
            rs = stmt.executeQuery();

            while (rs.next()) {
                FerramentaDTO ferramenta = new FerramentaDTO();
                ferramenta.setId(rs.getInt("id"));
                ferramenta.setNome(rs.getString("nome"));
                ferramenta.setHorasUso(rs.getInt("horasUso"));
                ferramenta.setVidaUtilMaxima(rs.getInt("vidaUtilMaxima"));
                listaFerramenta.add(ferramenta);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return listaFerramenta;
    }

    public int deleteByld(int id) {
        int linhas = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("DELETE FROM ferramental WHERE id = ?");
            linhas = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return linhas;
    }

    public int update(FerramentaDTO ferramenta) {
        int linhas = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("UPDATE ferramental SET nome = ?, horasUso = ?, vidaUtilMaxima = ? WHERE id = ?");
            stmt.setString(1, ferramenta.getNome());
            stmt.setInt(2, ferramenta.getHorasUso());
            stmt.setInt(3, ferramenta.getVidaUtilMaxima());
            stmt.setInt(4, ferramenta.getId());

            linhas = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linhas;
    }

}
