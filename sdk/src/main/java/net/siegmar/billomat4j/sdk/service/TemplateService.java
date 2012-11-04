/*
 * Copyright 2012 Oliver Siegmar <oliver@siegmar.net>
 *
 * This file is part of Billomat4J.
 *
 * Billomat4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Billomat4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Billomat4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.siegmar.billomat4j.sdk.service;

import java.util.List;

import net.siegmar.billomat4j.sdk.domain.template.ImageFormat;
import net.siegmar.billomat4j.sdk.domain.template.Template;
import net.siegmar.billomat4j.sdk.domain.template.TemplateFilter;

/**
 * @see http://www.billomat.com/api/vorlagen/
 */
public interface TemplateService extends AbstractCustomFieldService {

    /**
     * @param templateFilter
     *            template filter, may be {@code null} to find unfiltered
     * @return templates found by filter criteria or an empty list if no templates were found - never {@code null}
     * @throws net.siegmar.billomat4j.sdk.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    List<Template> findTemplates(TemplateFilter templateFilter);

    /**
     * Gets a template by its id.
     *
     * @param templateId
     *            the template's id
     * @return the template or {@code null} if not found
     * @throws net.siegmar.billomat4j.sdk.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    Template getTemplateById(int templateId);

    /**
     * @param template
     *            the template to create, must not be {@code null}
     * @throws NullPointerException
     *             if template is null
     * @throws net.siegmar.billomat4j.sdk.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    void createTemplate(Template template);

    /**
     * @param template
     *            the template to update, must not be {@code null}
     * @throws NullPointerException
     *             if template is null
     * @throws net.siegmar.billomat4j.sdk.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    void updateTemplate(Template template);

    /**
     * @param templateId
     *            the id of the template to be deleted
     * @throws net.siegmar.billomat4j.sdk.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    void deleteTemplate(int templateId);

    /**
     * @param templateId
     *            the id of the template to obtain a preview for
     * @param imageFormat
     *            the image file format this method should render
     * @return the template preview as binary data or {@code null} if template couldn't be found
     * @throws net.siegmar.billomat4j.sdk.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    byte[] getTemplatePreview(int templateId, ImageFormat imageFormat);

}
