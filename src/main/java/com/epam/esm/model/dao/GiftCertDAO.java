package com.epam.esm.model.dao;

import com.epam.esm.exception.DaoException;
import com.epam.esm.model.entity.GiftCertificate;

import java.util.List;

/**
 * The interface of gift certificate dao
 */
public interface GiftCertDAO {

    /**
     * Delete gift certificate
     * @param id id of tag that will be deleted
     * @throws DaoException if an dao exception occurred while processing
     */
    int deleteGiftCert(int id) throws DaoException;

    /**
     * Update gift certificate
     * @param giftCertificate gift certificate for update
     * @throws DaoException if an dao exception occurred while processing
     */
    int updateGiftCert(GiftCertificate giftCertificate) throws DaoException;

    /**
     * Add new gift certificate
     * @param giftCertificate new gift certificate
     * @throws DaoException if an dao exception occurred while processing
     */
    int insertGiftCert(GiftCertificate giftCertificate) throws DaoException;

    /**
     * Get last added gift certificate
     * @return gift certificate
     * @throws DaoException if an dao exception occurred while processing
     */
    GiftCertificate getLastGiftCert() throws DaoException;

    /**
     * Get list of all gift certificates
     * @return list of gift certificates
     * @throws DaoException if an dao exception occurred while processing
     */
    List<GiftCertificate> getAllGiftCertificates() throws DaoException;

    /**
     * Get gift certificate by it's id
     * @param id id of gift certificate to search
     * @return gift certificate
     * @throws DaoException if an dao exception occurred while processing
     */
    GiftCertificate getCertById(Integer id) throws DaoException;
}
