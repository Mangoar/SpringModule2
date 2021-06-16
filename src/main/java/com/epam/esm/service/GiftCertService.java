package com.epam.esm.service;

import com.epam.esm.exception.DaoException;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.entity.GiftCertificate;

import java.util.List;

/**
 * The interface gift certificate service.
 */
public interface GiftCertService {

    /**
     * Delete gift certificate
     * @param id id of tag that will be deleted
     * @throws ServiceException if an dao exception occurred while processing
     */
    int deleteGiftCert(int id) throws ServiceException;

    /**
     * Update gift certificate
     * @param giftCertificate gift certificate for update
     * @throws ServiceException if an dao exception occurred while processing
     */
    int updateGiftCert(GiftCertificate giftCertificate) throws ServiceException;

    /**
     * Add new gift certificate
     * @param giftCertificate new gift certificate
     * @throws ServiceException if an dao exception occurred while processing
     */
    int insertGiftCert(GiftCertificate giftCertificate) throws ServiceException;

    /**
     * Get last added gift certificate
     * @return gift certificate
     * @throws ServiceException if an dao exception occurred while processing
     */
    GiftCertificate getLastGiftCert() throws ServiceException;

    /**
     * Get list of all gift certificates
     * @return list of gift certificates
     * @throws ServiceException if an dao exception occurred while processing
     */
    List<GiftCertificate> getAllGiftCertificates() throws ServiceException;

    /**
     * Get gift certificate by it's id
     * @param id id of gift certificate to search
     * @return gift certificate
     * @throws ServiceException if an dao exception occurred while processing
     */
    GiftCertificate getCertById(Integer id) throws ServiceException;
}
