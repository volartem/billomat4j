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
package net.siegmar.billomat4j.sdk.domain.reminder;

import java.util.ArrayList;
import java.util.List;

import net.siegmar.billomat4j.sdk.domain.AbstractPageable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("reminder-tags")
public class ReminderTags extends AbstractPageable<ReminderTag> {

    @JsonProperty("reminder-tag")
    private List<ReminderTag> reminderTags = new ArrayList<>();

    public List<ReminderTag> getReminderTags() {
        return reminderTags;
    }

    public void setReminderTags(final List<ReminderTag> reminderTags) {
        this.reminderTags = reminderTags;
    }

    @JsonIgnore
    @Override
    public List<ReminderTag> getEntries() {
        return reminderTags;
    }

}
