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
package net.siegmar.billomat4j.sdk.domain.settings;

import java.math.BigDecimal;

import net.siegmar.billomat4j.sdk.domain.AbstractIdentifiable;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("reminder-text")
public class ReminderText extends AbstractIdentifiable {

    private Integer sorting;
    private String name;
    private String subject;
    private String header;
    private String footer;
    private String chargeName;
    private String chargeDescription;
    private BigDecimal chargeAmount;

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(final Integer sorting) {
        this.sorting = sorting;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(final String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(final String footer) {
        this.footer = footer;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(final String chargeName) {
        this.chargeName = chargeName;
    }

    public String getChargeDescription() {
        return chargeDescription;
    }

    public void setChargeDescription(final String chargeDescription) {
        this.chargeDescription = chargeDescription;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(final BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

}
