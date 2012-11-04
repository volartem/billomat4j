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
package net.siegmar.billomat4j.sdk.service.impl;

import java.util.List;

import net.siegmar.billomat4j.sdk.domain.unit.Unit;
import net.siegmar.billomat4j.sdk.domain.unit.UnitFilter;
import net.siegmar.billomat4j.sdk.domain.unit.Units;
import net.siegmar.billomat4j.sdk.service.UnitService;

import org.apache.commons.lang3.Validate;

public class UnitServiceImpl extends AbstractService implements UnitService {

    private static final String RESOURCE = "units";

    public UnitServiceImpl(final BillomatConfiguration billomatConfiguration) {
        super(billomatConfiguration);
    }

    @Override
    public String getCustomFieldValue(final int unitId) {
        return getCustomField(RESOURCE, unitId);
    }

    @Override
    public void setCustomFieldValue(final int unitId, final String value) {
        updateCustomField(RESOURCE, unitId, "unit", value);
    }

    @Override
    public List<Unit> findUnits(final UnitFilter unitFilter) {
        return getAllPagesFromResource(RESOURCE, Units.class, unitFilter);
    }

    @Override
    public Unit getUnitById(final int id) {
        return getById(RESOURCE, Unit.class, id);
    }

    @Override
    public void createUnit(final Unit unit) {
        create(RESOURCE, Validate.notNull(unit));
    }

    @Override
    public void updateUnit(final Unit unit) {
        update(RESOURCE, Validate.notNull(unit));
    }

    @Override
    public void deleteUnit(final int id) {
        delete(RESOURCE, id);
    }

}
