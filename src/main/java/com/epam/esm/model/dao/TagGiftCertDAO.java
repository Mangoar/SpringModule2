package com.epam.esm.model.dao;

import com.epam.esm.exception.DaoException;
import com.epam.esm.model.entity.TagGiftCert;

import java.util.List;

/**
 * The interface of gift certificate with tag dao
 */
public interface TagGiftCertDAO {

    /**
     * Get list of gift certificates with tag by mixed search conditions
     * @param tagName name of tag for search
     * @param likeType column of search by part
     * @param likeString part of chosen column to search
     * @param orderCol column of search by order
     * @param orderType type of search by order(asc/desc)
     * @return list of gift certificates with tag
     * @throws DaoException if an dao exception occurred while processing
     */
    List<TagGiftCert> getTagGiftCertsByMixConditions(String tagName, String likeType,
                                                     String likeString, String orderCol,
                                                     String orderType) throws DaoException;
    /**
     * Get list of all gift certificates with tag
     * @return list of gift certificates with tag
     * @throws DaoException if an dao exception occurred while processing
     */
    List<TagGiftCert> getAllTagGiftCerts() throws DaoException;

}
