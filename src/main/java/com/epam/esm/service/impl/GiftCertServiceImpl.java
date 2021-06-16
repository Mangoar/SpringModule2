package com.epam.esm.service.impl;

import com.epam.esm.exception.DaoException;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.dao.GiftCertDAO;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.service.GiftCertService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * The class for service gift certificate
 */
public class GiftCertServiceImpl implements GiftCertService {

    private GiftCertDAO giftCertDAO;

    public GiftCertServiceImpl(GiftCertDAO giftCertDAO) {
        this.giftCertDAO = giftCertDAO;
    }

    @Override
    public int deleteGiftCert(int id) throws ServiceException {
        try {
            return giftCertDAO.deleteGiftCert(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int updateGiftCert(GiftCertificate giftCertificate) throws ServiceException {
        try {
            return giftCertDAO.updateGiftCert(giftCertificate);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int insertGiftCert(GiftCertificate giftCertificate) throws ServiceException {
        try {
            return giftCertDAO.insertGiftCert(giftCertificate);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public GiftCertificate getLastGiftCert() throws ServiceException {
        try {
            return giftCertDAO.getLastGiftCert();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<GiftCertificate> getAllGiftCertificates() throws ServiceException {
        try {
            return giftCertDAO.getAllGiftCertificates();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public GiftCertificate getCertById(Integer id) throws ServiceException {
        try {
            return giftCertDAO.getCertById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
