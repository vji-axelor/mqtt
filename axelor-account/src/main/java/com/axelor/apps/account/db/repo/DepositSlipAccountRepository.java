/*
 * Axelor Business Solutions
 *
 * Copyright (C) 2017 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.account.db.repo;

import javax.persistence.PersistenceException;

import com.axelor.apps.account.db.DepositSlip;
import com.axelor.apps.account.exception.IExceptionMessage;
import com.axelor.apps.base.db.IAdministration;
import com.axelor.apps.base.db.Sequence;
import com.axelor.apps.base.service.administration.SequenceService;
import com.axelor.exception.AxelorException;
import com.axelor.exception.db.IException;
import com.axelor.exception.service.TraceBackService;
import com.axelor.i18n.I18n;
import com.axelor.inject.Beans;
import com.google.common.base.Strings;

public class DepositSlipAccountRepository extends DepositSlipRepository {

    @Override
    public DepositSlip save(DepositSlip entity) {
        try {

            if (Strings.isNullOrEmpty(entity.getDepositNumber())) {
                setDepositNumber(entity);
            }

            return super.save(entity);
        } catch (Exception e) {
            TraceBackService.trace(e);
            throw new PersistenceException(e.getLocalizedMessage());
        }
    }

    private void setDepositNumber(DepositSlip entity) throws AxelorException {
        SequenceService sequenceService = Beans.get(SequenceService.class);
        String depositNumber = sequenceService.getSequenceNumber(IAdministration.DEPOSIT_SLIP, entity.getCompany());

        if (Strings.isNullOrEmpty(depositNumber)) {
            throw new AxelorException(Sequence.class, IException.NO_VALUE,
                    I18n.get(IExceptionMessage.DEPOSIT_SLIP_MISSING_SEQUENCE), entity.getCompany().getName());
        }

        entity.setDepositNumber(depositNumber);
    }

    @Override
    public void remove(DepositSlip entity) {
        if (entity.getPublicationDate() != null) {
            throw new PersistenceException(I18n.get(IExceptionMessage.DEPOSIT_SLIP_CANNOT_DELETE));
        }

        entity.clearPaymentVoucherList();
        super.remove(entity);
    }

}
