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
package net.siegmar.billomat4j.sdk.confirmation;

import net.siegmar.billomat4j.sdk.AbstractTagTest;
import net.siegmar.billomat4j.sdk.domain.client.Client;
import net.siegmar.billomat4j.sdk.domain.confirmation.Confirmation;
import net.siegmar.billomat4j.sdk.domain.confirmation.ConfirmationTag;


public class ConfirmationTagTest extends AbstractTagTest<ConfirmationTag> {

    public ConfirmationTagTest() {
        setService(confirmationService);
    }

    @Override
    protected int createOwner() {
        final Client client = new Client();
        client.setName("ConfirmationTagTest Client");
        clientService.createClient(client);

        final Confirmation confirmation = new Confirmation();
        confirmation.setClientId(client.getId());
        confirmationService.createConfirmation(confirmation);
        return confirmation.getId();
    }

    @Override
    protected ConfirmationTag constructTag(final int ownerId) {
        final ConfirmationTag tag = new ConfirmationTag();
        tag.setConfirmationId(ownerId);
        return tag;
    }

    @Override
    protected void deleteOwner(final int ownerId) {
        final int clientId = confirmationService.getConfirmationById(ownerId).getClientId();
        confirmationService.deleteConfirmation(ownerId);
        clientService.deleteClient(clientId);
    }

}
