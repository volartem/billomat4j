/*
 * Copyright 2012 Oliver Siegmar
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
package de.siegmar.billomat4j.service;

import java.util.List;

import de.siegmar.billomat4j.domain.Email;
import de.siegmar.billomat4j.domain.invoice.Invoice;
import de.siegmar.billomat4j.domain.invoice.InvoiceActionKey;
import de.siegmar.billomat4j.domain.invoice.InvoiceComment;
import de.siegmar.billomat4j.domain.invoice.InvoiceCommentFilter;
import de.siegmar.billomat4j.domain.invoice.InvoiceFilter;
import de.siegmar.billomat4j.domain.invoice.InvoiceGroup;
import de.siegmar.billomat4j.domain.invoice.InvoiceGroupFilter;
import de.siegmar.billomat4j.domain.invoice.InvoiceItem;
import de.siegmar.billomat4j.domain.invoice.InvoicePayment;
import de.siegmar.billomat4j.domain.invoice.InvoicePaymentFilter;
import de.siegmar.billomat4j.domain.invoice.InvoicePdf;
import de.siegmar.billomat4j.domain.invoice.InvoiceTag;

/**
 * @see <a href="http://www.billomat.com/api/rechnungen/">API Rechnungen</a>
 * @see <a href="http://www.billomat.com/api/rechnungen/positionen/">API Rechnungen/Positionen</a>
 * @see <a href="http://www.billomat.com/api/rechnungen/kommentare-und-historie-5/">API Rechnungen/Kommentare</a>
 * @see <a href="http://www.billomat.com/api/rechnungen/zahlungen/">API Rechnungen/Zahlungen</a>
 * @see <a href="http://www.billomat.com/api/rechnungen/schlagworte/">API Rechnungen/Schlagworte</a>
 */
public interface InvoiceService extends
    GenericCustomFieldService,
    GenericTagService<InvoiceTag>,
    GenericCommentService<InvoiceActionKey, InvoiceComment, InvoiceCommentFilter>,
    GenericItemService<InvoiceItem>,
    GenericPaymentService<InvoicePayment, InvoicePaymentFilter> {

    /**
     * @param invoiceFilter
     *            invoice filter, may be {@code null} to find unfiltered
     * @return invoices found by filter criteria or an empty list if no invoices were found - never
     *         {@code null}
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    List<Invoice> findInvoices(InvoiceFilter invoiceFilter);

    /**
     * @param invoiceGroupFilter
     *            the group definition, must not be {@code null}
     * @param invoiceFilter
     *            the filter criteria, optional - may be {@code null}
     * @return grouped invoice list or an empty list if no invoices were found - never {@code null}
     * @throws NullPointerException
     *             if invoiceGroupFilter is null
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    List<InvoiceGroup> getGroupedInvoices(InvoiceGroupFilter invoiceGroupFilter, InvoiceFilter invoiceFilter);

    /**
     * Gets a invoice by its id.
     *
     * @param invoiceId
     *            the invoice's id
     * @return the invoice or {@code null} if not found
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    Invoice getInvoiceById(int invoiceId);

    /**
     * Gets a invoice by its invoice number.
     *
     * @param invoiceNumber
     *            the invoice number, must not be empty / {@code null}
     * @return the invoice or {@code null} if not found
     * @throws NullPointerException
     *             if invoiceNumber is null
     * @throws IllegalArgumentException
     *             if invoiceNumber is empty
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    Invoice getInvoiceByNumber(String invoiceNumber);

    /**
     * @param invoice
     *            the invoice to create, must not be {@code null}
     * @throws NullPointerException
     *             if invoice is null
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    void createInvoice(Invoice invoice);

    /**
     * @param invoice
     *            the invoice to update, must not be {@code null}
     * @throws NullPointerException
     *             if invoice is null
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    void updateInvoice(Invoice invoice);

    /**
     * @param invoiceId
     *            the id of the invoice to be deleted
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    void deleteInvoice(int invoiceId);

    /**
     * @param invoiceId
     *            the id of the invoice to get the PDF for
     * @return the invoice PDF or {@code null} if not found
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    InvoicePdf getInvoicePdf(int invoiceId);

    /**
     * @param invoiceId
     *            the id of the invoice to get the signed PDF for
     * @return the signed invoice PDF or {@code null} if not found
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     * @see #uploadInvoiceSignedPdf(int, byte[])
     * @see #getInvoicePdf(int)
     */
    InvoicePdf getInvoiceSignedPdf(int invoiceId);

    /**
     * Sets the invoice status to {@link de.siegmar.billomat4j.domain.invoice.InvoiceStatus#OPEN}
     * or {@link de.siegmar.billomat4j.domain.invoice.InvoiceStatus#OVERDUE}.
     *
     * @param invoiceId
     *            the id of the invoice to update
     * @param templateId
     *            the id of the template to use for the resulting document or {@code null} of no template should be used
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    void completeInvoice(int invoiceId, Integer templateId);

    /**
     * @param invoiceId
     *            the id of the invoice to upload the signed PDF for
     * @param pdf
     *            the signed PDF as binary data (must not be {@code null})
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     * @throws NullPointerException
     *             if pdf is null
     * @see #getInvoiceSignedPdf(int)
     */
    void uploadInvoiceSignedPdf(int invoiceId, byte[] pdf);

    /**
     * @param invoiceId
     *            the id of the invoice to send an email for
     * @param invoiceEmail
     *            the email configuration
     * @throws NullPointerException
     *             if invoiceEmail is null
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    void sendInvoiceViaEmail(int invoiceId, Email invoiceEmail);

    /**
     * Sets the invoice status to {@link de.siegmar.billomat4j.domain.invoice.InvoiceStatus#CANCELED}.
     *
     * @param invoiceId
     *            the id of the invoice to update
     * @throws de.siegmar.billomat4j.service.impl.ServiceException
     *             if an error occured while accessing the web service
     */
    void cancelInvoice(int invoiceId);

}
