package com.epam.esm.model.dao.impl;

import com.epam.esm.exception.DaoException;
import com.epam.esm.model.dao.GiftCertDAO;
import com.epam.esm.model.entity.GiftCertificate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The class for working with the database for the gift certificate
 */

public class GiftCertDAOImpl implements GiftCertDAO {

    private static final String DELETE_GIFT_CERTIFICATE_BY_ID = "DELETE FROM gift_certificate WHERE id = ?";
    private static final String CREATE_GIFT_CERTIFICATE = "INSERT INTO gift_certificate (cert_name, price, duration, description, create_date, last_update_date) VALUES (?,?,?,?,curdate(),curdate())";
    private static final String UPDATE_GIFT_CERTIFICATE = "UPDATE gift_certificate SET cert_name = ?,price = ?,duration = ?,description = ?,last_update_date = curdate() where id = ?;";
    private static final String GET_ALL_CERTIFICATES = "SELECT * FROM gift_certificate";
    private static final String GET_CERTIFICATE_BY_ID = "SELECT * FROM gift_certificate where id = ?";
    private static final String GET_LAST_CERTIFICATE = "SELECT * FROM gift_certificate where id = (select max(id) from gift_certificate)";

    private JdbcTemplate jdbcTemplate;

    public GiftCertDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int deleteGiftCert(int id) throws DaoException {
        try {
            return jdbcTemplate.update(DELETE_GIFT_CERTIFICATE_BY_ID, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public int updateGiftCert(GiftCertificate giftCertificate) throws DaoException {
        try {
            return jdbcTemplate.update(UPDATE_GIFT_CERTIFICATE, giftCertificate.getCertName(), giftCertificate.getPrice(), giftCertificate.getDuration(), giftCertificate.getDescription(), giftCertificate.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public int insertGiftCert(GiftCertificate giftCertificate) throws DaoException {
        try {
            return jdbcTemplate.update(CREATE_GIFT_CERTIFICATE, giftCertificate.getCertName(),
                    giftCertificate.getPrice(), giftCertificate.getDuration(), giftCertificate.getDescription());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public GiftCertificate getLastGiftCert() throws DaoException {
        try {

            return jdbcTemplate.query(GET_LAST_CERTIFICATE,
                    new BeanPropertyRowMapper<>(GiftCertificate.class)).stream().findAny().orElse(null);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<GiftCertificate> getAllGiftCertificates() throws DaoException {
        try {
            List<GiftCertificate> listGiftCertificate = jdbcTemplate.query(GET_ALL_CERTIFICATES, new RowMapper<GiftCertificate>() {

                @Override
                public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
                    GiftCertificate giftCertificate = new GiftCertificate();

                    giftCertificate.setId(rs.getInt("id"));
                    giftCertificate.setCertName(rs.getString("cert_name"));
                    giftCertificate.setDescription(rs.getString("description"));
                    giftCertificate.setPrice(rs.getInt("price"));
                    giftCertificate.setCreateDate(rs.getString("create_date"));
                    giftCertificate.setDuration(rs.getInt("duration"));
                    giftCertificate.setLastUpdateDate(rs.getString("last_update_date"));

                    return giftCertificate;
                }

            });
            return listGiftCertificate;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public GiftCertificate getCertById(Integer id) throws DaoException {
        try {
            return jdbcTemplate.query(GET_CERTIFICATE_BY_ID, new Object[]{id},
                    new BeanPropertyRowMapper<>(GiftCertificate.class)).stream().findAny().orElse(null);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

}
