package com.epam.esm.model.dao.impl;

import com.epam.esm.exception.DaoException;
import com.epam.esm.model.dao.TagGiftCertDAO;
import com.epam.esm.model.entity.TagGiftCert;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The class for working with the database for the gift certificate with tag
 */

public class TagGiftCertDAOImpl implements TagGiftCertDAO {

    private static final String GET_ALL_TAG_GIFT_CERTS_MIXED_1 = "select * from certificate_view ";
    private static final String WHERE = "where ";
    private static final String GET_ALL_TAG_GIFT_CERTS_MIXED_2 = "name = '";
    private static final String GET_ALL_TAG_GIFT_CERTS_MIXED_3 = "' ";
    private static final String AND = "and ";
    private static final String DESCRIPTION = "description";
    private static final String CERT_NAME = "cert_name";
    private static final String GET_ALL_TAG_GIFT_CERTS_MIXED_4 = " like '%";
    private static final String GET_ALL_TAG_GIFT_CERTS_MIXED_5 = "%'";
    private static final String GET_ALL_TAG_GIFT_CERTS_MIXED_6 = " order by ";
    private static final String ASC = " ASC";
    private static final String DESC = " DESC";


    private static final String GET_ALL_TAG_GIFT_CERTS = "SELECT * FROM certificate_view";

    private JdbcTemplate jdbcTemplate;

    public TagGiftCertDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<TagGiftCert> getTagGiftCertsByMixConditions(String tagName, String likeType,
                                                            String likeString, String orderCol,
                                                            String orderType) throws DaoException {
        try {
            StringBuilder stringBuilder = new StringBuilder(GET_ALL_TAG_GIFT_CERTS_MIXED_1);
            if (!tagName.equals("") || !likeType.equals("default")) {
                stringBuilder.append(WHERE);
            }
            if (!tagName.equals("")) {
                stringBuilder.append(GET_ALL_TAG_GIFT_CERTS_MIXED_2);
                stringBuilder.append(tagName);
                stringBuilder.append(GET_ALL_TAG_GIFT_CERTS_MIXED_3);
            }
            if (!likeType.equals("default")) {
                if (!tagName.equals("")) {
                    stringBuilder.append(AND);
                }
                if (likeType.equals("cert_name")) {
                    stringBuilder.append(CERT_NAME);
                } else if (likeType.equals("description")) {
                    stringBuilder.append(DESCRIPTION);
                }
                stringBuilder.append(GET_ALL_TAG_GIFT_CERTS_MIXED_4);
                stringBuilder.append(likeString);
                stringBuilder.append(GET_ALL_TAG_GIFT_CERTS_MIXED_5);
            }
            if (!orderCol.equals("default")) {
                stringBuilder.append(GET_ALL_TAG_GIFT_CERTS_MIXED_6);
                stringBuilder.append(orderCol);
                if (orderType.equals("desc")) {
                    stringBuilder.append(DESC);
                } else if (orderType.equals("asc")) {
                    stringBuilder.append(ASC);
                }
            }

            return jdbcTemplate.query(stringBuilder.toString(), new RowMapper<TagGiftCert>() {

                @Override
                public TagGiftCert mapRow(ResultSet rs, int rowNum) throws SQLException {
                    TagGiftCert tagGiftCert = new TagGiftCert();

                    tagGiftCert.setName(rs.getString("name"));
                    tagGiftCert.setCertName(rs.getString("cert_name"));
                    tagGiftCert.setPrice(rs.getInt("price"));
                    tagGiftCert.setDuration(rs.getInt("duration"));
                    tagGiftCert.setDescription(rs.getString("description"));
                    tagGiftCert.setCreateDate(rs.getString("create_date"));
                    tagGiftCert.setLastUpdateDate(rs.getString("last_update_date"));


                    return tagGiftCert;
                }

            });
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<TagGiftCert> getAllTagGiftCerts() throws DaoException {
        try {
            return jdbcTemplate.query(GET_ALL_TAG_GIFT_CERTS, new RowMapper<TagGiftCert>() {

                @Override
                public TagGiftCert mapRow(ResultSet rs, int rowNum) throws SQLException {
                    TagGiftCert tagGiftCert = new TagGiftCert();

                    tagGiftCert.setName(rs.getString("name"));
                    tagGiftCert.setCertName(rs.getString("cert_name"));
                    tagGiftCert.setPrice(rs.getInt("price"));
                    tagGiftCert.setDuration(rs.getInt("duration"));
                    tagGiftCert.setDescription(rs.getString("description"));
                    tagGiftCert.setCreateDate(rs.getString("create_date"));
                    tagGiftCert.setLastUpdateDate(rs.getString("last_update_date"));


                    return tagGiftCert;
                }

            });
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
