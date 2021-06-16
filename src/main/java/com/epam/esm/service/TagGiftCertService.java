package com.epam.esm.service;

import com.epam.esm.exception.DaoException;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.entity.TagGiftCert;

import java.util.List;

/**
 * The interface gift certificate with tag service.
 */
public interface TagGiftCertService {

    /**
     * Get list of all gift certificates with tag
     * @return list of gift certificates with tag
     * @throws ServiceException if an dao exception occurred while processing
     */
    List<TagGiftCert> getAllTagGiftCerts() throws ServiceException;

    /**
     * Get list of gift certificates with tag by mixed search conditions
     * @param tagName name of tag for search
     * @param likeType column of search by part
     * @param likeString part of chosen column to search
     * @param orderCol column of search by order
     * @param orderType type of search by order(asc/desc)
     * @return list of gift certificates with tag
     * @throws ServiceException if an dao exception occurred while processing
     */
    List<TagGiftCert> getTagGiftCertsByMixConditions(String tagName, String likeType,
                                                     String likeString, String orderCol,
                                                     String orderType) throws ServiceException;
}
