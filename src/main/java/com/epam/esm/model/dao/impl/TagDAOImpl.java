package com.epam.esm.model.dao.impl;

import com.epam.esm.exception.DaoException;
import com.epam.esm.model.dao.TagDAO;
import com.epam.esm.model.entity.Tag;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The class for working with the database for the tag
 */

public class TagDAOImpl implements TagDAO {

    private static final String DELETE_TAG_BY_ID = "DELETE FROM tag WHERE id = ?";
    private static final String CREATE_TAG = "INSERT INTO tag (name) VALUES (?)";
    private static final String CREATE_TAG_RELATION = "INSERT INTO gc_t_table (id_tag, id_gc) VALUES (?,?)";
    private static final String GET_ALL_TAGS = "SELECT * FROM tag";
    private static final String GET_TAG_BY_NAME = "SELECT * FROM tag where name = ?";

    private JdbcTemplate jdbcTemplate;

    public TagDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createTag(Tag tag) throws DaoException {
        try {
            return jdbcTemplate.update(CREATE_TAG, tag.getName());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public int deleteTag(int id) throws DaoException {
        try {
            return jdbcTemplate.update(DELETE_TAG_BY_ID, id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public int addTagRelation(int idTag, int idCert) throws DaoException {
        try {
            return jdbcTemplate.update(CREATE_TAG_RELATION, idTag, idCert);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


    @Override
    public List<Tag> getAllTags() throws DaoException {
        try {
            List<Tag> listTag = jdbcTemplate.query(GET_ALL_TAGS, new RowMapper<Tag>() {

                @Override
                public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Tag tag = new Tag();

                    tag.setId(rs.getInt("id"));
                    tag.setName(rs.getString("name"));

                    return tag;
                }

            });
            return listTag;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Tag getTagByName(String name) throws DaoException {
        try {
            return jdbcTemplate.query(GET_TAG_BY_NAME, new Object[]{name},
                    new BeanPropertyRowMapper<>(Tag.class)).stream().findAny().orElse(null);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
