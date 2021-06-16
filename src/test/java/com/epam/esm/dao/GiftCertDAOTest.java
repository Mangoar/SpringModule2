package com.epam.esm.dao;

import com.epam.esm.exception.DaoException;
import com.epam.esm.model.dao.impl.GiftCertDAOImpl;
import com.epam.esm.model.entity.GiftCertificate;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GiftCertDAOTest {

    private static GiftCertDAOImpl giftCertificateDAO;

    @BeforeAll
    public static void setup() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("classpath:create_gift_cert_table.sql")
                .build();
        giftCertificateDAO = new GiftCertDAOImpl(dataSource);
    }

    @AfterAll
    public static void deactivate() {
        new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("classpath:drop_gift_cert_table.sql")
                .build();
        giftCertificateDAO = null;
    }

    @Test
    @Order(1)
    public void addGiftCertValidTest() throws DaoException {
        GiftCertificate newGiftCert = new GiftCertificate(1,"testCert","testCertDesc",1,1,
                "2020-02-20","2020-02-20");
        int resultStatus = giftCertificateDAO.insertGiftCert(newGiftCert);
        Assert.assertEquals(1, resultStatus);
    }

    @Test
    @Order(2)
    public void getGiftCertByIdValidTest() throws DaoException {

        GiftCertificate expectedGiftCertificate = new GiftCertificate(1,"testCert","testCertDesc",1,1,
                java.time.LocalDate.now().toString(),java.time.LocalDate.now().toString());
        GiftCertificate actualGiftCertificate = giftCertificateDAO.getCertById(1);
        Assert.assertEquals(expectedGiftCertificate, actualGiftCertificate);
    }

    @Test
    @Order(3)
    public void getLastGiftCertValidTest() throws DaoException {
        int id = giftCertificateDAO.getLastGiftCert().getId();
        Assert.assertEquals(1, id);
    }

    @Test
    @Order(4)
    public void updateGiftCertValidTest() throws DaoException {
        GiftCertificate testGiftCert = new GiftCertificate(1,"testCertUpdate","testCertDescUpdate",1,1,
                "2020-02-20","2020-02-20");
        int resultStatus = giftCertificateDAO.updateGiftCert(testGiftCert);
        Assert.assertEquals(1, resultStatus);
    }

    @Test
    @Order(5)
    public void getAllGiftCertValidTest() throws DaoException {
        int listSize = giftCertificateDAO.getAllGiftCertificates().size();
        Assert.assertEquals(1, listSize);
    }

    @Test
    @Order(6)
    public void deleteGiftCertValidTest() throws DaoException {
        int resultStatus = giftCertificateDAO.deleteGiftCert(1);
        Assert.assertEquals(1, resultStatus);
    }
}
