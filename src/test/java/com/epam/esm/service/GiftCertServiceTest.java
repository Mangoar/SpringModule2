package com.epam.esm.service;

import com.epam.esm.exception.DaoException;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.dao.GiftCertDAO;
import com.epam.esm.model.dao.impl.GiftCertDAOImpl;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.service.impl.GiftCertServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GiftCertServiceTest {

    static GiftCertService giftCertService;

    @BeforeAll
    public static void setup() throws DaoException {
        GiftCertDAO giftCertDAO = mock(GiftCertDAOImpl.class);
        GiftCertificate giftCertificate = new GiftCertificate(1,"newCert","testCert",1,1,
                "2020-02-20","2020-02-20");
        GiftCertificate giftCertificateUpdated = new GiftCertificate(1,"newCertUpdate","testCertUpdate",1,1,
                "2020-02-20","2020-02-20");

        when(giftCertDAO.insertGiftCert(giftCertificate)).thenReturn(1);
        when(giftCertDAO.updateGiftCert(giftCertificateUpdated)).thenReturn(1);
        when(giftCertDAO.getLastGiftCert()).thenReturn(giftCertificateUpdated);
        when(giftCertDAO.getCertById(1)).thenReturn(giftCertificateUpdated);
        when(giftCertDAO.getAllGiftCertificates()).thenReturn(new ArrayList<GiftCertificate>(Arrays.asList(giftCertificateUpdated)));
        when(giftCertDAO.deleteGiftCert(1)).thenReturn(1);
        giftCertService = new GiftCertServiceImpl((GiftCertDAOImpl) giftCertDAO);
    }

    @Test
    public void insertGiftCertTestTrue() throws ServiceException {
        assertEquals(giftCertService.insertGiftCert(new GiftCertificate(1,"newCert","testCert",1,1,
                "2020-02-20","2020-02-20")),1);
    }

    @Test
    public void getLastGiftCertTestTrue() throws ServiceException {
        GiftCertificate expectedCertificate = new GiftCertificate(1,"newCertUpdate","testCertUpdate",1,1,
                "2020-02-20","2020-02-20");
        GiftCertificate actualCertificate = giftCertService.getLastGiftCert();
        assertEquals(expectedCertificate, actualCertificate);
    }

    @Test
    public void getGiftCertByIdTestTrue() throws ServiceException {
        GiftCertificate expectedCertificate = new GiftCertificate(1,"newCertUpdate","testCertUpdate",1,1,
                "2020-02-20","2020-02-20");
        GiftCertificate actualCertificate = giftCertService.getCertById(1);
        assertEquals(expectedCertificate,actualCertificate);
    }

    @Test
    public void updateGiftCertTestTrue() throws ServiceException {
        assertEquals(giftCertService.updateGiftCert(new GiftCertificate(1,"newCertUpdate","testCertUpdate",1,1,
                "2020-02-20","2020-02-20")),1);
    }

    @Test
    public void getAllGiftCertTestFalse() throws ServiceException {
        int listSize = giftCertService.getAllGiftCertificates().size();
        assertNotEquals(listSize,0);
    }

    @Test
    public void deleteGiftCertTestTrue() throws ServiceException {
        assertEquals(giftCertService.deleteGiftCert(1),1);
    }

}
