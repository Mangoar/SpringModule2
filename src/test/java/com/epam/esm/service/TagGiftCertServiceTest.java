package com.epam.esm.service;

import com.epam.esm.exception.DaoException;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.dao.TagGiftCertDAO;
import com.epam.esm.model.dao.impl.TagGiftCertDAOImpl;
import com.epam.esm.model.entity.TagGiftCert;
import com.epam.esm.service.impl.TagGiftCertServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TagGiftCertServiceTest {

    static TagGiftCertService tagGiftCertService;

    @BeforeAll
    public static void setup() throws DaoException {
        TagGiftCertDAOImpl tagGiftCertDAO = mock(TagGiftCertDAOImpl.class);
        TagGiftCert tagGiftCert1 = new TagGiftCert("tag1",
                "cert1",10,100,"description1","2021.06.14","2021.06.14");
        TagGiftCert tagGiftCert2 = new TagGiftCert("tag2",
                "cert2",10,100,"description2","2021.06.14","2021.06.14");

        when(tagGiftCertDAO.getAllTagGiftCerts()).thenReturn(new ArrayList<TagGiftCert>(Arrays.asList(tagGiftCert1,tagGiftCert2)));
        when(tagGiftCertDAO.getTagGiftCertsByMixConditions(
                "tag1","cert_name","cert","create_date","asc")).thenReturn(new ArrayList<TagGiftCert>(Arrays.asList(tagGiftCert1)));

        tagGiftCertService = new TagGiftCertServiceImpl(tagGiftCertDAO);
    }

    @Test
    public void testAllGiftCertTestTrue() throws ServiceException {
        int listSize = tagGiftCertService.getAllTagGiftCerts().size();
        assertEquals(2,listSize);
    }

    @Test
    public void testMixedGiftCertTestTrue() throws ServiceException {
        int listSize = tagGiftCertService.getTagGiftCertsByMixConditions("tag1","cert_name","cert","create_date","asc").size();
        assertEquals(1,listSize);
    }
}
