package com.epam.esm.model.dao;

import com.epam.esm.exception.DaoException;
import com.epam.esm.model.entity.Tag;

import java.util.List;

/**
 * The interface of tag dao
 */
public interface TagDAO {

    /**
     * Add new account
     * @param tag new tag
     * @throws DaoException if an dao exception occurred while processing
     */
    int createTag(Tag tag) throws DaoException;

    /**
     * Delete tag
     * @param id id of tag that will be deleted
     * @throws DaoException if an dao exception occurred while processing
     */
    int deleteTag(int id) throws DaoException;

    /**
     * Add relation between tag and gift certificate
     * @param idTag id of tag
     * @param idCert id of gift certificate
     * @throws DaoException if an dao exception occurred while processing
     */
    int addTagRelation(int idTag, int idCert) throws DaoException;

    /**
     * Get list of all tags
     * @return list of tags
     * @throws DaoException if an dao exception occurred while processing
     */
    List<Tag> getAllTags() throws DaoException;

    /**
     * Get tag by it's name
     * @param name name of tag to search
     * @return tag
     * @throws DaoException if an dao exception occurred while processing
     */
    Tag getTagByName(String name) throws DaoException;
}
