package com.epam.esm.service;

import com.epam.esm.exception.DaoException;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.dao.TagDAO;
import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.service.impl.TagServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TagServiceTest {

    static TagService tagService;

    @BeforeAll
    public static void setup() throws DaoException {
        TagDAO tagDAO = mock(TagDAOImpl.class);
        Tag newTag = new Tag("newTag");

        when(tagDAO.createTag(newTag)).thenReturn(1);
        when(tagDAO.getTagByName("newTag")).thenReturn(newTag);
        when(tagDAO.getAllTags()).thenReturn(new ArrayList<Tag>(Arrays.asList(newTag)));
        when(tagDAO.deleteTag(1)).thenReturn(1);
        tagService = new TagServiceImpl((TagDAOImpl) tagDAO);
    }

    @Test
    public void insertTagTestTrue() throws ServiceException {
        assertEquals(tagService.createTag(new Tag("newTag")),1);
    }

    @Test
    public void getTagByNameTestTrue() throws ServiceException {
        Tag expectedTag = new Tag("newTag");
        Tag actualtag = tagService.getTagByName("newTag");
        assertEquals(expectedTag,actualtag);
    }

    @Test
    public void getAllTagsTestFalse() throws ServiceException {
        int listSize = tagService.getAllTags().size();
        assertNotEquals(listSize,0);
    }

    @Test
    public void deleteTagTestTrue() throws ServiceException {
        assertEquals(tagService.deleteTag(1),1);
    }
}
