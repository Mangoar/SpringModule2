package com.epam.esm.service;

import com.epam.esm.exception.DaoException;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.entity.Tag;

import java.util.List;

/**
 * The interface tag service.
 */
public interface TagService {

    /**
     * Add new account
     * @param tag new tag
     * @throws ServiceException if an dao exception occurred while processing
     */
    int createTag(Tag tag) throws ServiceException;

    /**
     * Delete tag
     * @param id id of tag that will be deleted
     * @throws ServiceException if an dao exception occurred while processing
     */
    int deleteTag(int id) throws ServiceException;

    /**
     * Add relation between tag and gift certificate
     * @param idTag id of tag
     * @param idCert id of gift certificate
     * @throws ServiceException if an dao exception occurred while processing
     */
    int addTagRelation(int idTag, int idCert) throws ServiceException;

    /**
     * Get list of all tags
     * @return list of tags
     * @throws ServiceException if an dao exception occurred while processing
     */
    List<Tag> getAllTags() throws ServiceException;

    /**
     * Get tag by it's name
     * @param name name of tag to search
     * @return tag
     * @throws ServiceException if an dao exception occurred while processing
     */
    Tag getTagByName(String name) throws ServiceException;
}
