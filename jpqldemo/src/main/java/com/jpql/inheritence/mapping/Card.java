package com.jpql.inheritence.mapping;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
/*@DiscriminatorValue(value = "cc")*/
@Table(name = "card")
@PrimaryKeyJoinColumn(name = "id")
public class Card extends Payment {
    private String cardnumber;

    public Card() {
    }

    public Card(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
