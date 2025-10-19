package org.example.tp2.Entities;

import org.example.tp2.Enums.currencyType;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = Account.class,name = "account_projection")
public interface AccountView {
    currencyType getCurrency();
    Date getCreationAt();
}
