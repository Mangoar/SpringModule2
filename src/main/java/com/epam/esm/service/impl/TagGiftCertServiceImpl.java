package com.epam.esm.service.impl;

import com.epam.esm.exception.DaoException;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.dao.TagGiftCertDAO;
import com.epam.esm.model.entity.TagGiftCert;
import com.epam.esm.service.TagGiftCertService;

import java.util.List;

/**
 * The class for service gift certificate with tag
 */
public class TagGiftCertServiceImpl implements TagGiftCertService {

    private TagGiftCertDAO tagGiftCertDAO;


    public TagGiftCertServiceImpl(TagGiftCertDAO tagGiftCertDAO) {
        this.tagGiftCertDAO = tagGiftCertDAO;
    }

    @Override
    public List<TagGiftCert> getAllTagGiftCerts() throws ServiceException {
        try {
            return tagGiftCertDAO.getAllTagGiftCerts();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<TagGiftCert> getTagGiftCertsByMixConditions(String tagName, String likeType,
                                                            String likeString, String orderCol,
                                                            String orderType) throws ServiceException {
        try {
            return tagGiftCertDAO.getTagGiftCertsByMixConditions(tagName,likeType,likeString,orderCol,orderType);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
