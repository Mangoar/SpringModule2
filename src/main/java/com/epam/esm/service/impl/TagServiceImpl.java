package com.epam.esm.service.impl;

import com.epam.esm.exception.DaoException;
import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.dao.TagDAO;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The class for service tag
 */
public class TagServiceImpl implements TagService {

    private TagDAO tagDAO;

    public TagServiceImpl(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }


    @Override
    public int createTag(Tag tag) throws ServiceException {
        try {
            return tagDAO.createTag(tag);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int deleteTag(int id) throws ServiceException {
        try {
            return tagDAO.deleteTag(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int addTagRelation(int idTag, int idCert) throws ServiceException {
        try {
            return tagDAO.addTagRelation(idTag, idCert);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Tag> getAllTags() throws ServiceException {
        List<Tag> tagList = new ArrayList<>();
        try {
            tagList = tagDAO.getAllTags();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return tagList;
    }

    @Override
    public Tag getTagByName(String name) throws ServiceException {
        try {
            return tagDAO.getTagByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
