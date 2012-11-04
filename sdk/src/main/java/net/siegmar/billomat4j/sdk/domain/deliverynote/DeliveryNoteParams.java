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
package net.siegmar.billomat4j.sdk.domain.deliverynote;

import java.util.Date;

import net.siegmar.billomat4j.sdk.json.MyDateSerializer;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("delivery-note-params")
public class DeliveryNoteParams {

    private Integer clientId;
    private DeliveryNoteStatus status;

    @JsonSerialize(using = MyDateSerializer.class)
    @JsonInclude(Include.NON_NULL)
    private Date from;

    @JsonSerialize(using = MyDateSerializer.class)
    @JsonInclude(Include.NON_NULL)
    private Date to;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(final Integer clientId) {
        this.clientId = clientId;
    }

    public DeliveryNoteStatus getStatus() {
        return status;
    }

    public void setStatus(final DeliveryNoteStatus status) {
        this.status = status;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(final Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(final Date to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
