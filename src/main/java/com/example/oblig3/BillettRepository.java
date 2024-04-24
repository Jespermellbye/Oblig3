package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BillettRepository {
    @Autowired
    private JdbcTemplate db;

    public void lagreBillett(Billetter billett) {
        String sql = "INSERT INTO Billetter (film, antall, fornavn, etternavn, epost, telefon) VALUES (?, ?, ?, ?, ?, ?)";
        db.update(sql, billett.getFilm(), billett.getAntall(), billett.getFornavn(), billett.getEtternavn(), billett.getEpost(), billett.getTelefon());
    }

    public List<Billetter> hentAlleBilletter() {
        return db.query("SELECT * FROM Billetter", new BeanPropertyRowMapper<>(Billetter.class));
    }

    public Billetter hentEnBillett(Integer id) {
        return db.queryForObject("SELECT * FROM Billetter WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Billetter.class));
    }

    public void redigerBillett(Billetter billett) {
        String sql = "UPDATE Billetter SET film = ?, antall = ?, fornavn = ?, etternavn = ?, epost = ?, telefon = ? WHERE id = ?";
        db.update(sql, billett.getFilm(), billett.getAntall(), billett.getFornavn(), billett.getEtternavn(), billett.getEpost(), billett.getTelefon(), billett.getId());
    }

    public void slettEnBillett(Integer id) {
        db.update("DELETE FROM Billetter WHERE id = ?", id);
    }

    public void slettAlleBilletter() {
        db.update("DELETE FROM Billetter");
    }
}
