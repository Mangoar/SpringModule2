package com.epam.esm.controller;

import com.epam.esm.exception.ServiceException;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.entity.TagGiftCert;
import com.epam.esm.service.GiftCertService;
import com.epam.esm.service.TagGiftCertService;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Class of main controller to handle requests
 */
@RestController
public class MainController {

    @Autowired
    private TagGiftCertService tagGiftCertService;

    @Autowired
    private TagService tagService;

    @Autowired
    private GiftCertService giftCertService;


    //TAG_GIFT_CERT_R
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listTagGiftCert(ModelAndView model) throws ServiceException {

        List<TagGiftCert> listTagGiftCert = tagGiftCertService.getAllTagGiftCerts();
        model.addObject("listTagGiftCert", listTagGiftCert);
        model.setViewName("index");

        return model;
    }

    @RequestMapping(value = "/search_tag_gift_cert", method = RequestMethod.GET)
    public ModelAndView listTagGiftCertSortOrderBy(ModelAndView model,
                                                   @RequestParam(required = false) String tagName, @RequestParam String likeType,
                                                   @RequestParam(required = false) String likeString, @RequestParam String orderCol,
                                                   @RequestParam String orderType) throws ServiceException {

        List<TagGiftCert> listTagGiftCert = tagGiftCertService.getTagGiftCertsByMixConditions(tagName,
                likeType, likeString, orderCol, orderType);
        model.addObject("listTagGiftCert", listTagGiftCert);
        model.setViewName("index");

        return model;
    }

    //TAG CRD
    @RequestMapping(value = "/tags", method = RequestMethod.GET)
    public ModelAndView listTag(ModelAndView model) throws ServiceException {

        List<Tag> listTag = tagService.getAllTags();
        model.addObject("listTag", listTag);
        model.setViewName("tags");

        return model;
    }

    @RequestMapping(value = "/delete_tag", method = RequestMethod.GET)
    public ModelAndView deleteTagById(@RequestParam Integer id) throws ServiceException {

        tagService.deleteTag(id);

        return new ModelAndView("redirect:/tags");
    }

    @RequestMapping(value = "/new_tag_form", method = RequestMethod.GET)
    public ModelAndView newTag(ModelAndView model){

        Tag newTag = new Tag();
        model.addObject("tag", newTag);
        model.setViewName("tag_form");

        return model;
    }

    @RequestMapping(value = "/save_tag", method = RequestMethod.POST)
    public ModelAndView saveTag(ModelAndView model, Tag tag) throws ServiceException {

        if(!tag.getName().equals("")) {
            tagService.createTag(tag);
        }

        List<Tag> listTag = tagService.getAllTags();
        model.addObject("listTag", listTag);
        model.setViewName("tags");

        return model;
    }

    //CERTIFICATE CRUD

    @RequestMapping(value = "/certificates", method = RequestMethod.GET)
    public ModelAndView listCertificate(ModelAndView model) throws ServiceException {

        List<GiftCertificate> listCert = giftCertService.getAllGiftCertificates();
        model.addObject("listCertificate", listCert);
        model.setViewName("certificates");

        return model;
    }

    @RequestMapping(value = "/delete_certificate", method = RequestMethod.GET)
    public ModelAndView deleteGiftCertById(@RequestParam Integer id) throws ServiceException {

        giftCertService.deleteGiftCert(id);

        return new ModelAndView("redirect:/certificates");
    }

    @RequestMapping(value = "/new_cert_form", method = RequestMethod.GET)
    public ModelAndView newCertificate(ModelAndView model){

        GiftCertificate giftCertificate = new GiftCertificate();

        model.addObject("cert", giftCertificate);
        model.setViewName("cert_form");

        return model;
    }


    @RequestMapping(value = "/edit_cert_form", method = RequestMethod.GET)
    public ModelAndView editCertificate(HttpServletRequest request) throws ServiceException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        GiftCertificate giftCertificate = giftCertService.getCertById(id);

        ModelAndView model = new ModelAndView("cert_form");
        model.addObject("cert", giftCertificate);

        return model;
    }

    @RequestMapping(value = "/save_certificate", method = RequestMethod.POST)
    public ModelAndView saveCertificate(@RequestParam(required = false) String newTag,
                                        ModelAndView model, GiftCertificate giftCertificate) throws ServiceException {

        if (giftCertificate.getId() > 0) {
            giftCertService.updateGiftCert(giftCertificate);
        } else {
            giftCertService.insertGiftCert(giftCertificate);
        }

        if (!newTag.equals("")) {
            Tag tag = null;
            int idTag;
            int idCertificate = giftCertificate.getId();
            if (idCertificate == 0) {
                GiftCertificate newGiftCert = giftCertService.getLastGiftCert();
                idCertificate = newGiftCert.getId();
            }
            tag = tagService.getTagByName(newTag);

            if (tag == null) {
                tagService.createTag(new Tag(newTag));
                tag = tagService.getTagByName(newTag);
            }

            idTag = tag.getId();
            tagService.addTagRelation(idTag, idCertificate);
        }

        List<GiftCertificate> listGiftCertificate = giftCertService.getAllGiftCertificates();
        model.addObject("listCertificate", listGiftCertificate);
        model.setViewName("certificates");

        return model;
    }

}
